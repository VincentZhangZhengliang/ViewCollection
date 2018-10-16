package com.cmfspay.viewcollection.example.pieview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * @author zhang
 * @date 10/15/18
 * @desc
 */
public class PieView extends View {

	private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
			0xFFE6B800, 0xFF7CFC00};

	private Paint         mPaint;
	private int           mCenterX;
	private int           mCenterY;
	private int           mR;
	private List<PieBean> mDatas;

	private float sumValue = 0;
	private float curAngle = 0;

	public PieView(Context context) {
		this(context, null);
	}

	public PieView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initPaint();
	}

	private void initPaint() {
		mPaint = new Paint();
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(Color.GRAY);
	}

	private void initData(List<PieBean> data) {
		for (int i = 0; i < data.size(); i++) {
			PieBean pieBean = data.get(i);
			sumValue = sumValue + pieBean.getValue();
		}
		for (int i = 0; i < data.size(); i++) {
			PieBean pieBean = data.get(i);
			float   value   = pieBean.getValue();
			float   percent = value / sumValue;
			pieBean.setPrecent(percent);
			pieBean.setAngle(360 * value / sumValue);
			pieBean.setColor(mColors[i % mColors.length]);
		}
	}

	public void setData(List<PieBean> data) {
		this.mDatas = data;
		initData(mDatas);
		invalidate();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		mCenterX = w / 2;
		mCenterY = h / 2;
		mR = Math.min(mCenterX, mCenterY);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (null == mDatas || mDatas.size() == 0)   // 数据有问题 直接返回
			return;
		RectF rectF = new RectF(mCenterX - mR / 2, mCenterY - mR / 2, mCenterX + mR / 2, mCenterY + mR / 2);
		for (int i = 0; i < mDatas.size(); i++) {
			PieBean pieBean = mDatas.get(i);
			mPaint.setColor(pieBean.getColor());
			mPaint.setStrokeWidth(1);
			mPaint.setStyle(Paint.Style.FILL);
			canvas.drawArc(rectF, curAngle, pieBean.getAngle(), true, mPaint);
			double tempY = mR / 2 * Math.sin((curAngle + pieBean.getAngle()) / 2);
			double tempX = mR / 2 * Math.cos((curAngle + pieBean.getAngle()) / 2);
			mPaint.setStrokeWidth(10);
			mPaint.setColor(Color.BLACK);
			canvas.drawPoint((float) tempX + mCenterX, (float) tempY + mCenterY, mPaint);
			curAngle += pieBean.getAngle();
		}
	}

}
