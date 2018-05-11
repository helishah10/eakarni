package com.zensoftech.eakarni.service;

import java.util.List;

import com.zensoftech.eakarni.DAO.UserDao;
import com.zensoftech.eakarni.entities.User;
import com.zensoftech.eakarni.entities.UserDetails;

public class UserManagerImpl implements UserManager
{
	UserDao userdao;
	
	
	public UserManagerImpl(UserDao userdao2) {
		this.userdao=userdao2;
	
	}
	
	public boolean Login(String loginId,String pwd)
	{
		return userdao.authenticate(loginId, pwd);
	
	}
	public User getUser(String loginId)
	{
		User user=new User();
		user=userdao.getUser(loginId);
		return user;
	}
	
	public UserDetails getUserDetails(String loginId)
	{
		UserDetails userdetails=new UserDetails();
		userdetails=userdao.getUserDetail(loginId);
		return userdetails;
	}
	
	public void addUserDetails(String loginId,UserDetails userdetails)
	{
		userdao.addUserDetails(loginId, userdetails);
	}
	
	public boolean updateUserDetails(String loginId,UserDetails userdetails)
	{
		if(userdao.update(loginId, userdetails))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public void updatePassword(String loginId,String pwd)
	{
		
		userdao.updatepwd(loginId, pwd);
		
	}
	
	public User addUser(User user)
	{
	 userdao.addUser(user);
	 return user;
	}
	
	
	


	

	
}
