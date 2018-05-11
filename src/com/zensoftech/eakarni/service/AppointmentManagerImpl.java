package com.zensoftech.eakarni.service;



import com.zensoftech.eakarni.DAO.AppointmentDao;
import com.zensoftech.eakarni.DAO.StateDao;
import com.zensoftech.eakarni.entities.AppointmentDdo;
import com.zensoftech.eakarni.entities.AppointmentTalati;
import com.zensoftech.eakarni.entities.AppointmentTdo;



public class AppointmentManagerImpl implements AppointmentManager
{
	
	
	private AppointmentDao appointmentdao;

	

	public AppointmentManagerImpl(AppointmentDao appointmentdao2) {
		this.appointmentdao=appointmentdao2;
	
	}

	

	public AppointmentTalati getVillage(String loginId)
	{
		AppointmentTalati talati=new AppointmentTalati();
		talati= appointmentdao.getVillage(loginId);
		return talati;
	}
	
	public AppointmentTdo getTaluka(String loginId)
	{
		AppointmentTdo tdo=new AppointmentTdo();
		tdo= appointmentdao.getTaluka(loginId);
		return tdo;
	}
	
	public AppointmentDdo getDistrict(String loginId)
	{
		AppointmentDdo ddo=new AppointmentDdo();
		ddo= appointmentdao.getDistrict(loginId);
		return ddo;
	}
	
	
	
	
}
