package com.zensoftech.eakarni.service;

import java.sql.SQLException;
import java.util.Map;

import com.zensoftech.eakarni.entities.District;
import com.zensoftech.eakarni.entities.State;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public interface StateManager {
	
	public Map<Integer,State> getAllStates() throws ClassNotFoundException, SQLException;
	
	public Map<Integer,Taluka> getAllTalukas() throws ClassNotFoundException, SQLException;
	public Map<Integer,Village> getAllVillages() throws ClassNotFoundException, SQLException;
	public Village getVillage(int villageid);//census id
	
	
}
