package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.entities.JaminMehsulVeraVasulat;

public interface ViewJaminMehsulDetailsManager {
	
	public  Map<Integer,JaminMehsulVeraVasulat> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth);
	public  Map<Integer,JaminMehsulVeraVasulat> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth);
	public  Map<Integer,JaminMehsulVeraVasulat> getAllDetailsByVillageId(int villageId,YearMonth yearmonth);

}
