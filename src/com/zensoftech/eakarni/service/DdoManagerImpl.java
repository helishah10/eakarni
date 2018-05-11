package com.zensoftech.eakarni.service;

import com.zensoftech.eakarni.DAO.StateDao;

public class DdoManagerImpl implements DdoManager {
	
	StateDao statedao;

	public DdoManagerImpl(StateDao statedao2) {
		this.statedao=statedao2;
	
	}

	public int  getTotalTalukasByDistrictId(int districtId)
	{
		int total=statedao.getTotalTalukasByDistrictId(districtId);
		/*System.out.println("total villages:"+total);*/
		return total;
		
	}

	

}
