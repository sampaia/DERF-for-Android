package com.derf.ui;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.derf.adapter.ListAdapter;
import com.derf.beans.Event;
import com.derf.beans.ListItem;
import com.derf.util.Util;

public class ShowEventsActivity extends ListActivity {

	/** Called when the activity is first created. */
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		
		setContentView(com.derf.R.layout.header_frame_layout);
		
		// Create an array of Strings, that will be put to our ListActivity
		ListItem n1 = new ListItem(4, "Really long this is a test for a really long long line and it is a test for a long line 1", "the date stuff would go here as well", "http://www.derfmagazine.com/_includes/functions/image.php/FrankyFridays%5B1%5D?width=100&height=100&cropratio=3:2&image=/_images/cincinnati/events/2777/FrankyFridays[1]");		
		ListItem n2 = new ListItem(5, "this is going to be the headline of the second item.", "subtext2", "http://www.derfmagazine.com/_includes/functions/image.php/FrankyFridays%5B1%5D?width=100&height=100&cropratio=3:2&image=/_images/cincinnati/events/2777/FrankyFridays[1]");
		
		n1.setImageBitmap(Util.LoadImage(n1.getImageURL(), null));
		n2.setImageBitmap(Util.LoadImage(n2.getImageURL(), null));

		ArrayList<ListItem> nl = new ArrayList<ListItem>();
		nl.add(n1);
		nl.add(n2);

		this.setListAdapter(new ListAdapter(this, nl));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// Get the item that was clicked
//		ListItem o = (ListItem) this.getListAdapter().getItem(position);
//		String keyword = o.toString();
//		Toast.makeText(this, "You selected: " + o.getText() + "    " + o.getId(), Toast.LENGTH_LONG)
//				.show();
		
		ListItem o = (ListItem) this.getListAdapter().getItem(position);

		Intent i = new Intent(this, EventDetailActivity.class);

		Event e = new Event(5, "Happy Hour at some bar",
				"March 5 2011",
				"", 
				"http://www.derfmagazine.com/_images/cincinnati/news/962/sweater-vest-nerd.jpg",
				"7 PM",
				"9 PM",
				"Some Bar",
				"Google.com",
				"this is going to be a sweet event for some happy hour",
				"Cincinnati",
				"41073",
				"OH",
				"Venue Name"
		);
		
		i.putExtra("event", e);
		startActivity(i);
		
	}
	
	public void onHomeClick(View v){
		Util.goHome(this);
	}

}
