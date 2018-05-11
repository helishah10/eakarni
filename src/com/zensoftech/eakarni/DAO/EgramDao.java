package com.zensoftech.eakarni.DAO;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.entities.Egram;

public interface EgramDao
{
	public Map<Integer,Egram> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth);
	public  Map<Integer,Egram> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth);
	public Map<Integer,Egram> getAllDetailsByVillageId(int villageId,YearMonth yearmonth);
	public Egram insert(int villageId,Egram egram);
	public Egram getDetails(YearMonth yearmonth,int villageId);
	public Egram update(Egram egram,int villageId,YearMonth yearmonth);
	public int getTotalCountByTalukaId(int talukaId);
	public int getTotalCountByDistrictId(int districtId);

}
