package com.derf.beans;

import android.graphics.Bitmap;

public class ListItem {

	private int id;
	private String text;
	private String subText;
	private String imageURL;
	private Bitmap imageBitmap;
	
	public ListItem(){}
	
	public ListItem(int id, String text){
		this.id = id;
		this.text = text;
	}
	
	public ListItem(int id, String text, String imageURL){
		this.id = id;
		this.text = text;
		this.imageURL = imageURL;
	}

	public ListItem(int id, String text, String subText, String imageURL){
		this.id = id;
		this.text = text;
		this.subText = subText;
		this.imageURL = imageURL;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getSubText() {
		return subText;
	}

	public void setSubText(String subText) {
		this.subText = subText;
	}

	public Bitmap getImageBitmap() {
		return imageBitmap;
	}

	public void setImageBitmap(Bitmap imageBitmap) {
		this.imageBitmap = imageBitmap;
	}
	
}
