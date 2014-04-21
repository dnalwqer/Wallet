package com.lwq.wallet.inter;

import java.util.ArrayList;

import com.lwq.wallet.utils.RecordItem;

public interface RecordInterface {
	public ArrayList<RecordItem> getRecordList(String name); //获得消费记录接口
}
