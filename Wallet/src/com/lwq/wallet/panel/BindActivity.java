package com.lwq.wallet.panel;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lwq.wallet.login.R;

public class BindActivity extends Activity implements OnClickListener{

	private EditText username,id,bankid,password,confirmnum,phonenum;
	private TextView tv;
	private Button getconfirm,submit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bind);
		
		username=(EditText)findViewById(R.id.bind_name);
		id=(EditText)findViewById(R.id.bind_id);
		bankid=(EditText)findViewById(R.id.bind_bank);
		phonenum=(EditText)findViewById(R.id.bind_phone);
		password=(EditText)findViewById(R.id.bind_password);
		confirmnum=(EditText)findViewById(R.id.bind_confirm);
		
		tv=(TextView)findViewById(R.id.cardservice);
		tv.setText(Html.fromHtml("<u>《中软卡服务协议》</u>"));
		tv.setOnClickListener(this);
		
		getconfirm=(Button)findViewById(R.id.bind_get_confirm);
		submit=(Button)findViewById(R.id.bindbutton);
		getconfirm.setOnClickListener(this);
		submit.setOnClickListener(this);
	}
	
	public void onClick(View v) {
		String username_1,id_1,bankid_1,password_1,confirm_1;
		String phone;
		if(v.getId()==R.id.bind_get_confirm)
		{
			//完成获取验证码的功能
			//这里模拟验证码就是存在的并且可以验证成功
			confirm_1="123456";
		}
		else if(v.getId()==R.id.cardservice){
			AlertDialog.Builder ad=new AlertDialog.Builder(this);
			ad.setTitle("中软卡服务协议");
			ad.setMessage("测试");
			ad.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
				}
			});
			ad.show();
		}
		else if(v.getId()==R.id.bindbutton)
		{
			username_1=username.getText().toString();
			id_1=id.getText().toString();
			bankid_1=bankid.getText().toString();
			password_1=password.getText().toString();
			confirm_1=confirmnum.getText().toString();
			phone=phonenum.getText().toString();
			if(username_1.equals("")){
				Toast.makeText(this, "用户名不能为空！", Toast.LENGTH_SHORT).show();
				username.setFocusable(true);
				username.setFocusableInTouchMode(true);
			}
			else if(id_1.equals("")){
				Toast.makeText(this, "身份证号不能为空！", Toast.LENGTH_SHORT).show();
				id.setFocusable(true);
			}
			else if(bankid_1.equals("")){
				Toast.makeText(this, "银行卡号不能为空", Toast.LENGTH_SHORT).show();
				bankid.setFocusable(true);
			}
			else if(phone.equals("")){
				Toast.makeText(this, "手机号不能为空！", Toast.LENGTH_SHORT).show();
				phonenum.setFocusable(true);
			}
			else if(confirm_1.equals("")){
				Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
				confirmnum.setFocusable(true);
			}
			else if(password_1.equals("")){
				Toast.makeText(this, "密码不能为空！", Toast.LENGTH_SHORT).show();
				password.setFocusable(true);
			}
			else
			{
				//将信息送至服务器，调用接口进行判断
				if(true)  //如果判断成功进行绑定后， 返回
				{
					Intent intent=new Intent();
					Bundle bundle=new Bundle();
					bundle.putString("username", username_1);
					bundle.putString("bankid", bankid_1);
					intent.putExtras(bundle);
					setResult(RESULT_OK, intent);
					this.finish();
				}
				else{
					AlertDialog.Builder ad=new AlertDialog.Builder(this).
							setTitle("提醒")
							.setMessage("绑定失败")
							.setPositiveButton("确定", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface arg0, int arg1) {
									// TODO Auto-generated method stub
									
								}
							});
					ad.show();
				}
			}
		}
		
	}

}
