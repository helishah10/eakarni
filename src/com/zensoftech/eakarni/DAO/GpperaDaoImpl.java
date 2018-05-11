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
import com.zensoftech.eakarni.entities.GPauditpera;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class GpperaDaoImpl implements GpperaDao
{
	
	private static String driverName="";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
    
    public GpperaDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

    	GpperaDaoImpl.driverName = driverName;
    	GpperaDaoImpl.databaseUrl = databaseUrl;
    	GpperaDaoImpl.databaseUsername = databaseUsername;
    	GpperaDaoImpl.databasePassword = databasePassword;
    }
    
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
    	System.out.println("in connection method:");
    	Class.forName("com.mysql.jdbc.Driver");
       return DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
    }
	
		public   Map<Integer, GPauditpera> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth)//census district id
		{
			Connection con;
			PreparedStatement ps;
			ResultSet rs;
			 Map<Integer,GPauditpera > gpperaMap=new HashMap<Integer, GPauditpera>();
		
			 try
			 {
				con=GpperaDaoImpl.getConnection();
				 
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
						String GET_ALL="select * from gp_audit_pera_tbl where vid=? AND mth=? AND yr=?";
						ps=con.prepareStatement(GET_ALL);
						ps.setInt(1,vid);
						ps.setInt(2,yearmonth.getMonthValue());
						ps.setInt(3, yearmonth.getYear());
						rs=ps.executeQuery();
	
				 
						 while(rs.next())
						 {
							 GPauditpera p1=new GPauditpera();
							 p1.setId(rs.getInt("id"));
							 int year=rs.getInt("yr");
						 	 int month=rs.getInt("mth");
						 	 p1.setYearmonth(YearMonth.of(year, month));
							 p1.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
						 	 p1.setYearOfRegisteration(rs.getInt("year_of_registration"));
						 	 p1.setTotalPera(rs.getInt("total_pera"));
						 	 p1.setTotalPeraAnsweredThisWeek(rs.getInt("total_pera_answered_this_week"));
						 	 p1.setPeraNotanswered(rs.getInt("pera_not_answered"));
						 	 p1.setEntryDate(rs.getDate("entry_date").toLocalDate());
						 	 gpperaMap.put(p1.getId(),p1);
						 }
						 
					}
		rs.close();
		con.close();
		
	 }
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		return gpperaMap;
	}
	
		public   Map<Integer,GPauditpera> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth)//census taluka id
		{
			Connection con = null;
			PreparedStatement ps=null;
			ResultSet rs;		
			 Map<Integer,GPauditpera> peraMap=new HashMap<Integer,GPauditpera>();
			try
			{
				con=GpperaDaoImpl.getConnection();
				
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
				
				@SuppressWarnings("rawtypes")
				List<Integer> villagelist=new ArrayList();
				while(rs.next())
				{
					Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
					id=village.getId();
					villagelist.add(id);
									
				}
				//System.out.println("list:"+list);
				for(int vid:villagelist)
				{
					String GET_ALL="select * from gp_audit_pera_tbl where vid=? AND mth=? AND yr=?";
					ps=con.prepareStatement(GET_ALL,Statement.RETURN_GENERATED_KEYS);
					ps.setInt(1,vid);
					ps.setInt(2,yearmonth.getMonthValue());
					ps.setInt(3,yearmonth.getYear());
					rs=ps.executeQuery();
				
				    while(rs.next())
					{
				    	 GPauditpera p1=new GPauditpera();
						 p1.setId(rs.getInt("id"));
						 int year=rs.getInt("yr");
					 	 int month=rs.getInt("mth");
					 	 p1.setYearmonth(YearMonth.of(year, month));
						 p1.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
					 	 p1.setYearOfRegisteration(rs.getInt("year_of_registration"));
					 	 p1.setTotalPera(rs.getInt("total_pera"));
					 	 p1.setTotalPeraAnsweredThisWeek(rs.getInt("total_pera_answered_this_week"));
					 	 p1.setPeraNotanswered(rs.getInt("pera_not_answered"));
					 	 p1.setEntryDate(rs.getDate("entry_date").toLocalDate());
					 	 peraMap.put(p1.getId(),p1);
					}

		
				}	
			    rs.close();
			    con.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return peraMap;
		}
	
		public   Map<Integer,GPauditpera> getAllDetailsByVillageId(int villageId,YearMonth yearmonth)//census village id
		{
			Connection con = null;
			PreparedStatement ps=null;
			ResultSet rs;		
			 Map<Integer,GPauditpera> peraMap=new HashMap<Integer,GPauditpera>();
			try
			{
				con=GpperaDaoImpl.getConnection();
				
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
		
				String GET_ALL="select * from gp_audit_pera_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(GET_ALL);
				ps.setInt(1,id);
				ps.setInt(2,yearmonth.getMonthValue());
				ps.setInt(3, yearmonth.getYear());
				rs=ps.executeQuery();
				
			    while(rs.next())
				{
			    	 GPauditpera p1=new GPauditpera();
					 p1.setId(rs.getInt("id"));
					 int year=rs.getInt("yr");
					 int month=rs.getInt("mth");
					 p1.setYearmonth(YearMonth.of(year, month));
					 p1.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				 	 p1.setYearOfRegisteration(rs.getInt("year_of_registration"));
				 	 p1.setTotalPera(rs.getInt("total_pera"));
				 	 p1.setTotalPeraAnsweredThisWeek(rs.getInt("total_pera_answered_this_week"));
				 	 p1.setPeraNotanswered(rs.getInt("pera_not_answered"));
				 	 p1.setEntryDate(rs.getDate("entry_date").toLocalDate());
				 	 peraMap.put(p1.getId(),p1);
				}
		
			    rs.close();
			    con.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("pera in dao:"+peraMap);
			return peraMap;
	}
		
	
	public GPauditpera insert(int villageId,GPauditpera pera)//auto increment village id
	{
		Connection con=null;
		ResultSet rs;
		PreparedStatement ps;
		try
		{
			con=GpperaDaoImpl.getConnection();
			Village village=null;
			village=StateDaoImpl.getAllVillage(con).get(villageId);
			pera.setVillage(village);
			int vid=village.getId();
			/*String select_village="select id from village_tbl where vid=?";
			ps=con.prepareStatement(select_village);
			ps.setInt(1,villageId);
			rs=ps.executeQuery();
			int id=0;
			while(rs.next())
			{
				id=rs.getInt("id");
				System.out.println(id);
			}*/
			
			String INSERT="insert into gp_audit_pera_tbl(vid,mth,yr,year_of_registration,total_pera,"
					+ "total_pera_answered_this_week,pera_not_answered,entry_date) values(?,?,?,?,?,?,?,?)";
			
			ps=con.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,vid);
			ps.setInt(2,pera.getYearmonth().getMonthValue());
			ps.setInt(3,pera.getYearmonth().getYear());
			ps.setInt(4, pera.getYearOfRegisteration());
			ps.setInt(5, pera.getTotalPera());
			ps.setInt(6, pera.getTotalPeraAnsweredThisWeek());
			ps.setInt(7,pera.getPeraNotanswered());
			ps.setDate(8,Date.valueOf(java.time.LocalDate.now()));
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			while(rs.next())
			{
				@SuppressWarnings("unused")
				int id1=rs.getInt(1);
			}
			
			rs.close();
			con.close();
		}
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return pera;
	}
	
	public GPauditpera getDetails(YearMonth yearmonth,int villageId)//census village id
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		GPauditpera pera=new GPauditpera();
		try
		{
			con=GpperaDaoImpl.getConnection();
			
			String getId="select id from village_tbl where vid=?";
			ps=con.prepareStatement(getId);
			ps.setInt(1,villageId);
			rs=ps.executeQuery();
			rs.next();
			Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
			int vid=village.getId();
			pera.setVillage(village);
			pera.setYearmonth(yearmonth);
			
			
			String GET_ALL="select * from gp_audit_pera_tbl where vid=? AND mth=? AND yr=?";
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1,vid);
			ps.setInt(2,yearmonth.getMonthValue());
			ps.setInt(3,yearmonth.getYear());
			rs=ps.executeQuery();
			
		    while(rs.next())
			{
				 pera.setId(rs.getInt("id"));
				 int year=rs.getInt("yr");
				 int month=rs.getInt("mth");
				 pera.setYearmonth(YearMonth.of(year, month));
				 pera.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
			 	 pera.setYearOfRegisteration(rs.getInt("year_of_registration"));
			 	 pera.setTotalPera(rs.getInt("total_pera"));
			 	 pera.setTotalPeraAnsweredThisWeek(rs.getInt("total_pera_answered_this_week"));
			 	 pera.setPeraNotanswered(rs.getInt("pera_not_answered"));
			 	 pera.setEntryDate(rs.getDate("entry_date").toLocalDate());
			}
			rs.close();
			con.close();
		
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return pera;
	}
	
	public GPauditpera update(GPauditpera pera,int villageId,YearMonth yearmonth)//auto increment village id
	{
		Connection con=null;
		PreparedStatement ps;
		
		try
		{
			con=GpperaDaoImpl.getConnection();
				
			Village village=StateDaoImpl.getAllVillage(con).get(villageId);
			int vid=village.getId();
			
		 final String update = "UPDATE GP_AUDIT_PERA_tbl SET year_of_registration=?,"
		 		+ "total_pera=?,total_pera_answered_this_week=?,pera_not_answered=?,"
		 		+ "entry_date=? where vid=?";
			
			ps = con.prepareStatement(update,Statement.RETURN_GENERATED_KEYS);
		
			ps.setInt(1,pera.getYearOfRegisteration());
			ps.setInt(2,pera.getTotalPera());
			ps.setInt(3,pera.getTotalPeraAnsweredThisWeek());
			ps.setInt(4,pera.getPeraNotanswered());
			ps.setDate(5,java.sql.Date.valueOf(pera.getEntryDate()));
			ps.setInt(6, vid);
			ps.executeUpdate();
			
	  } 
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return pera;
		
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
			con=GpperaDaoImpl.getConnection();
						
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
				
				String getCount="select count(*) from gp_audit_pera_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(getCount);
				ps.setInt(1,vid);
				ps.setInt(2,YearMonth.now().getMonthValue()-1);
				ps.setInt(3, YearMonth.now().getYear());
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
			con=GpperaDaoImpl.getConnection();
	
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
					
					String getCount="select count(*) from gp_audit_pera_tbl where vid=? AND mth=? AND yr=?";
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
