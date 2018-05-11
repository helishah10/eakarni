package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.DAO.GpperaDao;
import com.zensoftech.eakarni.entities.GPauditpera;

public class ViewGpperaDetailsManagerImpl implements ViewGpperaDetailsManager {

	GpperaDao peradao;
	
	public ViewGpperaDetailsManagerImpl(GpperaDao peradao2) {
		this.peradao=peradao2;
	
	}
	
	
	public  Map<Integer,GPauditpera> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth)
	{
		Map<Integer,GPauditpera> peraMap;
		peraMap=peradao.getAllDetailsByTalukaId(talukaId,yearmonth);
		
		return peraMap;
		
	}
	public  Map<Integer,GPauditpera> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth)
	{
		Map<Integer,GPauditpera> peraMap;
		peraMap=peradao.getAllDetailsByDistrictId(districtId,yearmonth);
		
		return peraMap;
	}
	
	public  Map<Integer,GPauditpera> getAllDetailsByVillageId(int villageId,YearMonth yearmonth)
	{
		Map<Integer,GPauditpera> peraMap;
		peraMap=peradao.getAllDetailsByVillageId(villageId,yearmonth);
		System.out.println("pera map in service:"+peraMap);
		return peraMap;
	}

}
