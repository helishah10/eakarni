package com.zensoftech.eakarni.entities;

public class PropertyMaster
{
	private int id=0;
	private String propertyNo=null;
	private String areaName="";
	private boolean split;
	public String parent;
	private String description="";
	private int registrationYear=0;
	private int registerPageNo=0;
	Village village;
	
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public Village getVillage() {
		return village;
	}
	public void setVillage(Village village) {
		this.village = village;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPropertyNo() {
		return propertyNo;
	}
	public void setPropertyNo(String propertyNo) {
		this.propertyNo = propertyNo;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public boolean isSplit() {
		return split;
	}
	public void setSplit(boolean split) {
		this.split = split;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRegistrationYear() {
		return registrationYear;
	}
	public void setRegistrationYear(int registrationYear) {
		this.registrationYear = registrationYear;
	}
	public int getRegisterPageNo() {
		return registerPageNo;
	}
	public void setRegisterPageNo(int registerPageNo) {
		this.registerPageNo = registerPageNo;
	}
	
	public String toString()
	{
		return "village:"+this.getVillage().getvId()+"\tid:"+this.getId()+"\tproperty no:"+this.getPropertyNo()+"\tarea name:"+this.getAreaName()+
				"\tsplit:"+this.isSplit()+"\tdescription:"+this.getDescription()+"\tregisteration year:"+
				this.getRegistrationYear()+"\tregister pg no:"+this.getRegisterPageNo()+
				"\n parent:"+this.getParent();
	}
	

}
