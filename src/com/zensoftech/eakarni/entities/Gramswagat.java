package com.zensoftech.eakarni.entities;

import java.time.LocalDate;
import java.time.YearMonth;

public class Gramswagat 
{
	private int id=0;
	private YearMonth yearmonth;
	private String descriptionOfQuestionsRaised=null;
	private int disposal;
	private int pending;
	private LocalDate entryDate;
	Village village;
	
	public YearMonth getYearmonth() {
		return yearmonth;
	}

	public void setYearmonth(YearMonth yearmonth) {
		this.yearmonth = yearmonth;
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
	
	public LocalDate getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}
	public String getDescriptionOfQuestionsRaised() {
		return descriptionOfQuestionsRaised;
	}
	public void setDescriptionOfQuestionsRaised(String descriptionOfQuestionsRaised) {
		this.descriptionOfQuestionsRaised = descriptionOfQuestionsRaised;
	}
	public int getDisposal() {
		return disposal;
	}
	public void setDisposal(int disposal) {
		this.disposal = disposal;
	}
	public int getPending() {
		return pending;
	}
	public void setPending(int pending) {
		this.pending = pending;
	}
	
	public String toString()
	{
		return "\tyearmonth:"+this.getYearmonth()+ "description of questions: " +this.getDescriptionOfQuestionsRaised() +
				"disposal: " +this.getDisposal()+ "pending: " +this.getPending();
	}
	
}