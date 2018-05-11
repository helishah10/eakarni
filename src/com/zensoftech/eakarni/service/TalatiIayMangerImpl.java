package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.DAO.IayDao;
import com.zensoftech.eakarni.entities.Iay;

public class TalatiIayMangerImpl implements TalatiIayManager {
	
	
IayDao iaydao;
	
	
	public TalatiIayMangerImpl(IayDao iaydao) {
		this.iaydao=iaydao;
	}


	
	public Iay addEntry(Iay iay, int villageId) {
		iay=iaydao.insert(villageId, iay);
		return iay;
	}

	public Iay getIayDetailsByMonth(int villageId,YearMonth yearmonth)
	{
		Iay iay=new Iay();
		iay=iaydao.getDetails(yearmonth, villageId);
		return iay;
	}
	
	public Iay updateIay(Iay iay,int villageId,YearMonth yearmonth)
	{
		
		iay=iaydao.update(iay, villageId,yearmonth);
		return iay;
	}
	
	
	
	
	
}
