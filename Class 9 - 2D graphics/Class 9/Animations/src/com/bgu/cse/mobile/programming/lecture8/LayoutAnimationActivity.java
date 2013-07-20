package com.bgu.cse.mobile.programming.lecture8;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class LayoutAnimationActivity extends Activity{

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_layout);

		String[] listItems = new String[] {
				"Item 1", "Item 2", "Item 3",
				"Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9"
		};

		ArrayAdapter<String> listItemAdapter = new ArrayAdapter<String>(this
				,android.R.layout.simple_list_item_1
				,listItems);
		ListView lv = (ListView)this.findViewById(R.id.list_view);
		lv.setAdapter(listItemAdapter);		
	}

}