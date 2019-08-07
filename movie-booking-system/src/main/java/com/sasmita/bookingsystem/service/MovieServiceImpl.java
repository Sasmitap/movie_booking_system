package com.sasmita.bookingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasmita.bookingsystem.entity.Movie;
import com.sasmita.bookingsystem.repository.bo.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public List<Movie> getAllMovieDetailsByName(Movie movie) {
		return movieRepository.getAllMovieDetailsByName(movie);
	}

	@Override
	public List<Movie> getAllMovieByLanguageAndTimeRange(Movie movie) {
		return movieRepository.getAllMovieByLanguageAndTimeRange(movie);
	}

}
