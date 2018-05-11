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
import com.zensoftech.eakarni.DAO.SmbDao;

public class TotalEnteriesForVillageManagerImpl implements TotalEnteriesForVillageManager{
	
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
	
	
	int total;
	
	public TotalEnteriesForVillageManagerImpl(CdpDao cdpdao2)
	{
		this.cdpdao=cdpdao2;
	}
	
	public TotalEnteriesForVillageManagerImpl(EgramDao egramdao)
	{
		this.egramdao=egramdao;
	}
	
	public TotalEnteriesForVillageManagerImpl(PanchVeraDao panchveradao)
	{
		this.panchveradao=panchveradao;
	}
	public TotalEnteriesForVillageManagerImpl(Finance14Dao finance14dao)
	{
		this.finance14dao=finance14dao;
	}
	public TotalEnteriesForVillageManagerImpl(GpperaDao peradao)
	{
		this.peradao=peradao;
	}
	public TotalEnteriesForVillageManagerImpl(GramswagatDao gramswagatdao)
	{
		this.gramswagatdao=gramswagatdao;
	}
	public TotalEnteriesForVillageManagerImpl(HsgDao hsgdao)
	{
		this.hsgdao=hsgdao;
	}
	public TotalEnteriesForVillageManagerImpl(IayDao iaydao)
	{
		this.iaydao=iaydao;
	}
	public TotalEnteriesForVillageManagerImpl(JaminMehsulDao jamindao)
	{
		this.jamindao=jamindao;
	}
	public TotalEnteriesForVillageManagerImpl(SmbDao smbdao)
	{
		this.smbdao=smbdao;
	}
	

	public int getCdpTotalCount(int villageId)
	{
		int cdptotal=cdpdao.getTotalCountByTalukaId(villageId);
		System.out.println("in manager:"+cdptotal);
		return total;
	}
	
	public int getEgramTotalCount(int villageId)
	{
		total=egramdao.getTotalCountByTalukaId(villageId);
		return total;
	}
	public int getFinanceTotalCount(int villageId)
	{
		total=finance14dao.getTotalCountByTalukaId(villageId);
		return total;
	}
	public int getGpperaTotalCount(int villageId)
	{
		total=peradao.getTotalCountByTalukaId(villageId);
		return total;
	}
	public int getGramswagatTotalCount(int villageId)
	{
		total=gramswagatdao.getTotalCountByTalukaId(villageId);
		return total;
	}
	public int getHsgTotalCount(int villageId)
	{
		total=hsgdao.getTotalCountByTalukaId(villageId);
		return total;
	}
	public int getIayTotalCount(int villageId)
	{
		total=iaydao.getTotalCountByTalukaId(villageId);
		return total;
	}
	public int getJaminMehsulTotalCount(int villageId)
	{
		total=jamindao.getTotalCountByTalukaId(villageId);
		return total;
	}
	public int getSmbTotalCount(int villageId)
	{
		total=smbdao.getTotalCountByTalukaId(villageId);
		return total;
	}
	
	public int getPanchveraTotalCount(int villageId)
	{
		total=panchveradao.getTotalCountByTalukaId(villageId);
		return total;
	}

	

}
