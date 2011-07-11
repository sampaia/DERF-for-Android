package com.derf.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.derf.R;
import com.derf.beans.ListItem;
import com.derf.util.ImageLoader;

public class LazyAdapter extends BaseAdapter {
    
    private Activity activity;
    private ArrayList<ListItem> items;
    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader; 
    
    public LazyAdapter(Activity a, ArrayList<ListItem> listItems) {
        activity = a;
        items = listItems;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader = new ImageLoader(activity.getApplicationContext());
    }

    public int getCount() {
        return items.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public static class ViewHolder{
		public ImageView imageView;
		public TextView textView;
		public TextView subTextView;
		public TextView idView;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        ViewHolder holder;
        if(convertView==null){
            vi = inflater.inflate(R.layout.rowlayout, null, true);
            holder=new ViewHolder();
			holder.textView = (TextView) vi.findViewById(R.id.mainText);
			holder.subTextView = (TextView) vi.findViewById(R.id.subText);
			holder.imageView = (ImageView) vi.findViewById(R.id.icon);
			holder.idView = (TextView) vi.findViewById(R.id.rowIdValue);
            vi.setTag(holder);
        }
        else
            holder=(ViewHolder)vi.getTag();
        
        
		holder.textView.setText(Html.fromHtml(items.get(position).getText()));	
		holder.subTextView.setText(Html.fromHtml(items.get(position).getSubText()));
		holder.idView.setText(Integer.toString(items.get(position).getId()));
		//holder.imageView.setImageBitmap(items.get(position).getImageBitmap());
		holder.imageView.setTag(items.get(position).getImageURL());
        imageLoader.DisplayImage(items.get(position).getImageURL(), activity, holder.imageView);
        return vi;
    }
}