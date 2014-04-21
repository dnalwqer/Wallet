package com.lwq.wallet.panel;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;

import com.lwq.wallet.adapter.PanelAdapter;
import com.lwq.wallet.login.R;
import com.lwq.wallet.utils.PanelItem;

public class PanelActivity extends Activity implements OnItemClickListener{

	private String[] name={"圈存","查询","绑定银行卡","个人"};
	private int [] icon={R.drawable.save,R.drawable.consult,R.drawable.bind,R.drawable.info};
	private ArrayList<PanelItem> a=new ArrayList<PanelItem>();
	private int []color={Color.rgb(241,196,15),Color.rgb(235,148,52),Color.rgb(77,184, 130),Color.rgb(173,208,78)};
	private Class<?> [] panel_activity={SaveActivity.class, ConsultActivity.class, ShowCardActivity.class,InfoActivity.class};
	
	private GridView list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_panel);
		
		for(int i=0;i<name.length;i++){
			PanelItem item=new PanelItem();
			item.setTitle(icon[i], name[i],color[i]);
			a.add(item);
		}
		
		list=(GridView)findViewById(R.id.functionlist);
		list.setAdapter(new PanelAdapter(this,a));
		list.setOnItemClickListener(this);
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// 如果是返回键,直接返回到桌面
		if (keyCode == KeyEvent.KEYCODE_BACK)
			if (keyCode == KeyEvent.KEYCODE_BACK) {

				new AlertDialog.Builder(this).setTitle("你确定要退出当前程序吗？")
						.setNegativeButton("取消",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int which) {
									}
								}).setPositiveButton("确定",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
										android.os.Process.killProcess(android.os.Process.myPid());
									}
								}).show();
				return true;
			} else {
				return super.onKeyDown(keyCode, event);
			}

		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent intent=new Intent();
		intent.setClass(this, panel_activity[arg2]);
		startActivity(intent);
	}

}
