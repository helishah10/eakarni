package com.zensoftech.eakarni.DAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.zensoftech.eakarni.entities.Taxtype;

public class TaxtypeDaoImpl implements TaxtypeDao
{

	 private static String driverName = "";
	    private static String databaseUrl = "";
	    private static String databaseUsername = "";
	    private static String databasePassword = "";
	    
	    public TaxtypeDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

	    	TaxtypeDaoImpl.driverName = driverName;
	    	TaxtypeDaoImpl.databaseUrl = databaseUrl;
	    	TaxtypeDaoImpl.databaseUsername = databaseUsername;
	    	TaxtypeDaoImpl.databasePassword = databasePassword;
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
	public   Map<Integer, Taxtype> getAllDetails()
	{
		 Map<Integer, Taxtype> taxMap=new HashMap<Integer,Taxtype>();
		
		try
		{
			Connection con=TaxtypeDaoImpl.getConnection();
			String GET_ALL="select * from taxtype_tbl";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(GET_ALL);
			while(rs.next())
			{
				
				 Taxtype t1=new Taxtype();
				 t1.setTaxId(rs.getInt("tax_id"));
				 t1.setTaxName(rs.getString("tax_name"));
				 taxMap.put(t1.getTaxId(),t1);
			}
			
			/*for(Map.Entry<Integer,Taxtype> taxEntry:taxMap.entrySet())
			{
			       System.out.print(taxEntry.getKey()+" ---- ");
			       System.out.println(taxEntry.getValue());
			}*/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		
		return taxMap;

	}
	
	/*public Taxtype insert(int taxId,String taxName)
	{
		try
		{
			Connection con=TaxtypeDaoImpl.getConnection();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
			
			Taxtype t1=new Taxtype();
			t1.setTaxId(taxId);
			t1.setTaxName(taxName);
		
			String INSERT="insert into taxtype_tbl(tax_id,tax_name) values(?,?)";
			PreparedStatement ps=con.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,t1.getTaxId());
			ps.setString(2,t1.getTaxName());
			ps.executeUpdate();
			ResultSet rs=ps.getGeneratedKeys();
			while(rs.next())
			{
				@SuppressWarnings("unused")
				int id=rs.getInt(1);
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}*/
	
	public void update(int taxId)
	{
		Connection con=null;

		try
		{
			con=TaxtypeDaoImpl.getConnection();
		
			final String update = "UPDATE taxtype_tbl SET tax_name=? where id=?";
			
			PreparedStatement ps = con.prepareStatement(update,Statement.RETURN_GENERATED_KEYS);
			Taxtype taxtype=new Taxtype();
			ps.setString(1,taxtype.getTaxName());
			ps.setInt(2,taxtype.getTaxId());
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
	
	public Taxtype getTaxDetail(int taxId)
	{
		Connection con=null;
		ResultSet rs=null;
		Taxtype taxtype = new Taxtype();
		try
		{
			con=TaxtypeDaoImpl.getConnection();
		
			final String getAll = "Select * from taxtype_tbl where tax_id=?";
			
			PreparedStatement ps = con.prepareStatement(getAll,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,taxId);
			rs=ps.executeQuery();
			while(rs.next()){
				
				taxtype.setTaxId(rs.getInt("tax_id"));
				taxtype.setTaxName(rs.getString("tax_name"));
				ps.setString(1,taxtype.getTaxName());
				ps.setInt(2,taxtype.getTaxId());
				ps.executeUpdate();
				
			}
			
	} 
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return taxtype;
		
	}

	
	
}
