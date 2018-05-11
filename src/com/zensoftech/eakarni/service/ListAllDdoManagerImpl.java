package com.zensoftech.eakarni.service;

import java.util.ArrayList;
import java.util.List;

import com.zensoftech.eakarni.DAO.AppointmentDao;
import com.zensoftech.eakarni.DAO.StateDao;
import com.zensoftech.eakarni.entities.AppointmentDdo;

import com.zensoftech.eakarni.entities.District;


public class ListAllDdoManagerImpl implements ListAllDdoManager{
	
	private AppointmentDao appointmentdao;
	private StateDao statedao;
	

	public ListAllDdoManagerImpl(AppointmentDao appointmentdao,StateDao statedao) {
		this.appointmentdao=appointmentdao;
		this.statedao=statedao;
	
	}
	public List<AppointmentDdo> getAllDdo(int stateId)
	{
		List<AppointmentDdo> ddoList=new ArrayList<>();
		List<District> districtList= new ArrayList<>();
		AppointmentDdo ddo=new AppointmentDdo();
		
		districtList=statedao.getAllDistrictByStateId(stateId);
		System.out.println("district list:"+districtList);
		for(District district:districtList)
		{
			int districtId=district.getId();
			System.out.println("district id"+districtId);
			ddo=appointmentdao.getAllDdoDetails(districtId);
			ddoList.add(ddo);
			
		}
		System.out.println(ddoList);
		return ddoList;
	
	
	}
	
	

}
