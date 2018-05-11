package com.zensoftech.eakarni.service;

import com.zensoftech.eakarni.entities.AppointmentTdo;

public interface AddTdoManager {
	
	public AppointmentTdo insertTdo(int talukaId,int userId,AppointmentTdo tdo);

}
