package com.zensoftech.eakarni.service;

import com.zensoftech.eakarni.entities.Occupant;
import com.zensoftech.eakarni.entities.Owner;
import com.zensoftech.eakarni.entities.PropertyMaster;
import com.zensoftech.eakarni.entities.PropertyTransfer;
import com.zensoftech.eakarni.entities.Tax;

public interface TalatiMilkatRegisterManager {
	
	public Owner insertOwner(int propertyNo,Owner owner);
	public Occupant insertOccupant(int propertyNo,Occupant occupant);
	public PropertyTransfer insertPropertyTransfer(int propertyNo,PropertyTransfer transfer);
	public Tax insertTax(int propertyNo,Tax tax);
	public PropertyMaster insertPropertyMaster(int villageId,PropertyMaster property);
	
	

}
