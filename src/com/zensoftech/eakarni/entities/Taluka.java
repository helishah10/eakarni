package com.zensoftech.eakarni.entities;

public class Taluka {
	private int id=0;
	private int tId=0;
	private String name;
	District district;
	
	public Taluka()
	{}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public String toString()
	{
		return "Id: " + this.id +" did : " +this.getDistrict().getDId() + " Taluka Id: "+ this.tId+  " Name:" + this.name ;
	}
	
}

	