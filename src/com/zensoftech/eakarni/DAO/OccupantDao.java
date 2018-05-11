package com.zensoftech.eakarni.DAO;

import java.sql.SQLException;
import java.util.Map;

import com.zensoftech.eakarni.entities.Occupant;

public interface OccupantDao
{
	public Map<Integer,Occupant> getAllOccupantDetails() throws ClassNotFoundException, SQLException;
	public Occupant insertOccupant(int propertyNo,Occupant occupant);
	public void update(int propertyNo,Occupant occupant);
	public Occupant getProperty(int propertyNo);

}
