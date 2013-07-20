package com.bgu.cse.mobile.programming.lecture8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViewAnimationActivity extends Activity {


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_animation);
	}

	public void onInterpolators(View view){
		Intent intent = new Intent(this, Animation3.class);
		startActivity(intent);
	}

	public void onPush(View view){
		Intent intent = new Intent(this, Animation2.class);
		startActivity(intent);
	}

	public void onShake(View view){
		Intent intent = new Intent(this, Animation1.class);
		startActivity(intent);
	}

}
