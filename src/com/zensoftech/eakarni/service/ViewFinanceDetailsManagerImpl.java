package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.DAO.Finance14Dao;
import com.zensoftech.eakarni.entities.Finance14;

public class ViewFinanceDetailsManagerImpl implements ViewFinanceDetailsManager {
	
	Finance14Dao financedao;
	
	public ViewFinanceDetailsManagerImpl(Finance14Dao financedao2) {
		this.financedao=financedao2;
	
	}
	
	public  Map<Integer, Finance14> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth)
	{
		Map<Integer,Finance14> financeMap;
		financeMap=financedao.getAllDetailsByTalukaId(talukaId,yearmonth);
		System.out.println("in manager class:"+financeMap);
		return financeMap;
		
	}
	public  Map<Integer, Finance14> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth)
	{
		Map<Integer,Finance14> financeMap;
		financeMap=financedao.getAllDetailsByDistrictId(districtId,yearmonth);
		System.out.println("in manager class:"+financeMap);
		return financeMap;
		
	}
	
	public  Map<Integer, Finance14> getAllDetailsByVillageId(int villageId,YearMonth yearmonth)
	{
		Map<Integer,Finance14> financeMap;
		financeMap=financedao.getAllDetailsByVillageId(villageId,yearmonth);
		System.out.println("in manager class:"+financeMap);
		return financeMap;
		
	}

}
