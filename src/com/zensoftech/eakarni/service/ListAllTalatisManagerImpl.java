package com.zensoftech.eakarni.service;

import java.util.ArrayList;
import java.util.List;

import com.zensoftech.eakarni.DAO.AppointmentDao;
import com.zensoftech.eakarni.DAO.StateDao;
import com.zensoftech.eakarni.entities.AppointmentTalati;
import com.zensoftech.eakarni.entities.Village;

public class ListAllTalatisManagerImpl  implements ListAllTalatisManager{
	
	private AppointmentDao appointmentdao;
	private StateDao statedao;
	

	public ListAllTalatisManagerImpl(AppointmentDao appointmentdao2,StateDao statedao2) {
		this.appointmentdao=appointmentdao2;
		this.statedao=statedao2;
	
	}
	
	public List<AppointmentTalati> getAllTalatis(int talukaId)
	{
		List<AppointmentTalati> talatiList=new ArrayList<>();
		List<Village> villageList= new ArrayList<>();
		AppointmentTalati talati=new AppointmentTalati();
		
		villageList=statedao.getAllVillagesByTaluka(talukaId);
		System.out.println("village list: in dao"+villageList);
		for(Village village:villageList)
		{
			int villageId=village.getGramVillage().getId();
			/*int villageId=village.getvId();*/
			System.out.println("village id"+villageId);
			talati=appointmentdao.getAllTalatiDetails(villageId);
			talatiList.add(talati);
			
		}
		System.out.println(talatiList);
		return talatiList;
		
	}

}
