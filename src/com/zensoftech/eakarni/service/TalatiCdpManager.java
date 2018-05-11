package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.entities.Cdp;

public interface TalatiCdpManager{
	
	public Cdp addEntry(Cdp cdp,int villageId);
	public Cdp getCdpDetailsByMonth(int villageId,YearMonth yearmonth);
	public Cdp updateCdp(Cdp cdp,int villageId,YearMonth yearmonth);
	
	

}
