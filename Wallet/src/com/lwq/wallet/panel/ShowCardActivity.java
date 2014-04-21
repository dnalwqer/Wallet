package com.lwq.wallet.panel;

import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.lwq.wallet.adapter.CardAdapter;
import com.lwq.wallet.login.R;
import com.lwq.wallet.service.RecordService;
import com.lwq.wallet.service.CardItemService;
import com.lwq.wallet.utils.CardItem;
import com.lwq.wallet.utils.FileUtils;

public class ShowCardActivity extends Activity implements OnClickListener,OnItemLongClickListener{

	private static final int CREDIT_CARD_REQUEST = 0;
	private static final String cardlist="cardlist";
	private ImageButton addcard;
	private ListView listview;
	private ArrayList<CardItem> list=new ArrayList<CardItem>();
	private CardAdapter ca;
	private CardItemService as;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_showcard);
		
		//处理listview
		listview=(ListView)findViewById(R.id.cardlist);
		
		as=new CardItemService(this);
		list=as.getCardList();
		ca=new CardAdapter(ShowCardActivity.this, list);
		initlist(list);
		listview.setOnItemLongClickListener(this);
		//处理imagebutton
		addcard=(ImageButton)findViewById(R.id.addcard);
		addcard.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		Intent intent=new Intent();
		intent.setClass(this, BindActivity.class);
		startActivityForResult(intent, CREDIT_CARD_REQUEST);
	}
	//回调函数，返回从BindActivity传来的Intent
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch(requestCode){
			case CREDIT_CARD_REQUEST:
				if(resultCode==Activity.RESULT_OK){
					Bundle bundle=data.getExtras();
					String username=bundle.getString("username");
					String bankid=bundle.getString("bankid");
					CardItem card=new CardItem();
					card.setItem(bankid, username);
					list.add(card);
					initlist(list);
					//将list内容写入到文件中
					try {
						OutputStreamWriter os=new OutputStreamWriter(openFileOutput(cardlist, MODE_APPEND));
						os.write(card.getUsername()+"\t"+card.getBankid()+"\r\n");
						os.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		}
	}
	//初始化卡片列表
	public void initlist(ArrayList<CardItem> list){
		ca.notifyDataSetChanged();
		listview.setAdapter(ca);
	}

	//长按钮时的处理
	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		final int position=arg2;
		AlertDialog.Builder ab=new AlertDialog.Builder(this)
			.setTitle("提示")
			.setMessage("是否要解除对该卡的绑定？")
			.setPositiveButton("取消", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
				}
			})
			.setNegativeButton("确定", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					//向服务器发送删除请求
					if(true){
						list.remove(position);
						initlist(list);
						try {
							OutputStreamWriter os=new OutputStreamWriter(openFileOutput(cardlist, MODE_PRIVATE));
							for(int i=0;i<list.size();i++){
								os.write(list.get(i).getUsername()+"\t"+list.get(i).getBankid()+"\r\n");
							}
							os.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});
		ab.show();
		return false;
	}

}
