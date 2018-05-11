package com.zensoftech.eakarni.service;

import com.zensoftech.eakarni.DAO.StateDao;

public class TdoManagerImpl implements TdoManager {
	
	StateDao statedao;

	public TdoManagerImpl(StateDao statedao2) {
		this.statedao=statedao2;
	
	}

	public int  getTotalVillagesByTalukaId(int talukaId)
	{
		int total=statedao.getTotalVillagesByTalukaId(talukaId);
		/*System.out.println("total villages:"+total);*/
		return total;
		
	}
	

}
