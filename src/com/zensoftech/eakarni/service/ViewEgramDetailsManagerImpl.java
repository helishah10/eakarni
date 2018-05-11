package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.DAO.EgramDao;
import com.zensoftech.eakarni.entities.Egram;

public class ViewEgramDetailsManagerImpl implements ViewEgramDetailsManager {
		EgramDao egramdao;
		
		public ViewEgramDetailsManagerImpl(EgramDao egramdao2) {
			this.egramdao=egramdao2;
		
		}
		
		public  Map<Integer,Egram> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth)
		{
			Map<Integer,Egram> egramMap;
			egramMap=egramdao.getAllDetailsByTalukaId(talukaId,yearmonth);
			System.out.println("in manager class:"+egramMap);
			return egramMap;
			
		}
		public  Map<Integer,Egram> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth)
		{
			Map<Integer,Egram> egramMap;
			egramMap=egramdao.getAllDetailsByDistrictId(districtId,yearmonth);
			return egramMap;
		}

		
		public  Map<Integer,Egram> getAllDetailsByVillageId(int villageId,YearMonth yearmonth)
		{
			Map<Integer,Egram> egramMap;
			egramMap=egramdao.getAllDetailsByVillageId(villageId,yearmonth);
			return egramMap;
		}

}
