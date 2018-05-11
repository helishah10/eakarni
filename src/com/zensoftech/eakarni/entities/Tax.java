package com.zensoftech.eakarni.entities;

import java.time.LocalDate;

public class Tax 
{
	private int id=0;
	
	PropertyMaster property;
	private double assessmentOfAnnualRent=0.0;
	private double estimatedTaxAmount=0.0;
	private double  previouslyMentionedSurplusAndDeficitAmount=0.0;
	private LocalDate updatedDate;
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
	public double getEstimatedTaxAmount() {
		return estimatedTaxAmount;
	}
	public void setEstimatedTaxAmount(double estimatedTaxAmount) {
		this.estimatedTaxAmount = estimatedTaxAmount;
	}
	public double getAssessmentOfAnnualRent() {
		return assessmentOfAnnualRent;
	}
	public void setAssessmentOfAnnualRent(double assessmentOfAnnualRent) {
		this.assessmentOfAnnualRent = assessmentOfAnnualRent;
	}
	
	public double getPreviouslyMentionedSurplusAndDeficitAmount() {
		return previouslyMentionedSurplusAndDeficitAmount;
	}
	public void setPreviouslyMentionedSurplusAndDeficitAmount(double previouslyMentionedSurplusAndDeficitAmount) {
		this.previouslyMentionedSurplusAndDeficitAmount = previouslyMentionedSurplusAndDeficitAmount;
	}
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public String toString()
	{
		return "property no:"+this.getProperty().getPropertyNo()+"assessment of annual rent:"+this.getAssessmentOfAnnualRent()+
				"estimated tax amount:"+this.getEstimatedTaxAmount()+"previously mentioned surplus and defict amt:"+this.getPreviouslyMentionedSurplusAndDeficitAmount()+
				"updated date:"+this.getUpdatedDate();
	}

}
