package com.derf.beans;

import java.io.Serializable;
import java.util.Date;

import android.graphics.Bitmap;

public class News implements Serializable{

	private int id;
	private Date date;
	private String categoryId;
	private String category;
	private String headline;
	private String text;
	private String imageURL;
	private String thumbnailURL;
	private String url;
	private Date lastAccessDate;
	private byte[] imageBitmap;
	
	public News(){}
	public News(int id, String headline, String text, String imageURL){
		this.id = id;
		this.headline = headline;
		this.text = text;
		this.imageURL = imageURL;
	}
	

	public News(int id, Date date, String categoryId, String category,
			String headline, String text, String imageURL, String thumbnailURL,
			String url, Date lastAccessDate) {
		this.id = id;
		this.date = date;
		this.categoryId = categoryId;
		this.category = category;
		this.headline = headline;
		this.text = text;
		this.imageURL = imageURL;
		this.thumbnailURL = thumbnailURL;
		this.url = url;
		this.lastAccessDate = lastAccessDate;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getLastAccessDate() {
		return lastAccessDate;
	}
	public void setLastAccessDate(Date lastAccessDate) {
		this.lastAccessDate = lastAccessDate;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public byte[] getImageBitmap() {
		return imageBitmap;
	}
	public void setImageBitmap(byte[] imageBitmap) {
		this.imageBitmap = imageBitmap;
	}
	
	
}
