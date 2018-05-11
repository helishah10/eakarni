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
import java.util.Map.Entry;

import com.zensoftech.eakarni.entities.Cdp;
import com.zensoftech.eakarni.entities.District;
import com.zensoftech.eakarni.entities.Hsg;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class HsgDaoImpl implements HsgDao
{
	
	 private static String driverName = "";
	    private static String databaseUrl = "";
	    private static String databaseUsername = "";
	    private static String databasePassword = "";
	    
	    public HsgDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

	    	HsgDaoImpl.driverName = driverName;
	    	HsgDaoImpl.databaseUrl = databaseUrl;
	    	HsgDaoImpl.databaseUsername = databaseUsername;
	    	HsgDaoImpl.databasePassword = databasePassword;
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
	public  Map<Integer, Hsg> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth)
	{
		Connection con;
		PreparedStatement ps;
		Map<Integer, Hsg> hsgMap=new HashMap<Integer,Hsg>();
		ResultSet rs;
		try
		{
			
			con=HsgDaoImpl.getConnection();
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
				String GET_ALL="select * from hsg_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(GET_ALL);
				ps.setInt(1,vid);
				ps.setInt(2, yearmonth.getMonthValue());
				ps.setInt(3, yearmonth.getYear());
				rs=ps.executeQuery();
	
			
			while(rs.next())
			{
				 Hsg hsg=new Hsg();
				 hsg.setId(rs.getInt("id"));
				 int month=rs.getInt("mth");
				 int year=rs.getInt("yr");
				 hsg.setYearmonth(YearMonth.of(year, month));
				 hsg.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				 hsg.setTarget(rs.getInt("target"));
				 
				 hsg.setNotStartedHouses(rs.getInt("not_started_houses"));
				 hsg.setPlinthLevel(rs.getInt("plinth_level"));
				 hsg.setLintalLevel(rs.getInt("Lintal_level"));
				 hsg.setSlabLevel(rs.getInt("slab_level"));
				 hsg.setCompletedHouses(rs.getInt("completed_houses"));
			/*	 hsg.setGrantYear(rs.getInt("grant_year"));*/
				 hsg.setEntryDate(rs.getDate("entry_date").toLocalDate());
				 hsgMap.put(hsg.getId(),hsg);
				 
			}
			
			}
			rs.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		return hsgMap;
}
	public   Map<Integer,Hsg> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth)
	{
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs;		
		 Map<Integer, Hsg> hsgMap=new HashMap<Integer,Hsg>();
		try
		{
			con=HsgDaoImpl.getConnection();
			
//con=CdpDaoImpl.getConnection();
			
			String getTid="select id from taluka_tbl where tid=?";
			ps=con.prepareStatement(getTid);
			ps.setInt(1,talukaId);
			rs=ps.executeQuery();
			int tid=0;
			while(rs.next())
			{
		
			Taluka taluka=StateDaoImpl.getAllTalukas(con).get(rs.getInt("id"));
			tid=taluka.getId();
			System.out.println("taluka id:"+tid);
			}
			
			String getvid="select id from village_tbl where tid=?";
			ps=con.prepareStatement(getvid);
			ps.setInt(1,tid);
			int id=0;
			rs=ps.executeQuery();
		
			@SuppressWarnings({ "rawtypes", "unchecked" })
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
				String GET_ALL="select * from hsg_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(GET_ALL,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1,vid);
				ps.setInt(2, yearmonth.getMonthValue());
				ps.setInt(3,yearmonth.getYear());
				rs=ps.executeQuery();
				
			
			
			    while(rs.next())
				{
			    	 Hsg hsg=new Hsg();
					 hsg.setId(rs.getInt("id"));
					 int month=rs.getInt("mth");
					 int year=rs.getInt("yr");
					 hsg.setYearmonth(YearMonth.of(year, month));
					 hsg.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
					 hsg.setTarget(rs.getInt("target"));
					 hsg.setFinanceYear(rs.getInt("finance_year"));
					 hsg.setNotStartedHouses(rs.getInt("not_started_houses"));
					 hsg.setPlinthLevel(rs.getInt("plinth_level"));
					 hsg.setLintalLevel(rs.getInt("Lintal_level"));
					 hsg.setSlabLevel(rs.getInt("slab_level"));
					 hsg.setCompletedHouses(rs.getInt("completed_houses"));
				/*	 hsg.setGrantYear(rs.getInt("grant_year"));*/
					 hsg.setEntryDate(rs.getDate("entry_date").toLocalDate());
					 hsgMap.put(hsg.getId(),hsg);
				}
			}	
		    rs.close();
		    con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return hsgMap;
	}
	
	public   Map<Integer,Hsg> getAllDetailsByVillageId(int villageId,YearMonth yearmonth)// census village id
	{
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs;		
		 Map<Integer, Hsg> hsgMap=new HashMap<Integer,Hsg>();
		try
		{
			con=HsgDaoImpl.getConnection();
						
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
	
			String GET_ALL="select * from hsg_tbl where vid=? AND mth=? AND yr=?";
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1,id);
			ps.setInt(2,yearmonth.getMonthValue());
			ps.setInt(3, yearmonth.getYear());
			rs=ps.executeQuery();
			
		    while(rs.next())
			{
		    	Hsg hsg=new Hsg();
				 hsg.setId(rs.getInt("id"));
				 int month=rs.getInt("mth");
				 int year=rs.getInt("yr");
				 hsg.setYearmonth(YearMonth.of(year, month));
				 hsg.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				 hsg.setTarget(rs.getInt("target"));
				 hsg.setFinanceYear(rs.getInt("finance_year"));
				 hsg.setNotStartedHouses(rs.getInt("not_started_houses"));
				 hsg.setPlinthLevel(rs.getInt("plinth_level"));
				 hsg.setLintalLevel(rs.getInt("Lintal_level"));
				 hsg.setSlabLevel(rs.getInt("slab_level"));
				 hsg.setCompletedHouses(rs.getInt("completed_houses"));
				/* hsg.setGrantYear(rs.getInt("grant_year"));*/
				 hsg.setEntryDate(rs.getDate("entry_date").toLocalDate());
				 hsgMap.put(hsg.getId(),hsg);
				
			}
	
		    rs.close();
		    con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return hsgMap;
	}
	
	
	public Hsg insert(int villageId,Hsg hsg,YearMonth yearmonth) // auto-incremented id of village
	{
		Connection con;
		ResultSet rs;
		PreparedStatement ps;
		try
		{
			con=HsgDaoImpl.getConnection();
			Village village=null;
			village=StateDaoImpl.getAllVillage(con).get(villageId);
			hsg.setVillage(village);
			int vid=village.getId();
			
			String INSERT="insert into hsg_tbl(vid,mth,yr,target,not_started_houses,plinth_level,lintal_level,slab_level,"
					+ "completed_houses,entry_date,finance_year) values(?,?,?,?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
	
			ps.setInt(1,village.getId());
			ps.setInt(2,hsg.getYearmonth().getMonthValue());
			ps.setInt(3, hsg.getYearmonth().getYear());
			ps.setInt(4,hsg.getTarget());
			ps.setInt(5,hsg.getNotStartedHouses());
			ps.setInt(6,hsg.getPlinthLevel());
			ps.setInt(7,hsg.getLintalLevel());
			ps.setInt(8, hsg.getSlabLevel());
			ps.setInt(9, hsg.getCompletedHouses());
			ps.setDate(10,Date.valueOf(java.time.LocalDate.now()));
			ps.setInt(11, hsg.getFinanceYear());
			ps.executeUpdate();
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return hsg;
	}
	
	public Hsg getDetails(YearMonth yearmonth,int villageId)//actual village ID(census)
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		Hsg hsg=new Hsg();
		try
		{
			con=HsgDaoImpl.getConnection();
			
			String getId="select id from village_tbl where vid=?";
			ps=con.prepareStatement(getId);
			ps.setInt(1,villageId);
			rs=ps.executeQuery();
			rs.next();
			Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
			int vid=village.getId();
			System.out.println("village id:"+vid);
			hsg.setVillage(village);
			hsg.setYearmonth(yearmonth);
			rs=ps.executeQuery();
			
			String GET_ALL="select * from hsg_tbl where vid=? AND mth=? AND yr=?";
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1,vid);
			ps.setInt(2,yearmonth.getMonthValue());
			ps.setInt(3,yearmonth.getYear());
			rs=ps.executeQuery();
			
		   while(rs.next())
			{
		   
				 hsg.setId(rs.getInt("id"));
				 hsg.setTarget(rs.getInt("target"));
				 hsg.setNotStartedHouses(rs.getInt("not_started_houses"));
				 hsg.setPlinthLevel(rs.getInt("plinth_level"));
				 hsg.setLintalLevel(rs.getInt("Lintal_level"));
				 hsg.setSlabLevel(rs.getInt("slab_level"));
				 hsg.setCompletedHouses(rs.getInt("completed_houses"));
				 hsg.setFinanceYear(rs.getInt("finance_year"));
				 hsg.setEntryDate(rs.getDate("entry_date").toLocalDate());
				
			}
	
			rs.close();
			con.close();
		
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return hsg;
	}
	
	
	public Hsg update(Hsg hsg,int villageId,YearMonth yearmonth)//auto increment id of village
	{
		Connection con=null;
		PreparedStatement ps=null;
		boolean hsgdata;
		
		try
		{
			hsgdata=true;
			con=HsgDaoImpl.getConnection();
	
			Village village=StateDaoImpl.getAllVillage(con).get(villageId);
			int vid=village.getId();
			
				final String update = "UPDATE hsg_tbl SET target=?,not_started_houses=?,"
		 		+ "plinth_level=?,lintal_level=?,slab_level=?,completed_houses=?,"
		 		+ "entry_date=?,finance_year=? where vid=?";
			
		 		ps = con.prepareStatement(update,Statement.RETURN_GENERATED_KEYS);
		 		
	            ps.setInt(1,hsg.getTarget());
	            ps.setInt(2,hsg.getNotStartedHouses());
	            ps.setInt(3,hsg.getPlinthLevel());
	            ps.setInt(4,hsg.getLintalLevel());
	            ps.setInt(5,hsg.getSlabLevel());
	            ps.setInt(6,hsg.getCompletedHouses());
	         /*   ps.setInt(, hsg.getGrantYear());*/
	            ps.setDate(7,java.sql.Date.valueOf(hsg.getEntryDate()));
	            ps.setInt(8, hsg.getFinanceYear());
	            ps.setInt(9, vid);
	            ps.executeUpdate();
	 
	     } 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return hsg;
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
			con=HsgDaoImpl.getConnection();
						
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
				
				String getCount="select count(*) from hsg_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(getCount);
				ps.setInt(1,vid);
				ps.setInt(2,YearMonth.now().getMonthValue()-1);
				ps.setInt(3,YearMonth.now().getYear());
				/*ps.setInt(2,financeYear);*/
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
			con=HsgDaoImpl.getConnection();
	
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
					
					String getCount="select count(*) from hsg_tbl where vid=? AND mth=? AND yr=?";
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
