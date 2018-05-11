package com.zensoftech.eakarni.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Map;
import java.util.TreeMap;

import java.sql.Connection;

import com.zensoftech.eakarni.entities.Occupant;
import com.zensoftech.eakarni.entities.Owner;
import com.zensoftech.eakarni.entities.PropertyDetails;
import com.zensoftech.eakarni.entities.PropertyMaster;
import com.zensoftech.eakarni.entities.PropertyTransfer;
import com.zensoftech.eakarni.entities.Tax;

public class PropertyDetailsDaoImpl {
		private static String driverName = "";
	    private static String databaseUrl = "";
	    private static String databaseUsername = "";
	    private static String databasePassword = "";
	    
	    public PropertyDetailsDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

	    	PropertyDetailsDaoImpl.driverName = driverName;
	    	PropertyDetailsDaoImpl.databaseUrl = databaseUrl;
	    	PropertyDetailsDaoImpl.databaseUsername = databaseUsername;
	    	PropertyDetailsDaoImpl.databasePassword = databasePassword;
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
	
	
	public Map<Integer,PropertyDetails> getAllPropertyDetails(int propertyId) throws ClassNotFoundException, SQLException
	{
	
		Connection con=getConnection();
		PreparedStatement ps = null;
		ResultSet rs;
		
		String getOwner="select * from owner_tbl where property_id=?";
		ps=con.prepareStatement(getOwner);
		ps.setInt(1,propertyId);
		rs=ps.executeQuery();
		Owner ownermap = null;
		while(rs.next())
		{
			ownermap=OwnerDaoImpl.getAllOwnerDetails(con).get(rs.getInt("property_id"));
			System.out.println(ownermap);
		}
		
		String getOccupant="select * from occupant_tbl where property_id=?";
		ps=con.prepareStatement(getOccupant);
		ps.setInt(1,propertyId);
		rs=ps.executeQuery();
		Occupant occupantMap=null;
		while(rs.next())
		{
			occupantMap=OccupantDaoImpl.getAllOccupantDetails(con).get(rs.getInt("property_id"));
			System.out.println(occupantMap);
		}
		
		String getTax="select * from tax_tbl where property_id=?";
		ps=con.prepareStatement(getTax);
		ps.setInt(1,propertyId);
		rs=ps.executeQuery();
		Tax taxmap = null;
		while(rs.next())
		{
			taxmap=TaxDaoImpl.getAllTaxDetails(con).get(rs.getInt("property_id"));
			System.out.println(taxmap);
		}
		
		String getPropertyMaster="select * from property_master_tbl where id=?";
		ps=con.prepareStatement(getPropertyMaster);
		ps.setInt(1,propertyId);
		rs=ps.executeQuery();
		PropertyMaster propertymastermap = null;
		while(rs.next())
		{
			propertymastermap=PropertyDaoImpl.getAllPropertyDetails(con).get(rs.getInt("id"));
			System.out.println(propertymastermap);
		}
		
		String getPropertyTransfer="select * from property_transfer_tbl where property_id=?";
		ps=con.prepareStatement(getPropertyTransfer);
		ps.setInt(1,propertyId);
		rs=ps.executeQuery();
		PropertyTransfer propertytransfermap = null;
		while(rs.next())
		{
			propertytransfermap=PropertyTransferDaoImpl.getAllPropertyTransferDetails(con).get(rs.getInt("id"));
			System.out.println(propertytransfermap);
		}
		
		Map<Integer,PropertyDetails> propertydetailsMap = new TreeMap<>();
		PropertyDetails propertydetails=new PropertyDetails();
		propertydetails.setOwner(ownermap);
		propertydetails.setOccupant(occupantMap);
		propertydetails.setTax(taxmap);
		propertydetails.setProperty(propertymastermap);
		propertydetails.setTransfer(propertytransfermap);
		
		propertydetailsMap.put(propertydetails.getId(), propertydetails);
		System.out.println("property details map:"+propertydetailsMap);
		return propertydetailsMap;
		
		
			
	}

}
