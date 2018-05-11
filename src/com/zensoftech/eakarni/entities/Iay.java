package com.zensoftech.eakarni.entities;
import java.time.LocalDate;
import java.time.YearMonth;

public class Iay 
{
	private int id=0;
	private YearMonth yearmonth;
	private int target=0;
	private double firstInstallment=0.00;
	private double secondInstallment=0.00;
	private double thirdInstallment=0.00;
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

	public Iay()
	{}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public double getFirstInstallment() {
		return firstInstallment;
	}

	public void setFirstInstallment(double firstInstallment) {
		this.firstInstallment = firstInstallment;
	}

	public double getSecondInstallment() {
		return secondInstallment;
	}

	public void setSecondInstallment(double secondInstallment) {
		this.secondInstallment = secondInstallment;
	}

	public double getThirdInstallment() {
		return thirdInstallment;
	}

	public void setThirdInstallment(double thirdInstallment) {
		this.thirdInstallment = thirdInstallment;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public String toString(){
		return "\tyearmonth:"+this.getYearmonth() + " target : " + this.getTarget() + " first installment : " +this.getFirstInstallment() +
				" second installment : " +this.getSecondInstallment() + " third installment : " + this.getThirdInstallment();
	}
	

}
