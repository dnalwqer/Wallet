package com.lwq.wallet.inter;

import java.util.Vector;

public interface infoInterface {
	public boolean changePass(String oldpassword,String newpassword);  //更改密码请求
	public boolean resetInfo(String user,String phone,String email);   //重置用户信息请求
	public Vector<String> getInfo();    //获取用户信息
}
