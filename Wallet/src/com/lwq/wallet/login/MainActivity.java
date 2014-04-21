package com.lwq.wallet.login;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

	private static final String SHAREDPREFERENCES_NAME = "first";
	public Intent intent;
	public Timer timer=new Timer();
	public TimerTask timertask;
	public boolean flag=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		intent=new Intent();
		timertask=new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(!flag)
				{
					SharedPreferences preferences = getSharedPreferences(  
			                SHAREDPREFERENCES_NAME, MODE_PRIVATE);
					Boolean isFirst=preferences.getBoolean("isFirstIn", true);
					flag=true;
					if(isFirst)
					{
						intent.setClass(MainActivity.this, AnimationActivity.class);
						startActivity(intent);
						MainActivity.this.finish();
					}
					else
					{
						intent.setClass(MainActivity.this, LoginActivity.class);
						startActivity(intent);
						MainActivity.this.finish();
					}
				}
			}
		};
		timer.schedule(timertask, 1500, 1500);  //间隔1.5s后跳入新的Activity
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
