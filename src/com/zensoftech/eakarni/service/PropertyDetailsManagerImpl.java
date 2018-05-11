package com.zensoftech.eakarni.service;

import java.sql.SQLException;
import java.util.Map;

import com.zensoftech.eakarni.DAO.OccupantDao;
import com.zensoftech.eakarni.DAO.OwnerDao;
import com.zensoftech.eakarni.DAO.PropertyDao;
import com.zensoftech.eakarni.DAO.PropertyDetailsDaoImpl;
import com.zensoftech.eakarni.DAO.PropertyTransferDao;
import com.zensoftech.eakarni.DAO.TaxDao;
import com.zensoftech.eakarni.entities.Occupant;
import com.zensoftech.eakarni.entities.Owner;
import com.zensoftech.eakarni.entities.PropertyDetails;
import com.zensoftech.eakarni.entities.PropertyMaster;
import com.zensoftech.eakarni.entities.PropertyTransfer;
import com.zensoftech.eakarni.entities.Tax;

public class PropertyDetailsManagerImpl {
	
	
	PropertyDetailsDaoImpl propertydetailsdao;
	OwnerDao ownerdao;
	OccupantDao occupantdao;
	PropertyTransferDao transferdao;
	TaxDao taxdao;
	PropertyDao propertymasterdao;
	
	
	public PropertyDetailsManagerImpl(PropertyDetailsDaoImpl propertydetailsdao)
	{
		this.propertydetailsdao=propertydetailsdao;
	}
	
	public PropertyDetailsManagerImpl(OwnerDao ownerdao)
	{
		this.ownerdao=ownerdao;
	}
	public PropertyDetailsManagerImpl(OccupantDao occupantdao)
	{
		this.occupantdao=occupantdao;
	}
	public PropertyDetailsManagerImpl(PropertyTransferDao transferdao)
	{
		this.transferdao=transferdao;
	}
	public PropertyDetailsManagerImpl(TaxDao taxdao)
	{
		this.taxdao=taxdao;
	}
	public PropertyDetailsManagerImpl(PropertyDao propertymasterdao)
	{
		this.propertymasterdao=propertymasterdao;
	}
	
	
	public Map<Integer,PropertyDetails> getAllPropertyDetails(int propertyId) throws ClassNotFoundException, SQLException
	{
		 Map<Integer,PropertyDetails> propertyMap;
		propertyMap=propertydetailsdao.getAllPropertyDetails(propertyId);
		System.out.println(propertyMap);
		return propertyMap;
		
	}
	
	public Owner getAllOwnerDetails(int propertyId) throws ClassNotFoundException, SQLException
	{
		 Owner owner=new Owner();
		 owner=ownerdao.getProperty(propertyId);
		System.out.println(owner);
		return owner;
		
	}
	public Occupant getAllOccupantDetails(int propertyId) throws ClassNotFoundException, SQLException
	{
		 Occupant occupant=new Occupant();
		 occupant=occupantdao.getProperty(propertyId);
		System.out.println(occupant);
		return occupant;
		
	}
	public Tax getAllTaxDetails(int propertyId) throws ClassNotFoundException, SQLException
	{
		Tax tax=new Tax();
		tax=taxdao.getProperty(propertyId);
		System.out.println(tax);
		return tax;
		
	}
	public PropertyTransfer getAllPropertyTransferDetails(int propertyId) throws ClassNotFoundException, SQLException
	{
		PropertyTransfer transfer=new PropertyTransfer();
		transfer=transferdao.getProperty(propertyId);
		System.out.println(transfer);
		return transfer;
		
	}

	public PropertyMaster getProperty(String propertyId) {
		
		PropertyMaster property=new PropertyMaster();
		property=propertymasterdao.getProperty(propertyId);
		System.out.println(property);
		return property;
	

	}
	
	public Owner insertOwner(int propertyNo,Owner owner){
		/*Owner owner1 =new Owner();*/
		owner=ownerdao.insertOwner(propertyNo, owner);
		return owner;
		
		
	}
	
	public Occupant insertOccupant(int propertyNo,Occupant occupant){
		/*Owner owner1 =new Owner();*/
		occupant=occupantdao.insertOccupant(propertyNo, occupant);
		return occupant;
	}
	
	public PropertyDao insertProperty(int propertyNo,PropertyDao propertydao ){
		/*Owner owner1 =new Owner();*/
		propertydao=propertydao.insertProperty(propertyNo, propertydao);
		return propertydao;
	}

}
