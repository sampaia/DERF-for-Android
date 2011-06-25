package com.derf.ui;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.derf.adapter.ListAdapter;
import com.derf.beans.ListItem;
import com.derf.beans.News;

public class ShowPhotoAlbumsActivity extends ListActivity {

	/** Called when the activity is first created. */
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		// Create an array of Strings, that will be put to our ListActivity
		ListItem n1 = new ListItem(4, "Really long this is a test for a really long long line and it is a test for a long line 1", "the date stuff would go here as well", 
					"http://www.derfmagazine.com/_includes/functions/image.php/?width=65&height=65&cropratio=1:1&image=/_images/cincinnati/events/1260/1260_be98f57ec4652725457783b04a4d2a91_1241638678_31.jpg");		
		ListItem n2 = new ListItem(5, "this is going to be the headline of the second item.", "subtext2", 
					"http://www.derfmagazine.com/_includes/functions/image.php/?width=65&height=65&cropratio=1:1&image=/_images/cincinnati/events/1260/1260_be98f57ec4652725457783b04a4d2a91_1241638678_31.jpg");		
		
		ArrayList<ListItem> nl = new ArrayList<ListItem>();
		nl.add(n1);
		nl.add(n2);

		this.setListAdapter(new ListAdapter(this, nl));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// Get the item that was clicked
		ListItem o = (ListItem) this.getListAdapter().getItem(position);
		String keyword = o.toString();
		Toast.makeText(this, "You selected: " + o.getText() + "    " + o.getId(), Toast.LENGTH_LONG)
				.show();
	}

}
