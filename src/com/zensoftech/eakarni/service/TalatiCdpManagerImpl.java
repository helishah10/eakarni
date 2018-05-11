package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.DAO.CdpDao;
import com.zensoftech.eakarni.entities.Cdp;

public class TalatiCdpManagerImpl implements TalatiCdpManager {
	
	CdpDao cdpdao;
	
	
	public TalatiCdpManagerImpl(CdpDao cdpdao) {
		this.cdpdao=cdpdao;
	}
	
	public Cdp addEntry(Cdp cdp,int villageId)
	{
		
		cdp=cdpdao.insert(villageId, cdp);
		return cdp;
	}
	
	public Cdp getCdpDetailsByMonth(int villageId,YearMonth yearmonth)
	{
		Cdp cdp=new Cdp();
		cdp=cdpdao.getDetails( yearmonth,villageId);
		return cdp;
	}
	
	public Cdp updateCdp(Cdp cdp,int villageId,YearMonth yearmonth)
	{
		
		cdp=cdpdao.update(cdp, villageId,yearmonth);
		return cdp;
	}

}
