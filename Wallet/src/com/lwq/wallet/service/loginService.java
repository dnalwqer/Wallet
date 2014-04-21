package com.lwq.wallet.service;

import com.lwq.wallet.inter.loginInterface;
import com.lwq.wallet.utils.FileUtils;

import android.content.Context;
import android.content.ContextWrapper;

public class loginService extends ContextWrapper implements loginInterface{

	public static final String login="lwq";
	public loginService(Context base) {
		super(base);
	}

	@Override
	public boolean checkInfo(String user, String password) {
		try {
			FileUtils accountfile=new FileUtils(this);
			String []info=accountfile.readFile(login,"\t");
			if(user.equals(info[0])&&password.equals(info[1]))
				return true;
			else
				return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
