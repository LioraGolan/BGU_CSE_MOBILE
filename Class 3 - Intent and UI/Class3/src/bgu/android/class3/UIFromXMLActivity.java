package bgu.android.class3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class UIFromXMLActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_xml);

		
	}
	
	public void click(View view){
		Toast.makeText(UIFromXMLActivity.this, "clicked", Toast.LENGTH_SHORT).show();
	}

}
