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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.zensoftech.eakarni.entities.Cdp;
import com.zensoftech.eakarni.entities.District;
import com.zensoftech.eakarni.entities.Hsg;
import com.zensoftech.eakarni.entities.PropertyDetails;
import com.zensoftech.eakarni.entities.PropertyMaster;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class PropertyDaoImpl implements PropertyDao
{

	private static String driverName = "";
	    private static String databaseUrl = "";
	    private static String databaseUsername = "";
	    private static String databasePassword = "";
	    
	    public PropertyDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

	    	PropertyDaoImpl.driverName = driverName;
	    	PropertyDaoImpl.databaseUrl = databaseUrl;
	    	PropertyDaoImpl.databaseUsername = databaseUsername;
	    	PropertyDaoImpl.databasePassword = databasePassword;
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
	public  Map<Integer,PropertyMaster> getAllDetailsByDistrictId(int districtId)
	{
		Connection con;
		PreparedStatement ps;
		Map<Integer, PropertyMaster> propertyMap=new HashMap<Integer,PropertyMaster>();
		ResultSet rs;
		try
		{
			con=PropertyDaoImpl.getConnection();
			
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
				propertyMap=PropertyDaoImpl.getAllPropertyByVillageId(con, vid);
				/*System.out.println("in for:"+propertyMap);*/
				/*System.out.println("property map in dao:"+propertyMap);*/
			}	
		    rs.close();
		    con.close();
			
		  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return propertyMap;
				
}
	public   Map<Integer,PropertyMaster> getAllDetailsByTalukaId(int talukaId)
	{
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs;		
		 Map<Integer, PropertyMaster> propertyMap=new HashMap<Integer,PropertyMaster>();
		try
		{
			con=PropertyDaoImpl.getConnection();
			
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
				propertyMap=PropertyDaoImpl.getAllPropertyByVillageId(con, vid);
				/*System.out.println("in for:"+propertyMap);*/
				/*System.out.println("property map in dao:"+propertyMap);*/
			}	
		    rs.close();
		    con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("property map in dao:"+propertyMap);
		return propertyMap;
	}
	
	private static Map<Integer,PropertyMaster> propertyMap;
	public Map<Integer, PropertyMaster> getAllPropertyByVillage(int villageId) throws ClassNotFoundException, SQLException {
		Connection con=PropertyDaoImpl.getConnection();
		return PropertyDaoImpl.getAllPropertyByVillageId(con, villageId);
		
	}
	
	public static Map<Integer, PropertyMaster> getAllPropertyByVillageId(Connection con,int villageId) throws ClassNotFoundException, SQLException {
		PreparedStatement ps=null;
		ResultSet rs=null;

		if(propertyMap== null){
		
			Map<Integer,PropertyMaster> MapProperty=new TreeMap<>();
			Map<Integer,Integer> parentMap=new TreeMap<>();
			//con=StateDaoImpl.getConnection();
			/*String selectProperty="select * from property_master_tbl where vid=?";
			ps=con.prepareStatement(selectProperty);
			ps.setInt(1,villageId);
			rs=ps.executeQuery();*/
			
			/*String getVid="select id from village_tbl where vid=?";
			ps=con.prepareStatement(getVid);
			ps.setInt(1,villageId);
			rs=ps.executeQuery();
			int id=0;
			while(rs.next())
			{
				Village village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
				id=village.getId();
			
				
			}*/
			String GetProperty="select * from property_master_tbl where vid=?";
			ps=con.prepareStatement(GetProperty);
			ps.setInt(1,villageId);
			rs=ps.executeQuery();
			
 			while(rs.next())
 			{
 			
 				PropertyMaster property=new PropertyMaster(); 
				property.setId(rs.getInt("id"));
				property.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				property.setPropertyNo(rs.getString("property_no"));
				property.setAreaName(rs.getString("area_name"));
				property.setSplit(rs.getBoolean("split"));
				property.setDescription(rs.getString("description"));
				property.setRegistrationYear(rs.getInt("registration_year"));
				property.setRegisterPageNo(rs.getInt("register_page_no"));
				/*property.parent=property;*/
				property.setParent(rs.getString("parent"));
				
				MapProperty.put(property.getId(),property);
				parentMap.put(property.getId(), rs.getInt("parent"));
				
				
				for(Integer id1:parentMap.keySet())
				{
					MapProperty.get(id1).setParent(property.parent);
				}
					
			}
 			
		PropertyDaoImpl.propertyMap=MapProperty;
		}

		return Collections.unmodifiableMap(PropertyDaoImpl.propertyMap);
	}

	/*
	public   Map<Integer,PropertyMaster> getAllDetailsByVillageId(int villageId)
	{
		Connection con = null;
		PreparedStatement ps=null;
		PropertyMaster property=new PropertyMaster(); 
		ResultSet rs;		
		 Map<Integer, PropertyMaster> propertyMap=new HashMap<Integer,PropertyMaster>();
		try
		{
			con=PropertyDaoImpl.getConnection();
			
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
			String GETParent="select id from property_master_tbl where vid=?";
			ps=con.prepareStatement(GETParent);
			ps.setInt(1,id);
			int parentId=0;
			rs=ps.executeQuery();
			while(rs.next())
			{
				parentId=rs.getInt("id");
			}
			property.setId(parentId);
			PropertyMaster parent=new PropertyMaster();
			parent.setParent(property);
			
			
			
			String GET_ALL="select * from property_master_tbl where vid=?";
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1,id);
			rs=ps.executeQuery();
			
		
		    while(rs.next())
			{
		    	
				property.setId(rs.getInt("id"));
		    	property.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
		    	property.setPropertyNo(rs.getInt("property_no"));
		    	property.setParent(parent);
				property.setAreaName(rs.getString("area_name"));
				property.setSplit(rs.getBoolean("split"));
				property.setParent(parent);
				property.setDescription(rs.getString("description"));
				property.setRegistrationYear(rs.getInt("registration_year"));
				property.setRegisterPageNo(rs.getInt("register_page_no"));
				propertyMap.put(property.getId(),property);
			}
	
		    rs.close();
		    con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return propertyMap;
	}*/
	
	public PropertyMaster insert(int villageId,PropertyMaster property)
	{
		Connection con=null;
		ResultSet rs;
		PreparedStatement ps = null;
		try
		{
			con=PropertyDaoImpl.getConnection();
		
			Village village=null;
			village=StateDaoImpl.getAllVillage(con).get(villageId);
			property.setVillage(village);
			int vid=village.getId();
			
			/*String getParent="select id from property_master_tbl where property_no =?";
			ps=con.prepareStatement(getParent);
			ps.setString(1,parent);
			int id=0;
			rs=ps.executeQuery();
			while(rs.next())
			{
				id=rs.getInt("id");
				System.out.println("id:"+id);
				if(id==0)
				{
					id=
				}
			}*/
			/*PropertyMaster parent=new PropertyMaster();
			parent.setId(id);*/
			
			
			
			String insert="insert into property_master_tbl(vid,property_no,area_name,split,parent,description,"
					+ "registration_year,register_page_no) values(?,?,?,?,?,?,?,?)";
			
			ps=con.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, vid);
			ps.setString(2,property.getPropertyNo());
			ps.setString(3,property.getAreaName());
			ps.setBoolean(4,property.isSplit());
			ps.setString(5,property.getParent());
			ps.setString(6,property.getDescription());
			ps.setInt(7, property.getRegistrationYear());
			ps.setInt(8, property.getRegisterPageNo());
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			/*while(rs.next())
			{
				@SuppressWarnings("unused")
				int id1=rs.getInt(1);
			}*/
			
			
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return property;
		
	}
	
	public void update(PropertyMaster property,int villageId)
	{
		Connection con=null;
		PreparedStatement ps=null;

		try
		{
			
			con=PropertyDaoImpl.getConnection();
			Village village=StateDaoImpl.getAllVillage(con).get(villageId);
			int vid=village.getvId();
			
		
			final String update="update property_master_tbl set property_no=?,area_name=?,split=?,parent=?,"
					+ "description=?, registeration_year,registeration_pg_no where id?";
			
			ps = con.prepareStatement(update,Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1,property.getPropertyNo());
			ps.setString(2,property.getAreaName());
			ps.setBoolean(3,property.isSplit());
			ps.setObject(4,property.getParent());
			ps.setString(5,property.getDescription());
			ps.setDouble(6,property.getRegistrationYear());
			ps.setDouble(7,property.getRegisterPageNo());
			ps.setInt(8, vid);
			ps.executeUpdate();
		 
		
		}
		 catch(Exception e)
		{
			 
		}
	
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
				
				String getCount="select count(*) from property_master_tbl where vid=? ";
				ps=con.prepareStatement(getCount);
				ps.setInt(1,vid);
				
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
	
	
	public int getTotalCountByDistictId(int districtId)
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
					
					String getCount="select count(*) from property_master_tbl where vid=? ";
					ps=con.prepareStatement(getCount);
					ps.setInt(1,vid);
					
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

	@Override
	public int getTotalCountByDistrictId(int districtId) {
		return 0;
	}
	
	

	private static Map<Integer,PropertyMaster> propertymap;
	public Map<Integer, PropertyMaster> getAllPropertyMasterDetails() throws ClassNotFoundException, SQLException {
		Connection con=PropertyDaoImpl.getConnection();
		return PropertyDaoImpl.getAllPropertyDetails(con);
		
	}
	
	public static Map<Integer, PropertyMaster> getAllPropertyDetails(Connection con) throws ClassNotFoundException, SQLException {
		PreparedStatement ps=null;
		ResultSet rs=null;

		if(propertymap== null){
		
			Map<Integer,PropertyMaster> MapProperty=new TreeMap<>();
			Map<Integer,Integer> parentMap=new TreeMap<>();
			
			String GetProperty="select * from property_master_tbl";
			ps=con.prepareStatement(GetProperty);
			rs=ps.executeQuery();
			
 			while(rs.next())
 			{
 			
 				PropertyMaster property=new PropertyMaster(); 
				property.setId(rs.getInt("id"));
				property.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				property.setPropertyNo(rs.getString("property_no"));
				property.setAreaName(rs.getString("area_name"));
				property.setSplit(rs.getBoolean("split"));
				property.setDescription(rs.getString("description"));
				property.setRegistrationYear(rs.getInt("registration_year"));
				property.setRegisterPageNo(rs.getInt("register_page_no"));
				/*property.parent=property;*/
				property.setParent(rs.getString("parent"));
				
				MapProperty.put(property.getId(),property);
				parentMap.put(property.getId(), rs.getInt("parent"));
				
				
				for(Integer id1:parentMap.keySet())
				{
					MapProperty.get(id1).setParent(property.parent);
				}
					
			}
 			
		PropertyDaoImpl.propertymap=MapProperty;
		}

		return Collections.unmodifiableMap(PropertyDaoImpl.propertymap);
	}
	
	public PropertyMaster getProperty(String propertyId)
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		PropertyMaster property=new PropertyMaster(); 
		try
		{
			con=PropertyDaoImpl.getConnection();
			String GetProperty="select * from property_master_tbl where property_no=?";
			ps=con.prepareStatement(GetProperty);
			ps.setString(1, propertyId);
			rs=ps.executeQuery();
			
			
				while(rs.next())
				{
				
					
					property.setId(rs.getInt("id"));
					property.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
					property.setPropertyNo(rs.getString("property_no"));
					property.setAreaName(rs.getString("area_name"));
					property.setSplit(rs.getBoolean("split"));
					property.setDescription(rs.getString("description"));
					property.setRegistrationYear(rs.getInt("registration_year"));
					property.setRegisterPageNo(rs.getInt("register_page_no"));
					/*property.parent=property;*/
					property.setParent(rs.getString("parent"));
				}
				
				System.out.println("in dao:"+property);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return property;

	}
	
}
	
			



