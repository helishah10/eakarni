package com.zensoftech.eakarni.service;

import java.sql.SQLException;
import java.util.Map;

import com.zensoftech.eakarni.DAO.StateDao;
import com.zensoftech.eakarni.entities.District;
import com.zensoftech.eakarni.entities.State;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public class StateManagerImpl implements StateManager{

	StateDao statedao;

	public StateManagerImpl(StateDao statedao2) {
		this.statedao=statedao2;
	
	}

	public Map<Integer, State> getAllStates() throws ClassNotFoundException, SQLException {
		Map<Integer,State> stateMap;
		stateMap=statedao.getAllStates();
		return stateMap;
		
	}
	/*
	public Map<Integer, District> getAllDistricts() throws ClassNotFoundException, SQLException {
		Map<Integer,District> districtMap;
		districtMap=statedao.
		return districtMap;
	}*/

	
	public Map<Integer, Taluka> getAllTalukas() throws ClassNotFoundException, SQLException {
		Map<Integer,Taluka> talukaMap;
		talukaMap=statedao.getAllTalukas();
		return talukaMap;
	}

	public Map<Integer, Village> getAllVillages() throws ClassNotFoundException, SQLException {
		Map<Integer, Village> villageMap;
		villageMap=statedao.getAllVillage();
		return villageMap;
	}
	
	public Village getVillage(int villageId)
	{
		Village village =new Village();
		village=statedao.getVillage(villageId);
		System.out.println("in service:"+village);
		return village;
	}
	
	public Taluka getTaluka(int talukaId)
	{
		Taluka taluka=new Taluka();
		taluka=statedao.getTaluka(talukaId);
		return taluka;
	}

	public District getDistrict(int districtId) {//census id
		District district=new District();
		district=statedao.getDistrict(districtId);
		return district;
	}

	/*@Override
	public Map<Integer, District> getAllDistricts() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	
	

}
