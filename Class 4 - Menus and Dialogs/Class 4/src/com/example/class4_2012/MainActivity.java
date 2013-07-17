package com.example.class4_2012;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private static final int HELLO_ID = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        registerForContextMenu(findViewById(R.id.contextMenuTextView));
        
        Button menues = (Button)findViewById(R.id.menues);
        menues.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, MenuInflateFromXml.class);
				startActivity(intent);				
			}
		});
        
        Button dialogs = (Button)findViewById(R.id.dialogs);
        dialogs.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, AlertDialogSamples.class);
				startActivity(intent);				
			}
		});
        
        TextView notification = (TextView)findViewById(R.id.notification);
        notification.setOnClickListener(new OnClickListener() {
						
			@Override
			public void onClick(View v) {				
				
//				NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//				
//				mNotificationManager.cancel(HELLO_ID);
//				
//				
//				int icon = R.drawable.ic_notifications_white;
//				CharSequence tickerText = "Hello";
//				long when = System.currentTimeMillis();
//
//				Notification notification = new Notification(icon, tickerText, when);
//				
//				Context context = getApplicationContext();
//				CharSequence contentTitle = "My notification";
//				CharSequence contentText = "Hello World!";
//				Intent notificationIntent = new Intent(/*MainActivity.this, OtherClass.class*/);
//				PendingIntent contentIntent = PendingIntent.getActivity(MainActivity.this, 0, notificationIntent, 0);
//
//				notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);			
//
//				mNotificationManager.notify(HELLO_ID, notification);
				
				NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this);
				
				mBuilder.setAutoCancel(true)				
				.setSmallIcon(R.drawable.ic_notifications_white)
				.setContentTitle("this is my title")
				.setContentText("this is my text")
				.setNumber(3)
				.setTicker("Hello World!");
				
				//intent to fire when clicking hte notification
				Intent resultIntent = new Intent();
				// Creates the PendingIntent
				PendingIntent pendingNotifyIntent =
						PendingIntent.getActivity(
								MainActivity.this,
								0,
								resultIntent,
								PendingIntent.FLAG_UPDATE_CURRENT
								);

				// Puts the PendingIntent into the notification builder
				mBuilder.setContentIntent(pendingNotifyIntent);
				 
				NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				// id allows you to update the notification later on.				
				mNotificationManager.notify(HELLO_ID, mBuilder.build());
				
			}
		});
        
        Button progress = (Button)findViewById(R.id.progressDialog);
        progress.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ProgressDialog pd = ProgressDialog.show(MainActivity.this, "This is a progress dialog", "Doing something...");
				pd.setCancelable(true);
			}
		});
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
       
        switch (item.getItemId()) {
            case R.id.delete:
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.rename:
            	Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
