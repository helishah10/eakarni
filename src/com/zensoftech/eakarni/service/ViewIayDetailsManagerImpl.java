package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;


import com.zensoftech.eakarni.DAO.IayDao;
import com.zensoftech.eakarni.entities.Iay;

public class ViewIayDetailsManagerImpl implements ViewIayDetailsManager {
	
		IayDao iaydao;
		public ViewIayDetailsManagerImpl(IayDao iaydao) {
			this.iaydao=iaydao;
		
		}
		public  Map<Integer,Iay> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth)
		{
			Map<Integer,Iay> iayMap;
			iayMap=iaydao.getAllDetailsByTalukaId(talukaId,yearmonth);
			return iayMap;
			
		}
		public  Map<Integer,Iay> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth)
		{
			Map<Integer,Iay> iayMap;
			iayMap=iaydao.getAllDetailsByDistrictId(districtId,yearmonth);
			return iayMap;
		}
		
		public  Map<Integer,Iay> getAllDetailsByVillageId(int villageId,YearMonth yearmonth)
		{
			Map<Integer,Iay> iayMap;
			iayMap=iaydao.getAllDetailsByVillageId(villageId,yearmonth);
			return iayMap;
		}

}
