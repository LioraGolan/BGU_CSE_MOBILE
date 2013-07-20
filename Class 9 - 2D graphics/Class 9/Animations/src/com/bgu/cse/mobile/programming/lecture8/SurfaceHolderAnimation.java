package com.bgu.cse.mobile.programming.lecture8;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class SurfaceHolderAnimation extends Activity {
	
	SurfaceHolderView surfaceHolderView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.surfaceHolderView = new SurfaceHolderView(this);
		this.setContentView(this.surfaceHolderView);
		
		this.surfaceHolderView.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				((SurfaceHolderView)v).changeSizeAndSpeed();
			}
		});
	}
}