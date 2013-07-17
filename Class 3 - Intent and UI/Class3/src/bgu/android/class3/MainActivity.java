package bgu.android.class3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button list = (Button)findViewById(R.id.simpleList);
		list.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, SimpleListActivity.class);
				startActivity(intent);
			}
		});

		Button list2 = (Button)findViewById(R.id.simpleList2);
		list2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, SimpleListActivity2.class);
				startActivity(intent);
			}
		});

		Button customList = (Button)findViewById(R.id.customList);
		customList.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, CustomListActivity.class);
				startActivity(intent);
			}
		});

		Button xmlUi = (Button)findViewById(R.id.xmlUI);
		xmlUi.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, UIFromXMLActivity.class);
				startActivity(intent);
			}
		});

		Button codeUi = (Button)findViewById(R.id.codeUI);
		codeUi.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, UIFromCodeActivity.class );
				startActivity(intent);
			}
		});
	}


}
