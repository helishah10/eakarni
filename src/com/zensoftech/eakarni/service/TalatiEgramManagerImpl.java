package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.DAO.EgramDao;
import com.zensoftech.eakarni.entities.Egram;

public class TalatiEgramManagerImpl implements TalatiEgramManager{
	
EgramDao egramdao;
	
	
	public TalatiEgramManagerImpl(EgramDao egramdao) {
		this.egramdao=egramdao;
	}
	
	public Egram addEntry(Egram egram,int villageId)
	{
		
		egram=egramdao.insert(villageId, egram);
		return egram;
	}
	
	public Egram getEgramDetailsByMonth(int villageId,YearMonth yearmonth)
	{
		Egram egram=new Egram();
		egram=egramdao.getDetails(yearmonth, villageId);
		return egram;
	}
	
	public Egram updateEgram(Egram egram,int villageId,YearMonth yearmonth)
	{
		
		egram=egramdao.update(egram, villageId,yearmonth);
		return egram;
	}

	
}
