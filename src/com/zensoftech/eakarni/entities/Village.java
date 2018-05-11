package com.zensoftech.eakarni.entities;

public class Village {
	private int id=0;
	private int vId=0;
	/*private int gramVid;*/
	Village gramVillage=this;
	public Village getGramVillage() {
		return gramVillage;
	}
	public void setGramVillage(Village gramVillage) {
		this.gramVillage = gramVillage;
	}

	private String name="";
	Taluka taluka;
	
	/*public boolean isgrampanchayat()
	{
		return this==this.getGramVillage();
	}*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getvId() {
		return vId;
	}
	public void setvId(int vId) {
		this.vId = vId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public Taluka getTaluka() {
		return taluka;
	}
	public void setTaluka(Taluka taluka) {
		this.taluka = taluka;
	}
	
	public String toString()
	{
		return "Id: "+ this.getId() + " Taluka Id: " +this.getTaluka().gettId() + 
				" Village Id: " + this.getvId() + 
				" Village Name: " +this.getName() + 
				" GramVillage: " +this.getGramVillage().id;
	}
	/*public int getGramVid() {
		return gramVid;
	}
	public void setGramVid(int gramVid) {
		this.gramVid = gramVid;
	}*/
	
}
