package com.zensoftech.eakarni.DAO;
import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.entities.PanchVeraVasulat;

public interface PanchVeraDao
{
	public Map<Integer,PanchVeraVasulat> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth);
	public  Map<Integer,PanchVeraVasulat> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth);
	public Map<Integer,PanchVeraVasulat> getAllDetailsByVillageId(int villageId,YearMonth yearmonth);
	public PanchVeraVasulat insert(int villageId,PanchVeraVasulat panchvera,String taxname);
	public PanchVeraVasulat getDetails(YearMonth yearmonth,int villageId);
	public PanchVeraVasulat update(PanchVeraVasulat panchvera,int villageId, YearMonth yearmonth,String taxName);
	public int getTotalCountByTalukaId(int talukaId);
	public int getTotalCountByDistrictId(int districtId);
	
}