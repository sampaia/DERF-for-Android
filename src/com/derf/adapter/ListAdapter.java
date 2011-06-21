package com.derf.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.derf.R;
import com.derf.beans.News;
import com.derf.util.Util;

public class ListAdapter extends ArrayAdapter<News> {
	private final Activity context;
	private final ArrayList<News> items;

	public ListAdapter(Activity context, ArrayList<News> items) {
		super(context, R.layout.rowlayout, items);
		this.context = context;
		this.items = items;
	}

	// static to save the reference to the outer class and to avoid access to
	// any members of the containing class
	static class ViewHolder {
		public ImageView imageView;
		public TextView textView;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		View rowView = convertView;
		if (rowView == null) {
			LayoutInflater inflater = context.getLayoutInflater();
			rowView = inflater.inflate(R.layout.rowlayout, null, true);
			holder = new ViewHolder();
			holder.textView = (TextView) rowView.findViewById(R.id.label);
			holder.imageView = (ImageView) rowView.findViewById(R.id.icon);
			rowView.setTag(holder);
		} else {
			holder = (ViewHolder) rowView.getTag();
		}

		holder.textView.setText(items.get(position).getHeadline());	
		holder.imageView.setImageBitmap(Util.LoadImage("http://www.derfmagazine.com/_includes/functions/image.php/columnist-katieMichaels-plain.jpg?width=60&height=60&cropratio=1:1&image=/_images/columnists/columnist-katieMichaels-plain.jpg", null));
		return rowView;
	}
}
