package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.entities.Cdp;

public interface ViewCdpDetailsManager
{
	public  Map<Integer,Cdp> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth);
	public  Map<Integer,Cdp> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth);
	public  Map<Integer,Cdp> getAllDetailsByVillageId(int villageId,YearMonth yearmonth);
	
	
}
