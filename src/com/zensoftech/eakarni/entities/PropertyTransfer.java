package com.zensoftech.eakarni.entities;
import java.time.LocalDate;

public class PropertyTransfer 
{
	private int id=0;
	private String ownerName="";
	private LocalDate transferDate;
	private String attachement;
	
	PropertyMaster property;
	public PropertyMaster getProperty() {
		return property;
	}
	public void setProperty(PropertyMaster property) {
		this.property = property;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public LocalDate getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(LocalDate transferDate) {
		this.transferDate = transferDate;
	}
	public String getAttachement() {
		return attachement;
	}
	public void setAttachement(String attachement) {
		this.attachement = attachement;
	}
	
	public String toString(){
		return "property no:"+this.getProperty().getPropertyNo()+"owner name:"+this.getOwnerName()+"transfer date:"+this.getTransferDate()+
		"attachement:"+this.getAttachement();
	}
}
