package com.bgu.cse.mobile.programming.lecture8;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class DrawableActivity extends Activity{
	
	AnimationDrawable smurf;
	boolean isStarted;
	
	public void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.drawable);

		  ImageView smurfImage = (ImageView) findViewById(R.id.smurf_image);
		  smurfImage.setBackgroundResource(R.drawable.smurf_anim);
		  smurf = (AnimationDrawable) smurfImage.getBackground();
		}

		public boolean onTouchEvent(MotionEvent event) {
		  if (event.getAction() == MotionEvent.ACTION_DOWN) {
			  if (isStarted) {
				  smurf.stop();
				  isStarted = false;
			  } else {
				  smurf.start();  
				  isStarted = true;
			  }			  
		    return true;
		  }
		  return super.onTouchEvent(event);
		}
	

}
