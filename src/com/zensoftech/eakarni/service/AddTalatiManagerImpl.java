package com.zensoftech.eakarni.service;

import com.zensoftech.eakarni.DAO.AppointmentDao;
import com.zensoftech.eakarni.entities.AppointmentTalati;

public class AddTalatiManagerImpl implements AddTalatiManager{
	
	AppointmentDao appointmentdao;
	
	public AddTalatiManagerImpl(AppointmentDao appointmentdao)
	{
		this.appointmentdao=appointmentdao;
	}
	
	public AppointmentTalati insertTalati(int villageId,int userId,AppointmentTalati talati)
	{
		
		talati=appointmentdao.insertTalati(villageId, userId, talati);
		System.out.println("in service:"+talati);
		return talati;
	}

}
