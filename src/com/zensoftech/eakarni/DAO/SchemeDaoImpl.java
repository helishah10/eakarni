package com.zensoftech.eakarni.DAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

import com.zensoftech.eakarni.entities.Scheme;

public class SchemeDaoImpl implements SchemeDao
{
	
	public Scheme getSchemeById(int schemeid)
	{
		Scheme scheme=new Scheme();
		try
		{
			
			/*BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("enter the scheme id to get scheme name details:");
			try 
			{
				scheme_id=Integer.parseInt(br.readLine());
			} 
			catch (Exception e) 
			{
			
				e.printStackTrace();
			} 
			*/

			
			String sql="select name from scheme_tbl where scheme_id="+schemeid;
		
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=null;
					
			String connectionURL = "jdbc:mysql://localhost:3306/masterdb?autoReconnect=true&useSSL=false";
			con=DriverManager.getConnection(connectionURL,"eakarni","eakarni"); 
	
			
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{String name=rs.getString(1);
			scheme.setname(name);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return scheme;
		
	}
	
	public void addscheme( )
	{
		int scheme_id=0;

		try
		{
		
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=null;
			
			String connectionURL ="jdbc:mysql://localhost:3306/masterdb?autoReconnect=true&useSSL=false";
			con=DriverManager.getConnection(connectionURL,"eakarni","eakarni"); 
			BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("enter the scheme id to add:");
			scheme_id=Integer.parseInt(br2.readLine());
	
			System.out.println("enter the scheme name to add");
			String scheme_name=br2.readLine();
			
			Scheme s2=new Scheme();
			s2.setSchemeId(scheme_id);
			s2.setname(scheme_name);
			
			String sql1="insert into scheme_tbl(scheme_id,name) values(?,?)";
			PreparedStatement ps=con.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,s2.getSchemeId());
			ps.setString(2,s2.getname());
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
	}
	
	public  List<Scheme> getallschemes()
	{
		//System.out.println("all states");
		List<Scheme> schemeobj=new ArrayList<Scheme>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=null;
			String connectionURL = "jdbc:mysql://localhost:3306/masterdb?autoReconnect=true&useSSL=false";
			con=DriverManager.getConnection(connectionURL,"eakarni","eakarni"); 
			String sql2="select * from scheme_tbl";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql2);
			while(rs.next())
			{
				 Scheme s4=new Scheme();
				 //s4.setId(rs.getInt("id"));
				 s4.setSchemeId(rs.getInt("scheme_id"));
				 s4.setname(rs.getString("name"));
				 schemeobj.add(s4);
				 
			}
			
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		
		return schemeobj;
	}
}

