package com.lwq.wallet.login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.lwq.wallet.service.registerService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegsterActivity extends Activity implements OnClickListener{

	private EditText username,password1,password2;
	private Button regsterButton;
	private TextView textview;
	private String accountuser,password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
		setContentView(R.layout.activity_regester);
		
		username=(EditText)findViewById(R.id.user);
		password1=(EditText)findViewById(R.id.password);
		password2=(EditText)findViewById(R.id.password2);
		
		regsterButton=(Button)findViewById(R.id.login);
		textview=(TextView)findViewById(R.id.accountlogin);
		
		regsterButton.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		if(!password1.getText().toString().equals(password2.getText().toString()))
		{
			Toast.makeText(this, "请输入相同的密码", Toast.LENGTH_LONG).show();
			password2.setText("");
			password1.setText("");
			password1.setFocusable(true);
		}
		else
		{
			accountuser=username.getText().toString();
			password=password1.getText().toString();
			//System.out.println(accountuser+" "+password);
			registerService as=new registerService(this);
			boolean flag=as.registerInfo(accountuser, password);
			if(flag)
			{
				Intent intent=new Intent();
				intent.setClass(this, LoginActivity.class);
				startActivity(intent);
				RegsterActivity.this.finish();
			}
			else
			{
				Toast.makeText(this, "注册失败", Toast.LENGTH_LONG).show();
				username.setText("");
				password1.setText("");
				password2.setText("");
			}
		}
	}
	
	public void switchActivity(View v)
	{
		Intent intent=new Intent();
		intent.setClass(this, LoginActivity.class);
		startActivity(intent);
		this.finish();
	}
	
}
