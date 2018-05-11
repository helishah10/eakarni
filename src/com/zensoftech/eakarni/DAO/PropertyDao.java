package com.zensoftech.eakarni.DAO;

import java.sql.SQLException;
import java.util.Map;

import com.zensoftech.eakarni.entities.Iay;
import com.zensoftech.eakarni.entities.PropertyDetails;
import com.zensoftech.eakarni.entities.PropertyMaster;

public interface PropertyDao
{
	public Map<Integer,PropertyMaster> getAllDetailsByDistrictId(int districtId);//enter census id
	public  Map<Integer,PropertyMaster> getAllDetailsByTalukaId(int talukaId);//enter census id
	/*public Map<Integer,PropertyMaster> getAllDetailsByVillageId(int villageId);*/
	public PropertyMaster insert(int villageId,PropertyMaster property);
	public void update(PropertyMaster property,int villageId);
	public int getTotalCountByTalukaId(int talukaId);
	public int getTotalCountByDistrictId(int districtId);
	
	
	
	public Map<Integer, PropertyMaster> getAllPropertyByVillage(int villageId) throws ClassNotFoundException, SQLException;
	//enter autoincrement village id
	public  Map<Integer, PropertyMaster> getAllPropertyMasterDetails() throws ClassNotFoundException, SQLException;
	
	public PropertyMaster getProperty(String propertyId);
	
	
}
