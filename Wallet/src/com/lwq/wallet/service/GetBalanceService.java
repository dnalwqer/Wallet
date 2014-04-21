package com.lwq.wallet.service;

import com.lwq.wallet.inter.GetBalanceInterface;
import com.lwq.wallet.utils.FileUtils;

import android.content.Context;
import android.content.ContextWrapper;

public class GetBalanceService extends ContextWrapper implements GetBalanceInterface{

	public GetBalanceService(Context base) {
		super(base);
	}

	@Override
	public int getBalance(String name) {
		int balance=0;
		String info[];
		try {
			FileUtils file=new FileUtils(this);
			info = file.readFile(name, "\r\n");
			for(int i=0;i<info.length;i++){
				String records[]=info[i].split("\t");
				balance+=Integer.parseInt(records[1]);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			balance=0;
		}
		return balance;
	}

}
