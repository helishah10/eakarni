package com.zensoftech.eakarni.service;

import com.zensoftech.eakarni.entities.AppointmentDdo;

public interface AddDdoManager {
	public AppointmentDdo insertDdo(int districtId,String userId,AppointmentDdo ddo);

}
