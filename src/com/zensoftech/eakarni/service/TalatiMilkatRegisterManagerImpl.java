package com.zensoftech.eakarni.service;

import com.zensoftech.eakarni.DAO.OccupantDao;
import com.zensoftech.eakarni.DAO.OwnerDao;
import com.zensoftech.eakarni.DAO.PropertyDao;
import com.zensoftech.eakarni.DAO.PropertyTransferDao;
import com.zensoftech.eakarni.DAO.TaxDao;
import com.zensoftech.eakarni.entities.Occupant;
import com.zensoftech.eakarni.entities.Owner;
import com.zensoftech.eakarni.entities.PropertyMaster;
import com.zensoftech.eakarni.entities.PropertyTransfer;
import com.zensoftech.eakarni.entities.Tax;

public class TalatiMilkatRegisterManagerImpl implements TalatiMilkatRegisterManager{
	
	OwnerDao ownerdao;
	OccupantDao occupantdao;
	PropertyTransferDao transferdao;
	TaxDao taxdao;
	PropertyDao propertymasterdao;
	
	public TalatiMilkatRegisterManagerImpl(OwnerDao ownerdao){
		ownerdao=this.ownerdao;
	}
	
	public TalatiMilkatRegisterManagerImpl(OccupantDao occupantdao){
		occupantdao=this.occupantdao;
	}
	
	public TalatiMilkatRegisterManagerImpl(PropertyTransferDao transferdao){
		transferdao=this.transferdao;
	}
	
	public TalatiMilkatRegisterManagerImpl(PropertyDao propertymasterdao){
		propertymasterdao=this.propertymasterdao;
	}
	
	public TalatiMilkatRegisterManagerImpl(TaxDao taxdao){
		taxdao=this.taxdao;
	}
	
	public Owner insertOwner(int propertyNo,Owner owner){
		owner=ownerdao.insertOwner(propertyNo, owner);
		return owner;
	}
	
	public Occupant insertOccupant(int propertyNo,Occupant occupant){
		occupant=occupantdao.insertOccupant(propertyNo, occupant);
		return occupant;
	}
	
	public PropertyTransfer insertPropertyTransfer(int propertyNo,PropertyTransfer transfer){
		transfer=transferdao.insertTransferEntry(propertyNo, transfer);
		return transfer;
	}
	
	public Tax insertTax(int propertyNo,Tax tax){
		tax=taxdao.insertTax(propertyNo, tax);
		return tax;
	}
	
	public PropertyMaster insertPropertyMaster(int villageId,PropertyMaster property){
		property=propertymasterdao.insert(villageId, property);
		return property;
	}


}
