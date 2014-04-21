package com.lwq.wallet.background;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.lwq.wallet.login.R;
import com.lwq.wallet.panel.AccountActivity;

public class ConsumeService extends Service{

	private static final int Notifyme=1234;  //设置通知ID
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		//开启服务
		service();
		return START_STICKY;
	}

	@SuppressLint("NewApi")
	public void service(){ 
		Intent i =new Intent(this,AccountActivity.class);	
		//设置这两个flag，就是让一个且唯一的一个activity（服务界面）运行在最前端。
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
		PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);           
        Notification myNotify = new Notification.Builder(this) 
                                .setSmallIcon(R.drawable.icon) 
                                .setTicker("产生了一笔新的消费")
                                .setContentTitle("本次共计消费:") 
                                .setContentText("5元")
                                .setContentIntent(pi) 
                                .build();  
        startForeground(Notifyme,myNotify);
	}
	
}
