package com.zensoftech.eakarni.entities;

import java.time.LocalDate;
import java.time.YearMonth;

public class Finance14 
{
	private int id=0;
	private YearMonth yearmonth;
	private int totalWork=0;
	private int worksApproved=0;
	private int projectNotStarted=0;
	private int progress=0;
	private int completed=0;;
	private double grantAllocated=0.0;
	private double amountSpent=0.0;
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

	public Finance14()
	{}

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

	public int getTotalWork() {
		return totalWork;
	}

	public void setTotalWork(int totalWork) {
		this.totalWork = totalWork;
	}

	
	
	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public int getCompleted() {
		return completed;
	}

	public void setCompleted(int completed) {
		this.completed = completed;
	}

	

	public double getAmountSpent() {
		return amountSpent;
	}

	public void setAmountSpent(double amountSpent) {
		this.amountSpent = amountSpent;
	}

	

	public int getWorksApproved() {
		return worksApproved;
	}

	public void setWorksApproved(int worksApproved) {
		this.worksApproved = worksApproved;
	}

	public int getProjectNotStarted() {
		return projectNotStarted;
	}

	public void setProjectNotStarted(int projectNotStarted) {
		this.projectNotStarted = projectNotStarted;
	}

	public double getGrantAllocated() {
		return grantAllocated;
	}

	public void setGrantAllocated(double grantAllocated) {
		this.grantAllocated = grantAllocated;
	}
	public String toString()
	{
		return "village:"+this.getVillage().getvId()+"\tyearmonth:"+this.getYearmonth()+"total work:"+this.getTotalWork()+
				"works approved:"+this.getWorksApproved()+"project not started:"+this.getProjectNotStarted()+"progress:"+this.getProgress()+
				"completed:"+this.getCompleted()+"grant allocated:"+this.getGrantAllocated()+"grant spent:"+this.getAmountSpent()+
				"entry date:"+this.getEntryDate();
	}
	

}
