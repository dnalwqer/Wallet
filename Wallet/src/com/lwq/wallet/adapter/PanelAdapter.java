package com.lwq.wallet.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lwq.wallet.login.R;
import com.lwq.wallet.utils.PanelItem;

public class PanelAdapter extends BaseAdapter{

	public Context context;
	public ArrayList<PanelItem>a;
	public PanelAdapter(Context context,ArrayList<PanelItem> a){
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
		ViewWrapper v;
		if(view==null)
		{
			view=LayoutInflater.from(context).inflate(R.layout.panel_item, null);
			v=new ViewWrapper(view);
			view.setTag(v);
		}
		else
			v=(ViewWrapper)view.getTag();
		
		v.getLabel().setText(a.get(position).getTitleItem());
		v.getIcon().setImageResource(a.get(position).getImgItem());
		
		View vv=view.findViewById(R.id.panel_item);
		vv.setBackgroundColor(a.get(position).getColor());
		return view;
	}

}

class ViewWrapper{
    View base;
    TextView label = null;
    ImageView icon = null;
    
    ViewWrapper(View base){
        this.base = base;
    }
    
    TextView getLabel(){
        if(label == null)
            label = (TextView)base.findViewById(R.id.panel_title);
        return label;
    }
    
    ImageView getIcon(){
        if(icon == null)
            icon = (ImageView)base.findViewById(R.id.panel_icon);
        return icon;
    }
}

