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
import com.lwq.wallet.utils.RecordItem;

public class RecordAdapter extends BaseAdapter{

	public Context context;
	public ArrayList<RecordItem>a;
	public RecordAdapter(Context context,ArrayList<RecordItem> a){
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
		WrapperView v;
		if(view==null)
		{
			view=LayoutInflater.from(context).inflate(R.layout.record_item, null);
			v=new WrapperView(view);
			view.setTag(v);
		}
		else
			v=(WrapperView)view.getTag();
		
		v.getWays().setText(a.get(position).getRecordways());
		v.getTime().setText("Ê±¼ä:"+a.get(position).getTime());
		if(Integer.parseInt(a.get(position).getMoney())>0)
			v.getMoney().setText("+"+a.get(position).getMoney());
		else
			v.getMoney().setText(a.get(position).getMoney());
		return view;
	}

}

class WrapperView{
    View base;
    TextView ways = null;
    TextView money = null;
    TextView time=null;
    
    WrapperView(View base){
        this.base = base;
    }
    
    TextView getWays(){
        if(ways == null)
            ways = (TextView)base.findViewById(R.id.record_ways);
        return ways;
    }
    
    TextView getMoney(){
        if(money == null)
            money = (TextView)base.findViewById(R.id.record_money);
        return money;
    }
    
    TextView getTime(){
    	if(time == null)
    		time = (TextView)base.findViewById(R.id.record_time);
    	return time;
    }
}