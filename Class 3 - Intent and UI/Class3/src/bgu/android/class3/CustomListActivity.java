package bgu.android.class3;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class CustomListActivity extends Activity {

	ListView lv;
	ArrayList<User> users;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	    
		setContentView(R.layout.simple_list_2);

		users = new ArrayList<User>();	    

		users.add(new User ("Jhoni", "Boni", "555-444-363"));
		users.add(new User ("Dan",  "Cifi", "555-422-111"));
		users.add(new User ("Boris", "Aristo", "555-222-333"));

		lv = (ListView)findViewById(android.R.id.list);	
		
		CustomAdapter adapter = new CustomAdapter(CustomListActivity.this, R.layout.simple_list_item_2, users);		
		lv.setAdapter(adapter);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
				Log.d("class3", "onListItemClick " + position); 
				Toast.makeText(CustomListActivity.this,users.get(position).getName() +" "+ users.get(position).getLastName(), Toast.LENGTH_LONG).show();
			}
		});
		
		
	}
		
	class CustomAdapter extends ArrayAdapter<User>{

		Context context; 
		int layoutResourceId;    
		ArrayList<User> data = null;
		private LayoutInflater mInflater; 	

		public CustomAdapter(Context context, int layoutResourceId, ArrayList<User> data) {
			super(context, layoutResourceId, data);		  
			this.layoutResourceId = layoutResourceId;
			this.context = context;
			this.data = data;
			this.mInflater = LayoutInflater.from(context);						
		}

		public View getView(final int position, View convertView, ViewGroup parent) {		

			ViewHolder holder = null;		       

			if (convertView == null) {

				//item_list
				convertView = mInflater.inflate(R.layout.simple_list_item_2, null);

				holder = new ViewHolder();

				//fill the views
				holder.name = (TextView) convertView.findViewById(R.id.ListTextView01);
				holder.lastName = (TextView) convertView.findViewById(R.id.ListTextView02);
				holder.phone = (TextView) convertView.findViewById(R.id.ListTextView03);

				convertView.setTag(holder);						
			} 
			else {
				// Get the ViewHolder back to get fast access to the TextView
				// and the ImageView.
				holder = (ViewHolder) convertView.getTag();//			
			}

			holder.name.setText(data.get(position).getName());
			holder.lastName.setText(data.get(position).getLastName());
			holder.lastName.setText(data.get(position).getPhone());

			return convertView;
		}

		class ViewHolder {		
			TextView name;
			TextView lastName;
			TextView phone;			
		}
	}

}
