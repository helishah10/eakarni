package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.entities.PanchVeraVasulat;

public interface TalatiPanchVeraManager {
	
	public PanchVeraVasulat addEntry(PanchVeraVasulat panchvera,int villageId,String taxname);
	public PanchVeraVasulat getPanchVeraVasulatDetailsByMonth(int villageId,YearMonth yearmonth);
	public PanchVeraVasulat updatePanchVeraVasulat(PanchVeraVasulat panchvera,int villageId,YearMonth yearmonth,String taxname);

}
