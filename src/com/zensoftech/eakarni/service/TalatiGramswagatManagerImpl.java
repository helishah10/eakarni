package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.DAO.GramswagatDao;
import com.zensoftech.eakarni.entities.Cdp;
import com.zensoftech.eakarni.entities.Gramswagat;

public class TalatiGramswagatManagerImpl implements TalatiGramswagatManager {
	
	GramswagatDao gramdao;
	public TalatiGramswagatManagerImpl(GramswagatDao gramdao) {
		this.gramdao=gramdao;
	}
	
	public Gramswagat addEntry(Gramswagat gram,int villageId)
	{
		
		gram=gramdao.insert(villageId, gram);
		return gram;
	}
	
	public Gramswagat getGramswagatDetailsByMonth(int villageId,YearMonth yearmonth)
	{
		Gramswagat gram=new Gramswagat();
		gram=gramdao.getDetails( yearmonth,villageId);
		return gram;
	}
	
	public Gramswagat updateGramswagat(Gramswagat gram,int villageId,YearMonth yearmonth)
	{
		
		gram=gramdao.update(gram, villageId,yearmonth);
		
		return gram;
	}

}
