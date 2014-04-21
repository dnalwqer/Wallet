package com.lwq.wallet.login;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.lwq.wallet.adapter.ViewPageAdapter;

public class AnimationActivity extends Activity implements OnPageChangeListener{
	private ViewPager viewpager;
	private View page1,page2,page3;
	private ArrayList<View> views;
	private int currIndex=0;
	private ImageView mPage0,mPage1,mPage2;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); //设置无标题栏
		setContentView(R.layout.activity_animation);
		viewpager=(ViewPager)findViewById(R.id.viewpager);
		viewpager.setOnPageChangeListener(this);
		
		mPage0=(ImageView)findViewById(R.id.page0);
		mPage1=(ImageView)findViewById(R.id.page1);
		mPage2=(ImageView)findViewById(R.id.page2);
		
		LayoutInflater li=getLayoutInflater().from(this);
		View page1=li.inflate(R.layout.page_1,null);
		View page2=li.inflate(R.layout.page_2, null);
		View page3=li.inflate(R.layout.page_3, null);
		
		views=new ArrayList<View>();
		views.add(page1);
		views.add(page2);
		views.add(page3);
		
		viewpager.setAdapter(new ViewPageAdapter(views, this));
		viewpager.setOnPageChangeListener(this);
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		  Animation animation = null;//声明动画对象  
          switch (arg0) {  
          case 0: //页面一             
              mPage0.setImageDrawable(getResources().getDrawable(R.drawable.dot1));//进入第一个导航页面，小圆点为选中状态，下一个页面的小圆点是未选中状态。  
              mPage1.setImageDrawable(getResources().getDrawable(R.drawable.dot2));  
              if (currIndex == arg0+1) {  
                  animation = new TranslateAnimation(arg0+1, arg0, 0, 0);//圆点移动效果动画，从当前View移动到下一个View  
              }   
              break;  
          case 1: //页面二  
              mPage1.setImageDrawable(getResources().getDrawable(R.drawable.dot1));//当前View  
              mPage0.setImageDrawable(getResources().getDrawable(R.drawable.dot2));//上一个View  
              mPage2.setImageDrawable(getResources().getDrawable(R.drawable.dot2));//下一个View  
              if (currIndex == arg0-1) {//如果滑动到上一个View  
                  animation = new TranslateAnimation(arg0-1, arg0, 0, 0); //圆点移动效果动画，从当前View移动到下一个View  

                    
              } else if (currIndex == arg0+1) {//圆点移动效果动画，从当前View移动到下一个View，下同。  

                  animation = new TranslateAnimation(arg0+1, arg0, 0, 0);  
              }  
              break;  
          case 2: //页面三  
              mPage2.setImageDrawable(getResources().getDrawable(R.drawable.dot1));  
              mPage1.setImageDrawable(getResources().getDrawable(R.drawable.dot2));  
              if (currIndex == arg0-1) {  
                  animation = new TranslateAnimation(arg0-1, arg0, 0, 0);  
              } 
              break;  
          }
          currIndex = arg0;//设置当前View  
          animation.setFillAfter(true);// True:设置图片停在动画结束位置  
          animation.setDuration(300);//设置动画持续时间  
    }  
}

