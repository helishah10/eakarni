package com.zensoftech.eakarni.service;

import java.util.ArrayList;
import java.util.List;

import com.zensoftech.eakarni.DAO.AppointmentDao;
import com.zensoftech.eakarni.DAO.StateDao;
import com.zensoftech.eakarni.entities.AppointmentTdo;
import com.zensoftech.eakarni.entities.Taluka;


public class ListAllTdoManagerImpl implements ListAllTdoManager{
	
	
	private AppointmentDao appointmentdao;
	private StateDao statedao;
	

	public ListAllTdoManagerImpl(AppointmentDao appointmentdao,StateDao statedao) {
		this.appointmentdao=appointmentdao;
		this.statedao=statedao;
	
	}
	public List<AppointmentTdo> getAllTdo(int districtId)
	{
		List<AppointmentTdo> tdoList=new ArrayList<>();
		List<Taluka> talukaList= new ArrayList<>();
		AppointmentTdo tdo=new AppointmentTdo();
		
		talukaList=statedao.getTalukasByDistrict(districtId);
		System.out.println("taluka list:"+talukaList);
		for(Taluka taluka:talukaList)
		{
			int talukaId=taluka.getId();
			System.out.println("taluka id"+talukaId);
			tdo=appointmentdao.getAllTdoDetails(talukaId);
			tdoList.add(tdo);
			
		}
		System.out.println(talukaList);
		return tdoList;
		
	}
	

}
