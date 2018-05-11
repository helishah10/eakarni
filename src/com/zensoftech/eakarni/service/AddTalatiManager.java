package com.zensoftech.eakarni.service;

import com.zensoftech.eakarni.entities.AppointmentTalati;

public interface AddTalatiManager {
	
	public AppointmentTalati insertTalati(int villageId,int userId,AppointmentTalati talati);

}
