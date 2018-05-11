package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.DAO.CdpDao;
import com.zensoftech.eakarni.DAO.HsgDao;
import com.zensoftech.eakarni.entities.Cdp;
import com.zensoftech.eakarni.entities.Hsg;

public class ViewHsgDetailsManagerImpl implements ViewHsgDetailsManager {
	
	 HsgDao hsgdao;
		
		public ViewHsgDetailsManagerImpl(HsgDao hsgdao) {
			this.hsgdao=hsgdao;
		
		}
		Map<Integer,Hsg> hsgMap;
		public  Map<Integer,Hsg> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth)
		{
			
			hsgMap=hsgdao.getAllDetailsByTalukaId(talukaId,yearmonth);
			return hsgMap;
			
		}
		public  Map<Integer,Hsg> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth)
		{
			
			hsgMap=hsgdao.getAllDetailsByDistrictId(districtId,yearmonth);
			return hsgMap;
		}
		
		public  Map<Integer,Hsg> getAllDetailsByVillageId(int villageId,YearMonth yearmonth)
		{
			
			hsgMap=hsgdao.getAllDetailsByVillageId(villageId,yearmonth);
			return hsgMap;
		}

}
