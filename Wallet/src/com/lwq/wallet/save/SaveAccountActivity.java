package com.lwq.wallet.save;

import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lwq.wallet.login.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

public class SaveAccountActivity extends Activity implements OnItemSelectedListener{

	private static final String accountRecord="accountRecord";
	private Spinner spinner;
	private String []ways;
	private LinearLayout layout1,layout3;
	private ScrollView layout2;
	
	//处理layout1中组件
	private EditText quick_money,quick_pass;
	private Button button;
	
	//处理layout2中组件
	private EditText bank_money,bank_userid,bank_user,bank_id,phone,confirm,bank_pass;
	private Spinner bank;
	private Button button2,buttonconfirm;
	
	//处理layout3中组件
	private EditText account_money,account_pass;
	private Button button3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_saveaccount);
		
		initlayout();
		initspinner();
	}
	
	public void initlayout(){
		layout1=(LinearLayout)findViewById(R.id.saveaccount_layout1);
		layout2=(ScrollView)findViewById(R.id.saveaccount_layout2);
		layout3=(LinearLayout)findViewById(R.id.saveaccount_layout3);
		layout1.setVisibility(View.VISIBLE);
		layout2.setVisibility(View.GONE);
		layout3.setVisibility(View.GONE);
	}
	public void initspinner(){
		spinner=(Spinner)findViewById(R.id.spinner);
		ways=getResources().getStringArray(R.array.saveways2);
		ArrayAdapter<String> a=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ways);
		spinner.setAdapter(a);
		spinner.setOnItemSelectedListener(this);
	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		switch(arg2){
		case 0:
			initlayout1();
			break;
		case 1:
			initlayout2();
			break;
		case 2:
			initlayout3();
			break;
		}
	}
	
	public void onNothingSelected(AdapterView<?> arg0) {
	}

	public void initlayout1(){
		layout1.setVisibility(View.VISIBLE);
		layout2.setVisibility(View.GONE);
		layout3.setVisibility(View.GONE);
		quick_money=(EditText)findViewById(R.id.saveaccountmoney);
		quick_pass=(EditText)findViewById(R.id.saveaccountpassword);
		button=(Button)findViewById(R.id.saveaccountbutton);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String quickpay_money=quick_money.getText().toString();
				String quickpay_pass=quick_pass.getText().toString();
				if(quickpay_money.equals("")){
					Toast.makeText(SaveAccountActivity.this, "请输入支付金额", Toast.LENGTH_SHORT).show();
					quick_money.setFocusable(true);
				}
				else if(quickpay_pass.equals("")){
					Toast.makeText(SaveAccountActivity.this, "请输入支付密码", Toast.LENGTH_SHORT).show();
					quick_pass.setFocusable(true);
				}
				else{
					//调用接口认证
					boolean flag=true;
					if(flag){
						showdialog("支付成功");
						try {
							OutputStreamWriter os=new OutputStreamWriter(openFileOutput(accountRecord, MODE_APPEND));
							os.write("快捷支付转入:"+"\t"+quickpay_money+"\t"+getTime()+"\r\n");
							os.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else{
						showdialog("支付失败");				
					}
					quick_pass.setText("");
					quick_money.setText("");
				}
			}
		});
	}
	public void initlayout2(){
		layout2.setVisibility(View.VISIBLE);
		layout1.setVisibility(View.GONE);
		layout3.setVisibility(View.GONE);
		bank_money=(EditText)findViewById(R.id.saveaccountbankmoney);
		bank=(Spinner)findViewById(R.id.saveaccountbank);
		bank_user=(EditText)findViewById(R.id.saveaccountuser);
		bank_userid=(EditText)findViewById(R.id.saveaccountid);
		bank_id=(EditText)findViewById(R.id.saveaccountbankid);
		phone=(EditText)findViewById(R.id.saveaccountphone);
		confirm=(EditText)findViewById(R.id.saveaccountconfirm);
		bank_pass=(EditText)findViewById(R.id.saveaccountbankpassword);
		button2=(Button)findViewById(R.id.saveaccountbankbutton);
		
		String bankname[]=getResources().getStringArray(R.array.bankname);
		bank.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,bankname));
		final mySpinner myspinner=new mySpinner(this,bankname);
		bank.setOnItemSelectedListener(myspinner);
		buttonconfirm=(Button)findViewById(R.id.saveaccountgetconfirm);
		buttonconfirm.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//获取验证码
			}
		});
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String money=bank_money.getText().toString();
				String user=bank_user.getText().toString();
				String userid=bank_userid.getText().toString();
				String id=bank_id.getText().toString();
				String phonenum=phone.getText().toString();
				String confirmnu=confirm.getText().toString();
				String pass=bank_pass.getText().toString();
				String choosebank=myspinner.getBank();
				if(money.equals("")){
					Toast.makeText(SaveAccountActivity.this, "支付金额不能为空", Toast.LENGTH_SHORT).show();
					bank_money.setFocusable(true);
				}
				else if(choosebank.equals("")){
					Toast.makeText(SaveAccountActivity.this, "请选择银行", Toast.LENGTH_SHORT).show();
				}
				else if(user.equals("")){
					Toast.makeText(SaveAccountActivity.this, "姓名不能为空", Toast.LENGTH_SHORT).show();
					bank_user.setFocusable(true);
				}
				else if(userid.equals("")){
					Toast.makeText(SaveAccountActivity.this, "身份证号不能为空", Toast.LENGTH_SHORT).show();
					bank_userid.setFocusable(true);
				}
				else if(id.equals("")){
					Toast.makeText(SaveAccountActivity.this, "卡号不能为空", Toast.LENGTH_SHORT).show();
					bank_id.setFocusable(true);
				}
				else if(phonenum.equals("")){
					Toast.makeText(SaveAccountActivity.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
					phone.setFocusable(true);
				}
				else if(confirmnu.equals("")){
					Toast.makeText(SaveAccountActivity.this, "验证码不能为空", Toast.LENGTH_SHORT).show();
					confirm.setFocusable(true);
				}
				else if(pass.equals("")){
					Toast.makeText(SaveAccountActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
					bank_pass.setFocusable(true);
				}
				else{
					//调用接口判断
					boolean flag=true;
					if(flag){
						showdialog("支付成功");
						try {
							OutputStreamWriter os=new OutputStreamWriter(openFileOutput(accountRecord, MODE_APPEND));
							os.write(choosebank+"网银转入:"+"\t"+money+"\t"+getTime()+"\r\n");
							os.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					else{
						showdialog("支付失败");	
					}
					bank_money.setText("");
					bank_user.setText("");
					bank_userid.setText("");
					bank_id.setText("");
					phone.setText("");
					confirm.setText("");
					bank_pass.setText("");
				}
			}
		});
	}
	
	public void initlayout3(){
		layout3.setVisibility(View.VISIBLE);
		layout2.setVisibility(View.GONE);
		layout1.setVisibility(View.GONE);
		account_money=(EditText)findViewById(R.id.saveaccountaccountmoney);
		account_pass=(EditText)findViewById(R.id.saveaccountaccountpassword);
		button3=(Button)findViewById(R.id.saveaccountaccountbutton);
		button3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				String money=account_money.getText().toString();
				String password=account_pass.getText().toString();
				if(money.equals("")){
					Toast.makeText(SaveAccountActivity.this, "请输入卡号", Toast.LENGTH_SHORT).show();
					account_money.setFocusable(true);
				}
				else if(password.equals("")){
					Toast.makeText(SaveAccountActivity.this, "请输入支付密码", Toast.LENGTH_SHORT).show();
					account_pass.setFocusable(true);
				}
				else{
					//调用接口认证
					boolean flag=true;
					if(flag){
						showdialog("支付成功");
						try {
							OutputStreamWriter os=new OutputStreamWriter(openFileOutput(accountRecord, MODE_APPEND));
							os.write("预付卡支付转入:"+"\t"+"30"+"\t"+getTime()+"\r\n");
							os.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else{
						showdialog("支付失败");				
					}
					account_pass.setText("");
					account_money.setText("");
				}
			}
		});
	}
	public void showdialog(String title){
		AlertDialog.Builder ab=new AlertDialog.Builder(this)
			.setTitle("提示")
			.setTitle(title)
			.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface arg0, int arg1) {
				}
			});
		ab.show();
	}
	
	public String getTime(){
		SimpleDateFormat sdf=new SimpleDateFormat("MM-dd");
		return sdf.format(new Date());
	}
}
