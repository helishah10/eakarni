package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.DAO.JaminMehsulDao;
import com.zensoftech.eakarni.entities.JaminMehsulVeraVasulat;

public class ViewJaminMehsulDetailsManagerImpl {
		
	JaminMehsulDao jamindao;
	public ViewJaminMehsulDetailsManagerImpl(JaminMehsulDao jamindao2) {
		this.jamindao=jamindao2;
	
	}
	public  Map<Integer,JaminMehsulVeraVasulat> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth)
	{
		Map<Integer,JaminMehsulVeraVasulat> jaminMap;
		jaminMap=jamindao.getAllDetailsByTalukaId(talukaId,yearmonth);
		return jaminMap;
		
	}
	public  Map<Integer,JaminMehsulVeraVasulat> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth)
	{
		Map<Integer,JaminMehsulVeraVasulat> jaminMap;
		jaminMap=jamindao.getAllDetailsByDistrictId(districtId,yearmonth);
		return jaminMap;
		
	}
	
	public  Map<Integer,JaminMehsulVeraVasulat> getAllDetailsByVillageId(int villageId,YearMonth yearmonth)
	{
		Map<Integer,JaminMehsulVeraVasulat> jaminMap;
		jaminMap=jamindao.getAllDetailsByVillageId(villageId,yearmonth);
		return jaminMap;
		
	}

}
