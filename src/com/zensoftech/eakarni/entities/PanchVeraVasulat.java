package com.zensoftech.eakarni.entities;
import java.time.LocalDate;
import java.time.YearMonth;

public class PanchVeraVasulat 
{
	private int id=0;
	private YearMonth yearmonth;
	Taxtype taxtype;
	public Taxtype getTaxtype() {
		return taxtype;
	}

	public void setTaxtype(Taxtype taxtype) {
		this.taxtype = taxtype;
	}
	private double seekingPreviousAmountLeft=0.0;
	private double seekingCurrentAmount=0.0;
	private double seekingTotalAmount=0.0;
	private double recoveryTillPreviousMonthCurrent=0.0;
	private double recoveryTillPreviousMonthPrevious=0.0;
	private double recoveryTillPreviousMonthTotal=0.0;
	private double recoveryTillCurrentMonthCurrent=0.0;
	private double recoveryTillCurrentMonthPrevious=0.0;
	private double recoveryTillCurrentMonthTotal=0.0;
	private double totalRecoveryPrevious=0.0;
	private double totalRecoveryCurrent=0.0;
	private double totalRecoveryTotal=0.0;
	private double recoveryLeftAtTheEndMonthPrevious=0.0;
	private double recoveryLeftAtTheEndMonthCurrent=0.0;
	private double recoveryLeftAtTheEndMonthTotal=0.0;
	
	public YearMonth getYearmonth() {
		return yearmonth;
	}

