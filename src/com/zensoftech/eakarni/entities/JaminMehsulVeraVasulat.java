package com.zensoftech.eakarni.entities;
import java.time.LocalDate;
import java.time.YearMonth;

public class JaminMehsulVeraVasulat 
{
	private int id=0;
	private YearMonth yearmonth;
	private double landRevenue=0.00;
	private double totalAmountSeeking=0.00;
	private double amountCollectedDuringMonth=0.00;
	private double amountLeft=0.00;
	private double percentage=0.00;
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

	
	public String toString()
	{
		return "\tyearmont: " +this.getYearmonth()+ " land revenue : " +this.getLandRevenue() + " total amount seeking : " +
	this.getTotalAmountSeeking() + " amount collected during month :" +this.getAmountCollectedDuringMonth() + " amount left :" +this.getAmountLeft()
	+ " percentage : " +this.getPercentage();
	}
	

}
