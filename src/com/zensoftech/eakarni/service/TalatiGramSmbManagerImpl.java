package com.zensoftech.eakarni.service;

import java.time.YearMonth;

import com.zensoftech.eakarni.DAO.SmbDao;
import com.zensoftech.eakarni.entities.SMB;

public class TalatiGramSmbManagerImpl implements TalatiGramSmbManager {
	
	SmbDao smbdao;
	
	
	public TalatiGramSmbManagerImpl(SmbDao smbdao) {
		this.smbdao=smbdao;
	}
	
	public SMB addEntry(SMB smb,int villageId)
	{
		
		smb=smbdao.insert(villageId, smb);
		return smb;
	}
	
	public SMB getSMBDetailsByMonth(int villageId,YearMonth yearmonth)
	{
		SMB smb=new SMB();
		smb=smbdao.getDetails( yearmonth,villageId);
		return smb;
	}
	
	public SMB updateSMB(SMB smb,int villageId,YearMonth yearmonth)
	{
		
		smb=smbdao.update(smb, villageId,yearmonth);
		System.out.println("in service:"+smb);
		return smb;
	}


}
