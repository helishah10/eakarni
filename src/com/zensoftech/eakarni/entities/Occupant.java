package com.zensoftech.eakarni.entities;

import java.time.LocalDate;

public class Occupant 
{
	private int id=0;

	private String occupantName=null;
	private LocalDate updatedDate;
	PropertyMaster property;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*public int getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}*/
	public String getOccupantName() {
		return occupantName;
	}
	public void setOccupantName(String occupantName) {
		this.occupantName = occupantName;
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
		return "property id:"+this.getProperty().getPropertyNo()+"occupant name:"+this.getOccupantName()+"update date:"+this.getUpdatedDate()
		;
	}

}
