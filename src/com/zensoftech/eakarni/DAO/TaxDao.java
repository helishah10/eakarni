package com.zensoftech.eakarni.DAO;

import java.sql.SQLException;
import java.util.Map;

import com.zensoftech.eakarni.entities.Tax;

public interface TaxDao 
{
	public Map<Integer,Tax> getAllTaxDetails() throws ClassNotFoundException, SQLException;
	public Tax insertTax(int propertyNo,Tax tax);
	public void update(int propertyNo,Tax tax);
	public Tax getProperty(int propertyNo);

}
