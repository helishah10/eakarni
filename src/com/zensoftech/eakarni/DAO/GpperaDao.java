package com.zensoftech.eakarni.DAO;
import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.entities.GPauditpera;

public interface GpperaDao
{
	public Map<Integer,GPauditpera> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth);
	public  Map<Integer,GPauditpera> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth);
	public Map<Integer,GPauditpera> getAllDetailsByVillageId(int villageId,YearMonth yearmonth);
	public GPauditpera insert(int villageId,GPauditpera pera);
	public GPauditpera getDetails(YearMonth yearmonth,int villageId);
	public  GPauditpera update(GPauditpera pera,int villageId,YearMonth yearmonth);
	public int getTotalCountByTalukaId(int talukaId);
	public int getTotalCountByDistrictId(int districtId);
}
