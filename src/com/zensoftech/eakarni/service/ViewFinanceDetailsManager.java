package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.entities.Finance14;

public interface ViewFinanceDetailsManager {
	public  Map<Integer,Finance14> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth);
	public  Map<Integer,Finance14> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth);
	public  Map<Integer,Finance14> getAllDetailsByVillageId(int villageId,YearMonth yearmonth);

}
