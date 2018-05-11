package com.zensoftech.eakarni.DAO;

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
import com.zensoftech.eakarni.entities.Hsg;
import com.zensoftech.eakarni.entities.JaminMehsulVeraVasulat;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class JaminMehsulDaoImpl implements JaminMehsulDao
{
	private static String driverName = "";
	    private static String databaseUrl = "";
	    private static String databaseUsername = "";
	    private static String databasePassword = "";
	    
	    public JaminMehsulDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

	    	JaminMehsulDaoImpl.driverName = driverName;
	    	JaminMehsulDaoImpl.databaseUrl = databaseUrl;
	    	JaminMehsulDaoImpl.databaseUsername = databaseUsername;
	    	JaminMehsulDaoImpl.databasePassword = databasePassword;
	        
	    }
	    
	   public static Connection getConnection() throws SQLException, ClassNotFoundException
	   {
	    	System.out.println("in connection method:");
	       	Class.forName("com.mysql.jdbc.Driver");
	       return DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
	   }
	public   Map<Integer,JaminMehsulVeraVasulat> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth)//census district id
	{
		ResultSet rs;
		PreparedStatement ps;
		Connection con;
		 Map<Integer, JaminMehsulVeraVasulat> jaminMehsulMap=new HashMap<Integer,JaminMehsulVeraVasulat>();
		try
		{
			con=JaminMehsulDaoImpl.getConnection();
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
			List<Integer> list1=new ArrayList();
			int tid=0;
			while(rs.next())
			{
				Taluka taluka=StateDaoImpl.getAllTalukas(con).get(rs.getInt("id"));
				tid=taluka.getId();
				list1.add(tid);
			}
			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<Integer> villageList=new ArrayList();
			for(int id2:list1)
			{
				String getvid="select id from village_tbl where tid=?";
				ps=con.prepareStatement(getvid);
				ps.setInt(1,id2);
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
				String GET_ALL="select * from jamin_mehsul_vera_vasulat_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(GET_ALL);
				ps.setInt(1,vid);
				ps.setInt(2, yearmonth.getMonthValue());
				ps.setInt(3, yearmonth.getYear());
				rs=ps.executeQuery();
				
			
			while(rs.next())
			{
				 JaminMehsulVeraVasulat jamin=new JaminMehsulVeraVasulat();
				 jamin.setId(rs.getInt("id"));
				 int month=rs.getInt("mth");
				 int year=rs.getInt("yr");
				 jamin.setYearmonth(YearMonth.of(year, month));
				 jamin.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				 jamin.setLandRevenue(rs.getDouble("land_revenue"));
				 jamin.setTotalAmountSeeking(rs.getDouble("total_amount_seeking"));
				 jamin.setAmountCollectedDuringMonth(rs.getDouble("amount_collected_during_month"));
				 jamin.setAmountLeft(rs.getDouble("amount_left"));
				 jamin.setPercentage(rs.getDouble("percentage"));
				 jamin.setEntryDate(rs.getDate("entry_date").toLocalDate());
				 jaminMehsulMap.put(jamin.getId(), jamin);
			
			}
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
		return jaminMehsulMap;
	}
	public   Map<Integer,JaminMehsulVeraVasulat> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth)//census taluka id
	{
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs;		
		 Map<Integer, JaminMehsulVeraVasulat> jaminMap=new HashMap<Integer,JaminMehsulVeraVasulat>();
		try
		{
			con=JaminMehsulDaoImpl.getConnection();
			
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
			int vid=0;
			rs=ps.executeQuery();
			@SuppressWarnings("rawtypes")
			List<Integer> villageList=new ArrayList();
			while(rs.next())
			{
				Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
				vid=village.getId();
				villageList.add(vid);
				
			}
			//System.out.println("list:"+villageList);
			for(int i:villageList)
			{
				String GET_ALL="select * from jamin_mehsul_vera_vasulat_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(GET_ALL,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1,i);
				ps.setInt(2,yearmonth.getMonthValue());
				ps.setInt(3,yearmonth.getYear());
				rs=ps.executeQuery();
							
			    while(rs.next())
				{ 
			    	JaminMehsulVeraVasulat jamin=new JaminMehsulVeraVasulat();
			    	jamin.setId(rs.getInt("id"));
			    	int month=rs.getInt("mth");
			    	int year=rs.getInt("yr");
			    	jamin.setYearmonth(YearMonth.of(year, month));
			    	jamin.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
			    	jamin.setLandRevenue(rs.getDouble("land_revenue"));
			    	jamin.setTotalAmountSeeking(rs.getDouble("total_amount_seeking"));
			    	jamin.setAmountCollectedDuringMonth(rs.getDouble("amount_collected_during_month"));
			    	jamin.setAmountLeft(rs.getDouble("amount_left"));
			    	jamin.setPercentage(rs.getDouble("percentage"));
			    	jamin.setEntryDate(rs.getDate("entry_date").toLocalDate());
			    	jaminMap.put(jamin.getId(), jamin);
				
				}
			}	
		    rs.close();
		    con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return jaminMap;
	}
	
	public Map<Integer,JaminMehsulVeraVasulat> getAllDetailsByVillageId(int villageId,YearMonth yearmonth)//census village id
	{
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs;		
		Map<Integer, JaminMehsulVeraVasulat> jaminMap=new HashMap<Integer,JaminMehsulVeraVasulat>();
		try
		{
			con=JaminMehsulDaoImpl.getConnection();
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
	
			String GET_ALL="select * from jamin_mehsul_vera_vasulat_tbl where vid=? AND mth=? AND yr=?";
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1,vid);
			ps.setInt(2,yearmonth.getMonthValue());
			ps.setInt(3,yearmonth.getYear());
			rs=ps.executeQuery();
			
		    while(rs.next())
			{
		    	 JaminMehsulVeraVasulat jamin=new JaminMehsulVeraVasulat();
				 jamin.setId(rs.getInt("id"));
				 int month=rs.getInt("mth");
				 int year=rs.getInt("yr");
				 jamin.setYearmonth(YearMonth.of(year, month));
				 jamin.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				 jamin.setLandRevenue(rs.getDouble("land_revenue"));
				 jamin.setTotalAmountSeeking(rs.getDouble("total_amount_seeking"));
				 jamin.setAmountCollectedDuringMonth(rs.getDouble("amount_collected_during_month"));
				 jamin.setAmountLeft(rs.getDouble("amount_left"));
				 jamin.setPercentage(rs.getDouble("percentage"));
				 jamin.setEntryDate(rs.getDate("entry_date").toLocalDate());
				 jaminMap.put(jamin.getId(), jamin);
				
			}
	
		    rs.close();
		    con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return jaminMap;
	}
	
	
	
	public JaminMehsulVeraVasulat insert(int villageId,JaminMehsulVeraVasulat jamin)//census id of village
	{
		Connection con;
		ResultSet rs;
		PreparedStatement ps;
		try
		{

			con=JaminMehsulDaoImpl.getConnection();
/*
			String select_village="select id from village_tbl where vid=?";
			ps=con.prepareStatement(select_village);
			ps.setInt(1,villageId);
			rs=ps.executeQuery();
			int id=0;
			while(rs.next())
			{
				id=rs.getInt("id");
				
			}
			System.out.println(id);*/
			Village village=null;
			village=StateDaoImpl.getAllVillage(con).get(villageId);
			jamin.setVillage(village);
			int vid=village.getId();
			
			String INSERT="insert into JAMIN_MEHSUL_VERA_VASULAT_tbl(vid,mth,yr,land_revenue,total_amount_seeking,amount_collected_during_month,amount_left,"
					+ "percentage,entry_date) values(?,?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
	
			ps.setInt(1,vid);
			ps.setInt(2,jamin.getYearmonth().getMonthValue());
			ps.setInt(3, jamin.getYearmonth().getYear());
			ps.setDouble(4,jamin.getLandRevenue());
			ps.setDouble(5, jamin.getTotalAmountSeeking());
			ps.setDouble(6,jamin.getAmountCollectedDuringMonth());
			ps.setDouble(7,jamin.getAmountLeft());
			ps.setDouble(8,jamin.getPercentage());
			ps.setDate(9,Date.valueOf(java.time.LocalDate.now()));
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
		return jamin;
	} 
	
	public JaminMehsulVeraVasulat getDetails(YearMonth yearmonth,int villageId)//census id of village
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		JaminMehsulVeraVasulat jamin=new JaminMehsulVeraVasulat();
		try
		{
			con=JaminMehsulDaoImpl.getConnection();
			
			String getId="select id from village_tbl where vid=?";
			ps=con.prepareStatement(getId);
			ps.setInt(1,villageId);
			rs=ps.executeQuery();
			rs.next();
			Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
			int vid=village.getId();
			jamin.setVillage(village);
		/*	jamin.setYearmonth(yearmonth);*/
			
			
			String GET_ALL="select * from jamin_mehsul_vera_vasulat_tbl where vid=? AND mth=? AND yr=?";
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1, vid);
			ps.setInt(2,yearmonth.getMonthValue());
			ps.setInt(3,yearmonth.getYear());
			rs=ps.executeQuery();
			
		    while(rs.next())
			{
		    	 jamin.setId(rs.getInt("id"));
				 /*jamin.setMth(rs.getInt("mth"));
				 jamin.setYr(rs.getInt("yr"));*/
		    	 int month=rs.getInt("mth");
		    	 int year=rs.getInt("yr");
				 jamin.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				 jamin.setYearmonth(YearMonth.of(year, month));
				 jamin.setLandRevenue(rs.getDouble("land_revenue"));
				 jamin.setTotalAmountSeeking(rs.getDouble("total_amount_seeking"));
				 jamin.setAmountCollectedDuringMonth(rs.getDouble("amount_collected_during_month"));
				 jamin.setAmountLeft(rs.getDouble("amount_left"));
				 jamin.setPercentage(rs.getDouble("percentage"));
				 jamin.setEntryDate(rs.getDate("entry_date").toLocalDate());
				
			}
			
			rs.close();
			con.close();
		
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return jamin;
	}
	
	
	public JaminMehsulVeraVasulat update(JaminMehsulVeraVasulat jamin,int villageId,YearMonth yearmonth)//auto increment id of village
	{
		Connection con=null;
		PreparedStatement ps;
		boolean jamindata;
		
		try
		{
			jamindata=true;
			con=JaminMehsulDaoImpl.getConnection();
		
			Village village=StateDaoImpl.getAllVillage(con).get(villageId);
			int vid=village.getId();
			
			final String update = "UPDATE JAMIN_MEHSUL_VERA_VASULAT_tbl SET land_revenue=?,"
			 		+ "total_amount_seeking=?,amount_collected_during_month=?,amount_left=?,"
			 		+ "percentage=?,entry_date=? where vid=? AND mth=? AND yr=?";
				
			
		 	ps = con.prepareStatement(update,Statement.RETURN_GENERATED_KEYS);
		 	ps.setDouble(1,jamin.getLandRevenue());
			ps.setDouble(2,jamin.getTotalAmountSeeking());
			ps.setDouble(3,jamin.getAmountCollectedDuringMonth());
			ps.setDouble(4,jamin.getAmountLeft());
			ps.setDouble(5,jamin.getPercentage());
			ps.setDate(6,java.sql.Date.valueOf(java.time.LocalDate.now()));
			ps.setInt(7, villageId);
			ps.setInt(8, yearmonth.getMonthValue());
			ps.setInt(9,yearmonth.getYear());
			ps.executeUpdate();
	     } 
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return jamin;
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
			con=JaminMehsulDaoImpl.getConnection();

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
				
				String getCount="select count(*) from jamin_mehsul_vera_vasulat_tbl where vid=? AND mth=? AND yr=?";
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
			con=JaminMehsulDaoImpl.getConnection();
	
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
					
					String getCount="select count(*) from jamin_mehsul_vera_vasulat_tbl where vid=? AND mth=? AND yr=?";
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
