package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.entities.Iay;

public interface ViewIayDetailsManager {
	
	public  Map<Integer,Iay> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth);
	public  Map<Integer,Iay> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth);
	public  Map<Integer,Iay> getAllDetailsByVillageId(int villageId,YearMonth yearmonth);
}
