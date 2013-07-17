package bgu.android.class3;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SimpleListActivity extends ListActivity {

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    //we will use the default layout of ListActivity
	    //setContentView(...);
	
		String[] content = new String[]{"USA", "Israel", "Spain", "Jordan", "Italy"};
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
           		R.layout.simple_list_item, /*row layout*/
           		R.id.ListTextView, /*content text view in the row*/
           		content);  
        
        setListAdapter(adapter);		
	}
	
	@Override
	protected void onListItemClick(ListView parent, View v, int position,
			long id){		
		Log.d("class3", parent.getAdapter().getItem(position)+ " was selected"); 
	}

}
