package com.zensoftech.eakarni.DAO;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.entities.Hsg;
public interface HsgDao
{
	public Map<Integer,Hsg> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth);
	public  Map<Integer,Hsg> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth);
	public Map<Integer,Hsg> getAllDetailsByVillageId(int villageId,YearMonth yearmonth);
	public Hsg insert(int villageId,Hsg hsg,YearMonth yearmonth);
	public Hsg getDetails(YearMonth yearmonth,int villageId);

	public int getTotalCountByTalukaId(int talukaId);
	public int getTotalCountByDistrictId(int districtId);
	public Hsg update(Hsg hsg,int villageId,YearMonth yearmonth);

}
