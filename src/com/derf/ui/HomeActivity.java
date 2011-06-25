package com.derf.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.derf.R;

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
        setContentView(R.layout.home_activity);
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
}
