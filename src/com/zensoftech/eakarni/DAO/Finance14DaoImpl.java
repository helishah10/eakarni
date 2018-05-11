package com.zensoftech.eakarni.DAO;

import java.io.BufferedReader;


import java.io.InputStreamReader;
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
import com.zensoftech.eakarni.entities.Finance14;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class Finance14DaoImpl implements Finance14Dao
{
	
	
	 	private static String driverName = "";
	    private static String databaseUrl = "";
	    private static String databaseUsername = "";
	    private static String databasePassword = "";
	    public Finance14DaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

	    	Finance14DaoImpl.driverName = driverName;
	    	Finance14DaoImpl.databaseUrl = databaseUrl;
	    	Finance14DaoImpl.databaseUsername = databaseUsername;
	    	Finance14DaoImpl.databasePassword = databasePassword;
	        /*System.out.println(" DAO>drivername:"+UserDaoImpl.driverName);
	    	System.out.println("DAO > url:"+UserDaoImpl.databaseUrl);
	        System.out.println("DAO >name:"+databaseUsername);
	        System.out.println("DAO > password"+databasePassword);*/
	    }
	    
	    public static Connection getConnection() throws SQLException, ClassNotFoundException{
	    	System.out.println("in connection method:");
	    	
	    	 /*System.out.println(" connection>drivername:"+driverName);
	    	
	     	 System.out.println("connection > url:"+databaseUrl);
	         System.out.println("connection >name:"+databaseUsername);
	         System.out.println("connection> password"+databasePassword);*/
	    	Class.forName("com.mysql.jdbc.Driver");
	       return DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
	       }
	    public   Map<Integer,Finance14> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth)
	    {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		Map<Integer,Finance14> finance14Map=new HashMap<Integer,Finance14>();
		try
		{
			con=Finance14DaoImpl.getConnection();
			
			
			String getDid="select id from district_tbl where did=?";
			ps=con.prepareStatement(getDid);
			ps.setInt(1,districtId);
			rs=ps.executeQuery();
			int did=0;
			while(rs.next())
			{
				District district =StateDaoImpl.getAllDistricts(con).get(rs.getInt("id"));
				did=district.getId();
			
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
				
			}
			for(int vid:villageList)
			{
				String GET_ALL="select * from 14finance_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(GET_ALL);
				ps.setInt(1,vid);
				ps.setInt(2, yearmonth.getMonthValue());
				ps.setInt(3, yearmonth.getYear());
				rs=ps.executeQuery();
				
			
			    while(rs.next())
				{
			    	Finance14 f1=new Finance14();
					 f1.setId(rs.getInt("id"));
					 f1.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
					 int year=rs.getInt("yr");
					 int month=rs.getInt("mth");
					 f1.setYearmonth(YearMonth.of(year, month));
					 f1.setTotalWork(rs.getInt("total_work"));
					 f1.setWorksApproved(rs.getInt("no_of_works_approved"));
					 f1.setProjectNotStarted(rs.getInt("no_of_projects_not_started"));
					 f1.setProgress(rs.getInt("progress"));
					 f1.setCompleted(rs.getInt("completed"));
					 f1.setGrantAllocated(rs.getDouble("amount_of_grant_allocated"));
					 f1.setAmountSpent(rs.getDouble("amount_spent"));
					 f1.setEntryDate(rs.getDate("entry_date").toLocalDate());
					 finance14Map.put(f1.getId(), f1);

				}
			}
			
			 rs.close();
			 con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		return finance14Map;
	}
	
	public   Map<Integer,Finance14> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth)   ///(output: village[])
	{
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs;		
		 Map<Integer, Finance14> finance14Map=new HashMap<Integer,Finance14>();
		
			try
			{
				con=Finance14DaoImpl.getConnection();
				
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
					String GET_ALL="select * from 14finance_tbl where vid=? AND mth=? AND yr=?";
					ps=con.prepareStatement(GET_ALL,Statement.RETURN_GENERATED_KEYS);
					ps.setInt(1,vid);
					ps.setInt(2,yearmonth.getMonthValue());
					ps.setInt(3, yearmonth.getYear());
					rs=ps.executeQuery();
			    while(rs.next())
				{
			    	 Finance14 f1=new Finance14();
					 f1.setId(rs.getInt("id"));
					 f1.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
					 int year=rs.getInt("yr");
					 int month=rs.getInt("mth");
					 f1.setYearmonth(YearMonth.of(year, month));
					 f1.setTotalWork(rs.getInt("total_work"));
					 f1.setWorksApproved(rs.getInt("no_of_works_approved"));
					 f1.setProjectNotStarted(rs.getInt("no_of_projects_not_started"));
					 f1.setProgress(rs.getInt("progress"));
					 f1.setCompleted(rs.getInt("completed"));
					 f1.setGrantAllocated(rs.getDouble("amount_of_grant_allocated"));
					 f1.setAmountSpent(rs.getDouble("amount_spent"));
					 f1.setEntryDate(rs.getDate("entry_date").toLocalDate());
					 finance14Map.put(f1.getId(), f1); 
				}

	
			}	
		    rs.close();
		    con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			System.out.println("in dao:"+finance14Map);
		return finance14Map;
	}
	
	
	public   Map<Integer,Finance14> getAllDetailsByVillageId(int villageId,YearMonth yearmonth)
	{
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs;		
		 Map<Integer,Finance14> finance14Map=new HashMap<Integer,Finance14>();
		try
		{
			con=Finance14DaoImpl.getConnection();
			
			String getVid="select id from village_tbl where vid=?";
			ps=con.prepareStatement(getVid);
			ps.setInt(1,villageId);
			rs=ps.executeQuery();
			int vid=0;
			while(rs.next())
			{
				Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
				vid=village.getId();
			
				
			}
	
			String GET_ALL="select * from 14finance_tbl where vid=? AND mth=? AND yr=?";
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1,vid);
			ps.setInt(2,yearmonth.getMonthValue());
			ps.setInt(3,yearmonth.getYear());
			rs=ps.executeQuery();
	
			
		    while(rs.next())
			{
		    	 Finance14 f1=new Finance14();
		    	 f1.setId(rs.getInt("id"));
				 f1.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				 int year=rs.getInt("yr");
				 int month=rs.getInt("mth");
				 f1.setYearmonth(YearMonth.of(year, month));
				 f1.setTotalWork(rs.getInt("total_work"));
				 f1.setWorksApproved(rs.getInt("no_of_works_approved"));
				 f1.setProjectNotStarted(rs.getInt("no_of_projects_not_started"));
				 f1.setProgress(rs.getInt("progress"));
				 f1.setCompleted(rs.getInt("completed"));
				 f1.setGrantAllocated(rs.getDouble("amount_of_grant_allocated"));
				 f1.setAmountSpent(rs.getDouble("amount_spent"));
				 f1.setEntryDate(rs.getDate("entry_date").toLocalDate());
				 finance14Map.put(f1.getId(), f1);  
			}
	
		    rs.close();
		    con.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return finance14Map;
	}

	public Finance14 insert(int villageId,Finance14 finance)
	{
		 //insert the uto-incremented id of village
    	{
    		Connection con=null;
    		PreparedStatement ps=null;
    		ResultSet rs=null;
    		
    		try
    		{
    			con=Finance14DaoImpl.getConnection();
    		
    			/*String select_village="select id from village_tbl where vid=?";
    			ps=con.prepareStatement(select_village);
    			ps.setInt(1,villageId);
    			rs=ps.executeQuery();
    			int id=0;
    			while(rs.next())
    			{
    				id=rs.getInt("id");
    				System.out.println(id);
    			}
    			*/
    			Village village=null;
    			village=StateDaoImpl.getAllVillage(con).get(villageId);
    			finance.setVillage(village);
    			int vid=village.getId();
			String insert="insert into 14finance_tbl(vid,mth,yr,total_work,no_of_works_approved,no_of_projects_not_started,"
					+ "progress,completed,amount_of_grant_allocated,amount_spent,entry_date) values(?,?,?,?,?,?,?,?,?,?,?)";
			
		
			ps=con.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,vid);
			ps.setInt(2,finance.getYearmonth().getMonthValue());
			ps.setInt(3,finance.getYearmonth().getYear());
			ps.setInt(4,finance.getTotalWork());
			ps.setInt(5,finance.getWorksApproved());
			ps.setDouble(6,finance.getProjectNotStarted());
			ps.setDouble(7,finance.getProgress());
			ps.setDouble(8,finance.getCompleted());
			ps.setDouble(9, finance.getGrantAllocated());
			ps.setDouble(10,finance.getAmountSpent());
			ps.setDate(11,Date.valueOf(java.time.LocalDate.now()));
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			while(rs.next())
			{
				@SuppressWarnings("unused")
				int id1=rs.getInt(1);
			}
			System.out.println("successful");
			
		}
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
    		return finance;
    	}
    	
	}
	
	/*public Cdp getDetails(YearMonth yearmonth,int villageId)//census village id
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
			 year=rs.getInt("yr");
			 month=rs.getInt("mth");
			 cdp.setYearmonth(YearMonth.of(year, month));
			
			
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
				 cdp.setEntryDate(rs.getDate("entry_date").toLocalDate());
		
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
	*/
	
	public Finance14 getDetails(YearMonth  yearmonth,int villageId) //enter the census village id
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		Finance14 finance=new Finance14();
		try
		{
			con=Finance14DaoImpl.getConnection();
			
			String getId="select id from village_tbl where vid=?";
			ps=con.prepareStatement(getId);
			ps.setInt(1,villageId);
			rs=ps.executeQuery();
			rs.next();
			Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
			int vid=village.getId();
			finance.setVillage(village);
			finance.setYearmonth(yearmonth);
			
			String GET_ALL="select * from 14finance_tbl where vid=? AND mth=? AND yr=?";
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1,vid);
			ps.setInt(2,yearmonth.getMonthValue());
			ps.setInt(3,yearmonth.getYear());
			rs=ps.executeQuery();
		
			
		    while(rs.next())
			{
		    	
		    	finance.setId(rs.getInt("id"));
		    	finance.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				/*int year=rs.getInt("yr");
				 int month=rs.getInt("mth");
				 finance.setYearmonth(YearMonth.of(year, month));*/
				 finance.setTotalWork(rs.getInt("total_work"));
				 finance.setWorksApproved(rs.getInt("no_of_works_approved"));
				 finance.setProjectNotStarted(rs.getInt("no_of_projects_not_started"));
				 finance.setProgress(rs.getInt("progress"));
				 finance.setCompleted(rs.getInt("completed"));
				 finance.setGrantAllocated(rs.getDouble("amount_of_grant_allocated"));
				 finance.setAmountSpent(rs.getDouble("amount_spent"));
				 finance.setEntryDate(rs.getDate("entry_date").toLocalDate());
				 
			}
	
		
			
			rs.close();
			con.close();
		
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("in dao:"+finance);
		return finance;
		
	}

	public Finance14 update(Finance14 finance14,int villageId,YearMonth yearmonth)
	{
		Connection con=null;
		PreparedStatement ps=null;
		boolean financedata;
		
		try
		{
			financedata=true;
			con=Finance14DaoImpl.getConnection();
			Village village=StateDaoImpl.getAllVillage(con).get(villageId);
			System.out.println(village);
		
			finance14.setVillage(village);
	
			final String update = "UPDATE 14Finance_tbl SET total_work=?,no_of_works_approved=?,"
		 		+ "no_of_projects_not_started=?,progress=?,completed=?,amount_of_grant_allocated=?,"
		 		+ "amount_spent=?,entry_date=? where vid=? AND mth=? AND yr=?";
		 
		  ps = con.prepareStatement(update,Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1,finance14.getTotalWork());
			ps.setInt(2,finance14.getWorksApproved());
			ps.setInt(3,finance14.getProjectNotStarted());
			ps.setInt(4,finance14.getProgress());
			ps.setInt(5,finance14.getCompleted());
			ps.setDouble(6,finance14.getGrantAllocated());
			ps.setDouble(7,finance14.getAmountSpent());
			ps.setDate(8,java.sql.Date.valueOf(java.time.LocalDate.now()));
			ps.setInt(9, villageId);
			ps.setInt(10, yearmonth.getMonthValue());
			ps.setInt(11,yearmonth.getYear());
			ps.executeUpdate();
			
			System.out.println("successfully updated");
			
	            
	 } 
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return finance14;
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
				
				String getCount="select count(*) from 14finance_tbl where vid=? AND mth=? AND yr=?";
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
					
					String getCount="select count(*) from 14finance_tbl where vid=? AND mth=? AND yr=?";
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
