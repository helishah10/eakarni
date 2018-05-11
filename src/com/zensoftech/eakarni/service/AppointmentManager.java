package com.zensoftech.eakarni.service;


import com.zensoftech.eakarni.entities.AppointmentDdo;
import com.zensoftech.eakarni.entities.AppointmentTalati;
import com.zensoftech.eakarni.entities.AppointmentTdo;

public interface AppointmentManager 
{
	public AppointmentTalati getVillage(String loginId);
	public AppointmentTdo getTaluka(String loginId);
	public AppointmentDdo getDistrict(String loginId);


}
