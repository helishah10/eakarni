package com.zensoftech.eakarni.DAO;
import java.util.Map;

import com.zensoftech.eakarni.entities.Tax;
import com.zensoftech.eakarni.entities.Taxtype;

public interface TaxtypeDao 
{

	public  Map<Integer,Taxtype> getAllDetails();
	public Taxtype getTaxDetail(int taxId);
	public void update(int taxId);
}
