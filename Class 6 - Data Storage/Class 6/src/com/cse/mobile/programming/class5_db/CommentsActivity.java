package com.cse.mobile.programming.class5_db;

import java.util.List;
import java.util.Random;

import android.app.ListActivity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.view.View;
import android.widget.ArrayAdapter;

import com.cse.mobile.programming.class5_db.model.Comment;
import com.cse.mobile.programming.class5_db.model.CommentsDataSource;

public class CommentsActivity extends ListActivity {
	private CommentsDataSource datasource;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comments);

		datasource = new CommentsDataSource(this);
		datasource.open();

		List<Comment> values = datasource.getAllComments();

		// Use the SimpleCursorAdapter to show the
		// elements in a ListView
		ArrayAdapter<Comment> adapter = new ArrayAdapter<Comment>(this,
				android.R.layout.simple_list_item_1, values);
		setListAdapter(adapter);
	}

	// Will be called via the onClick attribute
	// of the buttons in main.xml
	public void onClick(View view) {
		@SuppressWarnings("unchecked")
		ArrayAdapter<Comment> adapter = (ArrayAdapter<Comment>) getListAdapter();
		Comment comment = null;
		switch (view.getId()) {
		case R.id.add:
			String[] comments = new String[] { "Cool", "Very nice", "Hate it" };
			int nextInt = new Random().nextInt(3);
			// Save the new comment to the database
			comment = datasource.createComment(comments[nextInt]);
			adapter.add(comment);
			break;
		case R.id.delete:
			if (getListAdapter().getCount() > 0) {
				comment = (Comment) getListAdapter().getItem(0);
				datasource.deleteComment(comment);
				adapter.remove(comment);
			}
			break;
		}
		adapter.notifyDataSetChanged();
	}

	@Override
	  protected void onResume() {
	    datasource.open();
	    super.onResume();
	    
	    
	    
	    // Defines selection criteria for the rows you want to delete
	    String mSelectionClause = UserDictionary.Words.APP_ID + " LIKE ?";
	    String[] mSelectionArgs = {"user"};

	    // Defines a variable to contain the number of rows deleted
	    int mRowsDeleted = 0;

	    // Deletes the words that match the selection criteria
	    mRowsDeleted = getContentResolver().delete(
	        UserDictionary.Words.CONTENT_URI,   // the user dictionary content URI
	        mSelectionClause,                    // the column to select on
	        mSelectionArgs                      // the value to compare to
	    );
	  }

	@Override
	protected void onPause() {
		datasource.close();
		super.onPause();
	}

}