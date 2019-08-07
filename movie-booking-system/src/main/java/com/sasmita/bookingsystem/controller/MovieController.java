package com.sasmita.bookingsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sasmita.bookingsystem.entity.Movie;
import com.sasmita.bookingsystem.model.MovieDetailsModel;
import com.sasmita.bookingsystem.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	@PostMapping("/getAllMovieByName")
	public @ResponseBody List<MovieDetailsModel> getAllMovieDetailsByName(@RequestBody Movie movie) throws MovieNotFoundException{
		logger.info("getAllMovieDetailsByName() starts");
		logger.info("Movie Name Is :::"+movie.getMovieName());
		List<MovieDetailsModel> movieModelList = new ArrayList<MovieDetailsModel>();
		List<Movie> movieList = movieService.getAllMovieDetailsByName(movie);
		logger.info("No Of Movies Available :::"+movieList.size());
		if(movieList.size()==0){
			throw new MovieNotFoundException("", "", movie.getMovieName());
		}else{
			movieList.stream().forEach(movieL->movieModelList.add(new MovieDetailsModel(movieL.getMovieId(), movieL.getMovieName(), 
					movieL.getMovieTiming(), movieL.getLanguage(), movieL.getTheatre().getName(), movieL.getTheatre().getTheatreId(), 
					movieL.getTheatre().getCity().getCityId(), movieL.getTheatre().getCity().getName(), movieL.getTheatre().getNoOfSeats())));
		}
		logger.info("getAllMovieDetailsByName() Ends");
		return movieModelList;
	}
	
	@PostMapping("/getAllMovieByLanguageAndTimeRange")
	public @ResponseBody List<MovieDetailsModel> getAllMovieByLanguageAndTimeRange(@RequestBody Movie movie) throws MovieNotFoundException{
		logger.info("getAllMovieByLanguageAndTimeRange() starts");
		logger.info("Movie Name Is :::"+movie.getMovieName()+" For the city :::"+movie.getCityName()+" For Time Range :::"+movie.getStratTime()+" To "+movie.getEndTime());
		List<MovieDetailsModel> movieModelList = new ArrayList<MovieDetailsModel>();
		List<Movie> movieList = movieService.getAllMovieByLanguageAndTimeRange(movie);
		logger.info("No Of Movies Available :::"+movieList.size());
		if(movieList.size()==0){
			throw new MovieNotFoundException("", "", movie.getMovieName());
		}else{
			movieList.stream().forEach(movieL->movieModelList.add(new MovieDetailsModel(movieL.getMovieId(), movieL.getMovieName(), 
					movieL.getMovieTiming(), movieL.getLanguage(), movieL.getTheatre().getName(), movieL.getTheatre().getTheatreId(), 
					movieL.getTheatre().getCity().getCityId(), movieL.getTheatre().getCity().getName(), movieL.getTheatre().getNoOfSeats())));
		}
		logger.info("getAllMovieByLanguageAndTimeRange() Ends");
		return movieModelList;
	}

}
