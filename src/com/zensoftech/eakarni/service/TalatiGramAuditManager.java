package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.entities.GPauditpera;

public interface TalatiGramAuditManager {

	public GPauditpera addEntry(GPauditpera pera,int villageId);
	public GPauditpera getGPauditperaDetailsByMonth(int villageId,YearMonth yearmonth);
	public GPauditpera updateGPauditpera(GPauditpera pera,int villageId,YearMonth yearmonth);
}
