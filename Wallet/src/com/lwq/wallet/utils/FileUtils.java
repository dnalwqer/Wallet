package com.lwq.wallet.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.apache.http.util.EncodingUtils;

import android.content.Context;
import android.content.ContextWrapper;

public class FileUtils extends ContextWrapper{

	public FileUtils(Context base) {
		super(base);
	}

	public String[] readFile(String file,String reg){
		FileInputStream fis;
		String info[]=null;
		try {
			fis = openFileInput(file);
			int len=fis.available();
			byte []buffer=new byte[len];
			fis.read(buffer);
			String res=EncodingUtils.getString(buffer, "UTF-8");
			info=res.split(reg);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}
}
