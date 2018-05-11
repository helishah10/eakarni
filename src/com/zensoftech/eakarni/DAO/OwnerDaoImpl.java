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
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.zensoftech.eakarni.entities.Occupant;
import com.zensoftech.eakarni.entities.Owner;
import com.zensoftech.eakarni.entities.State;

public class OwnerDaoImpl implements OwnerDao
{
	private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
    
    public OwnerDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

    	OwnerDaoImpl.driverName = driverName;
    	OwnerDaoImpl.databaseUrl = databaseUrl;
    	OwnerDaoImpl.databaseUsername = databaseUsername;
    	OwnerDaoImpl.databasePassword = databasePassword;
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
    	private static Map<Integer,Owner> ownerMap;
    	
    	public Map<Integer,Owner> getAllOwnerDetails() throws ClassNotFoundException, SQLException 
    	{
    		Connection con=getConnection();
    		return OwnerDaoImpl.getAllOwnerDetails(con);
    		
    	}
    	
    	public static Map<Integer,Owner> getAllOwnerDetails(Connection con) throws SQLException,ClassNotFoundException{
    		PreparedStatement ps=null;
    		ResultSet rs=null;
    		
    		if(OwnerDaoImpl.ownerMap == null)
    		{
    			Map<Integer,Owner> MapOwner=new TreeMap<Integer,Owner>();
    			try
    			{
    				String GET_ALL="select * from owner_tbl";
    				con=OwnerDaoImpl.getConnection();
    				ps=con.prepareStatement(GET_ALL);
    				/*ps.setInt(1, propertyId);*/
    				rs=ps.executeQuery();

    			  while(rs.next())
    				{
    					 Owner owner=new Owner();
    					 owner.setId(rs.getInt("id"));
    					owner.setProperty(PropertyDaoImpl.getAllPropertyDetails(con).get(rs.getInt("id")));
    					 owner.setOwnerName(rs.getString("owner_name"));
    					 owner.setUpdatedDate(rs.getDate("updated_date").toLocalDate());
    					 MapOwner.put(owner.getId(),owner);
    					 
    					/*for(Map.Entry<Integer,Owner> ownerEntry: ownerMap.entrySet())
    					{
    					       System.out.print(ownerEntry.getKey()+" ---- ");
    					       System.out.println(ownerEntry.getValue());
    					}*/
    				}
    				
    			    rs.close();
    			    con.close();

    			}
    			catch(Exception e)
    			{
    				e.printStackTrace();
    			}
    		OwnerDaoImpl.ownerMap=MapOwner;
    		
    		}
    		
    		return Collections.unmodifiableMap(OwnerDaoImpl.ownerMap);
    	}
    	
    
   /* 	
	public Map<Integer,Owner> getAllDetails(int propertyId)
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		 Map<Integer, Owner> ownerMap=new HashMap<Integer,Owner>();
		try
		{
			String GET_ALL="select * from owner_tbl where property_id=?";
			con=OwnerDaoImpl.getConnection();
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1, propertyId);
			rs=ps.executeQuery();

		  while(rs.next())
			{
				 Owner owner=new Owner();
				 owner.setId(rs.getInt("id"));
				owner.setProperty(PropertyDaoImpl.getAllPropertyDetails(con).get(rs.getInt("property_id")));
				 owner.setOwnerName(rs.getString("owner_name"));
				 owner.setUpdatedDate(rs.getDate("updated_date").toLocalDate());
				 ownerMap.put(owner.getId(),owner);
				 
				for(Map.Entry<Integer,Owner> ownerEntry: ownerMap.entrySet())
				{
				       System.out.print(ownerEntry.getKey()+" ---- ");
				       System.out.println(ownerEntry.getValue());
				}
			}
			
		    rs.close();
		    con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ownerMap;
		
	}
	*/
	public Owner insertOwner(int propertyNo,Owner owner){
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			con=OwnerDaoImpl.getConnection(); 
		
			String ownerName=null;
			LocalDate updatedDate;
			
			String getproperty="select id from property_master_tbl where property_no=?";
			ps=con.prepareStatement(getproperty);
			ps.setInt(1,propertyNo);
			rs=ps.executeQuery();
			int id=0;
			while(rs.next())
			{
				id=rs.getInt("id");
				System.out.println(id);
			}
			
			String insert="insert into owner_tbl(property_id,owner_name,updated_date) values(?,?,?)";

			ps=con.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,id);
			ps.setString(2,owner.getOwnerName());
			ps.setDate(3,Date.valueOf(owner.getUpdatedDate()));
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
		return owner;
		
	}
	
	public Owner getProperty(int propertyNo)
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		Owner owner=new Owner();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String connectionURL ="jdbc:mysql://localhost:3306/masterdb?autoReconnect=true&useSSL=false";
			con=DriverManager.getConnection(connectionURL,"eakarni","eakarni"); 
		
			String ownerName=null;
			LocalDate updatedDate;
			
			String getproperty="select id from property_master_tbl where property_no=?";
			ps=con.prepareStatement(getproperty);
			ps.setInt(1,propertyNo);
			rs=ps.executeQuery();
			int id=0;
			while(rs.next())
			{
				id=rs.getInt("id");
				System.out.println(id);
			}
			owner.setId(id);
			System.out.println(owner);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return owner;
	}
		
	
	public void update(int propertyNo,Owner owner)
	{
		Connection con=null;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			String connectionURL ="jdbc:mysql://localhost:3306/masterdb?autoReconnect=true&useSSL=false";
			con=DriverManager.getConnection(connectionURL,"eakarni","eakarni");
		
			
			final String update="update owner_tbl set owner_name=?,updated_date=?";
			
			PreparedStatement ps = con.prepareStatement(update,Statement.RETURN_GENERATED_KEYS);
	
			ps.setString(1,owner.getOwnerName());
			ps.setDate(2,java.sql.Date.valueOf(owner.getUpdatedDate()));
			ps.executeUpdate();
			ResultSet rs=ps.getGeneratedKeys();
			while(rs.next())
			{
				@SuppressWarnings("unused")
				int sid=rs.getInt(1);
			}
			
	} 
		
		catch(Exception e)
		{
			e.printStackTrace();

		}
	}


}
