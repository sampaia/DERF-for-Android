package com.derf.ui;

import java.io.ByteArrayInputStream;
import java.net.URLDecoder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.derf.R;
import com.derf.beans.News;
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

        News n = (News) getIntent().getExtras().get("news");
        
        if(n != null){
            //ByteArrayInputStream bytes = new ByteArrayInputStream(n.getImageBitmap());
            //BitmapDrawable bmd = new BitmapDrawable(bytes);
            //Bitmap bm = bmd.getBitmap();
            
        	headline.setText(n.getHeadline());
        	subText.setText(n.getDate().toString());
        	//img.setImageBitmap(BitmapFactory.decodeByteArray(n.getImageBitmap(), 0, n.getImageBitmap().length));
        	img.setImageBitmap(Util.LoadImage(URLDecoder.decode(n.getImageURL()), null));
        	//img.setImageBitmap(bm);
        	articleText.setText(Html.fromHtml(n.getText()));
        }       
        setContentView(newsView);
        
    }
    
	public void onHomeClick(View v){
		Util.goHome(this);
	}
}
