package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.entities.Gramswagat;

public interface ViewGramswagatDetailsManager {
	
	public  Map<Integer,Gramswagat> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth);
	public  Map<Integer,Gramswagat> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth);
	public  Map<Integer,Gramswagat> getAllDetailsByVillageId(int villageId,YearMonth yearmonth);

}
