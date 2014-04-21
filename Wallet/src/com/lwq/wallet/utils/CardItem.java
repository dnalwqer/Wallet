package com.lwq.wallet.utils;

public class CardItem {
	private String username;
	private String bankid;
	public String getUsername() {
		return username;
	}
	public String getBankid() {
		return bankid;
	}
	public void setItem(String bankid,String username) {
		this.bankid = bankid;
		this.username=username;
	}
}
