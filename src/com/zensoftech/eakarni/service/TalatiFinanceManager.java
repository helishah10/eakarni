package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.entities.Finance14;

public interface TalatiFinanceManager {
	
	public Finance14 addEntry( Finance14 finance,int villageId);
	public  Finance14 getFinanceDetailsByMonth(int villageId,YearMonth yearmonth);
	public  Finance14 updateFinance( Finance14 finance,int villageId,YearMonth yearmonth);

}
