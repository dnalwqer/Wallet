package com.lwq.wallet.utils;

public class RecordItem {
	private String recordways;
	private String time;
	private String money;
	
	public void setItem(String recordways,String money,String time){
		this.recordways=recordways;
		this.money=money;
		this.time=time;
	}
	
	public String getRecordways() {
		return recordways;
	}

	public String getTime() {
		return time;
	}

	public String getMoney() {
		return money;
	}
}
