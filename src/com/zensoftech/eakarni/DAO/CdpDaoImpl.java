package com.zensoftech.eakarni.DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zensoftech.eakarni.entities.Cdp;
import com.zensoftech.eakarni.entities.District;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;


public class CdpDaoImpl implements CdpDao
{
	
	 private static String driverName = "";
	    private static String databaseUrl = "";
	    private static String databaseUsername = "";
	    private static String databasePassword = "";
	    
	    public CdpDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

	    	CdpDaoImpl.driverName = driverName;
	    	CdpDaoImpl.databaseUrl = databaseUrl;
	    	CdpDaoImpl.databaseUsername = databaseUsername;
	    	CdpDaoImpl.databasePassword = databasePassword;
	        /*System.out.println(" DAO>drivername:"+UserDaoImpl.driverName);
	    	System.out.println("DAO > url:"+UserDaoImpl.databaseUrl);
	        System.out.println("DAO >name:"+databaseUsername);
	        System.out.println("DAO > password"+databasePassword);*/
	    }
	    
	    	public static Connection getConnection() throws SQLException, ClassNotFoundException{
	    	
	    	
	    	 /*System.out.println(" connection>drivername:"+driverName);
	    	
	     	 System.out.println("connection > url:"+databaseUrl);
	         System.out.println("connection >name:"+databaseUsername);
	         System.out.println("connection> password"+databasePassword);*/
	    	Class.forName("com.mysql.jdbc.Driver");
	       return DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
	       }
		
	    	public Cdp insert(int villageId,Cdp cdp) //insert the autoincremented id of village
	    	{
	    		Connection con=null;
	    		PreparedStatement ps=null;
	    		ResultSet rs=null;
	    		
	    		try
	    		{
	    			con=CdpDaoImpl.getConnection();
	    		
	    			/*String select_village="select id from village_tbl where vid=?";
	    			ps=con.prepareStatement(select_village);
	    			ps.setInt(1,villageId);
	    			rs=ps.executeQuery();
	    			int id=0;
	    			Village village=null;
	    			while(rs.next())
	    			{
	    				village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
	    			}*/
	    			Village village=null;
	    			village=StateDaoImpl.getAllVillage(con).get(villageId);
	    			cdp.setVillage(village);
	    			int vid=village.getId();
	    			
	    			String INSERT="insert into cdp_tbl(vid,mth,yr,grant_allocated,costs_during_previous_year,"
	    					+ "costs_during_this_month,ongoing_costs_during_current_year,"
	    					+ "achievement_of_previous_month_of_current_year,achievements_duirng_this_month,total_achievements_of_current_year,entry_date)"
	    					+ "values(?,?,?,?,?,?,?,?,?,?,?) ";
	    			
	    			ps=con.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
	    	
	    			ps.setInt(1,vid);
	    			ps.setInt(2,cdp.getYearmonth().getMonthValue());
	    			ps.setInt(3, cdp.getYearmonth().getYear());
	    			ps.setDouble(4,cdp.getGrantAllocated());
	    			ps.setDouble(5,cdp.getCostsDuringPreviousYear());
	    			ps.setDouble(6,cdp.getCostsDuringThisMonth());
	    			ps.setDouble(7,cdp.getOngoingCostsDuringCurrentYear());
	    			ps.setDouble(8,cdp.getAchievementOfPreviousMonthOfCurrentYear());
	    			ps.setDouble(9,cdp.getAchievementsDuirngThisMonth());
	    			ps.setDouble(10,cdp.getTotalAchievementsOfCurrentYear());
	    			ps.setDate(11,Date.valueOf(java.time.LocalDate.now()));
	    			ps.executeUpdate();
	    			rs=ps.getGeneratedKeys();
	    			while(rs.next())
	    			{
	    				@SuppressWarnings("unused")
	    				int id1=rs.getInt(1);
	    			}
	    			
	    			System.out.println("successfully inserted");
	    		}	
	    		catch(Exception e)
	    		{
	    			e.printStackTrace();
	    		}
	    		
	    		return cdp;
	    	}
	
	@SuppressWarnings({ "unchecked" })
	public   Map<Integer,Cdp> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth) //enter the census taluka id
	{
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs;		
		 Map<Integer, Cdp> cdpMap=new HashMap<Integer,Cdp>();
		try
		{
			con=CdpDaoImpl.getConnection();
			
			String getTid="select id from taluka_tbl where tid=?";
			ps=con.prepareStatement(getTid);
			ps.setInt(1,talukaId);
			rs=ps.executeQuery();
			int tid=0;
			while(rs.next())
			{
				
			Taluka taluka=StateDaoImpl.getAllTalukas(con).get(rs.getInt("id"));
			tid=taluka.getId();
			}
			
			String getvid="select id from village_tbl where tid=?";
			ps=con.prepareStatement(getvid);
			ps.setInt(1,tid);
			int id=0;
			rs=ps.executeQuery();
		
			@SuppressWarnings("rawtypes")
			List<Integer> villagelist=new ArrayList();
			while(rs.next())
			{
				Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
				id=village.getId();
				villagelist.add(id);
				
				
			}
			System.out.println("village list:"+villagelist);
			for(int vid:villagelist)
			{
				String GET_ALL="select * from cdp_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(GET_ALL,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1,vid);
				ps.setInt(2,yearmonth.getMonthValue());
				ps.setInt(3,yearmonth.getYear());
				rs=ps.executeQuery();
				
			
			    while(rs.next())
				{
					 Cdp c1=new Cdp();
					 c1.setId(rs.getInt("id"));
					 int year=rs.getInt("yr");
					 int month=rs.getInt("mth");
					 c1.setYearmonth(YearMonth.of(year, month));
					 c1.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
					 c1.setEntryDate(rs.getDate("entry_date").toLocalDate());
					 c1.setGrantAllocated((rs.getDouble("grant_allocated")));
					 c1.setCostsDuringPreviousYear((rs.getDouble("costs_during_previous_year")));
					 c1.setCostsDuringThisMonth(((rs.getDouble("costs_during_this_month"))));
					 c1.setOngoingCostsDuringCurrentYear((rs.getDouble("ongoing_costs_during_current_year")));
					 c1.setAchievementOfPreviousMonthOfCurrentYear(rs.getDouble("achievement_of_previous_month_of_current_year"));
					 c1.setCostsDuringPreviousYear((rs.getDouble("costs_during_previous_year")));
					 c1.setAchievementsDuirngThisMonth((rs.getDouble("achievements_duirng_this_month")));
					 c1.setTotalAchievementsOfCurrentYear((rs.getDouble("total_achievements_of_current_year")));
					 cdpMap.put(c1.getId(),c1);
				}

	
			}	
			rs.close();
		    con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cdpMap;
	}
	public   Map<Integer,Cdp> getAllDetailsByVillageId(int villageId,YearMonth yearmonth) //enter census village id
	{
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs;		
		 Map<Integer, Cdp> cdpMap=new HashMap<Integer,Cdp>();
		try
		{
			con=CdpDaoImpl.getConnection();
		
			String getVid="select id from village_tbl where vid=?";
			ps=con.prepareStatement(getVid);
			ps.setInt(1,villageId);
			
			rs=ps.executeQuery();
			int id=0;
			while(rs.next())
			{
				Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
				id=village.getId();
			
				
			}
	
			String GET_ALL="select * from cdp_tbl where vid=? AND mth=? AND yr=?";
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1,id);
			ps.setInt(2,yearmonth.getMonthValue());
			ps.setInt(3,yearmonth.getYear());
			rs=ps.executeQuery();
			
			
		    while(rs.next())
			{
				 Cdp c1=new Cdp();
				 c1.setId(rs.getInt("id"));
				 c1.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				 int  year=rs.getInt("yr");
				 int  month=rs.getInt("mth");
				 c1.setYearmonth(YearMonth.of(year, month));
				 c1.setEntryDate(rs.getDate("entry_date").toLocalDate());
				 c1.setGrantAllocated((rs.getDouble("grant_allocated")));
				 c1.setCostsDuringPreviousYear((rs.getDouble("costs_during_previous_year")));
				 c1.setCostsDuringThisMonth(((rs.getDouble("costs_during_this_month"))));
				 c1.setAchievementOfPreviousMonthOfCurrentYear(rs.getDouble("achievement_of_previous_month_of_current_year"));
				 c1.setOngoingCostsDuringCurrentYear((rs.getDouble("ongoing_costs_during_current_year")));
				 c1.setCostsDuringPreviousYear((rs.getDouble("costs_during_previous_year")));
				 c1.setAchievementsDuirngThisMonth((rs.getDouble("achievements_duirng_this_month")));					 
				 c1.setTotalAchievementsOfCurrentYear((rs.getDouble("total_achievements_of_current_year")));
				 cdpMap.put(c1.getId(),c1);
				
			}
	
		    rs.close();
		    con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cdpMap;
	}

	
	
	public Map<Integer,Cdp> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth) //census district id
	{
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs;		
		 Map<Integer, Cdp> cdpMap=new HashMap<Integer,Cdp>();
		try
		{
			con=CdpDaoImpl.getConnection();
			String getDid="select id from district_tbl where did=?";
			ps=con.prepareStatement(getDid);
			ps.setInt(1,districtId);
			rs=ps.executeQuery();
			int did=0;
			while(rs.next())
			{
				District district =StateDaoImpl.getAllDistricts(con).get(rs.getInt("id"));
				did=district.getId();
				//System.out.println("district id:"+did);
				
			}
	
			String getTid="select id from taluka_tbl where did=?";
			ps=con.prepareStatement(getTid);
			ps.setInt(1,did);
			rs=ps.executeQuery();
			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<Integer> talukaList=new ArrayList();
			int tid=0;
			while(rs.next())
			{
				Taluka taluka=StateDaoImpl.getAllTalukas(con).get(rs.getInt("id"));
				tid=taluka.getId();
				talukaList.add(tid);
			}
		//	System.out.println("taluka list:"+talukaList);

			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<Integer> villageList=new ArrayList();
			for(int talukaid:talukaList)
			{
				String getvid="select id from village_tbl where tid=?";
				ps=con.prepareStatement(getvid);
				ps.setInt(1,talukaid);
				rs=ps.executeQuery();
				int villageId=0;
			
				while(rs.next())
				{
					Village village =StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
					villageId=village.getId();
					villageList.add(villageId);
				}
				//System.out.println("village list:"+villageList);
				
				
			}
			for(int vid:villageList)
			{
				String GET_ALL="select * from cdp_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(GET_ALL);
				ps.setInt(1,vid);
				ps.setInt(2,yearmonth.getMonthValue());
				ps.setInt(3,yearmonth.getYear());
				rs=ps.executeQuery();
	
			
			    while(rs.next())
				{
					 Cdp c1=new Cdp();
					 c1.setId(rs.getInt("id"));
					 c1.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
					 int year=rs.getInt("yr");
					 int month=rs.getInt("mth");
					 c1.setYearmonth(YearMonth.of(year, month));
					 c1.setGrantAllocated((rs.getDouble("grant_allocated")));
					 c1.setCostsDuringPreviousYear((rs.getDouble("costs_during_previous_year")));
					 c1.setCostsDuringThisMonth(((rs.getDouble("costs_during_this_month"))));
					 c1.setOngoingCostsDuringCurrentYear((rs.getDouble("ongoing_costs_during_current_year")));
					 c1.setCostsDuringPreviousYear((rs.getDouble("costs_during_previous_year")));
					 c1.setAchievementOfPreviousMonthOfCurrentYear(rs.getDouble("achievement_of_previous_month_of_current_year"));
					 c1.setAchievementsDuirngThisMonth((rs.getDouble("achievements_duirng_this_month")));
					 c1.setTotalAchievementsOfCurrentYear((rs.getDouble("total_achievements_of_current_year")));
					 c1.setEntryDate(rs.getDate("entry_date").toLocalDate());
					 cdpMap.put(c1.getId(),c1);

			}
		}
			
			 rs.close();
			 con.close();
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			
		return cdpMap;
	}
	
	
	public Cdp getDetails(YearMonth yearmonth,int villageId)//census village id
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		Cdp cdp=new Cdp();
		try
		{
			con=CdpDaoImpl.getConnection();
			
			String getId="select id from village_tbl where vid=?";
			ps=con.prepareStatement(getId);
			ps.setInt(1,villageId);
			rs=ps.executeQuery();
			rs.next();
			Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
			int vid=village.getId();
			cdp.setVillage(village);
			cdp.setYearmonth(yearmonth);
			/* year=rs.getInt("yr");
			 month=rs.getInt("mth");
			 cdp.setYearmonth(YearMonth.of(year, month));*/
			
			
			String GET_ALL="select * from cdp_tbl where vid=? AND mth=? AND yr=?";
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1,vid);
			ps.setInt(2,yearmonth.getMonthValue());
			ps.setInt(3,yearmonth.getYear());
			rs=ps.executeQuery();

		
		    while(rs.next())
			{
				 cdp.setId(rs.getInt("id"));
				 cdp.setGrantAllocated((rs.getDouble("grant_allocated")));
				 cdp.setCostsDuringPreviousYear((rs.getDouble("costs_during_previous_year")));
				 cdp.setCostsDuringThisMonth(((rs.getDouble("costs_during_this_month"))));
				 cdp.setOngoingCostsDuringCurrentYear((rs.getDouble("ongoing_costs_during_current_year")));
				 cdp.setCostsDuringPreviousYear((rs.getDouble("costs_during_previous_year")));
				 cdp.setAchievementOfPreviousMonthOfCurrentYear(rs.getDouble("achievement_of_previous_month_of_current_year"));
				 cdp.setAchievementsDuirngThisMonth((rs.getDouble("achievements_duirng_this_month")));
				 cdp.setTotalAchievementsOfCurrentYear((rs.getDouble("total_achievements_of_current_year")));
				 cdp.setEntryDate(java.time.LocalDateTime.now().toLocalDate());
		
			}
			rs.close();
			con.close();

		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return cdp;
	}
	
	public Cdp update(Cdp cdp,int villageId,YearMonth yearmonth)
	{
		Connection con=null;
		PreparedStatement ps=null;
		boolean cdpdata;
		
		try
		{
			cdpdata=true;
			con=CdpDaoImpl.getConnection();
			Village village=StateDaoImpl.getAllVillage(con).get(villageId);
			System.out.println(village);
		
			cdp.setVillage(village);
			
		
			final String update = "UPDATE cdp_tbl SET grant_allocated=?, costs_during_previous_year=?, costs_during_this_month=?, "
			 		+ "achievement_of_previous_month_of_current_year=?,achievements_duirng_this_month=?,"
			 		+ "entry_date=? where vid=? AND mth=? AND yr=?";
			
			ps = con.prepareStatement(update,Statement.RETURN_GENERATED_KEYS);
			
			ps.setDouble(1,cdp.getGrantAllocated());
			ps.setDouble(2,cdp.getCostsDuringPreviousYear());
			ps.setDouble(3,cdp.getCostsDuringThisMonth());
			ps.setDouble(4,cdp.getAchievementOfPreviousMonthOfCurrentYear());
			ps.setDouble(5,cdp.getAchievementsDuirngThisMonth());
			ps.setDate(6,java.sql.Date.valueOf(java.time.LocalDate.now()));
			ps.setInt(7, villageId);
			ps.setInt(8, yearmonth.getMonthValue());
			ps.setInt(9,yearmonth.getYear());
			ps.executeUpdate();
			System.out.println(cdp);
			
			System.out.println("successfully updated");
			
	} 
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cdp;
	
	}
	
	public int getTotalCountByTalukaId(int talukaId)  // taluka id=census taluka id
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		int count=0;
		int total=0;
		try
		{
			con=CdpDaoImpl.getConnection();
			
			String getTid="select id from taluka_tbl where tid=?";
			ps=con.prepareStatement(getTid);
			ps.setInt(1,talukaId);
			rs=ps.executeQuery();
			int tid=0;
			while(rs.next())
			{
				Taluka taluka =StateDaoImpl.getAllTalukas(con).get(rs.getInt("id"));
				tid=taluka.getId();
			}
			
			String getvid="select id from village_tbl where tid=?";
			ps=con.prepareStatement(getvid);
			ps.setInt(1,tid);
			int id=0;
			rs=ps.executeQuery();
			@SuppressWarnings({ "rawtypes", "unchecked" })
			List<Integer> villageList=new ArrayList();
			while(rs.next())
			{
				Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
				int vid=village.getId();
				villageList.add(vid);
				
			}
			for(int vid:villageList)
			{
				
				String getCount="select count(*) from cdp_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(getCount);
				ps.setInt(1,vid);
				ps.setInt(2,YearMonth.now().getMonthValue()-1);
				ps.setInt(3,YearMonth.now().getYear());
				rs=ps.executeQuery();
				while(rs.next())
				{
					count=rs.getInt(1);
					System.out.println("in while loop:"+count);
					if(count != 0)
					{
						total=total+count;
						System.out.println("total:"+total);
					}
				}
				
				
			}
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("total no of rows:"+total);
		return total;
	}
	
	
	public int getTotalCountByDistrictId(int districtId)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		int count=0;
		int total=0;
		try
		{
			con=CdpDaoImpl.getConnection();
	
			String getDid="select id from district_tbl where did=?";
			ps=con.prepareStatement(getDid);
			ps.setInt(1,districtId);
			rs=ps.executeQuery();
			int did=0;
			while(rs.next())
			{
				District district=StateDaoImpl.getAllDistricts(con).get(rs.getInt("id"));
				did=district.getId();
			}
			
			String getTid="select id from taluka_tbl where did=?";
			ps=con.prepareStatement(getTid);
			ps.setInt(1,did);
			int tid=0;
			rs=ps.executeQuery();
			@SuppressWarnings({ "rawtypes", "unchecked" })
			List<Integer> talukaList=new ArrayList();
			while(rs.next())
			{
				Taluka taluka=StateDaoImpl.getAllTalukas(con).get(rs.getInt("id"));
				talukaList.add(rs.getInt("id"));
				
			}
			System.out.println("taluka list:"+talukaList);
			for(int talukaId:talukaList)
			{
				String getvid="select id from village_tbl where tid=?";
				ps=con.prepareStatement(getvid);
				ps.setInt(1,talukaId);
				int id=0;
				rs=ps.executeQuery();
				@SuppressWarnings({ "rawtypes", "unchecked" })
				List<Integer> villageList=new ArrayList();
				while(rs.next())
				{
					Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
					int vid=village.getId();
					villageList.add(vid);
					
				}
				for(int vid:villageList)
				{
					
					String getCount="select count(*) from cdp_tbl where vid=? AND mth=? AND yr=?";
					ps=con.prepareStatement(getCount);
					ps.setInt(1,vid);
					ps.setInt(2,YearMonth.now().getMonthValue()-1);
					ps.setInt(3,YearMonth.now().getYear());
					rs=ps.executeQuery();
					while(rs.next())
					{
						count=rs.getInt(1);
						System.out.println("in while loop:"+count);
						if(count != 0)
						{
							total=total+count;
							System.out.println("total:"+total);
						}
					}
					
					
				}
				
			}
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("total no of rows:"+total);
		return total;
	}

	
	


			
}
	




