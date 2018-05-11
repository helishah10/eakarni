package com.zensoftech.eakarni.service;


import com.zensoftech.eakarni.entities.User;
import com.zensoftech.eakarni.entities.UserDetails;



public interface UserManager
{
	//public List<User> getAllUsers(UserDao userdao);
	//public List<User> getUsersBytype();
	public void updatePassword(String loginId,String pwd);
	public void addUserDetails(String loginId,UserDetails userdetails);
	public boolean updateUserDetails(String loginId,UserDetails userdetails);
	//public void insertUser(User user);
	public boolean Login(String loginId,String pwd);
	public User getUser(String loginId);
	public UserDetails getUserDetails(String loginId);
	public User addUser(User user);
	

}
