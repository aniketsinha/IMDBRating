package com.scraper.imdb;

public class ScrapperConstants {
	public static final String IMDB_REQUEST_URL_FORMAT = "http://www.imdb.com/search/title?sort=user_rating,desc&title=%s&title_type=feature,tv_movie";
	public static final String ALL_ELEMENTS_SELECTOR_QUERY = ".lister-item.mode-advanced div.lister-item-content";
	public static final String TITLE_SELECTOR_QUERY = "h3.lister-item-header";
	public static final String RATING_SELECTOR_QUERY = "div.ratings-bar div.inline-block.ratings-imdb-rating";
	public static final int TIMEOUT = 6000;
}
