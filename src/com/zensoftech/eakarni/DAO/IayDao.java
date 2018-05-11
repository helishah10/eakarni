package com.zensoftech.eakarni.DAO;
import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.entities.Iay;

public interface IayDao
{
	public Map<Integer,Iay> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth);
	public  Map<Integer,Iay> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth);
	public Map<Integer,Iay> getAllDetailsByVillageId(int villageId,YearMonth yearmonth);
	public Iay insert(int villageId,Iay iay);
	public Iay getDetails(YearMonth yearmonth,int villageId);
	public Iay update(Iay iay,int villageId,YearMonth yearmonth);
	public int getTotalCountByTalukaId(int talukaId);
	public int getTotalCountByDistrictId(int districtId);

}
