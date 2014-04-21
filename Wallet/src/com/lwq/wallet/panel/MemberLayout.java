package com.lwq.wallet.panel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class MemberLayout extends LinearLayout {
	
	private final static int Round=10;
	
	public MemberLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public MemberLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void dispatchDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.dispatchDraw(canvas);
		canvas.drawColor(android.graphics.Color.TRANSPARENT);
		Paint paint=new Paint();
		paint.setAntiAlias(true);
		paint.setColor(Color.TRANSPARENT);
		
		RectF f= new RectF(getPaddingLeft(),getPaddingTop(),
				getWidth()-getPaddingRight(), getHeight()-getPaddingBottom());
		canvas.drawRoundRect(f,Round,Round, paint);
		paint.setColor(Color.DKGRAY);
		paint.setStyle(Paint.Style.STROKE);
		canvas.drawRoundRect(f,Round,Round, paint);
		
	}

}
