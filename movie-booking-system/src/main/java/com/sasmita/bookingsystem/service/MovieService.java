package com.sasmita.bookingsystem.service;

import java.util.List;

import com.sasmita.bookingsystem.entity.Movie;

public interface MovieService {

	List<Movie> getAllMovieDetailsByName(Movie movie);

	List<Movie> getAllMovieByLanguageAndTimeRange(Movie movie);
	

}
