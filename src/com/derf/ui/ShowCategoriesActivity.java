package com.derf.ui;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.derf.adapter.CategoryListAdapter;
import com.derf.beans.ListItem;
import com.derf.util.Util;

public class ShowCategoriesActivity extends ListActivity {
	
	/** Called when the activity is first created. */
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

        setContentView(com.derf.R.layout.header_frame_layout);

		
		ArrayList<ListItem> nl = new ArrayList<ListItem>();

		nl.add(new ListItem(1, "Sports"));
		nl.add(new ListItem(2, "Business"));
		nl.add(new ListItem(3, "Lifestyle"));
		nl.add(new ListItem(4, "Entertainment"));
		nl.add(new ListItem(5, "Politics"));
		nl.add(new ListItem(6, "Classics"));
		nl.add(new ListItem(7, "Music"));

		this.setListAdapter(new CategoryListAdapter(this, nl));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// Get the item that was clicked
		ListItem o = (ListItem) this.getListAdapter().getItem(position);
		String keyword = o.toString();
		
		Intent i = new Intent(this, TopNewsActivity.class);
		i.putExtra("category", o.getText());
		
		startActivity(i);
		
		
		//Toast.makeText(this, "You selected: " + o.getText() + "    " + o.getId(), Toast.LENGTH_LONG)
		//		.show();
	}
	
	public void onHomeClick(View v){
		Util.goHome(this);
	}

}
