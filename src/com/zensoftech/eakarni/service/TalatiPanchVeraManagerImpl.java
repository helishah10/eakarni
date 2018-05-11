package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.DAO.PanchVeraDao;
import com.zensoftech.eakarni.entities.PanchVeraVasulat;

public class TalatiPanchVeraManagerImpl implements TalatiPanchVeraManager {
	
PanchVeraDao panchveradao;

	
	
	public TalatiPanchVeraManagerImpl(PanchVeraDao panchveradao) {
		this.panchveradao=panchveradao;
	}
	
	public PanchVeraVasulat addEntry(PanchVeraVasulat panchvera,int villageId,String taxname) {
		panchvera=panchveradao.insert(villageId, panchvera,taxname);
		return panchvera;
	}

	@Override
	public PanchVeraVasulat getPanchVeraVasulatDetailsByMonth(int villageId,YearMonth yearmonth) {
		PanchVeraVasulat panchvera=new PanchVeraVasulat();
		panchvera=panchveradao.getDetails(yearmonth, villageId);
		return panchvera;
	}

	@Override
	public PanchVeraVasulat updatePanchVeraVasulat(PanchVeraVasulat panchvera, int villageId,YearMonth yearmonth,String taxname) {
		panchvera=panchveradao.update(panchvera, villageId,yearmonth,taxname);
		return panchvera;
	}

}
