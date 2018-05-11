package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.entities.Iay;

public interface TalatiIayManager {
	
	public Iay addEntry(Iay iay,int villageId);
	public Iay getIayDetailsByMonth(int villageId,YearMonth yearmonth);
	public Iay updateIay(Iay iay,int villageId,YearMonth yearmonth);
	

}
