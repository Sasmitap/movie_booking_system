package com.sasmita.bookingsystem.repository.bo;

import java.util.List;

import com.sasmita.bookingsystem.entity.Movie;

public interface MovieRepository {

	List<Movie> getAllMovieDetailsByName(Movie movie);

	List<Movie> getAllMovieByLanguageAndTimeRange(Movie movie);

}
