package com.zensoftech.eakarni.entities;

public class Person {
	private String name="";
	private int aadharcard=0;
	private boolean isAadharcardAvailable;
	public boolean isAadharcardAvailable() {
		return isAadharcardAvailable;
	}
	/*public void setAadharcardAvailable(boolean isAadharcardAvailable) {
		this.isAadharcardAvailable = isAadharcardAvailable;
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAadharcard() {
		return aadharcard;
	}
	public void setAadharcard(int aadharcard) {
		this.aadharcard = aadharcard;
	}
	
	/*public Person(String name,int aadharcard)
	{
		this.name=name;
		this.aadharcard=aadharcard;
	}*/
	
	public String toString(){
		return "name:"+this.name+"/taadharcard:"+this.getAadharcard();
	}
	
	
	

}
