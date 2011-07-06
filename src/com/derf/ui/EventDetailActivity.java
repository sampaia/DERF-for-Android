package com.derf.ui;

import com.derf.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.derf.beans.Event;
import com.derf.util.Util;

public class EventDetailActivity extends Activity{
    private static final String TAG = "EventDetailActivity";
    
    public EventDetailActivity() {
    }

    /**
     * Called with the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        View eventView;
        LayoutInflater li = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        eventView = li.inflate(R.layout.event_detail_layout, null);

        TextView headline = (TextView)eventView.findViewById(R.id.headline);
        TextView subText = (TextView) eventView.findViewById(R.id.subText);
        TextView address = (TextView) eventView.findViewById(R.id.address);
        ImageView img = (ImageView) eventView.findViewById(R.id.icon);
        TextView articleText = (TextView) eventView.findViewById(R.id.articleText);

        Event e = (Event) getIntent().getExtras().get("event");
        
        if(e != null){
        	headline.setText(e.getTitle());
        	subText.setText(e.getVenue() + " " + e.getStartTime() + " - " + e.getEndTime());
        	address.setText("Address:\n" + e.getStreet() + "\n" + e.getCity() + " " + e.getState() + " " + e.getZip());
        	img.setImageBitmap(Util.LoadImage(e.getImageURL(), null));
        	articleText.setText(e.getText());
        }       
        setContentView(eventView);
        
    }
    
	public void onHomeClick(View v){
		Util.goHome(this);
	}
}
