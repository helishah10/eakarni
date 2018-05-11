package com.zensoftech.eakarni.DAO;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zensoftech.eakarni.entities.AppointmentDdo;
import com.zensoftech.eakarni.entities.AppointmentTalati;
import com.zensoftech.eakarni.entities.AppointmentTdo;
import com.zensoftech.eakarni.entities.District;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.User;
import com.zensoftech.eakarni.entities.Village;
import com.zensoftech.eakarni.entities.User.Usertype;
import com.zensoftech.eakarni.DAO.StateDaoImpl;

public class AppointmentDaoImpl implements AppointmentDao
{

    private String driverName = "";
    private static String databaseUrl = "";
    private static String databaseUsername = "";
    private static String databasePassword = "";
    
    public AppointmentDaoImpl(String driverName, String databaseUrl, String databaseUsername, String databasePassword){

        this.driverName = driverName;
        this.databaseUrl = databaseUrl;
        this.databaseUsername = databaseUsername;
        this.databasePassword = databasePassword;
       /* System.out.println(" DAO>drivername:"+this.driverName);
    	System.out.println("DAO > url:"+this.databaseUrl);
        System.out.println("DAO >name:"+databaseUsername);
        System.out.println("DAO > password"+databasePassword);*/
    }
    
    	public static Connection getConnection() throws SQLException, ClassNotFoundException{

    	Class.forName("com.mysql.jdbc.Driver");
       return DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
       }
	public List<AppointmentTdo> getAllTdo(int talukaId) 
	{
		ResultSet rs;
		PreparedStatement ps;
		int id=0;
		List<AppointmentTdo> appointmentTdo=new ArrayList<AppointmentTdo>();
		
		try
		{
			Connection con=AppointmentDaoImpl.getConnection();
			String getId="select id from taluka_tbl where tid=?";
			ps=con.prepareStatement(getId);
			ps.setInt(1,talukaId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				id=rs.getInt("id");
			
			}
			
			AppointmentTdo tdo=new AppointmentTdo();
			Taluka taluka=new Taluka();
			taluka.setId(id);
			
			final String selectAll="select * from appointment_tdo_tbl where id=?";
			ps=con.prepareStatement(selectAll);
			ps.setInt(1,id);
			rs=ps.executeQuery();
		
			while(rs.next())
			{
				tdo.setTaluka(taluka);
				tdo.setStartDate(rs.getDate("start_date").toLocalDate());
				tdo.setEndDate(rs.getDate("end_date").toLocalDate());
				tdo.setAppointmentType(rs.getBoolean("type_of_appointment"));
				tdo.setAppointmentLetterNo(rs.getInt("appointment_letter_no"));
				appointmentTdo.add(tdo);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return appointmentTdo;
	}
	
	public AppointmentTdo insertTdo(int talukaId,int userId,AppointmentTdo tdo)//census id// auto id
	{
		Connection con;
		ResultSet rs;
		PreparedStatement ps;
		try
		{
			con=AppointmentDaoImpl.getConnection(); 
			
			String getTalukaId="select id from taluka_tbl where tid=?";
			ps=con.prepareStatement(getTalukaId);
			ps.setInt(1,talukaId);
			rs=ps.executeQuery();
			Taluka taluka = null;
			int tid=0;
			while(rs.next())
			{
				taluka=StateDaoImpl.getAllTalukas(con).get(rs.getInt("id"));
				
			}
			tdo.setTaluka(taluka);
			
			String getUser="select * from user_tbl where id=?";
			ps=con.prepareStatement(getUser);
			ps.setInt(1,userId);
			rs=ps.executeQuery();
			User user=new User();
			while(rs.next())
			{
				
				user.setLoginId(rs.getString("login_id"));
				user.setPwd(rs.getString("pwd"));
				user.setType(Usertype.values()[rs.getInt("user_type")]); 
			
			}
		
			
			System.out.println("user in dao:"+user);
			tdo.setUser(user);
			
			String insertTdo="insert into appointment_tdo_tbl(user_id,tid,start_date,type_of_appointment,"
					+ "appointment_letter_no) values(?,?,?,?,?) ";
			
			ps=con.prepareStatement(insertTdo,Statement.RETURN_GENERATED_KEYS);
			ps.setObject(1,userId);
			ps.setObject(2,taluka.getId());
			ps.setDate(3,java.sql.Date.valueOf(tdo.getStartDate()));
		/*	ps.setDate(4,java.sql.Date.valueOf(tdo.getEndDate()));*/
			ps.setBoolean(4, tdo.isAppointmentType());
			ps.setInt(5,tdo.getAppointmentLetterNo());
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			rs.next();
			@SuppressWarnings("unused")
				int id1=rs.getInt(1);
		
			
			System.out.println("entered succesffully");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return tdo;
	}
	
	public void updateTdoDetails(int talukaId,String userId,AppointmentTdo tdo)
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs = null;
		try
		{
			con=AppointmentDaoImpl.getConnection();
			String getTid="select id from taluka_tbl where tid=?";
			ps=con.prepareStatement(getTid);
			ps.setInt(1,talukaId);
			int tid=0;
			rs=ps.executeQuery();
			while(rs.next())
			{
				tid=rs.getInt("id");
				
			}
			
			String getUserId="select id from user_tbl where login_id=?";
			ps=con.prepareStatement(getUserId);
			ps.setString(1,userId);
			rs=ps.executeQuery();
			int uid=0;
			while(rs.next())
			{
				uid=rs.getInt("id");
			}
			
			String updateTdo="update appointment_tdo_tbl set user_id=?,join_date=?,leave_date=?,type_of_appointment=?,appointment_letter_no=? where tid="+tid;
		
			ps=con.prepareStatement(updateTdo,Statement.RETURN_GENERATED_KEYS);
						
			ps.setInt(1, uid);
			ps.setDate(2,java.sql.Date.valueOf(tdo.getStartDate()));
			ps.setDate(3,java.sql.Date.valueOf(tdo.getEndDate()));
			ps.setBoolean(4,tdo.isAppointmentType());
			ps.setInt(5,tdo.getAppointmentLetterNo());
			ps.executeUpdate();
			
			System.out.println("updated successfully");
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}
	
	/*public List<AppointmentDdo> getAllddo(int districtId)
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs = null;
		List<AppointmentDdo> appointmentDdo=new ArrayList<AppointmentDdo>();
		int id=0;
		try
		{
			con=AppointmentDaoImpl.getConnection();
			String getId="select id from district_tbl where did=?";
			ps=con.prepareStatement(getId);
			ps.setInt(1,districtId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				id=rs.getInt("id");
			
			}
			AppointmentDdo a=new AppointmentDdo();
			District district=new District();
			district.setId(id);
			
			final String selectAll="select * from appointment_ddo_tbl where did=?";
			ps=con.prepareStatement(selectAll);
			ps.setInt(1,id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				a.setDistrict(district);
				a.setStartDate(rs.getDate("join_date").toLocalDate());
				a.setLeaveDate(rs.getDate("leave_date").toLocalDate());
				a.setAppointmentType(rs.getBoolean("type_of_appointment"));
				a.setAppointmentLetterNo(rs.getInt("appointment_letter_no"));
				appointmentDdo.add(a);
			}
			
		}catch(Exception e)
		{
			System.out.println(e); 
		}
		return appointmentDdo;
	}
	*/
	public AppointmentDdo insertDdo(int districtId,String userId,AppointmentDdo ddo)
	{
		Connection con;
		ResultSet rs;
		PreparedStatement ps;
		try
		{
			con=AppointmentDaoImpl.getConnection();
			String getDistrictId="select id from district_tbl where did=?";
			ps=con.prepareStatement(getDistrictId);
			ps.setInt(1,districtId);
			rs=ps.executeQuery();
			int did=0;
			while(rs.next())
			{
				did=rs.getInt("id");
				
			}

			String getUserId="select id from user_tbl where login_id=?";
			ps=con.prepareStatement(getUserId);
			ps.setString(1,userId);
			rs=ps.executeQuery();
			int uid=0;
			while(rs.next())
			{
				uid=rs.getInt("id");
			}
			
			String insertDdo="insert into appointment_ddo_tbl(user_id,did,start_date,type_of_appointment,"
					+ "appointment_letter_no) values(?,?,?,?,?) ";
			
			ps=con.prepareStatement(insertDdo,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,uid);
			ps.setInt(2,did);
			ps.setDate(3,java.sql.Date.valueOf(ddo.getStartDate()));
			/*ps.setDate(4,java.sql.Date.valueOf(ddo.getLeaveDate()));*/
			ps.setBoolean(4, ddo.isAppointmentType());
			ps.setInt(5,ddo.getAppointmentLetterNo());
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			rs.next();
			@SuppressWarnings("unused")
				int id1=rs.getInt(1);
		
			
			System.out.println("entered succesffully");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return ddo;
		
	}
	
	public void updateDdoDetails(int districtId,String userId,AppointmentDdo ddo)
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs = null;
		try
		{
			con=AppointmentDaoImpl.getConnection();
			
			String getTid="select id from taluka_tbl where tid=?";
			ps=con.prepareStatement(getTid);
			ps.setInt(1,districtId);
			int did=0;
			rs=ps.executeQuery();
			while(rs.next())
			{
				did=rs.getInt("id");
				
			}
			
			String getUserId="select id from user_tbl where login_id=?";
			ps=con.prepareStatement(getUserId);
			ps.setString(1,userId);
			rs=ps.executeQuery();
			int uid=0;
			while(rs.next())
			{
				uid=rs.getInt("id");
			}
			
			String updateTdo="update appointment_tdo_tbl set user_id=?,join_date=?,leave_date=?,type_of_appointment=?,appointment_letter_no=? where tid="+did;
		
			ps=con.prepareStatement(updateTdo,Statement.RETURN_GENERATED_KEYS);
						
			ps.setInt(1, uid);
			ps.setDate(2,java.sql.Date.valueOf(ddo.getStartDate()));
			ps.setDate(3,java.sql.Date.valueOf(ddo.getLeaveDate()));
			ps.setBoolean(4,ddo.isAppointmentType());
			ps.setInt(5,ddo.getAppointmentLetterNo());
			ps.executeUpdate();
			
			System.out.println("updated successfully");
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
			
	}
	
	public AppointmentTalati getTalati(int villageId,String loginId)
	{
		ResultSet rs;
		PreparedStatement ps;
		int id=0;
		AppointmentTalati appointmentTalati=new AppointmentTalati();
		User user=new User();
		Connection con=null;
		try
		{
			con=AppointmentDaoImpl.getConnection();
			final String getUser="select * from user_tbl where login_id=?";
			ps=con.prepareStatement(getUser);
			ps.setInt(1,id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				user.setLoginId(rs.getString("login_id"));
				user.setPwd(rs.getString("pwd"));
				user.setType(User.Usertype.values()[rs.getInt("user_type")]);
			}
			
			final String selectAll="select * from appointment_talati_tbl where vid=? ORDER BY join_date DESC";
			ps=con.prepareStatement(selectAll);
			ps.setInt(1,id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				appointmentTalati.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
				appointmentTalati.setUser(user);
				appointmentTalati.setStartDate(rs.getDate("start_date").toLocalDate());
				appointmentTalati.setEndDate(rs.getDate("end_date").toLocalDate());
				appointmentTalati.setAppointmentType(rs.getBoolean("type_of_appointment"));
				appointmentTalati.setAppointmentLetterNo(rs.getInt("appointment_letter_no"));
			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return appointmentTalati;
			
	}
	
	public AppointmentTalati insertTalati(int villageId,int userId,AppointmentTalati talati)//census//auto user id
	{
		Connection con;
		ResultSet rs;
		PreparedStatement ps;
		try
		{
			con=AppointmentDaoImpl.getConnection();
			String getVillageId="select * from village_tbl where vid=?";
			ps=con.prepareStatement(getVillageId);
			ps.setInt(1,villageId);
			rs=ps.executeQuery();
			Village village = null;
			while(rs.next())
			{
				village=StateDaoImpl.getAllVillage(con).get(rs.getInt("id"));
				
			}
			talati.setVillage(village);
			System.out.println("village in dao:"+village);

			
			
			String getUser="select * from user_tbl where id=?";
			ps=con.prepareStatement(getUser);
			ps.setInt(1,userId);
			rs=ps.executeQuery();
			User user=new User();
			while(rs.next())
			{
				
				user.setLoginId(rs.getString("login_id"));
				user.setPwd(rs.getString("pwd"));
				user.setType(Usertype.values()[rs.getInt("user_type")]); 
			
			}
		
			
			System.out.println("user in dao:"+user);
			talati.setUser(user);
			
			
			String insertTalati="insert into appointment_talati_tbl(user_id,vid,start_date,type_of_appointment,"
					+ "appointment_letter_no) values(?,?,?,?,?)";
			
			ps=con.prepareStatement(insertTalati,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,userId);
			ps.setInt(2,village.getId());
			ps.setDate(3,java.sql.Date.valueOf(talati.getStartDate()));
/*			ps.setDate(4,java.sql.Date.valueOf(talati.getEndDate()));*/
			ps.setBoolean(4, talati.isAppointmentType());
			ps.setInt(5,talati.getAppointmentLetterNo());
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			rs.next();
			@SuppressWarnings("unused")
				int id1=rs.getInt(1);
		
			
			System.out.println("entered succesffully");
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
			return talati;
	}
	
	public void updateTalatiDetails(int villageId,String userId,AppointmentTalati talati)
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs = null;
		try
		{
			con=AppointmentDaoImpl.getConnection();
			
			String getTid="select id from taluka_tbl where tid=?";
			ps=con.prepareStatement(getTid);
			ps.setInt(1,villageId);
			int vid=0;
			rs=ps.executeQuery();
			while(rs.next())
			{
				vid=rs.getInt("id");
				
			}
			
			String getUserId="select id from user_tbl where login_id=?";
			ps=con.prepareStatement(getUserId);
			ps.setString(1,userId);
			rs=ps.executeQuery();
			int uid=0;
			while(rs.next())
			{
				uid=rs.getInt("id");
			}
			
			String updateTdo="update appointment_tdo_tbl set user_id=?,join_date=?,leave_date=?,type_of_appointment=?,appointment_letter_no=? where tid="+vid;
		
			ps=con.prepareStatement(updateTdo,Statement.RETURN_GENERATED_KEYS);
						
			ps.setInt(1, uid);
			ps.setDate(2,java.sql.Date.valueOf(talati.getStartDate()));
			ps.setDate(3,java.sql.Date.valueOf(talati.getEndDate()));
			ps.setBoolean(4,talati.isAppointmentType());
			ps.setInt(5,talati.getAppointmentLetterNo());
			ps.executeUpdate();
			
			System.out.println("updated successfully");
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
		
		public AppointmentTalati getVillage(String loginId)
		{
			AppointmentTalati talati=new AppointmentTalati();
			Connection con;
			PreparedStatement ps;
			ResultSet rs = null;
		
			try
			{
				con=AppointmentDaoImpl.getConnection();
				String getUserId="select id from user_tbl where login_id=?";
				ps=con.prepareStatement(getUserId);
				ps.setString(1,loginId);
				rs=ps.executeQuery();
				int id=0;
				while(rs.next())
				{
					id=rs.getInt("id");
					System.out.println("id:"+id);
				}
				User user=new User();
				user.setId(id);
				talati.setUser(user);
				
				String getVid="select * from appointment_talati_tbl where user_id=?";
				ps=con.prepareStatement(getVid);
				ps.setInt(1,id);
				rs=ps.executeQuery();
				while(rs.next())
				{
					talati.setUser(user);
					talati.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
					talati.setStartDate(rs.getDate("start_date").toLocalDate());
					/*talati.setEndDate(rs.getDate("end_date").toLocalDate());*/
					talati.setAppointmentType(rs.getBoolean("type_of_appointment"));
					talati.setAppointmentLetterNo(rs.getInt("appointment_letter_no"));
					
				}
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}

		
			return talati;
			}
		
		
		public AppointmentTdo getTaluka(String loginId)
		{
			AppointmentTdo tdo=new AppointmentTdo();
			Connection con;
			PreparedStatement ps;
			ResultSet rs = null;
		
			try
			{
				con=AppointmentDaoImpl.getConnection();
				String getUserId="select id from user_tbl where login_id=?";
				ps=con.prepareStatement(getUserId);
				ps.setString(1,loginId);
				rs=ps.executeQuery();
				int id=0;
				while(rs.next())
				{
					id=rs.getInt("id");
					System.out.println("id:"+id);
				}
				User user=new User();
				user.setId(id);
				tdo.setUser(user);
				
				String getVid="select * from appointment_tdo_tbl where user_id=?";
				ps=con.prepareStatement(getVid);
				ps.setInt(1,id);
				rs=ps.executeQuery();
				while(rs.next())
				{
					tdo.setUser(user);
					tdo.setTaluka(StateDaoImpl.getAllTalukas(con).get(rs.getInt("tid")));
					tdo.setStartDate(rs.getDate("start_date").toLocalDate());
					/*tdo.setEndDate(rs.getDate("end_date").toLocalDate());*/
					tdo.setAppointmentType(rs.getBoolean("type_of_appointment"));
					tdo.setAppointmentLetterNo(rs.getInt("appointment_letter_no"));
					
				}
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}

		
			return tdo;
			}
		
		
		public AppointmentDdo getDistrict(String loginId)
		{
			AppointmentDdo ddo=new AppointmentDdo();
			Connection con;
			PreparedStatement ps;
			ResultSet rs = null;
		
			try
			{
				con=AppointmentDaoImpl.getConnection();
				String getUserId="select id from user_tbl where login_id=?";
				ps=con.prepareStatement(getUserId);
				ps.setString(1,loginId);
				rs=ps.executeQuery();
				int id=0;
				while(rs.next())
				{
					id=rs.getInt("id");
					System.out.println("id:"+id);
				}
				User user=new User();
				user.setId(id);
				ddo.setUser(user);
				
				String getDid="select * from appointment_ddo_tbl where user_id=?";
				ps=con.prepareStatement(getDid);
				ps.setInt(1,id);
				rs=ps.executeQuery();
				while(rs.next())
				{
					ddo.setUser(user);
					ddo.setDistrict(StateDaoImpl.getAllDistricts(con).get(rs.getInt("did")));
					ddo.setStartDate(rs.getDate("start_date").toLocalDate());
					ddo.setLeaveDate(rs.getDate("end_date").toLocalDate());
					ddo.setAppointmentType(rs.getBoolean("type_of_appointment"));
					ddo.setAppointmentLetterNo(rs.getInt("appointment_letter_no"));
					
				}
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}

		
			return ddo;
			}
		
	
		public AppointmentTalati getAllTalatiDetails(int villageId) {//enter the autoincremented village id
			AppointmentTalati talati=new AppointmentTalati();
			Connection con;
			PreparedStatement ps;
			ResultSet rs = null;
		
			try
			{
				con=AppointmentDaoImpl.getConnection();
				String getUserId="select user_id from appointment_talati_tbl where vid=?";
				ps=con.prepareStatement(getUserId);
				ps.setInt(1,villageId);
				rs=ps.executeQuery();
				int userId=0;
				while(rs.next())
				{
					userId=rs.getInt("user_id");
					System.out.println("user id in dao:"+userId);
				}
				
				String getUser="select * from user_tbl where id=?";
				ps=con.prepareStatement(getUser);
				ps.setInt(1,userId);
				rs=ps.executeQuery();
				User user=new User();
				while(rs.next())
				{
					
					user.setLoginId(rs.getString("login_id"));
					user.setPwd(rs.getString("pwd"));
					user.setType(Usertype.values()[rs.getInt("user_type")]); 
				
				}
				
				
				
			//	talati.setUser(user);
				
				String getAllDetails="select * from appointment_talati_tbl where vid=?";
				ps=con.prepareStatement(getAllDetails);
				ps.setInt(1,villageId);
				rs=ps.executeQuery();
				while(rs.next())
				{
					talati.setUser(user);
					talati.setVillage(StateDaoImpl.getAllVillage(con).get(rs.getInt("vid")));
					talati.setStartDate(rs.getDate("start_date").toLocalDate());
					/*talati.setEndDate(rs.getDate("end_date").toLocalDate());*/
					talati.setAppointmentType(rs.getBoolean("type_of_appointment"));
					talati.setAppointmentLetterNo(rs.getInt("appointment_letter_no"));
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
			
			
			return talati;
		}
		
		public AppointmentTdo getAllTdoDetails(int talukaId)
		{
			AppointmentTdo tdo=new AppointmentTdo();
			Connection con;
			PreparedStatement ps;
			ResultSet rs = null;
		
			try
			{
				con=AppointmentDaoImpl.getConnection();
				String getUserId="select user_id from appointment_tdo_tbl where tid=?";
				ps=con.prepareStatement(getUserId);
				ps.setInt(1,talukaId);
				rs=ps.executeQuery();
				int userId=0;
				while(rs.next())
				{
					userId=rs.getInt("user_id");
					System.out.println("user id:"+userId);
				}
				
				String getUser="select * from user_tbl where id=?";
				ps=con.prepareStatement(getUser);
				ps.setInt(1,userId);
				rs=ps.executeQuery();
				User user=new User();
				while(rs.next())
				{
					user.setId(rs.getInt("id"));
					user.setLoginId(rs.getString("login_id"));
					user.setPwd(rs.getString("pwd"));
					user.setType(Usertype.values()[rs.getInt("user_type")]); 
				
				}
				System.out.println("user in dao:"+user);
				
				
			//	talati.setUser(user);
				
				String getAllDetails="select * from appointment_tdo_tbl where tid=?";
				ps=con.prepareStatement(getAllDetails);
				ps.setInt(1,talukaId);
				rs=ps.executeQuery();
				while(rs.next())
				{
					tdo.setUser(user);
					tdo.setTaluka(StateDaoImpl.getAllTalukas(con).get(rs.getInt("tid")));
					tdo.setStartDate(rs.getDate("start_date").toLocalDate());
					/*tdo.setEndDate(rs.getDate("end_date").toLocalDate());*/
					tdo.setAppointmentType(rs.getBoolean("type_of_appointment"));
					tdo.setAppointmentLetterNo(rs.getInt("appointment_letter_no"));
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
			
			
			return tdo;
			
		}

		@Override
		public AppointmentDdo getAllDdoDetails(int districtId) {//auto increment id
			AppointmentDdo ddo=new AppointmentDdo();
			Connection con;
			PreparedStatement ps;
			ResultSet rs = null;
		
			try
			{
				con=AppointmentDaoImpl.getConnection();
				String getUserId="select user_id from appointment_ddo_tbl where did=?";
				ps=con.prepareStatement(getUserId);
				ps.setInt(1,districtId);
				rs=ps.executeQuery();
				int userId=0;
				while(rs.next())
				{
					userId=rs.getInt("user_id");
					System.out.println("user id:"+userId);
				}
				
				String getUser="select * from user_tbl where id=?";
				ps=con.prepareStatement(getUser);
				ps.setInt(1,userId);
				rs=ps.executeQuery();
				User user=new User();
				while(rs.next())
				{
					user.setId(rs.getInt("id"));
					user.setLoginId(rs.getString("login_id"));
					user.setPwd(rs.getString("pwd"));
					user.setType(Usertype.values()[rs.getInt("user_type")]); 
				
				}
				System.out.println("user in dao:"+user);
				
				
			//	talati.setUser(user);
				
				String getAllDetails="select * from appointment_ddo_tbl where did=?";
				ps=con.prepareStatement(getAllDetails);
				ps.setInt(1,districtId);
				rs=ps.executeQuery();
				while(rs.next())
				{
					ddo.setUser(user);
					ddo.setDistrict(StateDaoImpl.getAllDistricts(con).get(rs.getInt("did")));
					ddo.setStartDate(rs.getDate("start_date").toLocalDate());
					/*tdo.setEndDate(rs.getDate("end_date").toLocalDate());*/
					ddo.setAppointmentType(rs.getBoolean("type_of_appointment"));
					ddo.setAppointmentLetterNo(rs.getInt("appointment_letter_no"));
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
			
			
			return ddo;
		}

	/*	@Override
		public AppointmentDdo insertDdo(int districtId, int userId, AppointmentDdo ddo) {
			Connection con;
			ResultSet rs;
			PreparedStatement ps;
			try
			{
				con=AppointmentDaoImpl.getConnection();
				String getDistrictId="select * from district_tbl where did=?";
				ps=con.prepareStatement(getDistrictId);
				ps.setInt(1,districtId);
				rs=ps.executeQuery();
				District district = null;
				while(rs.next())
				{
					district=StateDaoImpl.getAllDistricts(con).get(rs.getInt("id"));
					
				}
				ddo.setDistrict(district);
				System.out.println("ditrict in dao:"+district);

				
				
				String getUser="select * from user_tbl where id=?";
				ps=con.prepareStatement(getUser);
				ps.setInt(1,userId);
				rs=ps.executeQuery();
				User user=new User();
				while(rs.next())
				{
					
					user.setLoginId(rs.getString("login_id"));
					user.setPwd(rs.getString("pwd"));
					user.setType(Usertype.values()[rs.getInt("user_type")]); 
				
				}
			
				
				System.out.println("user in dao:"+user);
				ddo.setUser(user);
				
				
				String insertDdo="insert into appointment_ddo_tbl(user_id,vid,start_date,type_of_appointment,"
						+ "appointment_letter_no) values(?,?,?,?,?)";
				
				ps=con.prepareStatement(insertDdo,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1,userId);
				ps.setInt(2,district.getId());
				ps.setDate(3,java.sql.Date.valueOf(ddo.getStartDate()));
				ps.setDate(4,java.sql.Date.valueOf(talati.getEndDate()));
				ps.setBoolean(4, ddo.isAppointmentType());
				ps.setInt(5,ddo.getAppointmentLetterNo());
				ps.executeUpdate();
				rs=ps.getGeneratedKeys();
				rs.next();
				@SuppressWarnings("unused")
					int id1=rs.getInt(1);
			
				
				System.out.println("entered succesffully");
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			
				return ddo;
		}
*/
		

	
	
	
}
	
		

