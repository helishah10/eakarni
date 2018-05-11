package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.DAO.GpperaDao;
import com.zensoftech.eakarni.entities.GPauditpera;

public class TalatiGramAuditManagerImpl implements TalatiGramAuditManager {
	
	GpperaDao peradao;
	
	
	public TalatiGramAuditManagerImpl(GpperaDao peradao) {
		this.peradao=peradao;
	}
	
	public GPauditpera addEntry(GPauditpera pera,int villageId)
	{
		
		pera=peradao.insert(villageId, pera);
		return pera;
	}
	
	public GPauditpera getGPauditperaDetailsByMonth(int villageId,YearMonth yearmonth)
	{
		GPauditpera pera=new GPauditpera();
		pera=peradao.getDetails(yearmonth, villageId);
		return pera;
	}
	
	public GPauditpera updateGPauditpera(GPauditpera pera,int villageId,YearMonth yearmonth)
	{
		
		pera=peradao.update(pera, villageId,yearmonth);
		return pera;
	}


}
