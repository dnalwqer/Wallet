package com.lwq.wallet.service;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Vector;

import com.lwq.wallet.inter.infoInterface;
import com.lwq.wallet.utils.FileUtils;

import android.content.Context;
import android.content.ContextWrapper;

public class infoService extends ContextWrapper implements infoInterface{

	private static final String login="lwq";
	private static final String userinfo="info";
	public infoService(Context base) {
		super(base);
	}

	public boolean changePass(String oldpassword, String newpassword) {
		try {
			FileUtils accountfile=new FileUtils(this);
			String []res=accountfile.readFile(login,"\t");
			if(oldpassword.equals(res[1])){
				OutputStreamWriter os=new OutputStreamWriter(openFileOutput(login, MODE_PRIVATE));
				res[1]=newpassword;
				os.write(res[0]+"\t"+res[1]);
				os.close();
				return true;
			}	
			else
				return false;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean resetInfo(String user, String phone, String email) {
		try {
			OutputStreamWriter os=new OutputStreamWriter(openFileOutput(userinfo, MODE_PRIVATE));
			os.write(user+"\t"+phone+"\t"+email);
			os.close();
			return true;		
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Vector<String> getInfo() {
		String []info;
		Vector<String> res=new Vector<String>();
		try {
			FileUtils accountfile=new FileUtils(this);
			info=accountfile.readFile(userinfo,"\t");
			for(int i=0;i<info.length;i++)
				res.add(info[i]);
		} catch (Exception e) {
			
			res.clear();
		}
		return res;
	}
}
