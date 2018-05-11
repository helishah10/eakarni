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

public class TotalEnteriesForDistrictManagerImpl {
	
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
	
	public TotalEnteriesForDistrictManagerImpl(CdpDao cdpdao2)
	{
		this.cdpdao=cdpdao2;
	}
	
	public TotalEnteriesForDistrictManagerImpl(EgramDao egramdao)
	{
		this.egramdao=egramdao;
	}
	
	public TotalEnteriesForDistrictManagerImpl(PanchVeraDao panchveradao)
	{
		this.panchveradao=panchveradao;
	}
	public TotalEnteriesForDistrictManagerImpl(Finance14Dao finance14dao)
	{
		this.finance14dao=finance14dao;
	}
	public TotalEnteriesForDistrictManagerImpl(GpperaDao peradao)
	{
		this.peradao=peradao;
	}
	public TotalEnteriesForDistrictManagerImpl(GramswagatDao gramswagatdao)
	{
		this.gramswagatdao=gramswagatdao;
	}
	public TotalEnteriesForDistrictManagerImpl(HsgDao hsgdao)
	{
		this.hsgdao=hsgdao;
	}
	public TotalEnteriesForDistrictManagerImpl(IayDao iaydao)
	{
		this.iaydao=iaydao;
	}
	public TotalEnteriesForDistrictManagerImpl(JaminMehsulDao jamindao)
	{
		this.jamindao=jamindao;
	}
	public TotalEnteriesForDistrictManagerImpl(SmbDao smbdao)
	{
		this.smbdao=smbdao;
	}
	

	public int getCdpTotalCount(int districtId)
	{
		total=cdpdao.getTotalCountByDistrictId(districtId);
		return total;
	}
	
	public int getEgramTotalCount(int districtId)
	{
		total=egramdao.getTotalCountByDistrictId(districtId);
		return total;
	}
	public int getFinanceTotalCount(int districtId)
	{
		total=finance14dao.getTotalCountByDistrictId(districtId);
		return total;
	}
	public int getGpperaTotalCount(int districtId)
	{
		total=peradao.getTotalCountByDistrictId(districtId);
		return total;
	}
	public int getGramswagatTotalCount(int districtId)
	{
		total=gramswagatdao.getTotalCountByDistrictId(districtId);
		return total;
	}
	public int getHsgTotalCount(int districtId)
	{
		total=hsgdao.getTotalCountByDistrictId(districtId);
		return total;
	}
	public int getIayTotalCount(int districtId)
	{
		total=iaydao.getTotalCountByDistrictId(districtId);
		return total;
	}
	public int getJaminMehsulTotalCount(int districtId)
	{
		total=jamindao.getTotalCountByDistrictId(districtId);
		return total;
	}
	public int getSmbTotalCount(int districtId)
	{
		total=smbdao.getTotalCountByDistrictId(districtId);
		return total;
	}
	
	public int getPanchveraTotalCount(int districtId)
	{
		total=panchveradao.getTotalCountByDistrictId(districtId);
		return total;
	}
	

}
