package com.zensoftech.eakarni.entities;

public class State {
	  private int id=0;
	  private int stateId=0;
      private String name="";
      private String languageCode="";
      private String scriptCode=null;
      
      public State()
      {
      }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getScriptCode() {
		return scriptCode;
	}

	public void setScriptCode(String scriptCode) {
		this.scriptCode = scriptCode;
	}
	
	public String toString()
	{
		return "Id:" + this.id + " State Id:" +this.stateId + " Name:" + this.name + " Language Code: " +this.languageCode + " Script Code: " +this.scriptCode;
	}

}
