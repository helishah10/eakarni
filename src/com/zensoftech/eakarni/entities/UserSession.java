package com.zensoftech.eakarni.entities;

import java.time.LocalDateTime;

public class UserSession {

	private int userId=0;
	private LocalDateTime logIn;
	private LocalDateTime logOut;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public LocalDateTime getLogIn() {
		return logIn;
	}
	public void setLogIn(LocalDateTime logIn) {
		this.logIn = logIn;
	}
	public LocalDateTime getLogOut() {
		return logOut;
	}
	public void setLogOut(LocalDateTime logOut) {
		this.logOut = logOut;
	}
	
	
	

}
