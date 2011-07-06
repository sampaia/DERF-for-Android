package com.derf.beans;

import java.io.Serializable;

public class News implements Serializable{

	private int id;
	private String headline;
	private String text;
	private String imageURL;
	private String thumbnailURL;
	
	public News(){}
	public News(int id, String headline, String text, String imageURL){
		this.id = id;
		this.headline = headline;
		this.text = text;
		this.imageURL = imageURL;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
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

	public String getThumbnailURL() {
		return thumbnailURL;
	}

	public void setThumbnailURL(String thumbnailURL) {
		this.thumbnailURL = thumbnailURL;
	}
	
}
