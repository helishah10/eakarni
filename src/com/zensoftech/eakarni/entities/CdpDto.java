package com.zensoftech.eakarni.entities;

import java.time.LocalDate;
import java.time.YearMonth;

public class CdpDto {

	private int year;
	private int month;
	/*private int yr=0;*/
	private double grantAllocated=0.00;
	private double costsDuringPreviousYear=0.00;
	private double costsDuringThisMonth=0.00;
	private double ongoingCostsDuringCurrentYear=0.00;
	private double achievementOfPreviousMonthOfCurrentYear=0.00;
	private double achievementsDuirngThisMonth=0.00;
	private double totalAchievementsOfCurrentYear=0.00;
	private int villageId;
	private LocalDate entryDate;
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
	public int getVillageId() {
		return villageId;
	}
	public void setVillageId(int villageId) {
		this.villageId = villageId;
	}
	public LocalDate getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	
	
}
