package com.lwq.wallet.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lwq.wallet.login.R;
import com.lwq.wallet.utils.CardItem;

public class CardAdapter extends BaseAdapter{

	public Context context;
	public ArrayList<CardItem>a;
	public CardAdapter(Context context,ArrayList<CardItem> a){
		this.context=context;
		this.a=a;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return a.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		View view=convertView;
		FastView v;
		if(view==null)
		{
			view=LayoutInflater.from(context).inflate(R.layout.card_item, null);
			v=new FastView(view);
			view.setTag(v);
		}
		else
			v=(FastView)view.getTag();
		
		v.getUser().setText(a.get(position).getUsername());
		v.getId().setText("¿¨ºÅ:"+a.get(position).getBankid());
		
		View vv=view.findViewById(R.id.card_item);
		vv.setBackgroundColor(Color.rgb(229, 229, 229));
		return view;
	}

}

class FastView{
    View base;
    TextView username = null;
    TextView bankid = null;
    
    FastView(View base){
        this.base = base;
    }
    
    TextView getUser(){
        if(username == null)
            username = (TextView)base.findViewById(R.id.text_username);
        return username;
    }
    
    TextView getId(){
        if(bankid == null)
            bankid = (TextView)base.findViewById(R.id.text_bankid);
        return bankid;
    }
}