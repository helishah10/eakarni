package com.zensoftech.eakarni.service;

import com.zensoftech.eakarni.DAO.AppointmentDao;
import com.zensoftech.eakarni.entities.AppointmentDdo;

public class AddDdoManagerImpl implements AddDdoManager {
	
	AppointmentDao appointmentdao;
	
	public AddDdoManagerImpl(AppointmentDao appointmentdao)
	{
		this.appointmentdao=appointmentdao;
	}
	

	@Override
	public AppointmentDdo insertDdo(int districtId, String userId, AppointmentDdo ddo) {
		ddo=appointmentdao.insertDdo(districtId, userId, ddo);
		System.out.println("in service:"+ddo);
		return ddo;
	}

}
