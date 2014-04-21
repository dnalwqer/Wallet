package com.lwq.wallet.login;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.http.util.EncodingUtils;

import com.lwq.wallet.background.ConsumeService;
import com.lwq.wallet.panel.PanelActivity;
import com.lwq.wallet.service.loginService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener{

	private EditText username,password;
	private Button login;
	private TextView forgetPassword;
	private CheckBox rememberAccount;
	private String userinfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
		setContentView(R.layout.activity_login);
		username=(EditText)findViewById(R.id.user_1);
		password=(EditText)findViewById(R.id.pass_1);
		
		login=(Button) findViewById(R.id.login);
		login.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		String user=username.getText().toString();
		String pass=password.getText().toString();
		
		loginService as=new loginService(this);
		boolean flag=as.checkInfo(user, pass);
		System.out.println(flag);
		if(flag)
		{
			Intent intent=new Intent();
			intent.setClass(this, PanelActivity.class);
			startActivity(intent);
			
			startService(new Intent(this,ConsumeService.class));
			this.finish();
		}
		else
		{
			Toast.makeText(this, "µÇÂ½Ê§°Ü", Toast.LENGTH_LONG).show();
			username.setText("");
			password.setText("");
		}
	}

	public void forgetPass(View v){
		Intent intent=new Intent();
		intent.setClass(this, ForgetActivity.class);
		startActivity(intent);
	}

}
