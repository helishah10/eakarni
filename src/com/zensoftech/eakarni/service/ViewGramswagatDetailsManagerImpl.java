package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.DAO.GramswagatDao;
import com.zensoftech.eakarni.entities.Gramswagat;

public class ViewGramswagatDetailsManagerImpl implements ViewGramswagatDetailsManager {
	
	GramswagatDao gramswagatdao;
	
	public ViewGramswagatDetailsManagerImpl(GramswagatDao gramswagatdao2) {
		this.gramswagatdao=gramswagatdao2;
	
	}
	
	
	public  Map<Integer,Gramswagat> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth)
	{
		Map<Integer,Gramswagat> gramswagatMap;
		gramswagatMap=gramswagatdao.getAllDetailsByTalukaId(talukaId,yearmonth);
		
		return gramswagatMap;
		
	}
	public  Map<Integer,Gramswagat> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth)
	{
		Map<Integer,Gramswagat> gramswagatMap;
		gramswagatMap=gramswagatdao.getAllDetailsByDistrictId(districtId,yearmonth);
		
		return gramswagatMap;
	}

	
	public  Map<Integer,Gramswagat> getAllDetailsByVillageId(int villageId,YearMonth yearmonth)
	{
		Map<Integer,Gramswagat> gramswagatMap;
		gramswagatMap=gramswagatdao.getAllDetailsByVillageId(villageId,yearmonth);
		
		return gramswagatMap;
	}

}
