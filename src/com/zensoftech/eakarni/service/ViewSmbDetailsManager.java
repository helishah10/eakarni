package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.entities.SMB;

public interface ViewSmbDetailsManager {
	
	public  Map<Integer,SMB> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth);
	public  Map<Integer,SMB> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth);
	public  Map<Integer,SMB> getAllDetailsByVillageId(int villageId,YearMonth yearmonth);

}
