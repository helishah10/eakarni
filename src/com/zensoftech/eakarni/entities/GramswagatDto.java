package com.zensoftech.eakarni.entities;

import java.time.LocalDate;
import java.time.YearMonth;

public class GramswagatDto {

	private int id=0;
	private int year=0;
	private int month=0;
	private String descriptionOfQuestionsRaised=null;
	private int disposal;
	private int pending;
	private LocalDate entryDate;
	private int villageid=0;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
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
	public LocalDate getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}
	public int getVillageid() {
		return villageid;
	}
	public void setVillageid(int villageid) {
		this.villageid = villageid;
	}
	
	
}
