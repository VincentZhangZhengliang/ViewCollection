package com.cmfspay.viewcollection.foundation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author zhang
 * @date 10/12/18
 * @desc
 */
public class BasicShapeView extends View {

	private Paint mPaint;
	private int   mCenterX;
	private int   mCenterY;

	public BasicShapeView(Context context) {
		this(context, null);
	}

	public BasicShapeView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public BasicShapeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	private void init() {
		mPaint = new Paint();
		mPaint.setColor(Color.GREEN);
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setStrokeWidth(10f);
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
		drawPoint(canvas);
		drawLine(canvas);
		drawRect(canvas);
		drawRoundRect(canvas);
		drawOval(canvas);
		drawCircle(canvas);
	}

	private void drawCircle(Canvas canvas) {
		canvas.drawCircle(240, 100, 50, mPaint);
	}

	private void drawOval(Canvas canvas) {
		mPaint.setColor(Color.GRAY);
		mPaint.setStyle(Paint.Style.FILL);
		RectF rectF = new RectF(80, 540, 600, 860);
		canvas.drawOval(rectF, mPaint);
	}

	private void drawRoundRect(Canvas canvas) {
		RectF rectF = new RectF(40, 500, 640, 900);
		canvas.drawRoundRect(rectF, 20, 20, mPaint);
	}

	private void drawRect(Canvas canvas) {
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(Color.BLUE);
		canvas.drawRect(40, 40, 80, 80, mPaint);
		canvas.drawRect(85, 85, 160, 160, mPaint);
		canvas.drawRect(165, 165, 320, 320, mPaint);
		canvas.drawRect(325, 325, 480, 480, mPaint);
	}

	private void drawLine(Canvas canvas) {
		mPaint.setStrokeWidth(5f);
		mPaint.setColor(Color.RED);
		canvas.drawLine(40, 40, 80, 80, mPaint);
		canvas.drawLine(85, 85, 160, 160, mPaint);
		canvas.drawLine(165, 165, 320, 320, mPaint);
		canvas.drawLine(325, 325, 480, 480, mPaint);
	}

	private void drawPoint(Canvas canvas) {
		canvas.drawPoint(40, 40, mPaint);
		canvas.drawPoint(80, 80, mPaint);
		canvas.drawPoint(160, 160, mPaint);
		canvas.drawPoint(320, 320, mPaint);
	}

}
