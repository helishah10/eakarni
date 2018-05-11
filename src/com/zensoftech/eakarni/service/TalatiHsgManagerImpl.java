package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.DAO.HsgDao;
import com.zensoftech.eakarni.entities.Hsg;

public class TalatiHsgManagerImpl implements TalatiHsgManager {
	
	HsgDao hsgdao;
	
	
	public TalatiHsgManagerImpl(HsgDao hsgdao) {
		this.hsgdao=hsgdao;
	}
	
	public Hsg addEntry(Hsg hsg,int villageId,YearMonth yearmonth)
	{
		
		hsg=hsgdao.insert(villageId, hsg,yearmonth);
		return hsg;
	}
	
	public Hsg getHsgDetailsByMonth(int villageId,YearMonth yearmonth)
	{
		Hsg hsg=new Hsg();
		hsg=hsgdao.getDetails(yearmonth, villageId);
		return hsg;
	}
	
	public Hsg updateHsg(Hsg hsg,int villageId,YearMonth yearmonth)
	{
		
		hsg=hsgdao.update(hsg,villageId,yearmonth);
		return hsg;
	}

	
}