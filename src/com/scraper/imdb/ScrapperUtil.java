package com.scraper.imdb;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapperUtil {
	public static ArrayList<Movie> scrapForMovie(String movieName) throws IOException {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		String url = String.format(ScrapperConstants.IMDB_REQUEST_URL_FORMAT, movieName);
		Document document = Jsoup.connect(url).timeout(ScrapperConstants.TIMEOUT).get();
		Elements allElements = document.select(ScrapperConstants.ALL_ELEMENTS_SELECTOR_QUERY);
		if(allElements.isEmpty()) {
			return movies;
		}
		else {
			for(Element element: allElements) {
				String title = element.select(ScrapperConstants.TITLE_SELECTOR_QUERY).text();
				String rating = element.select(ScrapperConstants.RATING_SELECTOR_QUERY).text();
				Movie iterMovie = new Movie(title, rating);
				movies.add(iterMovie);
			}
		}
		return movies;
	}
}
