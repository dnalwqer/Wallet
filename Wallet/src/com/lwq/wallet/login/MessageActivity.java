package com.lwq.wallet.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MessageActivity extends Activity implements OnClickListener{

	private EditText phone,confirm;
	private Button button1,button2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);
		
		phone=(EditText)findViewById(R.id.message_phone);
		confirm=(EditText)findViewById(R.id.message_confirm);
		button2=(Button)findViewById(R.id.message_button);
		button1=(Button)findViewById(R.id.message_get_confirm);
		button2.setOnClickListener(this);
		button1.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		String phonenum,confirmnumber;
		phonenum=phone.getText().toString();
		confirmnumber=confirm.getText().toString();
		if(v.getId()==R.id.message_get_confirm){
			if(phonenum.equals("")){
				showDialog("请输入手机号");
			}
			else{
				
			}
		}
		if(v.getId()==R.id.message_button){
			if(phonenum.equals("")){
				showDialog("请输入手机号");
			}
			else if(confirmnumber.equals(""))
				showDialog("请输入验证码");
			else{
				if(true)//验证失败
					showDialog("找回短信已发送至您的手机");
				else
					showDialog("验证码错误");
			}
		}
	}

	public void showDialog(String message){
		AlertDialog.Builder ab=new AlertDialog.Builder(this).setMessage(message)
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						
					}
				});
		ab.show();
	}
}
