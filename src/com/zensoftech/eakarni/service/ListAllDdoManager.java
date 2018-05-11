package com.zensoftech.eakarni.service;

import java.util.List;


import com.zensoftech.eakarni.entities.AppointmentDdo;


public interface ListAllDdoManager {

	public List<AppointmentDdo> getAllDdo(int stateId);
}
