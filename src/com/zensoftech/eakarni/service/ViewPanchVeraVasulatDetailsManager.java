package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.entities.PanchVeraVasulat;

public interface ViewPanchVeraVasulatDetailsManager {
	public  Map<Integer,PanchVeraVasulat> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth);
	public  Map<Integer,PanchVeraVasulat> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth);
	public  Map<Integer,PanchVeraVasulat> getAllDetailsByVillageId(int villageId,YearMonth yearmonth);

}
