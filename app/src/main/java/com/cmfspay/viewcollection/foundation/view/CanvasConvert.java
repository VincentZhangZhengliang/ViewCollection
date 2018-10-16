package com.cmfspay.viewcollection.foundation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author zhang
 * @date 10/15/18
 * @desc
 */
public class CanvasConvert extends View {

	private Paint mPaint;
	private int   mCenterX;
	private int   mCenterY;

	public CanvasConvert(Context context) {
		this(context, null);
	}

	public CanvasConvert(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CanvasConvert(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	private void init() {
		mPaint = new Paint();
		mPaint.setColor(Color.BLACK);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		mCenterX = w / 2;
		mCenterY = h / 2;
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		translate(canvas);
	}

	private void translate(Canvas canvas) {
		canvas.drawLine(5, 5, mCenterX * 2, 5, mPaint);
		canvas.drawLine(5, 5, 5, mCenterY * 2, mPaint);
		canvas.drawCircle(200, 200, 100, mPaint);
		canvas.translate(100, 100);
		mPaint.setColor(Color.RED);
		canvas.drawCircle(200, 200, 100, mPaint);

	}

}
