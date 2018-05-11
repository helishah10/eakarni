package com.zensoftech.eakarni.DAO;
import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.entities.SMB;

public interface SmbDao 
{
	public Map<Integer,SMB> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth);
	public  Map<Integer,SMB> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth);
	public Map<Integer,SMB> getAllDetailsByVillageId(int villageId,YearMonth yearmonth);
	public SMB insert(int villageId,SMB smb);
	public SMB getDetails(YearMonth yearmonth,int villageId);//needs improvement
	public SMB update(SMB smb,int villageId,YearMonth yearmonth);
	public int getTotalCountByTalukaId(int talukaId);
	public int getTotalCountByDistrictId(int districtId);
	

}
