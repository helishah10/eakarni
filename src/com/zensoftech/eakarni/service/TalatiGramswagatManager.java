package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.entities.Gramswagat;;

public interface TalatiGramswagatManager {
	public Gramswagat addEntry(Gramswagat gram,int villageId);
	public Gramswagat getGramswagatDetailsByMonth(int villageId,YearMonth yearmonth);
	public Gramswagat updateGramswagat(Gramswagat gram,int villageId,YearMonth yearmonth);

}
