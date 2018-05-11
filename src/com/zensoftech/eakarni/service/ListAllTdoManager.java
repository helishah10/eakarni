package com.zensoftech.eakarni.service;

import java.util.List;

import com.zensoftech.eakarni.entities.AppointmentTdo;

public interface ListAllTdoManager {
	public List<AppointmentTdo> getAllTdo(int districtId);

}
