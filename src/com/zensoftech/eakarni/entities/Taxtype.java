package com.zensoftech.eakarni.entities;


public class Taxtype 
{
	private int taxId=0;
	private String taxName="";
	
	public Taxtype()
	{}

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}
	
	public String toString()
	{
		return "tax id:"+this.getTaxId()+"tax name:"+this.getTaxName();
	}

	
}
