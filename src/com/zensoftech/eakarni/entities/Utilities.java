package com.zensoftech.eakarni.entities;

import java.security.MessageDigest;
import java.sql.SQLException;
public class Utilities 
{
	
 public String get_SHA_512_SecurePassword(String passwordToHash) throws ClassNotFoundException, SQLException
 {
	 String generatedPassword = null;
		try
		{
	
				//String salt=loginId+"@123";
				MessageDigest md = MessageDigest.getInstance("SHA-512");
				md.update(passwordToHash.getBytes());
				byte[] bytes= md.digest(passwordToHash.getBytes("UTF-8"));
				StringBuilder sb = new StringBuilder();
				for(int i=0; i< bytes.length ;i++)
				{
					sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
				}
				generatedPassword = sb.toString();
		
		}
		
		catch (Exception e)
		{
		     e.printStackTrace();
		}
		   return generatedPassword;
 }
 

	
 }
 
 
	




