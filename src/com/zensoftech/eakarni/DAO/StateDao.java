package com.zensoftech.eakarni.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.zensoftech.eakarni.entities.District;
import com.zensoftech.eakarni.entities.State;
import com.zensoftech.eakarni.entities.Taluka;
import com.zensoftech.eakarni.entities.Village;

public interface StateDao {
	
		public Map<Integer,State> getAllStates() throws ClassNotFoundException, SQLException;
		public State getStateByStateId(int stateid) throws SQLException;
		public State getStateByName(String StateName) throws SQLException;
		public void update(State state) throws SQLException;
	
	//public Map<Integer, District> getAllDistricts(Map<Integer, States> stateMap);

		public Map<Integer,District> getDistrictsByState(State state);
		public District getDistrictByName(String districtName);
		public District getDistrictByDistrictId(int dId);
		public void update(District district);
		
		public Map<Integer,Taluka> getAllTalukas() throws ClassNotFoundException, SQLException;
		//public Map<Integer,Taluka> getAllTalukas(Map<Integer,District> districtMap);
		//public Map<Integer,Taluka> getTalukasByState();
		public List<Taluka> getTalukasByDistrict(int districtId);//auto id
		/*public Taluka getTalukaByName(String talukaname);*/
		public Taluka getTaluka(int talukaId);//census id
		public void update(Taluka taluka);
		
		public Map<Integer,Village> getAllVillage() throws ClassNotFoundException, SQLException;
		public List<Village> getAllVillagesByTaluka(int talukaId);
		public int getTotalVillagesByTalukaId(int talukaId);
		public Village getVillage(int villageId);//census id
		
		
		public List<District> getAllDistrictByStateId(int stateId);
		public District getDistrict(int districtId);
		public int getTotalTalukasByDistrictId(int districtId);
		
		

}
