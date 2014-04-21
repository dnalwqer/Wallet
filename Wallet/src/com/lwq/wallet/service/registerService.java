package com.lwq.wallet.service;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import android.content.Context;
import android.content.ContextWrapper;

import com.lwq.wallet.inter.registerInterface;

public class registerService extends ContextWrapper implements registerInterface{
	
	public static final String register="lwq";
	public registerService(Context base) {
		super(base);
	}

	public boolean registerInfo(String user,String password){
		try {
			OutputStream op=openFileOutput(register, MODE_PRIVATE);
			OutputStreamWriter os=new OutputStreamWriter(op);
			os.write(user+"\t"+password);
			os.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
