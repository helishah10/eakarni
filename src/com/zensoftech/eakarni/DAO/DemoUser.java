
package com.zensoftech.eakarni.DAO;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zensoftech.eakarni.entities.District;
import com.zensoftech.eakarni.entities.PropertyMaster;
import com.zensoftech.eakarni.entities.User;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.service.UserManager;
import com.zensoftech.eakarni.service.UserManagerImpl;
import com.zensoftech.eakarni.entities.User.Usertype;

public class DemoUser 
{

	public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException 
	{
		String loginId="";
		String pwd="";

		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/masterdb?autoReconnect=true&useSSL=false";
		String user="eakarni";
		String password="eakarni";
		User user2=new User();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		UserDao userdao=new UserDaoImpl(driver,url,user,password);
		StateDao statedao=new StateDaoImpl(driver,url,user,password);
		/*int districtId=200;
		District district=statedao.getDistrict(districtId);
		System.out.println(district);*/
		
		PropertyDao propertydao=new PropertyDaoImpl(driver,url,user,password);
		System.out.println("enter village id:");
		int villageId=Integer.parseInt(br.readLine());
		/*System.out.println("enter property number:");
		String pno=br.readLine();
		System.out.println("area name:");
		String area=br.readLine();
		System.out.println("split:");
		boolean split=Boolean.parseBoolean(br.readLine());
		System.out.println("parent name:");
		String parent=br.readLine();
		System.out.println("description:");
		String desc=br.readLine();
		System.out.println("registration yr:");
		int yr=Integer.parseInt(br.readLine());
		System.out.println("reg page number:");
		int pageno=Integer.parseInt(br.readLine());	*/
		
		PropertyMaster property=new PropertyMaster();
		
		property.setParent("13aaa");
		property.setAreaName("aaaa");
		property.setDescription("good bad");
		property.setPropertyNo("13a");
		property.setRegisterPageNo(12);
		property.setRegistrationYear(2000);
		property.setSplit(true);
		
		property=propertydao.insert(villageId, property);
		System.out.println("property in main:"+property);//run 
		
		

	
		
	
	
		
		
		
		/*System.out.println("enter User id:");
		loginId=br.readLine();
		System.out.println("enter password:");
		pwd=br.readLine();
		System.out.println("enter User type:");
		String type=br.readLine();
		Usertype utype=Usertype.valueOf(type);
	
		user2.setLoginId(loginId);
		user2.setPwd(pwd);
		user2.setType(utype);
		System.out.println(user2);
		userdao.addUser(user2);*/
		/*UserDao userdao=new UserDaoImpl(driver,url,user,password);
				User user1=new User();
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				System.out.println("enter User id:");
				loginId=br.readLine();
				user1=userdao.getUser(loginId);
				System.out.println("in main:"+user1);*/
				
				
				//Class.forName("com.mysql.Jdbc.driver");
				//BufferedReader br12=new BufferedReader(new InputStreamReader(System.in));
				//userdao.getUserDetail(loginId);
				
				/*System.out.println("enter the login id:");
				loginId=br12.readLine();
				UserDetails ud=new UserDetails();
				ud=userdao.getUserDetail(loginId);
				System.out.println(ud);
			
				@SuppressWarnings("rawtypes")
				ArrayList al=new ArrayList();
				al.add(ud);
				for(int i=0;i<al.size();i++)
				{
					System.out.println("first name:"+ud.getFirstName());
					
				}*/
				/*System.out.println("enter the password:"); 
				pwd=br12.readLine();
				dao.authenticate(loginId,pwd);
*/
		//UserDao dao3=new UserDaoImpl(databasePassword, databasePassword, databasePassword, databasePassword);
	/*	User user2=new User();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter User id:");
		loginId=br.readLine();
		System.out.println("enter password:");
		pwd=br.readLine();
		System.out.println("enter User type:");
		String type=br.readLine();
		Usertype utype=Usertype.valueOf(type);
	
		user2.setLoginId(loginId);
		user2.setPwd(pwd);
		user2.setType(utype);
		System.out.println(user2);
		userdao.addUser(user2);
		
		/*UserDao dao2=new UserDaoImpl();
		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the type(talati/tdo/ddo): ");
		String Utype=br1.readLine();
		for(User user:dao2.getusersbytype(Utype))
		{
			System.out.println("User id: "+user.getLoginId()+"\t User password:" +user.getPwd()+"\t usertype:"+user.getType());
		}
		*/
		
	
		/*UserDao dao1=new UserDaoImpl();

		System.out.println("all users:");
		for(User u: dao1.getallusers())
		{
			System.out.println("User id: "+u.getLoginId()+"\t User password:" +u.getPwd()+"\t usertype:"+u.getType());

		}*/
		
		
		/*String firstName="",middleName="",lastName="",address="",emailId="";
		int contactNo=0,postalCode=0,aadharcard=0;*/
		
		
	

		
		
		/*UserDao dao5=new UserDaoImpl();
		BufferedReader br3=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter the id whose pwd to be changed:");
		String loginId1=br3.readLine();
		
		System.out.println("enter the new password:");
		String pwd1=br3.readLine();
		
		dao5.updatepwd(loginId1,pwd1);
		
		UserDao dao8=new UserDaoImpl();
		BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
		
		UserDetails ud=new UserDetails();
		
		System.out.println("enter the login id to add the details to:");
		loginId=br2.readLine();
		
		
		System.out.println("enter first name:");
		firstName=br2.readLine();
		System.out.println("enter the middle name:");
		middleName=br2.readLine();
		System.out.println("enter the last name:");
		lastName=br2.readLine();
		System.out.println("enter address: ");
		address=br2.readLine();
		System.out.println("enter contact number:");
		contactNo=Integer.parseInt(br2.readLine());
		System.out.println("enter postal code:");
		 postalCode=Integer.parseInt(br2.readLine());
		System.out.println("enter email id:");
		emailId=br2.readLine();
		System.out.println("enter your aadharcard number:");
		aadharcard=Integer.parseInt(br2.readLine());

		ud.setFirstName(firstName);
		ud.setMiddleName(middleName);
		ud.setLastName(lastName);
		ud.setAddress(address);
		ud.setContactNo(contactNo);
		ud.setPostalCode(postalCode);
		ud.setEmailId(emailId);
		ud.setAadharcard(aadharcard);
		
		dao8.addUserDetails(loginId,ud);

		*/
	/*	UserDao dao6=new UserDaoImpl(driver, url, user, password);
		
		BufferedReader br4=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter the login id to make the updates:");
		loginId=br4.readLine();
		
		System.out.println("enter first name:");
		String firstName=br4.readLine();
		System.out.println("enter the middle name:");
		String middleName=br4.readLine();
		System.out.println("enter the last name:");
		String lastName=br4.readLine();
		System.out.println("enter address: ");
		String address=br4.readLine();
		System.out.println("enter contact number:");
		int contactNo=Integer.parseInt(br4.readLine());
		System.out.println("enter postal code:");
		int postalCode=Integer.parseInt(br4.readLine());
		System.out.println("enter email id:");
		String emailId=br4.readLine();
		System.out.println("enter your aadharcard number:");
		int aadharcard=Integer.parseInt(br4.readLine());
		
		
		UserDetails ud1=new UserDetails();
		
		ud1.setFirstName(firstName);
		ud1.setMiddleName(middleName);
		ud1.setLastName(lastName);
		ud1.setAddress(address);
		ud1.setContactNo(contactNo);
		ud1.setPostalCode(postalCode);
		ud1.setEmailId(emailId);
		ud1.setAadharcard(aadharcard);

		dao6.update(loginId,ud1);
		*/
		
		/*User user1=new User();
		System.out.println("enter the login id:");
		loginId=br.readLine();
		System.out.println("enter the new pwd:");
		String newpwd=br.readLine();
		
		user1=userdao.updatepwd(loginId,newpwd);
		System.out.println(user1);
		
	boolean value=userdao.authenticate(loginId, newpwd);
		System.out.println(value);*/
		
	}
}
		



