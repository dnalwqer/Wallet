package com.lwq.wallet.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends Activity implements OnClickListener{

	private Button button;
	private EditText email;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email);
		
		button=(Button)findViewById(R.id.emailbutton);
		button.setOnClickListener(this);
		
		email=(EditText)findViewById(R.id.email_input);
	}
	@Override
	public void onClick(View v) {
		String mail=email.getText().toString();
		if(v.getId()==R.id.emailbutton)
		{
			if(mail.equals(""))
			{
				AlertDialog.Builder ab=new AlertDialog.Builder(this).setTitle("提示")
						.setMessage("请输入邮箱地址")
						.setPositiveButton("确定", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface arg0, int arg1) {		
								email.setFocusable(true);
							}
						});
				ab.show();
			}
			else
			{
				//发送邮件
			}
		}
	}
}
