package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.DAO.PanchVeraDao;
import com.zensoftech.eakarni.entities.PanchVeraVasulat;

public class ViewPanchVeraVasulatDetailsManagerImpl {
	
		PanchVeraDao panchveradao;
		
		public ViewPanchVeraVasulatDetailsManagerImpl(PanchVeraDao panchveradao) {
			this.panchveradao=panchveradao;
		
		}
		public  Map<Integer,PanchVeraVasulat> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth)
		{
			Map<Integer,PanchVeraVasulat> panchveraMap;
			panchveraMap=panchveradao.getAllDetailsByTalukaId(talukaId,yearmonth);
			return panchveraMap;
			
		}
		public  Map<Integer,PanchVeraVasulat> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth)
		{
			Map<Integer,PanchVeraVasulat> panchveraMap;
			panchveraMap=panchveradao.getAllDetailsByDistrictId(districtId,yearmonth);
			System.out.println("in manager:"+panchveraMap);
			return panchveraMap;
		}
		
		public  Map<Integer,PanchVeraVasulat> getAllDetailsByVillageId(int villageId,YearMonth yearmonth)
		{
			Map<Integer,PanchVeraVasulat> panchveraMap;
			panchveraMap=panchveradao.getAllDetailsByVillageId(villageId,yearmonth);
			System.out.println("in manager:"+panchveraMap);
			return panchveraMap;
		}

}
