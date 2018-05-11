 package com.zensoftech.eakarni.DAO;
import java.time.YearMonth;
import java.util.Map;
import com.zensoftech.eakarni.entities.Cdp;

public interface CdpDao{
	
	public Cdp insert(int villageId,Cdp cdp);//autoincrmented village id
	public Cdp update(Cdp cdp,int villageId,YearMonth yearmonth);//autoincremented villageid
	public  Map<Integer,Cdp> getAllDetailsByTalukaId(int talukaId,YearMonth year);
	public Map<Integer,Cdp> getAllDetailsByVillageId(int villageId,YearMonth year);
	public Map<Integer,Cdp> getAllDetailsByDistrictId(int districtId,YearMonth year);
	public int getTotalCountByTalukaId(int talukaId);
	public int getTotalCountByDistrictId(int districtId);
	
	public Cdp getDetails(YearMonth yearmonth,int villageId);

	
}
