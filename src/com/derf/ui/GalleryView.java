package com.derf.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import com.derf.R;
import com.derf.util.Util;

public class GalleryView extends Activity {
    ArrayList<Bitmap> pics;
    ProgressDialog pd;
    ImageView imageView;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.gallery_layout);
		pd = ProgressDialog.show(this, "Working...", "Getting Pictures", true,
                false);
      
		new DownloadTask().execute("12345");     
    }
    
	public void onHomeClick(View v){
		Util.goHome(this);
	}
    
    private void createView(){
        Gallery ga = (Gallery)findViewById(R.id.gallery);
        ga.setAdapter(new ImageAdapter(this));
        
        imageView = (ImageView)findViewById(R.id.galleryImage);
        imageView.setImageBitmap(pics.get(0));
        
        //pd.cancel();
        ga.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(getBaseContext(), "You have selected picture " + (arg2+1) + "", Toast.LENGTH_SHORT).show();
				imageView.setImageBitmap(pics.get(arg2));	
			}
        	
        });
    }
    
    private class DownloadTask extends AsyncTask<String, Void, ArrayList<Bitmap>> {
        protected ArrayList<Bitmap> doInBackground(String... args) {
            Log.i("MyApp", "Background thread starting");

            Log.i("Gallery", args[0]);
            ArrayList<Bitmap> pics = new ArrayList<Bitmap>();
            pics.add(Util.LoadImage("http://www.derfmagazine.com/_images/cincinnati/events/2924/2924_62a9b129bd0b8563e7b5cd7f3bad91b7_1304174512_16.jpg", null));
            pics.add(Util.LoadImage("http://www.derfmagazine.com/_images/cincinnati/events/1783/1783_f577e9c0ebaa624bbfdb90359a7162ea_1269103589_27.jpg", null));
            pics.add(Util.LoadImage("http://www.derfmagazine.com/_images/cincinnati/events/1232/1232_cadf9a2d8d7a28ca41a6f26442a0c6aa_1241309174_53.jpg", null));
            pics.add(Util.LoadImage("http://www.derfmagazine.com/_images/cincinnati/events/944/944_7ff40f8e4288bf8bda2fe7d0de582986_1225428056_34.jpg", null));
            pics.add(Util.LoadImage("http://www.derfmagazine.com/_images/cincinnati/events/944/944_7ff40f8e4288bf8bda2fe7d0de582986_1225428056_14.jpg", null));
            pics.add(Util.LoadImage("http://www.derfmagazine.com/_images/cincinnati/events/944/944_7ff40f8e4288bf8bda2fe7d0de582986_1225428056_4.jpg", null));
          
            return pics;
        }

        protected void onPostExecute(ArrayList<Bitmap> result) {
            // Pass the result data back to the main activity
            GalleryView.this.pics = result;
            GalleryView.this.createView();
            
            if (GalleryView.this.pd != null) {
            	GalleryView.this.pd.dismiss();
            }
        }
   } 
    
    public class ImageAdapter extends BaseAdapter {

    	private Context ctx;
    	int imageBackground;
    	
    	public ImageAdapter(Context c) {
			ctx = c;
			TypedArray ta = obtainStyledAttributes(R.styleable.gallery);
			imageBackground = ta.getResourceId(R.styleable.gallery_android_galleryItemBackground, 1);
			ta.recycle();
		}

		@Override
    	public int getCount() {
    		
    		return pics.size();
    	}

    	@Override
    	public Object getItem(int arg0) {
    		
    		return arg0;
    	}

    	@Override
    	public long getItemId(int arg0) {
    		
    		return arg0;
    	}

    	@Override
    	public View getView(int arg0, View arg1, ViewGroup arg2) {
    		ImageView iv = new ImageView(ctx);
    		
    		Bitmap image = pics.get(arg0);
    		iv.setImageBitmap(image);
    		//iv.setImageResource(pics[arg0]);
    		iv.setScaleType(ImageView.ScaleType.FIT_XY);
    		
    		double layoutScale = (double) ((double) 120 / (double) image.getHeight());
    		int layoutHeight = (int) (image.getHeight() * layoutScale);
    		int layoutWidth = (int) (image.getWidth() * layoutScale);
    		iv.setLayoutParams(new Gallery.LayoutParams(layoutWidth, layoutHeight));
    		
    		iv.setBackgroundResource(imageBackground);
    		return iv;
    	}

    }
}