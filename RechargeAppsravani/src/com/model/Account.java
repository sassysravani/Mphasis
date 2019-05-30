package com.model;

public class Account {

	private int mobileno;
	private String pass;
	private String uname;
	private String type_accno;
	private int amt;
	public Account()
	{
		
	}
	public int getMobileno() {
		return mobileno;
	}
	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getType_accno() {
		return type_accno;
	}
	public void setType_accno(String type_accno) {
		this.type_accno = type_accno;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}

	
	
}