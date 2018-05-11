package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.entities.GPauditpera;

public interface ViewGpperaDetailsManager {
	
	public  Map<Integer,GPauditpera> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth);
	public  Map<Integer,GPauditpera> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth);
	public  Map<Integer,GPauditpera> getAllDetailsByVillageId(int villageId,YearMonth yearmonth);

}
