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
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zensoftech.eakarni.entities.District;
import com.zensoftech.eakarni.entities.Gramswagat;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class GramswagatDaoImpl implements GramswagatDao
{
	private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
    public GramswagatDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

    	GramswagatDaoImpl.driverName = driverName;
    	GramswagatDaoImpl.databaseUrl = databaseUrl;
    	GramswagatDaoImpl.databaseUsername = databaseUsername;
    	GramswagatDaoImpl.databasePassword = databasePassword;
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
	public Map<Integer, Gramswagat> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth)
	{
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs;
		Map<Integer,Gramswagat> gramswagatMap=new HashMap<Integer,Gramswagat>();
		
		try
		{
			con=GramswagatDaoImpl.getConnection();
			String getDid="select id from district_tbl where did=?";
			ps=con.prepareStatement(getDid);
			ps.setInt(1,districtId);
			rs=ps.executeQuery();
			int did=0;
			while(rs.next())
			{
				District district =StateDaoImpl.getAllDistricts(con).get(rs.getInt("id"));
				did=district.getId();
				System.out.println("district id:"+did);
				
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
				/*System.out.println(talukaList);*/
			}
			System.out.println("talukaList:"+talukaList);
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
				System.out.println("village list:"+villageList);
				
				
			}
			for(int vid:villageList)
			{
				String GET_ALL="select * from gramswagat_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(GET_ALL);
				ps.setInt(1,vid);
				ps.setInt(2,yearmonth.getMonthValue());
				ps.setInt(3,yearmonth.getYear());
				rs=ps.executeQuery();
			
			while(rs.next())
			{
				 Gramswagat gramswagat=new Gramswagat();
				 gramswagat.setId(rs.getInt("id"));
				 gramswagat.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				 int month=rs.getInt("mth");
				 int year=rs.getInt("yr");
				 gramswagat.setYearmonth(YearMonth.of(year, month));
				 gramswagat.setDescriptionOfQuestionsRaised(rs.getString("description_of_questions_raised"));
				 gramswagat.setDisposal(rs.getInt("disposal"));
				 gramswagat.setPending(rs.getInt("pending"));
				 gramswagat.setEntryDate(rs.getDate("entry_date").toLocalDate());
				 gramswagatMap.put(gramswagat.getId(),gramswagat);
			
			}
		
			}
			rs.close();
			con.close();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		
		return gramswagatMap;
	}
	
	public   Map<Integer,Gramswagat> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth)
	{
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs;		
		 Map<Integer,Gramswagat> gramswagatMap=new HashMap<Integer,Gramswagat>();
		try
		{
			con=GramswagatDaoImpl.getConnection();
			
			String getTid="select id from taluka_tbl where tid=?";
			ps=con.prepareStatement(getTid);
			ps.setInt(1,talukaId);
			rs=ps.executeQuery();
			int tid=0;
			while(rs.next())
			{
				tid=rs.getInt("id");
				System.out.println("taluka id"+tid);
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
				id=rs.getInt("id");
				//System.out.println("id:"+id);
				villageList.add(rs.getInt("id"));
				
			}
			System.out.println("list:"+villageList);
			for(int i:villageList)
			{
				String GET_ALL="select * from gramswagat_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(GET_ALL,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1,i);
				ps.setInt(2,yearmonth.getMonthValue());
				ps.setInt(3, yearmonth.getYear());
				rs=ps.executeQuery();
				
			
			    while(rs.next())
				{
			    	 Gramswagat gramswagat=new Gramswagat();
					 gramswagat.setId(rs.getInt("id"));
					 int month=rs.getInt("mth");
					 int year=rs.getInt("yr");
					 gramswagat.setYearmonth(YearMonth.of(year, month));
					 gramswagat.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
					 gramswagat.setDescriptionOfQuestionsRaised(rs.getString("description_of_questions_raised"));
					 gramswagat.setDisposal(rs.getInt("disposal"));
					 gramswagat.setPending(rs.getInt("pending"));
					 gramswagat.setEntryDate(rs.getDate("entry_date").toLocalDate());
					 gramswagatMap.put(gramswagat.getId(),gramswagat);
					
				}

	
			}	
		    rs.close();
		    con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return gramswagatMap;
	}
	
	public   Map<Integer,Gramswagat> getAllDetailsByVillageId(int villageId,YearMonth yearmonth)
	{
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs;		
		 Map<Integer,Gramswagat> gramswagatMap=new HashMap<Integer,Gramswagat>();
		try
		{
			con=GramswagatDaoImpl.getConnection();
			
			String getVid="select id from village_tbl where vid=? ";
			ps=con.prepareStatement(getVid);
			ps.setInt(1,villageId);
			
			rs=ps.executeQuery();
			int vid=0;
			while(rs.next())
			{
				vid=rs.getInt("id");
				System.out.print("village id:"+vid);
			}
	
			String GET_ALL="select * from gramswagat_tbl where vid=? AND mth=? AND yr=?";
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1,vid);
			ps.setInt(2,yearmonth.getMonthValue() );
			ps.setInt(3,yearmonth.getYear());
			rs=ps.executeQuery();
			
			
		    while(rs.next())
			{
		    	 Gramswagat gramswagat=new Gramswagat();
				 gramswagat.setId(rs.getInt("id"));
				 int month=rs.getInt("mth");
				 int year=rs.getInt("yr");
				 gramswagat.setYearmonth(YearMonth.of(year, month));
				 gramswagat.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				 gramswagat.setDescriptionOfQuestionsRaised(rs.getString("description_of_questions_raised"));
				 gramswagat.setDisposal(rs.getInt("disposal"));
				 gramswagat.setPending(rs.getInt("pending"));
				 gramswagat.setEntryDate(rs.getDate("entry_date").toLocalDate());
				 gramswagatMap.put(gramswagat.getId(),gramswagat);
				
				
			}
	
		    rs.close();
		    con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return gramswagatMap;
	}
	
	public Gramswagat insert(int villageId,Gramswagat gramswagat)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try
		{
			con=GramswagatDaoImpl.getConnection();
			Village village=null;
			village=StateDaoImpl.getAllVillage(con).get(villageId);
			gramswagat.setVillage(village);
			int vid=village.getId();
		
			

			String insertsmb="insert into gramswagat_tbl(vid,mth,yr,disposal,pending,description_of_questions_raised,entry_date)"
					+ "values(?,?,?,?,?,?,?)";
			
			
			ps=con.prepareStatement(insertsmb,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,vid);
			ps.setInt(2,gramswagat.getYearmonth().getMonthValue());
			ps.setInt(3,gramswagat.getYearmonth().getYear());
			ps.setInt(4,gramswagat.getDisposal());
			ps.setInt(5,gramswagat.getPending());
			ps.setString(6, gramswagat.getDescriptionOfQuestionsRaised());
			ps.setDate(7,Date.valueOf(java.time.LocalDate.now()));
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
		return gramswagat;
	}
	
	public Gramswagat getDetails(YearMonth yearmonth,int villageId)
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		Gramswagat gramswagat=new Gramswagat();
		try
		{
			con=GramswagatDaoImpl.getConnection();
			
			String getId="select id from village_tbl where vid=?";
			ps=con.prepareStatement(getId);
			ps.setInt(1,villageId);
			rs=ps.executeQuery();
			Village village=null;
			while(rs.next())
			{
				village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
				
			}
			 
			gramswagat.setVillage(village);
			gramswagat.setYearmonth(yearmonth);
			int vid=village.getId();
			
			String GET_ALL="select * from gramswagat_tbl where vid=? AND mth=? AND yr=?";
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1,vid);
			ps.setInt(2,yearmonth.getMonthValue() );
			ps.setInt(3,yearmonth.getYear());
			rs=ps.executeQuery();
			
			
		    while(rs.next())
			{
				 gramswagat.setId(rs.getInt("id"));
				 int month=rs.getInt("mth");
				 int year=rs.getInt("yr");
				 gramswagat.setYearmonth(YearMonth.of(year, month));
				 gramswagat.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				 gramswagat.setDescriptionOfQuestionsRaised(rs.getString("description_of_questions_raised"));
				 gramswagat.setDisposal(rs.getInt("disposal"));
				 gramswagat.setPending(rs.getInt("pending"));
				 gramswagat.setEntryDate(java.time.LocalDate.now());
				 
				
				
			}
			
			rs.close();
			con.close();
		
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return gramswagat;
	}
	
	
	public Gramswagat update(Gramswagat gramswagat,int villageId,YearMonth yearmonth)
	{
		Connection con=null;
		PreparedStatement ps;
		boolean gramswagatdata;
		
		try
		{
			gramswagatdata=true;
			con=GramswagatDaoImpl.getConnection();
			Village village=StateDaoImpl.getAllVillage(con).get(villageId);
			System.out.println(village);
		
			gramswagat.setVillage(village);
			
			
			final String update = "UPDATE gramswagat_tbl SET  disposal=?,pending=?,description_of_questions_raised=?,"
					+ "entry_date=? where vid=? AND mth=? AND yr=?";
			
			ps = con.prepareStatement(update);
			ps.setInt(1,gramswagat.getDisposal());
			ps.setInt(2,gramswagat.getPending());
			ps.setString(3, gramswagat.getDescriptionOfQuestionsRaised());
			ps.setDate(4,java.sql.Date.valueOf(java.time.LocalDate.now()));
			ps.setInt(5, villageId);
			ps.setInt(6, yearmonth.getMonthValue());
			ps.setInt(7,yearmonth.getYear());
			ps.executeUpdate();
			System.out.println("successfully updated");
			
		}
		

		catch(Exception e)
		{
			e.printStackTrace();
		}
		return gramswagat;
	
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
			con=GramswagatDaoImpl.getConnection();
			
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
				
				String getCount="select count(*) from gramswagat_tbl where vid=? AND mth=? AND yr=?";
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
					
					String getCount="select count(*) from gramswagat_tbl where vid=? AND mth=? AND yr=?";
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

	
	



