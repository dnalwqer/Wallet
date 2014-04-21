package com.lwq.wallet.service;

import java.util.ArrayList;

import android.content.Context;
import android.content.ContextWrapper;

import com.lwq.wallet.inter.CardItemInterface;
import com.lwq.wallet.utils.CardItem;
import com.lwq.wallet.utils.FileUtils;

public class CardItemService extends ContextWrapper implements CardItemInterface{

	private static final String cardlist="cardlist";
	
	public CardItemService(Context base) {
		super(base);
	}
	@Override
	public ArrayList<CardItem> getCardList() {
		ArrayList<CardItem> al=new ArrayList<CardItem>();
		try {
			FileUtils file=new FileUtils(this);
			String info[]=file.readFile(cardlist, "\r\n");
			for(int i=0;i<info.length;i++){
				CardItem card=new CardItem();
				String carditem[]=info[i].split("\t");
				card.setItem(carditem[1], carditem[0]);
				al.add(card);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			al.clear();
		}
		return al;
	}
}
