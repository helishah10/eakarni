package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.DAO.JaminMehsulDao;
import com.zensoftech.eakarni.entities.JaminMehsulVeraVasulat;

public class TalatiJaminMehsulManagerImpl implements TalatiJaminMehsulManager {
	
   JaminMehsulDao jamindao;
	
	
	public TalatiJaminMehsulManagerImpl(JaminMehsulDao jamindao) {
		this.jamindao=jamindao;
	}
	
	public JaminMehsulVeraVasulat addEntry(JaminMehsulVeraVasulat jamin,int villageId)
	{
		
		jamin=jamindao.insert(villageId, jamin);
		return jamin;
	}
	
	public JaminMehsulVeraVasulat getJaminMehsulVeraVasulatDetailsByMonth(int villageId,YearMonth yearmonth)
	{
		JaminMehsulVeraVasulat jamin=new JaminMehsulVeraVasulat();
		jamin=jamindao.getDetails(yearmonth, villageId);
		return jamin;
		
	}
	
	public JaminMehsulVeraVasulat updateJaminMehsulVeraVasulat(JaminMehsulVeraVasulat jamin,int villageId,YearMonth yearmonth)
	{
		
		jamin=jamindao.update(jamin, villageId,yearmonth);
		return jamin;
	}

}
