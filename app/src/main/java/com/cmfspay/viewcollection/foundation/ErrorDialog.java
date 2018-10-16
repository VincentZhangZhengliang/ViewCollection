package com.cmfspay.viewcollection.foundation;


import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.cmfspay.viewcollection.R;

public class ErrorDialog extends DialogFragment {

	private static final String ARG_1 = "arg_1";
	private static final String ARG_2 = "arg_2";

	private AppCompatActivity mActivity;
	private TextView          mTvTitle;
	private TextView          mTvMessage;
	private View              mView;
	private String            mTitleStr;
	private String            mMessageStr;

	private Handler mHandler = new Handler();

	public static ErrorDialog newInstance(String title, String message) {
		ErrorDialog fragment = new ErrorDialog();
		Bundle      bundle   = new Bundle();
		bundle.putString(ARG_1, title);
		bundle.putString(ARG_2, message);
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		mActivity = (AppCompatActivity) context;
		mTitleStr = getArguments().getString(ARG_1);
		mMessageStr = getArguments().getString(ARG_2);
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setStyle(DialogFragment.STYLE_NO_TITLE, R.style.BottomDialog);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.dialog_error, container);
		initView();
		initData();
		initListener();
		return mView;
	}

	private void initData() {
		mTvTitle.setText(mTitleStr);
		mTvMessage.setText(mMessageStr);
	}

	private void initListener() {
		mHandler.postDelayed(mRunnable, 3000);
	}

	Runnable mRunnable = new Runnable() {
		@Override
		public void run() {
			dismiss();
		}
	};

	private void initView() {
		mTvTitle = mView.findViewById(R.id.tv_title);
		mTvMessage = mView.findViewById(R.id.tv_message);
	}

	@Override
	public void onStart() {
		super.onStart();
		DisplayMetrics dm = new DisplayMetrics();
		mActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		Window window = getDialog().getWindow();
		window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		setCancelable(false);
		getDialog().setCanceledOnTouchOutside(false);
		WindowManager.LayoutParams windowParams = window.getAttributes();
		windowParams.dimAmount = 0.5f;
		windowParams.gravity = Gravity.CENTER;
		windowParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
		windowParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
		window.setAttributes(windowParams);
	}

	@Override
	public void onDismiss(DialogInterface dialog) {
		super.onDismiss(dialog);
		mHandler.removeCallbacks(mRunnable);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mHandler.removeCallbacks(mRunnable);
	}

}
