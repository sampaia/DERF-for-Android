package com.derf.beans;

import java.io.Serializable;

public class Event implements Serializable{

	private int id;
	private String title;
	private String date;
	private String thumbnailURL;
	private String imageURL;
	private String startTime;
	private String endTime;
	private String venue;
	private String url;
	private String text;
	private String street;
	private String city;
	private String zip;
	private String state;
	
	public Event(){}
	public Event(int id, 
			String title, 
			String date, 
			String thumbnailURL,
			String imageURL,
			String startTime,
			String endTime,
			String street,
			String url,
			String text,
			String city,
			String zip,
			String state,
			String venue){
		
		this.id = id;
		this.title = title;
		this.date = date;
		this.thumbnailURL = thumbnailURL;
		this.imageURL = imageURL;
		this.startTime = startTime;
		this.endTime = endTime;
		this.street = street;
		this.url = url;
		this.text = text;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.venue = venue;
		this.venue = venue;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getThumbnailURL() {
		return thumbnailURL;
	}
	public void setThumbnailURL(String thumbnailURL) {
		this.thumbnailURL = thumbnailURL;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
}
