package com.zensoftech.eakarni.DAO;

import java.util.ArrayList;
import java.util.List;

import com.zensoftech.eakarni.entities.AppointmentDdo;
import com.zensoftech.eakarni.entities.AppointmentTalati;
import com.zensoftech.eakarni.entities.AppointmentTdo;
import com.zensoftech.eakarni.entities.Village;

public interface AppointmentDao
{
	public List<AppointmentTdo> getAllTdo(int talukaId);
	public AppointmentTdo insertTdo(int talukaId,int userId,AppointmentTdo tdo);
	public void updateTdoDetails(int taluakId,String userId,AppointmentTdo tdo);
	public AppointmentTdo getTaluka(String loginId);
	public AppointmentTdo getAllTdoDetails(int talukaId);
	
	
	/*public List<AppointmentDdo> getAllddo(int districtId);*/
	public AppointmentDdo insertDdo(int distirctId,String userId,AppointmentDdo ddo);
	public void updateDdoDetails(int districtId,String UserId,AppointmentDdo ddo);
	public AppointmentDdo getDistrict(String loginId);
	
	public AppointmentTalati getTalati(int villageId,String loginId);
	public AppointmentTalati insertTalati(int villageId,int userId,AppointmentTalati talati);//census village id
	public void updateTalatiDetails(int villageId,String userId,AppointmentTalati talati);
	public AppointmentTalati getVillage(String loginId);
	public AppointmentTalati getAllTalatiDetails(int villageId);
	
	public AppointmentDdo getAllDdoDetails(int districtId);
	

}

