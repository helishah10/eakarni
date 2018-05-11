package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.entities.SMB;

public interface TalatiGramSmbManager {
	
	public SMB addEntry(SMB smb,int villageId);
	public SMB getSMBDetailsByMonth(int villageId,YearMonth yearmonth);
	public SMB updateSMB(SMB smb,int villageId,YearMonth yearmonth);

}
