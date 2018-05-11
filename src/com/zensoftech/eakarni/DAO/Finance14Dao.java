package com.zensoftech.eakarni.DAO;
import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.entities.Finance14;

public interface Finance14Dao
{
	public Map<Integer,Finance14> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth);
	public  Map<Integer,Finance14> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth);
	public Map<Integer,Finance14> getAllDetailsByVillageId(int villageId,YearMonth yearmonth);
	public Finance14 insert(int villageId,Finance14 finance);
	public Finance14 getDetails(YearMonth yearmonth,int villageId);
	public Finance14 update(Finance14 finance14,int villageId,YearMonth yearmonth);
	public int getTotalCountByTalukaId(int talukaId);
	public int getTotalCountByDistrictId(int districtId);
	
}
