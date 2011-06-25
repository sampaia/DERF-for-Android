package com.derf.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.derf.R;
import com.derf.beans.ListItem;
import com.derf.util.Util;

public class PhotoAlbumsAdapter extends ArrayAdapter<ListItem> {
	private final Activity context;
	private final ArrayList<ListItem> items;

	public PhotoAlbumsAdapter(Activity context, ArrayList<ListItem> items) {
		super(context, R.layout.rowlayout, items);
		this.context = context;
		this.items = items;
	}

	// static to save the reference to the outer class and to avoid access to
	// any members of the containing class
	static class ViewHolder {
		public ImageView imageView;
		public TextView textView;
		public TextView subTextView;
		public TextView idView;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		View rowView = convertView;
		if (rowView == null) {
			LayoutInflater inflater = context.getLayoutInflater();
			rowView = inflater.inflate(R.layout.rowlayout, null, true);
			holder = new ViewHolder();
			holder.textView = (TextView) rowView.findViewById(R.id.mainText);
			holder.subTextView = (TextView) rowView.findViewById(R.id.subText);
			holder.imageView = (ImageView) rowView.findViewById(R.id.icon);
			holder.idView = (TextView) rowView.findViewById(R.id.rowIdValue);
			rowView.setTag(holder);
		} else {
			holder = (ViewHolder) rowView.getTag();
		}

		holder.textView.setText(Html.fromHtml(items.get(position).getText()));	
		holder.subTextView.setText(Html.fromHtml(items.get(position).getSubText()));
		holder.idView.setText(Integer.toString(items.get(position).getId()));
		holder.imageView.setImageBitmap(Util.LoadImage(items.get(position).getImageURL(), null));
		//holder.imageView.setImageBitmap(Util.LoadImage("http://www.derfmagazine.com/_includes/functions/image.php/columnist-katieMichaels-plain.jpg?width=60&height=60&cropratio=1:1&image=/_images/columnists/columnist-katieMichaels-plain.jpg", null));
		return rowView;
	}
}
