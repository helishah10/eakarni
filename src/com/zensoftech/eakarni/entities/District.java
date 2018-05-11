package com.zensoftech.eakarni.entities;

public class District {
	private int id=0;
	private int dId=0;
    private String name="";
    State state;
    
    public District()
    {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDId() {
		return dId;
	}

	public void setDId(int dId) {
		this.dId = dId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String toString()
	{
		return "Id:" + this.id +"  state id: "+this.getState().getStateId()+"  did : " +this.dId +"  Name:" + this.name ;
	}
}
