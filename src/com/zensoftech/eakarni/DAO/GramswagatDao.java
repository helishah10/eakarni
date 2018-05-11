

package com.zensoftech.eakarni.DAO;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.entities.Gramswagat;

public interface GramswagatDao 
{
	public Map<Integer,Gramswagat> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth);
	public  Map<Integer,Gramswagat> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth);
	public Map<Integer,Gramswagat> getAllDetailsByVillageId(int villageId,YearMonth yearmonth);
	public Gramswagat insert(int villageId,Gramswagat gramswagat);
	public Gramswagat getDetails(YearMonth yearmonth,int villageId);
	public Gramswagat  update(Gramswagat gramswagat,int villageId,YearMonth yearmonth);
	public int getTotalCountByTalukaId(int talukaId);
	public int getTotalCountByDistrictId(int districtId);



}
