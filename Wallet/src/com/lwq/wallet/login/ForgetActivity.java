package com.lwq.wallet.login;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class ForgetActivity extends TabActivity{

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forget);
		
		TabHost tabhost=getTabHost();
		TabHost.TabSpec spec=null;
		
		Intent intent=new Intent();
		intent.setClass(this, MessageActivity.class);
		spec=tabhost.newTabSpec("tag1");
		spec.setContent(intent);
		spec.setIndicator("∂Ã–≈’“ªÿ");
		tabhost.addTab(spec);
		
		intent.setClass(this, EmailActivity.class);
		spec=tabhost.newTabSpec("tag2");
		spec.setContent(intent);
		spec.setIndicator("” œ‰’“ªÿ");
		tabhost.addTab(spec);
		
		tabhost.setCurrentTab(0);
	}

}
