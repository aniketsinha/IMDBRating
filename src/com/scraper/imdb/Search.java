package com.scraper.imdb;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Search {
	private static Logger logger = null; 
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter movie name: ");
		String movieName = in.nextLine().trim();
		in.close();
		logger = Logger.getLogger(movieName);
		System.out.println("Searching IMDB for \""+movieName+ "\"...");
		searchMovies(movieName);
		
	}
	
	public static void searchMovies(String movieName) {
		ArrayList<Movie> allMovies = null;
		try {
			allMovies = ScrapperUtil.scrapForMovie(movieName);
			if(allMovies.size() == 0) {
				System.out.println("No movies found!");
			}
			for(Movie movie: allMovies) {
				System.out.println(movie);
			}
		}
		catch(UnknownHostException uhe) {
			logger.log(Level.SEVERE, "UnknownHostException: Unable to resolve host. "+uhe.getMessage());
		}
		catch(SocketTimeoutException ste) {
			logger.log(Level.SEVERE, "SocketTimeoutException: Request timed out. "+ste.getMessage());
		}
		catch (IOException e) {
			logger.log(Level.SEVERE, "Exception occured. Exception = "+e.getMessage());
			e.printStackTrace();
		}
	}
}
