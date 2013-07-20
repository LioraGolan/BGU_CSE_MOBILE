package com.bgu.cse.mobile.programming.lecture8;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
    public void onStartDraw(View view){
    	Intent intent = new Intent(this, DrawableActivity.class);
    	startActivity(intent);
    }
    
    public void onStartView(View view){
    	Intent intent = new Intent(this, ViewAnimationActivity.class);
    	startActivity(intent);
    }
    
    public void onSurface(View view){
    	Intent intent = new Intent(this, SurfaceHolderAnimation.class);
    	startActivity(intent);
    }
    
    public void onLayout(View view){
    	Intent intent = new Intent(this, LayoutAnimationActivity.class);
    	startActivity(intent);
    }
}
