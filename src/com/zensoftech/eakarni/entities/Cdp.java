package com.zensoftech.eakarni.entities;
import java.time.LocalDate;
import java.time.YearMonth;

public class Cdp 
{
	private int id=0;
	private YearMonth yearmonth;
	/*private int yr=0;*/
	private double grantAllocated=0.00;
	private double costsDuringPreviousYear=0.00;
	private double costsDuringThisMonth=0.00;
	private double ongoingCostsDuringCurrentYear=0.00;
	private double achievementOfPreviousMonthOfCurrentYear=0.00;
	private double achievementsDuirngThisMonth=0.00;
	private double totalAchievementsOfCurrentYear=0.00;
	Village village;
	private LocalDate entryDate;
	
	public YearMonth getYearmonth() {
		return yearmonth;
	}

	public void setYearmonth(YearMonth yearmonth) {
		this.yearmonth = yearmonth;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cdp(){}

	public double getGrantAllocated() {
		return grantAllocated;
	}

	public void setGrantAllocated(double grantAllocated) {
		this.grantAllocated = grantAllocated;
	}

	public double getCostsDuringPreviousYear() {
		return costsDuringPreviousYear;
	}

	public void setCostsDuringPreviousYear(double costsDuringPreviousYear) {
		this.costsDuringPreviousYear = costsDuringPreviousYear;
	}

	public double getCostsDuringThisMonth() {
		return costsDuringThisMonth;
	}

	public void setCostsDuringThisMonth(double costsDuringThisMonth) {
		this.costsDuringThisMonth = costsDuringThisMonth;
	}

	public double getOngoingCostsDuringCurrentYear() {
		return ongoingCostsDuringCurrentYear;
	}

	public void setOngoingCostsDuringCurrentYear(double ongoingCostsDuringCurrentYear) {
		this.ongoingCostsDuringCurrentYear = ongoingCostsDuringCurrentYear;
	}

	public double getAchievementOfPreviousMonthOfCurrentYear() {
		return achievementOfPreviousMonthOfCurrentYear;
	}

	public void setAchievementOfPreviousMonthOfCurrentYear(double achievementOfPreviousMonthOfCurrentYear) {
		this.achievementOfPreviousMonthOfCurrentYear = achievementOfPreviousMonthOfCurrentYear;
	}

	public double getAchievementsDuirngThisMonth() {
		return achievementsDuirngThisMonth;
	}

	public void setAchievementsDuirngThisMonth(double achievementsDuirngThisMonth) {
		this.achievementsDuirngThisMonth = achievementsDuirngThisMonth;
	}

	public double getTotalAchievementsOfCurrentYear() {
		return totalAchievementsOfCurrentYear;
	}

	public void setTotalAchievementsOfCurrentYear(double totalAchievementsOfCurrentYear) {
		this.totalAchievementsOfCurrentYear = totalAchievementsOfCurrentYear;
	}

	public LocalDate getEntryDate() {
		
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}
	
	public String toString()
	{
		return "village id:"+this.village.getId()+"\tyearmonth:"+this.getYearmonth()+" grant allocated: "+ this.getGrantAllocated()+ 
				" costs during previous year:" + this.getCostsDuringPreviousYear()+"costs during this month:"+
				this.getCostsDuringThisMonth() +"ongoing costs during current year:"+this.getOngoingCostsDuringCurrentYear()+
				" achievement Of Previous Month Of CurrentYear:"+this.getAchievementOfPreviousMonthOfCurrentYear() +
				" achievements Duirng This Month:"+this.getAchievementsDuirngThisMonth() +"totalAchievementsOfCurrentYear:"+
				this.getTotalAchievementsOfCurrentYear()+ "entry date:"+this.getEntryDate();
	}


	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}
}

