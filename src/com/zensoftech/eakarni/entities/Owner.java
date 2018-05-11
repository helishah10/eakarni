package com.zensoftech.eakarni.entities;

import java.time.LocalDate;

public class Owner 
{
	private int id=0;
	private String ownerName="";
	private LocalDate updatedDate;
	PropertyMaster property;
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
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	public PropertyMaster getProperty() {
		return property;
	}
	public void setProperty(PropertyMaster property) {
		this.property = property;
	}
	
	public String toString()
	{
		return "owner name:"+this.getOwnerName()+"update date:"+this.getUpdatedDate()+"property no:"+this.property.getPropertyNo();
	}

}
