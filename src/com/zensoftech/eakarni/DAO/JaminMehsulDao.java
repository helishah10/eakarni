package com.zensoftech.eakarni.DAO;
import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.entities.JaminMehsulVeraVasulat;
public interface JaminMehsulDao
{
	
	public Map<Integer,JaminMehsulVeraVasulat> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth);
	public  Map<Integer,JaminMehsulVeraVasulat> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth);
	public Map<Integer,JaminMehsulVeraVasulat> getAllDetailsByVillageId(int villageId,YearMonth yearmonth);
	public  JaminMehsulVeraVasulat insert(int villageId,JaminMehsulVeraVasulat panchvera);
	public JaminMehsulVeraVasulat getDetails(YearMonth yearmonth,int villageId);
	public JaminMehsulVeraVasulat update(JaminMehsulVeraVasulat panchvera,int villageId,YearMonth yearmonth);
	public int getTotalCountByTalukaId(int talukaId);
	public int getTotalCountByDistrictId(int districtId);
}
