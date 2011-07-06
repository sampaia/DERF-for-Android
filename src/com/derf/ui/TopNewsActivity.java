package com.derf.ui;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.derf.adapter.ListAdapter;
import com.derf.beans.ListItem;
import com.derf.beans.News;
import com.derf.util.Util;

public class TopNewsActivity extends ListActivity {

	/** Called when the activity is first created. */
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
	
		setContentView(com.derf.R.layout.header_frame_layout);
		
		String categoryValue = null;
		
		//see if category is specified and if so, get the articles
		//only for that category
		if(getIntent().getExtras() != null && getIntent().getExtras().get("category") != null){
			Object categoryObject = getIntent().getExtras().get("category");
			categoryValue = categoryObject.toString();
		}

		this.setListAdapter(new ListAdapter(this, processItemsForCategory(categoryValue)));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// Get the item that was clicked
		ListItem o = (ListItem) this.getListAdapter().getItem(position);
		//String keyword = o.toString();
		//Toast.makeText(this, "You selected: " + o.getText() + "    " + o.getId(), Toast.LENGTH_LONG)
		//		.show();
		
		Intent i = new Intent(this, NewsArticleActivity.class);

		News n = new News(4, 
				"this is a headline value for this article",
				"text for the article", 
				"http://www.derfmagazine.com/_images/cincinnati/news/962/sweater-vest-nerd.jpg");
		
		i.putExtra("news", n);
		startActivity(i);
	}
	
	private ArrayList<ListItem> processItemsForCategory(String category){
		
		ListItem n1;
		ListItem n2;
		if(category != null){
			n1 = new ListItem(4, category + " Really long this is a test for a really long long line and it is a test for a long line 1", "the date stuff would go here as well", "http://www.derfmagazine.com/_includes/functions/image.php/columnist-katieMichaels-plain.jpg?width=60&height=60&cropratio=1:1&image=/_images/columnists/columnist-katieMichaels-plain.jpg");		
			n2 = new ListItem(5, category + " this is going to be the headline of the second item.", "subtext2", "http://www.derfmagazine.com/_includes/functions/image.php/columnist-katieMichaels-plain.jpg?width=60&height=60&cropratio=1:1&image=/_images/columnists/columnist-katieMichaels-plain.jpg");
		}
		else{
			n1 = new ListItem(4, "Really long this is a test for a really long long line and it is a test for a long line 1", "the date stuff would go here as well", "http://www.derfmagazine.com/_includes/functions/image.php/columnist-katieMichaels-plain.jpg?width=60&height=60&cropratio=1:1&image=/_images/columnists/columnist-katieMichaels-plain.jpg");		
			n2 = new ListItem(5, "this is going to be the headline of the second item.", "subtext2", "http://www.derfmagazine.com/_includes/functions/image.php/columnist-katieMichaels-plain.jpg?width=60&height=60&cropratio=1:1&image=/_images/columnists/columnist-katieMichaels-plain.jpg");	
		}
		ArrayList<ListItem> nl = new ArrayList<ListItem>();
		nl.add(n1);
		nl.add(n2);
		
		return nl;
	}
	public void onHomeClick(View v){
		Util.goHome(this);
	}

}
