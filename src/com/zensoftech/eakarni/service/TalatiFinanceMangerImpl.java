package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.DAO.Finance14Dao;
import com.zensoftech.eakarni.entities.Finance14;

public class TalatiFinanceMangerImpl implements TalatiFinanceManager {
	
	Finance14Dao financedao;
	public TalatiFinanceMangerImpl(Finance14Dao financedao)
	{
		this.financedao=financedao;
	}
	
	public Finance14 addEntry( Finance14 finance,int villageId)
	{
		
		finance=financedao.insert(villageId, finance);
		return finance;
		
	}
	public  Finance14 getFinanceDetailsByMonth(int villageId,YearMonth yearmonth)
	{
		Finance14 finance=new Finance14();
		finance=financedao.getDetails(yearmonth,villageId);
		return finance;
	}
	public  Finance14 updateFinance( Finance14 finance,int villageId,YearMonth yearmonth)
	{
		finance=financedao.update(finance, villageId, yearmonth);
		return finance;
	}

}
