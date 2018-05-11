package com.zensoftech.eakarni.entities;

public class UserDetails {
	private int contactNo=0;
	private int postalCode=0;
	private int aadharcard=0;
	private String firstName="";
	private String middleName="";
	private String lastName="";
	private String address="";
	private String emailId="";
	private boolean userDetailsAvailable;
	private User user;

	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public int getAadharcard() {
		return aadharcard;
	}
	public void setAadharcard(int aadharcard) {
		this.aadharcard = aadharcard;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isUserDetailsAvailable() {
		
		if(user.getLoginId().equals("") || user.getPwd().equals("") || firstName.equals("") || lastName.equals(""))
			return false;
		else
			return true;
	}
	
	
}
