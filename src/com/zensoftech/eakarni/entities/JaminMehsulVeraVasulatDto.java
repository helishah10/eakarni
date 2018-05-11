package com.zensoftech.eakarni.entities;

import java.time.LocalDate;
import java.time.YearMonth;

public class JaminMehsulVeraVasulatDto {
	
	private int id=0;
	private int year=0;
	private int month=0;
	private double landRevenue=0.00;
	private double totalAmountSeeking=0.00;
	private double amountCollectedDuringMonth=0.00;
	private double amountLeft=0.00;
	private double percentage=0.00;
	private LocalDate entryDate;
	private int villageId=0;
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
	public double getLandRevenue() {
		return landRevenue;
	}
	public void setLandRevenue(double landRevenue) {
		this.landRevenue = landRevenue;
	}
	public double getTotalAmountSeeking() {
		return totalAmountSeeking;
	}
	public void setTotalAmountSeeking(double totalAmountSeeking) {
		this.totalAmountSeeking = totalAmountSeeking;
	}
	public double getAmountCollectedDuringMonth() {
		return amountCollectedDuringMonth;
	}
	public void setAmountCollectedDuringMonth(double amountCollectedDuringMonth) {
		this.amountCollectedDuringMonth = amountCollectedDuringMonth;
	}
	public double getAmountLeft() {
		return amountLeft;
	}
	public void setAmountLeft(double amountLeft) {
		this.amountLeft = amountLeft;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public LocalDate getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}
	public int getVillageId() {
		return villageId;
	}
	public void setVillageId(int villageId) {
		this.villageId = villageId;
	}
	
	

}
