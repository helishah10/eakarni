package com.zensoftech.eakarni.service;

import com.zensoftech.eakarni.DAO.CdpDao;
import com.zensoftech.eakarni.DAO.EgramDao;
import com.zensoftech.eakarni.DAO.Finance14Dao;
import com.zensoftech.eakarni.DAO.GpperaDao;
import com.zensoftech.eakarni.DAO.GramswagatDao;
import com.zensoftech.eakarni.DAO.HsgDao;
import com.zensoftech.eakarni.DAO.IayDao;
import com.zensoftech.eakarni.DAO.JaminMehsulDao;
import com.zensoftech.eakarni.DAO.PanchVeraDao;
import com.zensoftech.eakarni.DAO.PropertyDao;
import com.zensoftech.eakarni.DAO.SmbDao;

public class TotalEnteriesForTalukaManagerImpl implements TotalEnteriesForTalukaManager{
	
	CdpDao cdpdao;
	EgramDao egramdao;
	Finance14Dao finance14dao;
	GpperaDao peradao;
	GramswagatDao gramswagatdao;
	HsgDao hsgdao;
	IayDao iaydao;
	JaminMehsulDao jamindao;
	SmbDao smbdao;
	PanchVeraDao panchveradao;
	PropertyDao propertydao;
	
	
	int total;
	
	public TotalEnteriesForTalukaManagerImpl(CdpDao cdpdao2)
	{
		this.cdpdao=cdpdao2;
	}
	
	public TotalEnteriesForTalukaManagerImpl(EgramDao egramdao)
	{
		this.egramdao=egramdao;
	}
	
	public TotalEnteriesForTalukaManagerImpl(PanchVeraDao panchveradao)
	{
		this.panchveradao=panchveradao;
	}
	public TotalEnteriesForTalukaManagerImpl(Finance14Dao finance14dao)
	{
		this.finance14dao=finance14dao;
	}
	public TotalEnteriesForTalukaManagerImpl(GpperaDao peradao)
	{
		this.peradao=peradao;
	}
	public TotalEnteriesForTalukaManagerImpl(GramswagatDao gramswagatdao)
	{
		this.gramswagatdao=gramswagatdao;
	}
	public TotalEnteriesForTalukaManagerImpl(HsgDao hsgdao)
	{
		this.hsgdao=hsgdao;
	}
	public TotalEnteriesForTalukaManagerImpl(IayDao iaydao)
	{
		this.iaydao=iaydao;
	}
	public TotalEnteriesForTalukaManagerImpl(JaminMehsulDao jamindao)
	{
		this.jamindao=jamindao;
	}
	public TotalEnteriesForTalukaManagerImpl(SmbDao smbdao)
	{
		this.smbdao=smbdao;
	}
	
	public TotalEnteriesForTalukaManagerImpl(PropertyDao propertydao)
	{
		this.propertydao=propertydao;
	}
	
	

	public int getCdpTotalCount(int talukaId)
	{
		total=cdpdao.getTotalCountByTalukaId(talukaId);
		return total;
	}
	
	public int getEgramTotalCount(int talukaId)
	{
		total=egramdao.getTotalCountByTalukaId(talukaId);
		return total;
	}
	public int getFinanceTotalCount(int talukaId)
	{
		total=finance14dao.getTotalCountByTalukaId(talukaId);
		return total;
	}
	public int getGpperaTotalCount(int talukaId)
	{
		total=peradao.getTotalCountByTalukaId(talukaId);
		return total;
	}
	public int getGramswagatTotalCount(int talukaId)
	{
		total=gramswagatdao.getTotalCountByTalukaId(talukaId);
		return total;
	}
	public int getHsgTotalCount(int talukaId)
	{
		total=hsgdao.getTotalCountByTalukaId(talukaId);
		return total;
	}
	public int getIayTotalCount(int talukaId)
	{
		total=iaydao.getTotalCountByTalukaId(talukaId);
		return total;
	}
	public int getJaminMehsulTotalCount(int talukaId)
	{
		total=jamindao.getTotalCountByTalukaId(talukaId);
		return total;
	}
	public int getSmbTotalCount(int talukaId)
	{
		total=smbdao.getTotalCountByTalukaId(talukaId);
		return total;
	}
	
	public int getPanchveraTotalCount(int talukaId)
	{
		total=panchveradao.getTotalCountByTalukaId(talukaId);
		return total;
	}
	public int getPropertyTotal(int talukaId){
		total=propertydao.getTotalCountByTalukaId(talukaId);
		return total;
		
	}

}
