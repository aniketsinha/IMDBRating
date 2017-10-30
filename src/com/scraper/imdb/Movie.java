package com.scraper.imdb;

public class Movie {
	
	private String title;
	private float rating;
	
	public Movie (String title, String rating) {
		setTitle(title);
		if(!rating.equals("")) {
			setRating(Float.parseFloat(rating));
		}
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(title).append(" - ");
		if(rating == 0.0) {
			sb.append("No rating");
		}
		else {
			sb.append(rating);
		}
		return sb.toString();
		
	}
	
}
