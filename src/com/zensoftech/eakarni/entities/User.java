package com.zensoftech.eakarni.entities;

public class User 
{
	private int id=0;
	private String loginId="";
	private String pwd="";
	private Usertype type;
	//private boolean userdetails;
	
	public enum Usertype
	 {
	        Admin(0),
	        Ddo(1),
	        Tdo(2),
	        Talati(3);
		
		private int value;

		private Usertype(int value)
		 {
			 this.value=value;
		 }
		public int getValue()
		{
		    return this.value;
	
		}
	 }
	 
	 public Usertype getType(){
	        return type; 
	     }

	     public void setType(Usertype type){  
	         this.type = type;
	     } 
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	public String toString()
	{
		return "loign Id:"+this.getLoginId()+"\tpwd:"+this.getPwd()+"\tuser type:"+this.getType();
		
	}

}
