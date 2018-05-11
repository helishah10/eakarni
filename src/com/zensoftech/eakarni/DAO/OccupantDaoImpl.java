package com.zensoftech.eakarni.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.zensoftech.eakarni.entities.Occupant;
import com.zensoftech.eakarni.entities.Owner;

public class OccupantDaoImpl implements OccupantDao
{
    private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
    
    public OccupantDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

    	OccupantDaoImpl.driverName = driverName;
    	OccupantDaoImpl.databaseUrl = databaseUrl;
    	OccupantDaoImpl.databaseUsername = databaseUsername;
    	OccupantDaoImpl.databasePassword = databasePassword;
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
    	private static Map<Integer,Occupant> occupantMap;
    	
    	public Map<Integer,Occupant> getAllOccupantDetails() throws ClassNotFoundException, SQLException
    	{
    		Connection con=getConnection();
    		return OccupantDaoImpl.getAllOccupantDetails(con);
    		
    	}
    	
    	public static Map<Integer,Occupant> getAllOccupantDetails(Connection con) throws SQLException,ClassNotFoundException{
    		PreparedStatement ps=null;
    		ResultSet rs=null;
    		
    		if(OccupantDaoImpl.occupantMap == null)
    		{
    			Map<Integer,Occupant> MapOccupant=new TreeMap<Integer,Occupant>();
    			try
    			{
    				String GET_ALL="select * from occupant_tbl";
    				con=OccupantDaoImpl.getConnection();
    				ps=con.prepareStatement(GET_ALL);
    				/*ps.setInt(1, propertyId);*/
    				rs=ps.executeQuery();

    			  while(rs.next())
    				{
    				  	 Occupant occupant=new Occupant();
    					 occupant.setId(rs.getInt("id"));
    					 occupant.setProperty(PropertyDaoImpl.getAllPropertyDetails(con).get(rs.getInt("property_id")));
    					 occupant.setOccupantName(rs.getString("occupant_name"));
    					 occupant.setUpdatedDate(rs.getDate("updated_date").toLocalDate());
    					 MapOccupant.put(occupant.getId(),occupant);
    					 
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
    		OccupantDaoImpl.occupantMap=MapOccupant;
    		
    		}
    		
    		return Collections.unmodifiableMap(OccupantDaoImpl.occupantMap);
    	}
    	
	
	/*public Map<Integer,Occupant> getAllDetails(int propertyId)
	{
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		 Map<Integer, Occupant> occupantMap=new HashMap<Integer,Occupant>();
		try
		{
			con=OccupantDaoImpl.getConnection();
			String GET_ALL="select * from occupant_tbl where property_id=?";
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1, propertyId);
			rs=ps.executeQuery();

		  while(rs.next())
			{
				 Occupant occupant=new Occupant();
				 occupant.setId(rs.getInt("id"));
				 occupant.setProperty(PropertyDaoImpl.getAllPropertyDetails(con).get(rs.getInt("property_id")));
				 occupant.setOccupantName(rs.getString("occupant_name"));
				 occupant.setUpdatedDate(rs.getDate("updated_date").toLocalDate());
				 occupantMap.put(occupant.getId(),occupant);
				 
				for(Map.Entry<Integer,Occupant> occupantEntry: occupantMap.entrySet())
				{
				       System.out.print(occupantEntry.getKey()+" ---- ");
				       System.out.println(occupantEntry.getValue());
				}
			}
			
		    rs.close();
		    con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return occupantMap;
		
	}
	*/
	public Occupant insertOccupant(int propertyNo,Occupant occupant){
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			con=OccupantDaoImpl.getConnection();
			
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
			
			String insert="insert into occupant_tbl(property_id,occupant_name,updated_date) values(?,?,?)";

			ps=con.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,id);
			ps.setString(2,occupant.getOccupantName());
			ps.setDate(3,Date.valueOf(occupant.getUpdatedDate()));
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
		return occupant;
	}
	
	public Occupant getProperty(int propertyNo)
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		Occupant occupant=new Occupant();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String connectionURL ="jdbc:mysql://localhost:3306/masterdb?autoReconnect=true&useSSL=false";
			con=DriverManager.getConnection(connectionURL,"eakarni","eakarni"); 
		
			
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
			occupant.setId(id);
			System.out.println(occupant);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return occupant;
	}
		
	
	public void update(int propertyNo,Occupant occupant)
	{
		Connection con=null;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			String connectionURL ="jdbc:mysql://localhost:3306/masterdb?autoReconnect=true&useSSL=false";
			con=DriverManager.getConnection(connectionURL,"eakarni","eakarni");
		
			
			final String update="update occupant_tbl  set occupant_name=?,updated_date=?";
			
			PreparedStatement ps = con.prepareStatement(update,Statement.RETURN_GENERATED_KEYS);
	
			ps.setString(1,occupant.getOccupantName());
			ps.setDate(2,java.sql.Date.valueOf(occupant.getUpdatedDate()));
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
	
