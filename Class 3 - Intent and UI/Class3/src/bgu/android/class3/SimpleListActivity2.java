package bgu.android.class3;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class SimpleListActivity2 extends ListActivity {

	
	private static final String NAME_FIELD = "name";
	private static final String LAST_NAME_FIELD = "lastName";
	private static final String PHONE_FIELD = "phone";
	ArrayList<HashMap<String, String>> content;
	TextView pick;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);	
	    setContentView(R.layout.simple_list_2);
	    
	   pick = (TextView)findViewById(R.id.TextView01);
	    
	   content = new ArrayList< HashMap<String,String>>();
	    
	    HashMap<String,String> contentItem = new HashMap<String,String>(){{
	    	put(NAME_FIELD, "Jhoni");
	    	put(LAST_NAME_FIELD, "Boni");
	    	put(PHONE_FIELD, "555-444-363");
	    }};	    		
		content.add(contentItem);
		
		contentItem = new HashMap<String,String>(){{
	    	put(NAME_FIELD, "Dan");
	    	put(LAST_NAME_FIELD, "Cifi");
	    	put(PHONE_FIELD, "555-422-111");
	    }};	    		
		content.add(contentItem);
		
		contentItem = new HashMap<String,String>(){{
	    	put(NAME_FIELD, "Boris");
	    	put(LAST_NAME_FIELD, "Aristo");
	    	put(PHONE_FIELD, "555-222-333");
	    }};	    		
		content.add(contentItem);
		
		contentItem = new HashMap<String,String>(){{
	    	put(NAME_FIELD, "Jacob");
	    	put(LAST_NAME_FIELD, "Sosa");
	    	put(PHONE_FIELD, "555-123-321");
	    }};	    		
		content.add(contentItem);
		
		contentItem = new HashMap<String,String>(){{
	    	put(NAME_FIELD, "Gili");
	    	put(LAST_NAME_FIELD, "Tzili");
	    	put(PHONE_FIELD, "555-999-000");
	    }};	    		
		content.add(contentItem);
	    
	    SimpleAdapter adapter = new SimpleAdapter(this,
	    		content,
				R.layout.simple_list_item_2,
				new String[]{NAME_FIELD,LAST_NAME_FIELD, PHONE_FIELD},
				new int[]{R.id.ListTextView01,R.id.ListTextView02, R.id.ListTextView02});  

		setListAdapter(adapter);
				
	}
	
	@Override
	protected void onListItemClick(ListView parent, View v, int position,long id){
		Log.d("class3", "onListItemClick " + position); 
		pick.setText(content.get(position).get(NAME_FIELD) + " " + content.get(position).get(LAST_NAME_FIELD));
	}

}
