package com.zensoftech.eakarni.DAO;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.sql.Connection;
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

import com.zensoftech.eakarni.entities.District;
import com.zensoftech.eakarni.entities.Hsg;
import com.zensoftech.eakarni.entities.SMB;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class SmbDaoImpl implements SmbDao
{
	 	private static String driverName = "";
	    private static String databaseUrl = "";
	    private static String databaseUsername = "";
	    private static String databasePassword = "";
	    
	    public SmbDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

	    	SmbDaoImpl.driverName = driverName;
	    	SmbDaoImpl.databaseUrl = databaseUrl;
	    	SmbDaoImpl.databaseUsername = databaseUsername;
	    	SmbDaoImpl.databasePassword = databasePassword;
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
	public   Map<Integer, SMB> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth)
	
	{
		
		Connection con;
		PreparedStatement ps;
		Map<Integer, SMB> smbMap=new HashMap<Integer,SMB>();
		ResultSet rs;
		try
		{
			con=SmbDaoImpl.getConnection();
			
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
				String GET_ALL="select * from smb_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(GET_ALL);
				ps.setInt(1,vid);
				ps.setInt(2,yearmonth.getMonthValue());
				ps.setInt(3, yearmonth.getYear());
				rs=ps.executeQuery();
			while(rs.next())
			{
				 SMB smb=new SMB();
				 smb.setId(rs.getInt("id"));
				 int month=rs.getInt("mth");
				 int year=rs.getInt("yr");
				 smb.setYearmonth(YearMonth.of(year, month));
				 smb.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				 smb.setTotalFamilies(rs.getInt("total_families"));
				 smb.setFamiliesHavingLavatories(rs.getInt("families_having_lavatories"));
				 smb.setFamiliesNotHavingLavatories(rs.getInt("families_not_having_lavatories"));
				 smb.setLavatoriesMadeDuringWeek(rs.getInt("no_of_lavatories_made_during_week"));
				 smb.setEntryDate(java.time.LocalDate.now());
				 smbMap.put(smb.getId(),smb);
			}
			
			/*for(Map.Entry<Integer,SMB> smbEntry: smbMap.entrySet())
			{
			       System.out.print(smbEntry.getKey()+" ---- ");
			       System.out.println(smbEntry.getValue());
			}*/
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
		return smbMap;

	}
	
	public   Map<Integer,SMB> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth)
	{
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs;		
		 Map<Integer, SMB> smbMap=new HashMap<Integer,SMB>();
		try
		{
			con=SmbDaoImpl.getConnection();
			
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
				String GET_ALL="select * from smb_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(GET_ALL,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1,vid);
				ps.setInt(2, yearmonth.getMonthValue());
				ps.setInt(3, yearmonth.getYear());
				rs=ps.executeQuery();
			
			    while(rs.next())
				{
			    	SMB smb=new SMB();
					 smb.setId(rs.getInt("id"));
					 int month=rs.getInt("mth");
					 int year=rs.getInt("yr");
					 smb.setYearmonth(YearMonth.of(year, month));
					 smb.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
					 smb.setTotalFamilies(rs.getInt("total_families"));
					 smb.setFamiliesHavingLavatories(rs.getInt("families_having_lavatories"));
					 smb.setFamiliesNotHavingLavatories(rs.getInt("families_not_having_lavatories"));
					 smb.setLavatoriesMadeDuringWeek(rs.getInt("no_of_lavatories_made_during_week"));
					 smb.setEntryDate(java.time.LocalDate.now());
					 smbMap.put(smb.getId(),smb);
				}
			}	
		    rs.close();
		    con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return smbMap;
	}
	
	public   Map<Integer,SMB> getAllDetailsByVillageId(int villageId,YearMonth yearmonth)
	{
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs;		
		 Map<Integer,SMB> smbMap=new HashMap<Integer,SMB>();
		try
		{
			con=SmbDaoImpl.getConnection();
			
			
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
	
			String GET_ALL="select * from smb_tbl where vid=? AND mth=? AND yr=?";
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1,id);
			ps.setInt(2,yearmonth.getMonthValue());
			ps.setInt(3,yearmonth.getYear());
			rs=ps.executeQuery();
			
		    while(rs.next())
			{
		    	SMB smb=new SMB();
				 smb.setId(rs.getInt("id"));
				 int month=rs.getInt("mth");
				 int year=rs.getInt("yr");
				 smb.setYearmonth(YearMonth.of(year, month));
				 smb.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				 smb.setTotalFamilies(rs.getInt("total_families"));
				 smb.setFamiliesHavingLavatories(rs.getInt("families_having_lavatories"));
				 smb.setFamiliesNotHavingLavatories(rs.getInt("families_not_having_lavatories"));
				 smb.setLavatoriesMadeDuringWeek(rs.getInt("no_of_lavatories_made_during_week"));
				 smb.setEntryDate(java.time.LocalDate.now());
				 smbMap.put(smb.getId(),smb);
			}
	
		    rs.close();
		    con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return smbMap;
	}
	
	
	
	public SMB insert(int villageId,SMB smb)
	{
		ResultSet rs;
		PreparedStatement ps = null;
		Connection con;
		try
		{
			con=SmbDaoImpl.getConnection();
			
    	
			Village village=StateDaoImpl.getAllVillage(con).get(villageId);

			String INSERT="insert into smb_tbl(vid,mth,yr,total_families,families_having_lavatories,"
					+ "families_not_having_lavatories,no_of_lavatories_made_during_week,entry_date) values(?,?,?,?,?,?,?,?)";
			
			ps=con.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,village.getId());
			ps.setInt(2,smb.getYearmonth().getMonthValue());
			ps.setInt(3,smb.getYearmonth().getYear());
			ps.setInt(4,smb.getTotalFamilies());
			ps.setInt(5,smb.getFamiliesHavingLavatories());
			ps.setInt(6,smb.getFamiliesNotHavingLavatories());
			ps.setInt(7, smb.getLavatoriesMadeDuringWeek());
			ps.setDate(8,java.sql.Date.valueOf(java.time.LocalDate.now()));
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			while(rs.next())
			{
				@SuppressWarnings("unused")
				int id1=rs.getInt(1);
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return smb;
	}
	
	public SMB getDetails(YearMonth yearmonth,int villageId)
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		SMB smb=new SMB();
		try
		{
			con=SmbDaoImpl.getConnection();
			
			String getId="select id from village_tbl where vid=? ";
			ps=con.prepareStatement(getId);
			ps.setInt(1,villageId);
			rs=ps.executeQuery();
			rs.next();
			Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
			int vid=village.getId();
			smb.setVillage(village);
			smb.setYearmonth(yearmonth);
			
			
			String GET_ALL="select * from smb_tbl where vid=? AND mth=? AND yr=?";
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1,vid);
			ps.setInt(2, yearmonth.getMonthValue());
			ps.setInt(3,yearmonth.getYear());
			rs=ps.executeQuery();
			
		    while(rs.next())
			{
		    	
				 smb.setId(rs.getInt("id"));
				 int month=rs.getInt("mth");
				 int year=rs.getInt("yr");
				 smb.setYearmonth(YearMonth.of(year, month));
				 smb.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				 smb.setTotalFamilies(rs.getInt("total_families"));
				 smb.setFamiliesHavingLavatories(rs.getInt("families_having_lavatories"));
				 smb.setFamiliesNotHavingLavatories(rs.getInt("families_not_having_lavatories"));
				 smb.setLavatoriesMadeDuringWeek(rs.getInt("no_of_lavatories_made_during_week"));
				 smb.setEntryDate(rs.getDate("entry_date").toLocalDate());
				
			}
			
		
			
			rs.close();
			con.close();
		
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return smb;
	}
	
	
	public SMB update(SMB smb,int villageId,YearMonth yearmonth)
	{
		Connection con=null;
		PreparedStatement ps;
		try
		{
			con=SmbDaoImpl.getConnection();
			Village village=StateDaoImpl.getAllVillage(con).get(villageId);
			System.out.println(village);
		
			smb.setVillage(village);
		
			
			 final String update = "UPDATE smb_tbl SET total_families=?,families_having_lavatories=?,"
			 		+ "families_not_having_lavatories=?,no_of_lavatories_made_during_week=?,entry_date=? where vid=? AND mth=? AND yr=?";
			
		 		ps = con.prepareStatement(update,Statement.RETURN_GENERATED_KEYS);
		 		
		 		ps.setInt(1,smb.getTotalFamilies());
				ps.setInt(2,smb.getFamiliesHavingLavatories());
				ps.setInt(3,smb.getFamiliesNotHavingLavatories());
				ps.setInt(4,smb.getLavatoriesMadeDuringWeek());
				ps.setDate(5,java.sql.Date.valueOf(java.time.LocalDate.now()));
				ps.setInt(6, villageId);
				ps.setInt(7,yearmonth.getMonthValue());
				ps.setInt(8,yearmonth.getYear());
	            ps.executeUpdate();
	 
	     } 
		
		catch(Exception e)
		{
			e.printStackTrace();
		}

		System.out.println("success");
		return smb;
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
				
				String getCount="select count(*) from smb_tbl where vid=? AND mth=? AND yr=?";
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
					
					String getCount="select count(*) from smb_tbl where vid=? AND mth=? AND yr=?";
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
