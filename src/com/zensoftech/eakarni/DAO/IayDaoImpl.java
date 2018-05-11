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
import com.zensoftech.eakarni.entities.Hsg;
import com.zensoftech.eakarni.entities.Iay;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class IayDaoImpl implements IayDao
{
	
	private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
    
    public IayDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword)
    {

    	IayDaoImpl.driverName = driverName;
    	IayDaoImpl.databaseUrl = databaseUrl;
    	IayDaoImpl.databaseUsername = databaseUsername;
    	IayDaoImpl.databasePassword = databasePassword;
    }
    
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
    	System.out.println("in connection method:");
    	Class.forName("com.mysql.jdbc.Driver");
    	return DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
    }
	
	public  Map<Integer,Iay> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth)//census district id
	{
		 Map<Integer,Iay> iayMap=new HashMap<Integer,Iay>();
		 Connection con;
		 PreparedStatement ps;
		 ResultSet rs;
		try
		{
		
			con=IayDaoImpl.getConnection();
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
				String GET_ALL="select * from iay_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(GET_ALL);
				ps.setInt(1,vid);
				ps.setInt(2,yearmonth.getMonthValue());
				ps.setInt(3, yearmonth.getYear());
				rs=ps.executeQuery();
	
					while(rs.next())
					{
						Iay iay=new Iay();
						iay.setId(rs.getInt("id"));
						int month=rs.getInt("mth");
						int year=rs.getInt("yr");
						iay.setYearmonth(YearMonth.of(year, month));
						iay.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
						iay.setTarget(rs.getInt("target"));
						iay.setFirstInstallment(rs.getDouble("first_installment"));
						iay.setSecondInstallment(rs.getDouble("second_installment"));
						iay.setThirdInstallment(rs.getDouble("third_installment"));
						iay.setEntryDate(rs.getDate("entry_date").toLocalDate());
						iayMap.put(iay.getId(), iay);
					}
			}
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	 return iayMap;
		
}
			
		
	
		public   Map<Integer,Iay> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth)//census taluka id
		{
			Connection con = null;
			PreparedStatement ps=null;
			ResultSet rs;		
			 Map<Integer, Iay> iayMap=new HashMap<Integer,Iay>();
			try
			{
			
				con=IayDaoImpl.getConnection();
				String getTid="select id from taluka_tbl where tid=?";
				ps=con.prepareStatement(getTid);
				ps.setInt(1,talukaId);
				rs=ps.executeQuery();
				int id1=0;
				while(rs.next())
				{
					id1=rs.getInt("id");
				}
				
				String getvid="select id from village_tbl where tid=?";
				ps=con.prepareStatement(getvid);
				ps.setInt(1,id1);
				int id=0;
				rs=ps.executeQuery();
				@SuppressWarnings("rawtypes")
				List<Integer> list=new ArrayList();
				while(rs.next())
				{
					id=rs.getInt("id");
					//System.out.println("id:"+id);
					list.add(rs.getInt("id"));
					
				}
				//System.out.println("list:"+list);
				for(int i:list)
				{
					String GET_ALL="select * from iay_tbl where vid=? AND mth=? AND yr=?";
					ps=con.prepareStatement(GET_ALL,Statement.RETURN_GENERATED_KEYS);
					ps.setInt(1,i);
					ps.setInt(2,yearmonth.getMonthValue());
					ps.setInt(3, yearmonth.getYear());
					rs=ps.executeQuery();
					Village village=new Village();
					village.setId(i);
				
				    while(rs.next())
					{
				    	 Iay iay=new Iay();
				    	 iay.setId(rs.getInt("id"));
						 int month=rs.getInt("mth");
						 int year=rs.getInt("yr");
						 iay.setYearmonth(YearMonth.of(year, month));
						 iay.setTarget(rs.getInt("target"));
						 iay.setFirstInstallment(rs.getDouble("first_installment"));
						 iay.setSecondInstallment(rs.getDouble("second_installment"));
						 iay.setThirdInstallment(rs.getDouble("third_installment"));
						 iay.setEntryDate(rs.getDate("entry_date").toLocalDate());
						 iayMap.put(iay.getId(),iay);
					}	
				   
				}
				rs.close();
			    con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return iayMap;
		}
		
		public Map<Integer,Iay> getAllDetailsByVillageId(int villageId,YearMonth yearmonth)
		{
			Connection con = null;
			PreparedStatement ps=null;
			ResultSet rs;		
			Map<Integer, Iay> iayMap=new HashMap<Integer,Iay>();
			try
			{
				con=IayDaoImpl.getConnection();
				
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
		
				String GET_ALL="select * from iay_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(GET_ALL);
				ps.setInt(1,id);
				ps.setInt(2, yearmonth.getMonthValue());
				ps.setInt(3, yearmonth.getYear());
				rs=ps.executeQuery();
				
			    while(rs.next())
				{
			    	 Iay iay=new Iay();
			    	 iay.setId(rs.getInt("id"));
					 int month=rs.getInt("mth");
					 int year=rs.getInt("yr");
					 iay.setYearmonth(YearMonth.of(year, month));;
					 iay.setTarget(rs.getInt("target"));
					 iay.setFirstInstallment(rs.getDouble("first_installment"));
					 iay.setSecondInstallment(rs.getDouble("second_installment"));
					 iay.setThirdInstallment(rs.getDouble("third_installment"));
					 iay.setEntryDate(rs.getDate("entry_date").toLocalDate());
					 iayMap.put(iay.getId(),iay);
				}
		
			    rs.close();
			    con.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return iayMap;
		}


		public Iay insert(int villageId,Iay iay)//auto increment of village
		{
			Connection con;
			ResultSet rs;
			PreparedStatement ps;
			try
			{
				con=IayDaoImpl.getConnection();

				
				
				/*String select_village="select id from village_tbl where vid=?";
				ps=con.prepareStatement(select_village);
				ps.setInt(1,villageId);
				rs=ps.executeQuery();
				int id=0;
				while(rs.next())
				{
					Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt(id));
					id=village.getId();
				}*/
		
				Village village=null;
    			village=StateDaoImpl.getAllVillage(con).get(villageId);
    			iay.setVillage(village);
    			int vid=village.getId();
				String INSERT="insert into iay_tbl(vid,mth,yr,target,first_installment,second_installment,third_installment,"
						+ "entry_date) values(?,?,?,?,?,?,?,?)";
				ps=con.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1,vid);
				ps.setInt(2,iay.getYearmonth().getMonthValue());
    			ps.setInt(3, iay.getYearmonth().getYear());
				ps.setDouble(4,iay.getTarget());
				ps.setDouble(5,iay.getFirstInstallment());
				ps.setDouble(6,iay.getSecondInstallment());
				ps.setDouble(7,iay.getThirdInstallment());
				ps.setDate(8,Date.valueOf(java.time.LocalDate.now()));
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
			return iay;
		}
		
		public Iay getDetails(YearMonth yearmonth,int villageId)
		{
			Connection con;
			PreparedStatement ps;
			ResultSet rs;
			Iay iay=new Iay();
			try
			{
				con=IayDaoImpl.getConnection();
				
				String getId="select id from village_tbl where vid=?";
				ps=con.prepareStatement(getId);
				ps.setInt(1,villageId);
				rs=ps.executeQuery();
				rs.next();
				Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
				int vid=village.getId();
				
				iay.setVillage(village);
				iay.setYearmonth(yearmonth);
				
				
				String GET_ALL="select * from iay_tbl where vid=? AND mth=? AND yr=?";
				ps=con.prepareStatement(GET_ALL);
				ps.setInt(1,vid);
				ps.setInt(2,yearmonth.getMonthValue());
				ps.setInt(3,yearmonth.getYear());

				rs=ps.executeQuery();
				
			    while(rs.next())
				{
			    	 
			    	 iay.setId(rs.getInt("id"));
					 iay.setTarget(rs.getInt("target"));
					 iay.setFirstInstallment(rs.getDouble("first_installment"));
					 iay.setSecondInstallment(rs.getDouble("second_installment"));
					 iay.setThirdInstallment(rs.getDouble("third_installment"));
					 iay.setEntryDate(rs.getDate("entry_date").toLocalDate());
				}
				rs.close();
				con.close();
			
			}

			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return iay;
		}
		
		
		public Iay update(Iay iay,int villageId,YearMonth yearmonth)
		{
			Connection con=null;
			PreparedStatement ps;
			boolean iaydata;
			
			try
			{
				iaydata=true;
				con=IayDaoImpl.getConnection();
			
				Village village=StateDaoImpl.getAllVillage(con).get(villageId);
				System.out.println(village);
			
				iay.setVillage(village);
				
				
				 final String update = "UPDATE iay_tbl SET target=?,first_installment=?,"
					 		+ "second_installment=?,third_installment=?,entry_date=? where vid=? AND mth=? AND yr=?";
						
				ps = con.prepareStatement(update,Statement.RETURN_GENERATED_KEYS);
				ps.setDouble(1,iay.getTarget());
				ps.setDouble(2,iay.getFirstInstallment());
				ps.setDouble(3,iay.getSecondInstallment());
				ps.setDouble(4,iay.getThirdInstallment());
				ps.setDate(5,java.sql.Date.valueOf(java.time.LocalDate.now()));
				ps.setInt(6, villageId);
				ps.setInt(7, yearmonth.getMonthValue());
				ps.setInt(8,yearmonth.getYear());
				ps.executeUpdate();
		        
		      con.close();
		 
		     } 
			
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return iay;
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
				con=IayDaoImpl.getConnection();
								
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
					
					String getCount="select count(*) from iay_tbl where vid=? AND mth=? AND yr=?";
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
				con=IayDaoImpl.getConnection();
		
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
						
						String getCount="select count(*) from iay_tbl where vid=? AND mth=? AND yr=?";
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