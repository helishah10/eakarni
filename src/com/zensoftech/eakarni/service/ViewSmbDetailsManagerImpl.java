package com.zensoftech.eakarni.service;

import java.time.YearMonth;
import java.util.Map;

import com.zensoftech.eakarni.DAO.SmbDao;
import com.zensoftech.eakarni.entities.SMB;

public class ViewSmbDetailsManagerImpl implements ViewSmbDetailsManager {
	
	 SmbDao smbdao;
	
		public ViewSmbDetailsManagerImpl(SmbDao smbdao2) {
			this.smbdao=smbdao2;
		
		}
		public  Map<Integer,SMB> getAllDetailsByTalukaId(int talukaId,YearMonth yearmonth)
		{
			Map<Integer,SMB> smbMap;
			smbMap=smbdao.getAllDetailsByTalukaId(talukaId,yearmonth);
			return smbMap;
			
		}
		public  Map<Integer,SMB> getAllDetailsByDistrictId(int districtId,YearMonth yearmonth)
		{
			Map<Integer,SMB> smbMap;
			smbMap=smbdao.getAllDetailsByDistrictId(districtId,yearmonth);
			return smbMap;
		}
		@Override
		public Map<Integer, SMB> getAllDetailsByVillageId(int villageId,YearMonth yearmonth) {
			Map<Integer,SMB> smbMap;
			smbMap=smbdao.getAllDetailsByVillageId(villageId,yearmonth);
			return smbMap;
		}
	

}
