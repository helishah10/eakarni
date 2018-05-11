package com.zensoftech.eakarni.DAO;

import java.sql.SQLException;
import java.util.Map;

import com.zensoftech.eakarni.entities.PropertyTransfer;

public interface PropertyTransferDao
{
	public Map<Integer,PropertyTransfer> getAllPropertyTransferDetails() throws ClassNotFoundException, SQLException;
	public PropertyTransfer insertTransferEntry(int propertyNo,PropertyTransfer transfer);
	public void update(int propertyNo,PropertyTransfer trasfer);
	public PropertyTransfer getProperty(int propertyNo);
}
