package com.zensoftech.eakarni.DAO;

import java.util.*;


import com.zensoftech.eakarni.entities.User;
import com.zensoftech.eakarni.entities.UserDetails;
import com.zensoftech.eakarni.entities.UserSession;
public interface UserDao {

	public List<User> getusersbytype(String usertype);
	public User addUser(User user);
	public  List<User> getallusers();
	
	public boolean authenticate(String id,String pwd);
	public User getUser(String loginId);
	public UserDetails getUserDetail(String loginId);
	
	public User updatepwd(String loginId,String newPwd);
	public boolean update(String loginId,UserDetails userdetails);
	public void addUserDetails(String loginId,UserDetails userdetails);
	
	//public void saveSessionDetails(UserSession session);

	
}
