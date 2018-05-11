package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.entities.Egram;


public interface ViewEgramDetailsManager {
	
	public  Map<Integer,Egram> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth);
	public  Map<Integer,Egram> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth);
	public  Map<Integer,Egram> getAllDetailsByVillageId(int villageId,YearMonth yearmonth);


}
