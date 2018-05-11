package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.DAO.CdpDao;
import com.zensoftech.eakarni.DAO.CdpDaoImpl;
import com.zensoftech.eakarni.DAO.UserDao;
import com.zensoftech.eakarni.entities.Cdp;

public class ViewCdpDetailsManagerImpl implements ViewCdpDetailsManager
{
    CdpDao cdpdao;
	
	public ViewCdpDetailsManagerImpl(CdpDao cdpdao2) {
		this.cdpdao=cdpdao2;
	
	}
	public  Map<Integer,Cdp> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth)
	{
		Map<Integer,Cdp> cdpMap;
		cdpMap=cdpdao.getAllDetailsByTalukaId(talukaId,yearmonth);
		return cdpMap;
		
	}
	public  Map<Integer,Cdp> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth)
	{
		Map<Integer,Cdp> cdpMap;
		cdpMap=cdpdao.getAllDetailsByDistrictId(districtId,yearmonth);
		return cdpMap;
	}
	
	public  Map<Integer,Cdp> getAllDetailsByVillageId(int villageId,YearMonth yearmonth)
	{
		Map<Integer,Cdp> cdpMap;
		cdpMap=cdpdao.getAllDetailsByVillageId(villageId, yearmonth);
		return cdpMap;
	}
}
