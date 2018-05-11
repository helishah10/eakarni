package com.zensoftech.eakarni.entities;

public class PropertyDetails {
	private int id = 0;
	PropertyMaster property;
	Owner owner;
	PropertyTransfer transfer;
	Occupant occupant;
	Tax tax;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PropertyMaster getProperty() {
		return property;
	}

	public void setProperty(PropertyMaster property) {
		this.property = property;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public PropertyTransfer getTransfer() {
		return transfer;
	}

	public void setTransfer(PropertyTransfer transfer) {
		this.transfer = transfer;
	}

	public Occupant getOccupant() {
		return occupant;
	}

	public void setOccupant(Occupant occupant) {
		this.occupant = occupant;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}
	
	public String toString()
	{
		return "owner name:"+this.getOwner().getOwnerName()+"\toccupant name:"+this.getOccupant().getOccupantName()
				+"\tproperty no"+this.getProperty().getPropertyNo()+"\tproperty area:"+this.getProperty().getAreaName()+
				"\t property desc:"+this.getProperty().getDescription()+"\tyear rent:"+this.getTax().getAssessmentOfAnnualRent()+
				"\trent:"+this.getTax().getEstimatedTaxAmount()+"amount left:"+this.getTax().getPreviouslyMentionedSurplusAndDeficitAmount()+
				"\tregisterd pg no:"+this.getProperty().getRegisterPageNo();
	}

}
