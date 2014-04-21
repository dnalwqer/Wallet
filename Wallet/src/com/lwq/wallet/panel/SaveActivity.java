package com.lwq.wallet.panel;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.lwq.wallet.login.R;
import com.lwq.wallet.save.SaveAccountActivity;
import com.lwq.wallet.save.SaveCardActivity;

public class SaveActivity extends TabActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_save);
		
		TabHost tabhost=getTabHost();
		TabHost.TabSpec spec=null;
		
		Intent intent=new Intent();
		intent.setClass(this, SaveCardActivity.class);
		spec=tabhost.newTabSpec("tag1");
		spec.setIndicator("充值到中软卡");
		spec.setContent(intent);
		tabhost.addTab(spec);
		
		intent.setClass(this, SaveAccountActivity.class);
		spec=tabhost.newTabSpec("tag2");
		spec.setIndicator("充值到中软账户");
		spec.setContent(intent);
		tabhost.addTab(spec);
		
		
	}

}
