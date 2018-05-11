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
import com.zensoftech.eakarni.entities.Tax;

public class TaxDaoImpl implements TaxDao
{
	 private static String driverName = "";
	    private static String databaseUrl = "";
	    private static String databaseUsername = "";
	    private static String databasePassword = "";
	    
	    public TaxDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

	    	TaxDaoImpl.driverName = driverName;
	    	TaxDaoImpl.databaseUrl = databaseUrl;
	    	TaxDaoImpl.databaseUsername = databaseUsername;
	    	TaxDaoImpl.databasePassword = databasePassword;
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
	    	
	    	private static Map<Integer,Tax> taxMap;
	    	
	    	public Map<Integer,Tax> getAllTaxDetails() throws ClassNotFoundException, SQLException
	    	{
	    		Connection con=getConnection();
	    		return TaxDaoImpl.getAllTaxDetails(con);
	    		
	    	}
	    	
	    	public static Map<Integer,Tax> getAllTaxDetails(Connection con) throws SQLException,ClassNotFoundException{
	    		PreparedStatement ps=null;
	    		ResultSet rs=null;
	    		
	    		if(TaxDaoImpl.taxMap == null)
	    		{
	    			Map<Integer,Tax> MapTax=new TreeMap<Integer,Tax>();
	    			try
	    			{
	    				String GET_ALL="select * from tax_tbl";
	    				con=TaxDaoImpl.getConnection();
	    				ps=con.prepareStatement(GET_ALL);
	    				/*ps.setInt(1, propertyId);*/
	    				rs=ps.executeQuery();

	    			  while(rs.next())
	    				{
	    				  Tax t1=new Tax();
	    				  	 t1.setId(rs.getInt("id"));
	    				  	 t1.setProperty(PropertyDaoImpl.getAllPropertyDetails(con).get(rs.getInt("property_id")));
	    					 t1.setAssessmentOfAnnualRent(rs.getDouble("assessment_of_annualrent"));
	    					 t1.setEstimatedTaxAmount(rs.getDouble("estimated_taxAmaount"));
	    					 t1.setPreviouslyMentionedSurplusAndDeficitAmount(rs.getDouble("previously_mentioned_surplus_and_deficit_amount"));
	    					 t1.setUpdatedDate(rs.getDate("updated_date").toLocalDate());
	    					 MapTax.put(t1.getId(),t1);
	    				  	
	    					 
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
	    		TaxDaoImpl.taxMap=MapTax;
	    		
	    		}
	    		
	    		return Collections.unmodifiableMap(TaxDaoImpl.taxMap);
	    	}
/*	public Map<Integer,Tax> getAllDetails(int propertyId)
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		 Map<Integer, Tax> taxMap=new HashMap<Integer,Tax>();
		try
		{
			String GET_ALL="select * from tax_tbl where property_id=?";
			con=TaxDaoImpl.getConnection();
			
			 
			ps=con.prepareStatement(GET_ALL);
			ps.setInt(1, propertyId);
			rs=ps.executeQuery();

		  while(rs.next())
			{
			  	 Tax t1=new Tax();
			  	 t1.setId(rs.getInt("id"));
			  	 t1.setProperty(PropertyDaoImpl.getAllPropertyDetails(con).get(rs.getInt("property_id")));
				 t1.setAssessmentOfAnnualRent(rs.getDouble("assessment_of_annualrent"));
				 t1.setEstimatedTaxAmaount(rs.getDouble("estimated_taxAmaount"));
				 t1.setPreviouslyMentionedSurplusAndDeficitAmount(rs.getDouble("previously_mentioned_surplus_and_deficit_amount"));
				 t1.setUpdatedDate(rs.getDate("updated_date").toLocalDate());
				 taxMap.put(t1.getId(),t1);
			  	
			}
				
			
		    rs.close();
		    con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return taxMap;
		
	}*/
	
	public Tax insertTax(int propertyNo,Tax tax){
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			con=TaxDaoImpl.getConnection(); 
			
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
			
			String INSERT="insert into tax_tbl(property_id,assessment_of_annualrent,estimated_taxamaount,"
					+ "previously_mentioned_surplus_and_deficit_amount,updated_date) values(?,?,?,?,?)";
			
			ps=con.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,id);
			ps.setDouble(2,tax.getAssessmentOfAnnualRent());
			ps.setDouble(3, tax.getEstimatedTaxAmount());
			ps.setDouble(4,tax.getPreviouslyMentionedSurplusAndDeficitAmount());
			ps.setDate(5,java.sql.Date.valueOf(tax.getUpdatedDate()));
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			while(rs.next())
			{
				@SuppressWarnings("unused")
				int id1=rs.getInt(1);
			}
			System.out.println(tax);
			
			System.out.println("successfully inserted");
			rs.close();
			con.close();
		}
				
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return tax;
	}
	
