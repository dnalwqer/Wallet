package com.lwq.wallet.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.lwq.wallet.login.R;
import com.lwq.wallet.login.RegsterActivity;

public class ViewPageAdapter extends PagerAdapter{

	private List<View> views;  
	private Activity activity;  
	private static final String SHAREDPREFERENCES_NAME = "first";  
	public ViewPageAdapter(List<View> views, Activity activity) {  
		this.views = views;  
	    this.activity = activity;  
	}  
	
	@Override
	public void destroyItem(View arg0, int arg1, Object arg2) {
		// TODO Auto-generated method stub
		((ViewPager) arg0).removeView(views.get(arg1));  
	}

	@Override
	public void finishUpdate(View arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
	     if (views != null) {  
	            return views.size();  
	        }  
	     return 0;  
	}

	@Override
	public Object instantiateItem(View arg0, int arg1) {
		// TODO Auto-generated method stub
		 ((ViewPager) arg0).addView(views.get(arg1), 0);  
	        if (arg1 == views.size() - 1) {  
	            Button ImageButton = (Button) arg0  
	                    .findViewById(R.id.startbutton);  
	            ImageButton.setOnClickListener(new OnClickListener() {  
	  
	                @Override  
	                public void onClick(View v) {  
	                    // 设置已经引导  
	                	 SharedPreferences preferences = activity.getSharedPreferences(  
	                             SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);  
	                     Editor editor = preferences.edit();  
	                     // 存入数据  
	                     editor.putBoolean("isFirstIn", false);  
	                     // 提交修改  
	                     editor.commit();  
	                     Intent intent=new Intent();
	                     intent.setClass(activity, RegsterActivity.class);
	                     activity.startActivity(intent);
	                     activity.finish();
	                }  
	  
	            });  
	        }  
	        return views.get(arg1);  
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	@Override
	public void restoreState(Parcelable arg0, ClassLoader arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Parcelable saveState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void startUpdate(View arg0) {
		// TODO Auto-generated method stub
		
	}

}
