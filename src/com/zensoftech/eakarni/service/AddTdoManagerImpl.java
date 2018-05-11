package com.zensoftech.eakarni.service;

import com.zensoftech.eakarni.DAO.AppointmentDao;
import com.zensoftech.eakarni.entities.AppointmentTalati;
import com.zensoftech.eakarni.entities.AppointmentTdo;

public class AddTdoManagerImpl implements AddTdoManager {
	
AppointmentDao appointmentdao;
	
	public AddTdoManagerImpl(AppointmentDao appointmentdao)
	{
		this.appointmentdao=appointmentdao;
	}
	
	public AppointmentTdo insertTdo(int villageId,int userId,AppointmentTdo tdo)
	{
		
		tdo=appointmentdao.insertTdo(villageId, userId, tdo);
		System.out.println("in service:"+tdo);
		return tdo;
	}

}
