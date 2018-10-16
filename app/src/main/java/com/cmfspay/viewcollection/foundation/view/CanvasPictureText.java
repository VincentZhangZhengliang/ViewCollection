package com.cmfspay.viewcollection.foundation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author zhang
 * @date 10/16/18
 * @desc
 */
public class CanvasPictureText extends View {

	private Paint           mPaint;
	private Picture         mPicture;
	private PictureDrawable mPictureDrawable;

	public CanvasPictureText(Context context) {
		this(context, null);
	}

	public CanvasPictureText(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CanvasPictureText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	private void init() {
		mPaint = new Paint();
		mPicture = new Picture();
		mPictureDrawable = new PictureDrawable(mPicture);
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
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		mPicture.beginRecording(500, 500);
		canvas.drawCircle(100, 100, 50, mPaint);
		mPicture.endRecording();
		mPictureDrawable.setBounds(0, 0, 250, 250);
		mPictureDrawable.draw(canvas);
	}

}
