package com.zensoftech.eakarni.entities;
import java.time.LocalDate;
import java.time.YearMonth;

public class Hsg 
{
	private int id=0;
	private YearMonth yearmonth;
	private int target=0;
	private int notStartedHouses=0;
	private int plinthLevel=0;
	private int lintalLevel=0;
	private int slabLevel=0;
	private int financeYear=0;
	private int completedHouses=0;
	/*private int grantYear=0; */
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
	public Hsg()
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
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public int getNotStartedHouses() {
		return notStartedHouses;
	}
	public void setNotStartedHouses(int notStartedHouses) {
		this.notStartedHouses = notStartedHouses;
	}
	public int getPlinthLevel() {
		return plinthLevel;
	}
	public void setPlinthLevel(int plinthLevel) {
		this.plinthLevel = plinthLevel;
	}
	public int getLintalLevel() {
		return lintalLevel;
	}
	public void setLintalLevel(int lintalLevel) {
		this.lintalLevel = lintalLevel;
	}
	public int getSlabLevel() {
		return slabLevel;
	}
	public void setSlabLevel(int slabLevel) {
		this.slabLevel = slabLevel;
	}
	
/*	public int getGrantYear() {
		return grantYear;
	}
	public void setGrantYear(int grantYear) {
		this.grantYear = grantYear;
	}*/
	public int getCompletedHouses() {
		return completedHouses;
	}
	public void setCompletedHouses(int completedHouses) {
		this.completedHouses = completedHouses;
	}
	
	public String toString(){
		return "\tyearmonth:"+this.getYearmonth()+"target:"+this.getTarget()+"not started houses:"+this.notStartedHouses+
				"plint level:"+this.plinthLevel+"lintal level:"+this.lintalLevel+"slab level:"+this.slabLevel+/*"grant year:"+this.getGrantYear()*/
				"completed houses:"+this.getCompletedHouses();
	}

	public int getFinanceYear() {
		return financeYear;
	}

	public void setFinanceYear(int financeYear) {
		this.financeYear = financeYear;
	}
	
	
}
