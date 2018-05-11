package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.entities.Hsg;

public interface ViewHsgDetailsManager {
	
	public  Map<Integer,Hsg> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth);
	public  Map<Integer,Hsg> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth);
	public  Map<Integer,Hsg> getAllDetailsByVillageId(int villageId,YearMonth yearmonth);

}
