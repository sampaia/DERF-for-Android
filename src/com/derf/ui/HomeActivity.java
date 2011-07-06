package com.derf.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.derf.R;
import com.derf.beans.Event;
import com.derf.beans.News;
import com.derf.util.Util;

public class HomeActivity extends Activity{
    private static final String TAG = "HomeActivity";
    
    public HomeActivity() {
    }

    /**
     * Called with the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout for this activity.  You can find it
        // in res/layout/hello_activity.xml
        View homeView;
        LayoutInflater li = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        homeView = li.inflate(R.layout.home_activity, null);

        TextView headline = (TextView)homeView.findViewById(R.id.happyHourDate);
        TextView subText = (TextView) homeView.findViewById(R.id.happyHourInfo);
        ImageView img = (ImageView) homeView.findViewById(R.id.icon);

        Event n = getDerfHappyHourEvent();
        
        if(n != null){
        	headline.setText(n.getDate() + " " + n.getStartTime() + " - " + n.getEndTime());
        	subText.setText(n.getVenue() + ", " + n.getTitle());
        	img.setImageBitmap(Util.LoadImage(n.getImageURL(), null));
        }       
        setContentView(homeView);

        
        
        
        //setContentView(R.layout.home_activity);
    }
 
    /** Handle "home" action. */
    public void onTopNewsClick(View v) {
        // Launch overall conference schedule
        startActivity(new Intent(this, TopNewsActivity.class));
    }
    
    /** Handle "categories" action. */
    public void onCategoriesClick(View v) {
        // Launch overall conference schedule
        startActivity(new Intent(this, ShowCategoriesActivity.class));
    }
    
    /** Handle "events" action. */
    public void onEventsClick(View v) {
        // Launch overall conference schedule
        startActivity(new Intent(this, ShowEventsActivity.class));
    }   

    /** Handle "photo albums" action. */
    public void onPhotoAlbumsClick(View v) {
        // Launch overall conference schedule
        startActivity(new Intent(this, ShowPhotoAlbumsActivity.class));
    }    
    
    public void onHappyHourClick(View v) {
		Intent i = new Intent(this, EventDetailActivity.class);	
		i.putExtra("event", getDerfHappyHourEvent());
		startActivity(i);	
    }
    
    public Event getDerfHappyHourEvent(){
    	Event e = new Event();
    	e.setDate("Friday, July 8");
    	e.setVenue("Longworths");
    	e.setImageURL("http://www.derfmagazine.com/_images/cincinnati/events/3059/DHH-Photo-4girls.jpg");
    	e.setStartTime("5:30PM");
    	e.setEndTime("9:30PM");
    	e.setTitle("$10 for 10 beers -OR- 6 Cocktails!");
    	e.setId(3059);
    	
    	return e;
    }
}
