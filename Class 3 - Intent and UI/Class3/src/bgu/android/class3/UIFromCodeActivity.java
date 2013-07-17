package bgu.android.class3;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class UIFromCodeActivity extends Activity {

	LinearLayout root;
	TextView textview;
	EditText editext;
	Button button;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    root = new LinearLayout(this);
	    root.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	    root.setOrientation(LinearLayout.VERTICAL);
	    root.setGravity(Gravity.CENTER);
	    
	    textview = new TextView(this);
	    textview.setText(getResources().getString(R.string.enter_phone));
	    root.addView(textview);
	    
	    editext = new EditText(this);
	    editext.setHint("phone comes here");
	    editext.setInputType(InputType.TYPE_CLASS_PHONE);
	    editext.setOnEditorActionListener(new OnEditorActionListener() {
			
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				showToast();
				return false;
			}
		});
	    root.addView(editext);
	    
	    button = new Button(this);
	    button.setText("Click me");
	    root.addView(button);
	    
	    setContentView(root);
	    
	    button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Toast.makeText(UIFromCodeActivity.this, "clicked", Toast.LENGTH_SHORT).show();
			}
		});
	    
//	    button.setOnClickListener(new MyClick());
	}
	
	private void showToast(){
		Toast.makeText(UIFromCodeActivity.this, "clicked", Toast.LENGTH_SHORT).show();
	}
	
	class MyClick implements View.OnClickListener{

		public void onClick(View v) {
			switch (v.getId()){
			case R.id.button:
				showToast();
				break;
			}
		}
	}
}