	public Tax getProperty(int propertyNo)
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		Tax tax=new Tax();
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
			tax.setId(id);
			System.out.println(tax);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return tax;
	}
		
	
	public void update(int propertyNo,Tax tax)
	{
		Connection con=null;
		PreparedStatement ps;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			String connectionURL ="jdbc:mysql://localhost:3306/masterdb?autoReconnect=true&useSSL=false";
			con=DriverManager.getConnection(connectionURL,"eakarni","eakarni");
			
			
		
			
			 final String update = "update tax_tbl set assessment_of_annualrent=?,estimated_taxamaount=?,"
			 		+ "previously_mentioned_surplus_and_deficit_amount=?,updated_date=? ";
				
				ps = con.prepareStatement(update,Statement.RETURN_GENERATED_KEYS);
				ps.setDouble(1 , tax.getAssessmentOfAnnualRent());
				ps.setDouble(2,tax.getEstimatedTaxAmount());
				ps.setDouble(3,tax.getPreviouslyMentionedSurplusAndDeficitAmount());
				ps.setDate(4,java.sql.Date.valueOf(tax.getUpdatedDate()));
				ps.executeUpdate();
				
				System.out.println("successfully updated");
			
	} 
		
		catch(Exception e)
		{
			e.printStackTrace();

		}
	}
}
	/* ResultSet rs;

		public   Map<Integer, Tax> getAllDetails()
		{
			 Map<Integer,Tax> taxMap=new HashMap<Integer,Tax>();
			try
			{
				String GET_ALL="SELECT * FROM tax_tbl";
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=null;
				String connectionURL = "jdbc:mysql://localhost:3306/masterdb?zeroDateTimeBehavior=convertToNull&autoReconnect=true&useSSL=false";
				con=DriverManager.getConnection(connectionURL,"eakarni","eakarni"); 
				Statement st;
	  			st = con.createStatement();
				rs=st.executeQuery(GET_ALL);
			
			    while(rs.next())
				{
					 Tax t1=new Tax();
					 t1.property.setId(rs.getInt("id"));
					 t1.setAssessmentOfAnnualRent(rs.getDouble("assessment_of_annualrent"));
					 t1.setEstimatedTaxAmaount(rs.getDouble("estimated_taxAmaount"));
					 t1.setPreviouslyMentionedSurplusAndDeficitAmount(rs.getDouble("previously_mentioned_surplus_and_deficit_amount"));
					 t1.setUpdatedDate(rs.getDate("updated_date").toLocalDate());
					 taxMap.put(t1.getId(),t1);
					 
					for(Map.Entry<Integer,Tax> taxEntry: taxMap.entrySet())
					{
					       System.out.print(taxEntry.getKey()+" ---- ");
					       System.out.println(taxEntry.getValue());
					}
					 
					 }
				
			    rs.close();
			    st.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return taxMap;
				
		
		}
		
		public void insert(Tax tax)
		{
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");  
			
				String connectionURL ="jdbc:mysql://localhost:3306/masterdb?autoReconnect=true&useSSL=false";
				con=DriverManager.getConnection(connectionURL,"eakarni","eakarni"); 
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				
				System.out.println("enter the property id to add the details to:");
				int pid=Integer.parseInt(br.readLine());
				
				String select_village="select id from property_master_tbl where id="+pid+"";
				Statement st=con.createStatement();
				rs=st.executeQuery(select_village);
				int id=0;
				while(rs.next())
				{
					id=rs.getInt("id");
					System.out.println(id);
				}
				tax.property.setId(id);
				
				System.out.println("enter the assessment of annual rent:");
				double assessmentOfAnnualRent=Double.parseDouble(br.readLine());
				
				System.out.println("enter the estimated tax amount:");
				double estimatedTaxAmount=Double.parseDouble(br.readLine());
				
				System.out.println("enter the previously mentioned surplus and deficit amount:");
				double previouslyMentionedSurplusAndDeficitAmount=Double.parseDouble(br.readLine());
				
				System.out.println("enter the date(dd-mm-yyyy):");
				String date=br.readLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate updatedDate = LocalDate.parse(date, formatter);
						
				Tax t1=new Tax();
				t1.property.setId(id);
				t1.setAssessmentOfAnnualRent(assessmentOfAnnualRent);
				t1.setEstimatedTaxAmaount(estimatedTaxAmount);
				t1.setPreviouslyMentionedSurplusAndDeficitAmount(previouslyMentionedSurplusAndDeficitAmount);
				t1.setUpdatedDate(updatedDate);
				
				String INSERT="insert into tax_tbl(property_id,assessment_of_annualrent,estimated_taxamount,previously_mentioned_surplus_and"
						+ "defict_amount,updated_date) values(?,?,?,?,?)";
				
				ps=con.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1,t1.property.getId());
				ps.setDouble(2,t1.getAssessmentOfAnnualRent());
				ps.setDouble(3, t1.getEstimatedTaxAmaount());
				ps.setDouble(4,t1.getPreviouslyMentionedSurplusAndDeficitAmount());
				ps.setDate(5,java.sql.Date.valueOf(t1.getUpdatedDate()));
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
		}
		
		public void update(Tax tax)
		{
			Connection con=null;
			Tax t1=new Tax();
			t1=tax;
			int pid=t1.property.getId();

			try
			{
				Class.forName("com.mysql.jdbc.Driver");  
				String connectionURL ="jdbc:mysql://localhost:3306/masterdb?autoReconnect=true&useSSL=false";
				con=DriverManager.getConnection(connectionURL,"eakarni","eakarni");
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				
				System.out.println("enter the serial number to be updated:");
				int id=Integer.parseInt(br.readLine());
				t1.setId(id);
				t1.property.setId(pid);
				
			 final String update = "update tax_tbl set assessment_of_annualrent=?,estimated_taxamount=?,"
			 		+ "previously_mentioned_surplus_and_defict_amount=?,updated_date=? where id="+id+"";
				
				PreparedStatement ps = con.prepareStatement(update,Statement.RETURN_GENERATED_KEYS);
				System.out.println("enter the assessment of annual rent:");
				double assessmentOfAnnualRent=Double.parseDouble(br.readLine());
				
				System.out.println("enter the estimated tax amount:");
				double estimatedTaxAmount=Double.parseDouble(br.readLine());
				
				System.out.println("enter the previously mentioned surplus and deficit amount:");
				double previouslyMentionedSurplusAndDeficitAmount=Double.parseDouble(br.readLine());
				
				System.out.println("enter the date(dd-mm-yyyy):");
				String date=br.readLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate updatedDate = LocalDate.parse(date, formatter);
						
				ps.setDouble(1 , assessmentOfAnnualRent);
				ps.setDouble(2,estimatedTaxAmount);
				ps.setDouble(3,previouslyMentionedSurplusAndDeficitAmount);
				ps.setDate(4,java.sql.Date.valueOf(updatedDate));
				ps.executeUpdate();
				ResultSet rs=ps.getGeneratedKeys();
				while(rs.next())
				{
					@SuppressWarnings("unused")
					int sid=rs.getInt(1);
				}
				System.out.println("successfully updated");
				
		} 
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		
		}
	*/


