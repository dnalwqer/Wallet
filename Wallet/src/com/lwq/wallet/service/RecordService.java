package com.lwq.wallet.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.apache.http.util.EncodingUtils;

import com.lwq.wallet.inter.RecordInterface;
import com.lwq.wallet.utils.CardItem;
import com.lwq.wallet.utils.FileUtils;
import com.lwq.wallet.utils.RecordItem;

import android.content.Context;
import android.content.ContextWrapper;

public class RecordService extends ContextWrapper implements RecordInterface{

	public RecordService(Context base) {
		super(base);
	}
	
	//获得消费记录的list
	public ArrayList<RecordItem> getRecordList(String name){
		ArrayList<RecordItem> list=new ArrayList<RecordItem>();
		try {
			FileUtils file=new FileUtils(this);
			String info[]=file.readFile(name, "\r\n");
			System.out.println(info.length);
			for(int i=0;i<info.length;i++){
				String records[]=info[i].split("\t");
				RecordItem item=new RecordItem();
				item.setItem(records[0], records[1], records[2]);
				list.add(item);
			}
		} catch (Exception e) {
			list.clear();
		}
		return list;
	}
}
