package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.entities.Hsg;;

public interface TalatiHsgManager {
	
	public Hsg addEntry(Hsg hsg,int villageId,YearMonth yearmonth);
	public Hsg getHsgDetailsByMonth(int villageId,YearMonth yearmonth);
	public Hsg updateHsg(Hsg hsg,int villageId,YearMonth yearmonth);

}
