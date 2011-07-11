package com.derf.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.derf.R;
import com.derf.adapter.LazyAdapter;
import com.derf.beans.ListItem;
import com.derf.beans.News;
import com.derf.util.NewsAPI;
import com.derf.util.Util;

public class TopNewsActivity extends ListActivity {

	ListView list;
	LazyAdapter listAdapter;
	public ArrayList<News> newsItems;
    ProgressDialog pd;
    public String category = null;
	
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(com.derf.R.layout.header_frame_layout);
		
		pd = ProgressDialog.show(this, "Working...", "Loading Stuff", true, false);
				
		new DownloadTask().execute();
	}
	
    @Override
    public void onDestroy()
    {
    	listAdapter.imageLoader.stopThread();
        list.setAdapter(null);
        super.onDestroy();
    }
    
    public OnClickListener listener=new OnClickListener(){
        @Override
        public void onClick(View arg0) {
        	listAdapter.imageLoader.clearCache();
        	listAdapter.notifyDataSetChanged();
        }
    };

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// Get the item that was clicked
		Object o = this.getListAdapter().getItem(position);
		Intent i = new Intent(this, NewsArticleActivity.class);
				
		int newsID = 0;
		TextView idView = (TextView) v.findViewById(R.id.rowIdValue);
		newsID = Integer.valueOf(idView.getText().toString());
		
		for (Iterator iterator = this.newsItems.iterator(); iterator.hasNext();) {
			News n = (News) iterator.next();
			if(n.getId() == newsID){
				i.putExtra("news", n);
			}
		}
		startActivity(i);
	}
	
    private class DownloadTask extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... args) {
            Log.i("News", "Background thread starting");
            
    		if(TopNewsActivity.this.getIntent().getExtras() != null && TopNewsActivity.this.getIntent().getExtras().get("category") != null){
    			Object categoryObject = TopNewsActivity.this.getIntent().getExtras().get("category");
    			category = categoryObject.toString();
    		}
    		try {
    			TopNewsActivity.this.populateNewsItems(category);
    		} catch (JsonParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (JsonMappingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
			return null;
        }

        protected void onPostExecute(String s) {
            // Pass the result data back to the main activity
            TopNewsActivity.this.createView();
            
            if (TopNewsActivity.this.pd != null) {
            	TopNewsActivity.this.pd.dismiss();
            }
        }
   } 
 
    private void createView(){
		list = (ListView) findViewById(android.R.id.list);
		listAdapter = new LazyAdapter(this, processItemsForCategory());
        list.setAdapter(listAdapter);
    	this.setListAdapter(listAdapter);    
    }    
	
    private void populateNewsItems(String category) throws JsonParseException, JsonMappingException, IOException{
    	if(category == null) 
    		category = "0";
		
		String dataFileName = "category-" + category + ".json";
		Calendar now = Calendar.getInstance();
		now.getTimeInMillis();
		
		
		File f = TopNewsActivity.this.getFileStreamPath(dataFileName);
		FileOutputStream fos = null;
		FileInputStream fis = null;
		
		long fileLength = f.length();
		if(!f.exists() || !(f.exists() && fileLength > 0) || (now.getTimeInMillis() - f.lastModified() > Util.FILE_TIMEOUT)){
			fos = TopNewsActivity.this.openFileOutput(dataFileName, Context.MODE_PRIVATE);
		}
		else{
			fis = TopNewsActivity.this.openFileInput(dataFileName);
		}
		newsItems = NewsAPI.getTopNewsItems(fos, fis, category);

    }
    
	private ArrayList<ListItem> processItemsForCategory(){			
		
		ArrayList<ListItem> nl = new ArrayList<ListItem>();
		
		for (Iterator iterator = newsItems.iterator(); iterator.hasNext();) {
			News news = (News) iterator.next();
			
			ListItem li = new ListItem();
			li.setId(news.getId());
			li.setImageURL(URLDecoder.decode(news.getImageURL()));
			li.setText(news.getHeadline());
			li.setSubText(news.getDate().toString());	
			//li.setImageBitmap(BitmapFactory.decodeByteArray(news.getImageBitmap(), 0, news.getImageBitmap().length));
			
			nl.add(li);
		}
		return nl;
	}
	public void onHomeClick(View v){
		Util.goHome(this);
	}

}
