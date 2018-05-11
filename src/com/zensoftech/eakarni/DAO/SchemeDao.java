package com.zensoftech.eakarni.DAO;

import java.util.List;

import com.zensoftech.eakarni.entities.Scheme;

public interface SchemeDao
{
	public Scheme getSchemeById(int schemeid);
	public void addscheme();
	public  List<Scheme> getallschemes();
	

}
