package com.zensoftech.eakarni.DAO;

import java.io.*;

import java.sql.*;
import java.util.*;

import com.zensoftech.eakarni.entities.User;
import com.zensoftech.eakarni.entities.User.Usertype;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.entities.UserSession;
import com.zensoftech.eakarni.entities.Utilities;

public  class UserDaoImpl implements UserDao{


    private static String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
    
    public UserDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

        UserDaoImpl.driverName = driverName;
        UserDaoImpl.databaseUrl = databaseUrl;
        UserDaoImpl.databaseUsername = databaseUsername;
        UserDaoImpl.databasePassword = databasePassword;
        /*System.out.println(" DAO>drivername:"+UserDaoImpl.driverName);
    	System.out.println("DAO > url:"+UserDaoImpl.databaseUrl);
        System.out.println("DAO >name:"+databaseUsername);
        System.out.println("DAO > password"+databasePassword);*/
    }
    
    	public static Connection getConnection() throws SQLException, ClassNotFoundException{
    	System.out.println("in connection method:");
    	
    	 System.out.println(" connection>drivername:"+driverName);
    	
     	/*System.out.println("connection > url:"+databaseUrl);
         System.out.println("connection >name:"+databaseUsername);
         System.out.println("connection> password"+databasePassword);*/
    	Class.forName("com.mysql.jdbc.Driver");
       return DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
       }
	

	public List<User> getallusers()
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<User> user=new ArrayList<User>();
		try
		{
			//Utilities utilities=new Utilities();
			con=UserDaoImpl.getConnection();
			//System.out.println(con);
			
			final String select_sql="Select * from user_tbl";
			ps=con.prepareStatement(select_sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				User u=new User();
				u.setLoginId(rs.getString("login_id"));
				u.setPwd(rs.getString("pwd"));
				u.setType(Usertype.values()[rs.getInt("user_type")]); 
				user.add(u);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}
	
	public List<User> getusersbytype(String usertype)
	{
		List<User> user=new ArrayList<User>();
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		try
		{
			con=UserDaoImpl.getConnection();
			Usertype utype=User.Usertype.valueOf(usertype);
			final String selectbytype_sql="select * from user_tbl where user_type='"+utype.ordinal()+"'";
			ps=con.prepareStatement(selectbytype_sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				User u=new User();
				u.setLoginId(rs.getString("login_id"));
				u.setPwd(rs.getString("pwd"));
				u.setType(User.Usertype.values()[rs.getInt("user_type")]);
				user.add(u);
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return user;
	}
	
	public User addUser(User user)
	{
		Connection con=null;
		try
		{
			con=UserDaoImpl.getConnection();
			
			Utilities utilities=new Utilities();
			//con=getConnection();
			String loginId="";
			String pwd="";
			
			final String insert_sql="insert into user_tbl(login_id,pwd,user_type) values(?,?,?)";
			PreparedStatement pst=con.prepareStatement(insert_sql);
			
			pst.setString(1,user.getLoginId());
			loginId=user.getLoginId();
			System.out.println("loginid:"+loginId);
			
			String salt=loginId+"@123";
			pwd=user.getPwd();
			String pass1=pwd+salt;
			System.out.println("password:"+pass1);
			String storepwd=utilities.get_SHA_512_SecurePassword(pass1);
			user.setPwd(storepwd);
			pst.setString(2,user.getPwd());
			pst.setObject(3,user.getType().ordinal());
			pst.executeUpdate();
			
			System.out.println("successfully added");

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return user;

}
	
	public void addUserDetails(String loginId,UserDetails userdetails)
	
	{
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps;
	
		try
		{
			con=UserDaoImpl.getConnection();
			String getId="select id from user_tbl where login_id=?";
			ps=con.prepareStatement(getId);
			ps.setString(1, loginId);
			rs=ps.executeQuery();
			int id=0;
			while(rs.next())
			{
				id=rs.getInt("id");
				System.out.println("id:"+id);
			
			}
	
			String insert_sql="insert into user_details_tbl(id,first_name,middle_name,last_name,address,contact_no,"
					+ "postal_code,email_id,aadharcard) values(?,?,?,?,?,?,?,?,?) ";
			
			ps=con.prepareStatement(insert_sql);
			ps.setInt(1,id);
			ps.setString(2,userdetails.getFirstName());
			ps.setString(3, userdetails.getMiddleName());
			ps.setString(4, userdetails.getLastName());
			ps.setString(5,userdetails.getAddress());
			ps.setInt(6,userdetails.getContactNo());
			ps.setInt(7,userdetails.getPostalCode() );
			ps.setString(8,userdetails.getEmailId());
			ps.setInt(9,userdetails.getAadharcard());
		
			ps.executeUpdate();
			
			System.out.println("succesfully saved");
			
			rs.close();
			con.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}


	public boolean update(String loginId,UserDetails userdetails)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean userdata;
		try
		{
			userdata =true;
			con=UserDaoImpl.getConnection();
			String getId="select id from user_tbl where login_id=?";
			ps=con.prepareStatement(getId);
			ps.setString(1, loginId);
			rs=ps.executeQuery();
			int id=0;
			while(rs.next())
			{
				id=rs.getInt("id");
				System.out.println("id:"+id);
			
			}
			
			String update="UPDATE user_details_tbl set first_name=?,middle_name=?,last_name=?,address=?,"
					+ "contact_no=?,postal_code=?,email_id=?,aadharcard=? where id="+id;
			
			ps=con.prepareStatement(update);
		
			ps.setString(1,userdetails.getFirstName());
			ps.setString(2, userdetails.getMiddleName());
			ps.setString(3, userdetails.getLastName());
			ps.setString(4,userdetails.getAddress());
			ps.setInt(5, userdetails.getContactNo());
			ps.setInt(6,userdetails.getPostalCode() );
			ps.setString(7,userdetails.getEmailId());
			ps.setInt(8,userdetails.getAadharcard());
			ps.executeUpdate();
			
			
		}catch(Exception e)
		{
			
			e.printStackTrace();
		}
		if(userdata=true)
		{
			return true;
		}
		else
		{
			return false;
		}
			
	}
	
	//  UPDATE METHOD
	
	public User updatepwd(String loginId,String newpwd)
	{
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		User user=new User();
		try
		{
			con=UserDaoImpl.getConnection();
			
			String getId="select * from user_tbl where login_id=?";
			ps=con.prepareStatement(getId);
			ps.setString(1, loginId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				user.setId(rs.getInt("id"));
				user.setLoginId(rs.getString("login_id"));
				user.setPwd(rs.getString("pwd"));
				user.setType(User.Usertype.values()[rs.getInt("user_type")]);
				
			}
			System.out.println("before:user in dao:"+user);
			String pwd=user.getPwd();
			
			
			final String update_pwd="update user_tbl set pwd=? where login_id=?";
			
			Utilities u=new Utilities();
			String salt=loginId+"@123";
			String pass1=newpwd+salt;
			System.out.println("password:"+pass1);
			String hpwd=u.get_SHA_512_SecurePassword(pass1);
			user.setPwd(hpwd);
			
			
			ps=con.prepareStatement(update_pwd);
			ps.setString(1,user.getPwd());
			ps.setString(2,user.getLoginId());            
			ps.executeUpdate();
			
			
			System.out.println("password changed");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("after method:"+user);
		return user;
	}

	
	/*public User authenticate(String loginid,String pwd)
	{
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		String sid="";
		String spwd="";
		String hpwd="";
		User user=new User();
		try
		{

			String search="select * from user_tbl where login_id =?";
			con=getConnection();
			ps=con.prepareStatement(search);
			ps.setString(1,loginid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				sid=rs.getString("login_id");
				spwd=rs.getString("pwd");
				user.setLoginId(rs.getString("login_id"));
				user.setPwd(rs.getString("pwd"));
				user.setType(User.Usertype.values()[rs.getInt("user_type")]);
			}
		
			Utilities u=new Utilities();
			String salt=loginid+"@123";
			String pass1=pwd+salt;
			System.out.println("password:"+pass1);
			hpwd=u.get_SHA_512_SecurePassword(pass1);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			if(loginid.equals(sid) && hpwd.equals(spwd) )
			{
				System.out.println("valid login");
			
			}
			else
			{ 
				System.out.println("user does not exist");
			
			}
	return user;
	}*/
	
	public UserDetails getUserDetail(String loginId)
	{
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		UserDetails userdetails=new UserDetails();
		try
		{
			con=UserDaoImpl.getConnection();
			String getId="select id from user_tbl where login_id=?";
			ps=con.prepareStatement(getId);
			ps.setString(1, loginId);
			rs=ps.executeQuery();
			int id=0;
			while(rs.next())
			{
				id=rs.getInt("id");
				
			}
			String getUserDetails="select * from user_details_tbl where id=?";
			ps=con.prepareStatement(getUserDetails);
			ps.setInt(1,id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				userdetails.setFirstName(rs.getString("first_name"));
				userdetails.setMiddleName(rs.getString("middle_name"));
				userdetails.setLastName(rs.getString("last_name"));
				userdetails.setAddress(rs.getString("address"));
				userdetails.setContactNo(rs.getInt("contact_no"));
				userdetails.setPostalCode(rs.getInt("postal_code"));
				userdetails.setEmailId(rs.getString("email_id"));
				userdetails.setAadharcard(rs.getInt("aadharcard"));
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return userdetails;
		
	}
	
	
	//AUTHENTICATE METHOD
	
	public boolean authenticate(String loginid,String pwd)
	{
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs=null;
		String sid="";
		String spwd="";
		String hpwd="";
		User user=new User();
		try
		{

			String search="select * from user_tbl where login_id =?";
			con=UserDaoImpl.getConnection();
			ps=con.prepareStatement(search);
			ps.setString(1,loginid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				sid=rs.getString("login_id");
				spwd=rs.getString("pwd");
				user.setLoginId(rs.getString("login_id"));
				user.setPwd(rs.getString("pwd"));
				user.setType(User.Usertype.values()[rs.getInt("user_type")]);
			}
		
			System.out.println("stored pwd:"+spwd);
			Utilities u=new Utilities();
			String salt=loginid+"@123";
			String pass1=pwd+salt;
			System.out.println("password:"+pass1);
			hpwd=u.get_SHA_512_SecurePassword(pass1);
			System.out.println("hased pwd:"+hpwd);
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			if(loginid.equals(sid) && hpwd.equals(spwd) )
			{
				System.out.println("valid login");
				return true;
			}
			else
			{ 
				System.out.println("user does not exist");
				return false;
			}

	}
	
	public User getUser(String loginId)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User user=new User();
		try
		{
			con=UserDaoImpl.getConnection();
			String getId="select * from user_tbl where login_id=?";
			ps=con.prepareStatement(getId);
			ps.setString(1, loginId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				user.setId(rs.getInt("id"));
				user.setLoginId(rs.getString("login_id"));
				user.setPwd(rs.getString("pwd"));
				user.setType(User.Usertype.values()[rs.getInt("user_type")]);
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(user);
		return user;
	
	}

	
}







