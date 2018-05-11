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

import com.zensoftech.eakarni.entities.Owner;
import com.zensoftech.eakarni.entities.PropertyTransfer;

public class PropertyTransferDaoImpl implements PropertyTransferDao
{
	private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
    
    public PropertyTransferDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

    	PropertyTransferDaoImpl.driverName = driverName;
    	PropertyTransferDaoImpl.databaseUrl = databaseUrl;
    	PropertyTransferDaoImpl.databaseUsername = databaseUsername;
    	PropertyTransferDaoImpl.databasePassword = databasePassword;
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
    	
    	private static Map<Integer,PropertyTransfer> propertytransferMap;
    	
    	public Map<Integer,PropertyTransfer> getAllPropertyTransferDetails() throws ClassNotFoundException, SQLException 
    	{
    		Connection con=getConnection();
    		return PropertyTransferDaoImpl.getAllPropertyTransferDetails(con);
    		
    	}
    	
    	public static Map<Integer,PropertyTransfer> getAllPropertyTransferDetails(Connection con) throws SQLException,ClassNotFoundException{
    		PreparedStatement ps=null;
    		ResultSet rs=null;
    		
    		if(PropertyTransferDaoImpl.propertytransferMap == null)
    		{
    			Map<Integer,PropertyTransfer> MapPropertyTransfer=new TreeMap<Integer,PropertyTransfer>();
    			try
    			{
    				String GET_ALL="select * from property_transfer_tbl";
    				con=OwnerDaoImpl.getConnection();
    				ps=con.prepareStatement(GET_ALL);
    				/*ps.setInt(1, propertyId);*/
    				rs=ps.executeQuery();

    			  while(rs.next())
    				{
    				  	PropertyTransfer transfer=new PropertyTransfer();
    					 transfer.setId(rs.getInt("id"));
    					 transfer.setProperty(PropertyDaoImpl.getAllPropertyDetails(con).get(rs.getInt("property_id")));
    					 transfer.setOwnerName(rs.getString("owner_name"));
    					 transfer.setTransferDate(rs.getDate("transfer_date").toLocalDate());
    					 transfer.setAttachement(rs.getString("attachement"));
    					 MapPropertyTransfer.put(transfer.getId(),transfer);
    					 
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
    		PropertyTransferDaoImpl.propertytransferMap=MapPropertyTransfer;
    		
    		}
    		
    		return Collections.unmodifiableMap(PropertyTransferDaoImpl.propertytransferMap);
    	}
    	
	/*public Map<Integer,PropertyTransfer> getAllDetails(int propertyId)
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		 Map<Integer, PropertyTransfer> propertyTransferMap=new HashMap<Integer,PropertyTransfer>();
		try
		{
			String GET_ALL="select * from property_transfer_tbl where property_id=?";
			con=PropertyTransferDaoImpl.getConnection();
			
			
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1, propertyId);
			rs=ps.executeQuery();

		  while(rs.next())
			{
				 PropertyTransfer transfer=new PropertyTransfer();
				 transfer.setId(rs.getInt("id"));
				 transfer.setProperty(PropertyDaoImpl.getAllPropertyDetails(con).get(rs.getInt("property_id")));
				 transfer.setOwnerName(rs.getString("owner_name"));
				 transfer.setTransferDate(rs.getDate("transfer_date").toLocalDate());
				 transfer.setAttachement(rs.getString("attachement"));
				 propertyTransferMap.put(transfer.getId(),transfer);
				 
				for(Map.Entry<Integer,PropertyTransfer> transferEntry: propertyTransferMap.entrySet())
				{
				       System.out.print(transferEntry.getKey()+" ---- ");
				       System.out.println(transferEntry.getValue());
				}
			}
			
		    rs.close();
		    con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return propertyTransferMap;
		
	}*/
	
	public PropertyTransfer insertTransferEntry(int propertyNo,PropertyTransfer transfer){
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
		
			String connectionURL ="jdbc:mysql://localhost:3306/masterdb?autoReconnect=true&useSSL=false";
			con=DriverManager.getConnection(connectionURL,"eakarni","eakarni"); 
		
			//String ownerName=null;
			//LocalDate updatedDate;
			
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
			
			String insert="insert into property_transfer_tbl(property_id,owner_name,transfer_date,attachement) values(?,?,?,?)";

			ps=con.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,id);
			ps.setString(2,transfer.getOwnerName());
			ps.setDate(3,Date.valueOf(transfer.getTransferDate()));
			ps.setString(4,transfer.getAttachement());
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
		return transfer;
		
	}
	
	public PropertyTransfer getProperty(int propertyNo)
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		PropertyTransfer transfer=new PropertyTransfer();
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
			transfer.setId(id);
			//System.out.println(owner);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return transfer;
	}
		
	
	public void update(int propertyNo,PropertyTransfer transfer)
	{
		Connection con=null;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			String connectionURL ="jdbc:mysql://localhost:3306/masterdb?autoReconnect=true&useSSL=false";
			con=DriverManager.getConnection(connectionURL,"eakarni","eakarni");
		
			
			final String update="update property_transfer_tbl set owner_name=?,transfer_date=?,attachment=?";
			
			PreparedStatement ps = con.prepareStatement(update,Statement.RETURN_GENERATED_KEYS);
	
			ps.setString(1,transfer.getOwnerName());
			ps.setDate(2,java.sql.Date.valueOf(transfer.getTransferDate()));
			ps.setString(3,transfer.getAttachement());
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
