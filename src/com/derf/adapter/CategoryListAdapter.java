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

public class CategoryListAdapter extends ArrayAdapter<ListItem> {
	private final Activity context;
	private final ArrayList<ListItem> items;
     
	public CategoryListAdapter(Activity context, ArrayList<ListItem> items) {
		super(context, R.layout.rowlayout, items);
		this.context = context;
		this.items = items;
	}

	// static to save the reference to the outer class and to avoid access to
	// any members of the containing class
	static class ViewHolder {
		public TextView textView;
		public TextView idView;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		View rowView = convertView;
		if (rowView == null) {
			LayoutInflater inflater = context.getLayoutInflater();
			rowView = inflater.inflate(R.layout.categorylayout, parent, false);
			holder = new ViewHolder();
			holder.textView = (TextView) rowView.findViewById(R.id.mainText);
			holder.idView = (TextView) rowView.findViewById(R.id.rowIdValue);
			rowView.setTag(holder);
		} else {
			holder = (ViewHolder) rowView.getTag();
		}

		holder.textView.setText(Html.fromHtml(items.get(position).getText()));	
		holder.idView.setText(Integer.toString(items.get(position).getId()));
		return rowView;
	}
}
