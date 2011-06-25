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
import com.derf.util.Util;

public class NewsArticleActivity extends Activity{
    private static final String TAG = "NewsArticleActivity";
    
    public NewsArticleActivity() {
    }

    /**
     * Called with the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        View newsView;
        LayoutInflater li = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        newsView = li.inflate(R.layout.news_detail_layout, null);

        TextView headline = (TextView)newsView.findViewById(R.id.headline);
        TextView subText = (TextView) newsView.findViewById(R.id.subText);
        ImageView img = (ImageView) newsView.findViewById(R.id.icon);
        TextView articleText = (TextView) newsView.findViewById(R.id.articleText);

        headline.setText("Headline value goes here for the article");
        subText.setText("sub text about author and date");
        img.setImageBitmap(Util.LoadImage("http://www.derfmagazine.com/_images/cincinnati/news/962/sweater-vest-nerd.jpg", null));
        articleText.setText("this is the article text right here");
                
        setContentView(newsView);
        
    }
}
