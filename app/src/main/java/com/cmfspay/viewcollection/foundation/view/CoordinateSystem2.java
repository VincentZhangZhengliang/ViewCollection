package com.cmfspay.viewcollection.foundation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

/**
 * @author zhang
 * @date 10/10/2018
 * @desc
 */
class CoordinateSystem2 extends View {

	private int   mCenterX;
	private int   mCenterY;
	private Paint paint;

	private Context mContext;
	private int     screenWidth;
	private int     screenHeight;

	public CoordinateSystem2(Context context) {
		this(context, null);
	}

	public CoordinateSystem2(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CoordinateSystem2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mContext = context;
		initPaint();
	}

	private void initPaint() {
		paint = new Paint();
		paint.setColor(Color.RED);
		paint.setStrokeWidth(5);
		WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
		screenWidth = wm.getDefaultDisplay().getWidth();
		screenHeight = wm.getDefaultDisplay().getHeight();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		mCenterX = w / 2;   //中心点x坐标
		mCenterY = h / 2;   //中心点y坐标
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		drawCoordinateSystem(canvas);
		drawParentView(canvas);
		drawChildView(canvas);
		drawColor(canvas);
	}

	private void drawColor(Canvas canvas) {

	}

	private void drawChildView(Canvas canvas) {
		paint.setColor(Color.BLUE);
		canvas.drawRect(mCenterX - mCenterX / 4, mCenterY - mCenterY / 4, mCenterX + mCenterX / 4, mCenterY + mCenterY / 4, paint);

		canvas.drawLine(mCenterX * 3 / 4, mCenterY / 2, mCenterX * 3 / 4, mCenterY * 3 / 4, paint);
		canvas.drawLine(mCenterX / 2, mCenterY * 3 / 4, mCenterX * 3 / 4, mCenterY * 3 / 4, paint);

		canvas.drawLine(mCenterX / 2, mCenterY * 3 / 4, mCenterX / 2 + 12, mCenterY * 3 / 4 - 12, paint);
		canvas.drawLine(mCenterX / 2, mCenterY * 3 / 4, mCenterX / 2 + 12, mCenterY * 3 / 4 + 12, paint);

		canvas.drawLine(mCenterX * 3 / 4, mCenterY / 2, mCenterX * 3 / 4 - 12, mCenterY / 2 + 12, paint);
		canvas.drawLine(mCenterX * 3 / 4, mCenterY / 2, mCenterX * 3 / 4 + 12, mCenterY / 2 + 12, paint);

		paint.setTextSize(40);
		paint.measureText("getTop()");
		Paint.FontMetrics fontMetrics = paint.getFontMetrics();
		float             height      = fontMetrics.bottom - fontMetrics.top;
		canvas.drawText("getTop()", mCenterX / 2 + 25, mCenterY / 4 + height / 22, paint);

		float             width        = paint.measureText("getLeft()");
		Paint.FontMetrics fontMetrics1 = paint.getFontMetrics();
		float             height1      = fontMetrics1.bottom - fontMetrics1.top;
		canvas.drawText("getLeft()", mCenterX / 4 - width / 2, mCenterY / 2 - height1 / 2, paint);

	}

	private void drawParentView(Canvas canvas) {

		canvas.drawRect(mCenterX - mCenterX / 2, mCenterY - mCenterY / 2, mCenterX + mCenterX / 2, mCenterY + mCenterY / 2, paint);
		canvas.drawLine(mCenterX / 2, 0, mCenterX / 2, mCenterY / 2, paint);
		canvas.drawLine(0, mCenterY / 2, mCenterX / 2, mCenterY / 2, paint);

		canvas.drawLine(mCenterX / 2, 0, mCenterX / 2 - 25, 25, paint);
		canvas.drawLine(mCenterX / 2, 0, mCenterX / 2 + 25, 25, paint);

		canvas.drawLine(0, mCenterY / 2, 25, mCenterY / 2 - 25, paint);
		canvas.drawLine(0, mCenterY / 2, 25, mCenterY / 2 + 25, paint);

		paint.setTextSize(40);
		paint.measureText("getTop()");
		Paint.FontMetrics fontMetrics = paint.getFontMetrics();
		float             height      = fontMetrics.bottom - fontMetrics.top;
		canvas.drawText("getTop()", mCenterX / 2 + 25, mCenterY / 4 + height / 22, paint);

		float             width        = paint.measureText("getLeft()");
		Paint.FontMetrics fontMetrics1 = paint.getFontMetrics();
		float             height1      = fontMetrics1.bottom - fontMetrics1.top;
		canvas.drawText("getLeft()", mCenterX / 4 - width / 2, mCenterY / 2 - height1 / 2, paint);

	}

	/**
	 * 画坐标系
	 *
	 * @param canvas
	 */
	private void drawCoordinateSystem(Canvas canvas) {
		canvas.drawLine(0, 0, mCenterX * 2, 0, paint);
		canvas.drawLine(0, 0, 0, mCenterY * 2, paint);
		canvas.drawLine(mCenterX * 2, 0, mCenterX * 2 - 25, 25, paint);
		canvas.drawLine(0, mCenterY * 2, 25, mCenterY * 2 - 25, paint);

		//获取文字高度 通过FontMetrics的 bottom 和 top差 获取
		//获取文字宽度 measureText会加上文字周边的空隙  getTextBounds 获取的是无限靠近文字的宽度
//		paint.measureText("(0,0)")
		paint.setTextSize(60);
		paint.measureText("(0,0)");
		Paint.FontMetrics fontMetrics = paint.getFontMetrics();
		float             height      = fontMetrics.bottom - fontMetrics.top;
		Rect              rect        = new Rect();
		paint.getTextBounds("(0,0)", 0, "(0,0)".length(), rect);
		canvas.drawText("(0,0)", 20, height, paint);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
	}

}