	public void setYearmonth(YearMonth yearmonth) {
		this.yearmonth = yearmonth;
	}
	private double percentage;
	public double getPercentage() {
		return percentage;
	}


	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}


	private LocalDate entryDate;
	Village village;
	
	
	public Village getVillage() {
		return village;
	}


	public void setVillage(Village village) {
		this.village = village;
	}


	public PanchVeraVasulat()
	{}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}




	public double getSeekingPreviousAmountLeft() {
		return seekingPreviousAmountLeft;
	}


	public void setSeekingPreviousAmountLeft(double seekingPreviousAmountLeft) {
		this.seekingPreviousAmountLeft = seekingPreviousAmountLeft;
	}


	public double getSeekingCurrentAmount() {
		return seekingCurrentAmount;
	}


	public void setSeekingCurrentAmount(double seekingCurrentAmount) {
		this.seekingCurrentAmount = seekingCurrentAmount;
	}


	public double getSeekingTotalAmount() {
		return seekingTotalAmount;
	}


	public void setSeekingTotalAmount(double seekingTotalAmount) {
		this.seekingTotalAmount = seekingTotalAmount;
	}


	public double getRecoveryTillPreviousMonthCurrent() {
		return recoveryTillPreviousMonthCurrent;
	}


	public void setRecoveryTillPreviousMonthCurrent(double recoveryTillPreviousMonthCurrent) {
		this.recoveryTillPreviousMonthCurrent = recoveryTillPreviousMonthCurrent;
	}


	public double getRecoveryTillPreviousMonthPrevious() {
		return recoveryTillPreviousMonthPrevious;
	}


	public void setRecoveryTillPreviousMonthPrevious(double recoveryTillPreviousMonthPrevious) {
		this.recoveryTillPreviousMonthPrevious = recoveryTillPreviousMonthPrevious;
	}


	public double getRecoveryTillPreviousMonthTotal() {
		return recoveryTillPreviousMonthTotal;
	}


	public void setRecoveryTillPreviousMonthTotal(double recoveryTillPreviousMonthTotal) {
		this.recoveryTillPreviousMonthTotal = recoveryTillPreviousMonthTotal;
	}


	public double getTotalRecoveryPrevious() {
		return totalRecoveryPrevious;
	}


	public void setTotalRecoveryPrevious(double totalRecoveryPrevious) {
		this.totalRecoveryPrevious = totalRecoveryPrevious;
	}


	public double getTotalRecoveryCurrent() {
		return totalRecoveryCurrent;
	}


	public void setTotalRecoveryCurrent(double totalRecoveryCurrent) {
		this.totalRecoveryCurrent = totalRecoveryCurrent;
	}


	public double getTotalRecoveryTotal() {
		return totalRecoveryTotal;
	}


	public void setTotalRecoveryTotal(double totalRecoveryTotal) {
		this.totalRecoveryTotal = totalRecoveryTotal;
	}


	public double getRecoveryLeftAtTheEndMonthPrevious() {
		return recoveryLeftAtTheEndMonthPrevious;
	}


	public void setRecoveryLeftAtTheEndMonthPrevious(double recoveryLeftAtTheEndMonthPrevious) {
		this.recoveryLeftAtTheEndMonthPrevious = recoveryLeftAtTheEndMonthPrevious;
	}


	public double getRecoveryLeftAtTheEndMonthCurrent() {
		return recoveryLeftAtTheEndMonthCurrent;
	}


	public void setRecoveryLeftAtTheEndMonthCurrent(double recoveryLeftAtTheEndMonthCurrent) {
		this.recoveryLeftAtTheEndMonthCurrent = recoveryLeftAtTheEndMonthCurrent;
	}


	public double getRecoveryLeftAtTheEndMonthTotal() {
		return recoveryLeftAtTheEndMonthTotal;
	}


	public void setRecoveryLeftAtTheEndMonthTotal(double recoveryLeftAtTheEndMonthTotal) {
		this.recoveryLeftAtTheEndMonthTotal = recoveryLeftAtTheEndMonthTotal;
	}


	public LocalDate getEntryDate() {
		return entryDate;
	}


	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}


	public double getRecoveryTillCurrentMonthCurrent() {
		return recoveryTillCurrentMonthCurrent;
	}


	public void setRecoveryTillCurrentMonthCurrent(double recoveryTillCurrentMonthCurrent) {
		this.recoveryTillCurrentMonthCurrent = recoveryTillCurrentMonthCurrent;
	}


	public double getRecoveryTillCurrentMonthPrevious() {
		return recoveryTillCurrentMonthPrevious;
	}


	public void setRecoveryTillCurrentMonthPrevious(double recoveryTillCurrentMonthPrevious) {
		this.recoveryTillCurrentMonthPrevious = recoveryTillCurrentMonthPrevious;
	}


	public double getRecoveryTillCurrentMonthTotal() {
		return recoveryTillCurrentMonthTotal;
	}


	public void setRecoveryTillCurrentMonthTotal(double recoveryTillCurrentMonthTotal) {
		this.recoveryTillCurrentMonthTotal = recoveryTillCurrentMonthTotal;
	}


	public String toString()
	{
		return "village:"+this.getVillage().getvId()+"\tyearmonth:"+this.getYearmonth()+
				"tax id:"+this.getTaxtype().getTaxName()+
				"seeking previous amountLeft:"+this.getSeekingPreviousAmountLeft()+"seekingCurrentAmount:"+this.getSeekingCurrentAmount()+
			"seekingTotalAmount:"+this.getSeekingTotalAmount()+"recovery till previous month current:"+this.getRecoveryTillPreviousMonthCurrent()+
			"recovery till previous month previous:"+this.getRecoveryTillPreviousMonthPrevious()+"recovery till previous month total:"+this.getRecoveryTillPreviousMonthTotal()+
			"recovery till current month current:"+this.getRecoveryTillCurrentMonthCurrent()+"recovery till current month previous:"+
			this.getRecoveryTillCurrentMonthPrevious()+"recovery till current month total:"+this.getRecoveryTillCurrentMonthTotal()+
			"total recovery previous:"+this.getTotalRecoveryPrevious()+"total recovery current:"+this.getTotalRecoveryCurrent()+
			"total recovery total:"+this.getTotalRecoveryTotal()+"recovery left at end month previous:"+this.recoveryLeftAtTheEndMonthPrevious+
			"recovery left at end month current:"+this.getRecoveryLeftAtTheEndMonthCurrent()+"recovery left at end month total:"+this.getRecoveryLeftAtTheEndMonthTotal()+
			"percentage:"+this.getPercentage()+"entry date:"+this.getEntryDate();
	}

	

	
}