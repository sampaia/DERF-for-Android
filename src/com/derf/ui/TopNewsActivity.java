package com.derf.ui;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.derf.adapter.ListAdapter;
import com.derf.beans.News;

public class TopNewsActivity extends ListActivity {

	/** Called when the activity is first created. */
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		// Create an array of Strings, that will be put to our ListActivity
		News n1 = new News();
		n1.setHeadline("test 1");
		
		News n2 = new News();
		n2.setHeadline("test 2");
		
		ArrayList<News> nl = new ArrayList<News>();
		nl.add(n1);
		nl.add(n2);
		
		String[] names = new String[] { "Linux", "Windows7", "Eclipse", "Suse",
				"Ubuntu", "Solaris", "Android", "iPhone" };
		this.setListAdapter(new ListAdapter(this, nl));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// Get the item that was clicked
		Object o = this.getListAdapter().getItem(position);
		String keyword = o.toString();
		Toast.makeText(this, "You selected: " + keyword, Toast.LENGTH_LONG)
				.show();
	}

}
