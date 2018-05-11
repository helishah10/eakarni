package com.zensoftech.eakarni.DAO;

import java.sql.SQLException;
import java.util.Map;

import com.zensoftech.eakarni.entities.Owner;

public interface OwnerDao 
{
	public Map<Integer,Owner> getAllOwnerDetails() throws ClassNotFoundException, SQLException;
	public Owner insertOwner(int propertyNo,Owner owner);
	public void update(int propertyNo,Owner owner);
	public Owner getProperty(int propertyNo);

	
}
