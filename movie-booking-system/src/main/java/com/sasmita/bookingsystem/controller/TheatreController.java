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

import com.sasmita.bookingsystem.entity.City;
import com.sasmita.bookingsystem.entity.Theatre;
import com.sasmita.bookingsystem.model.TheatreDetailsModel;
import com.sasmita.bookingsystem.service.TheatreService;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	@Autowired
	TheatreService theatreService;
	
	@PostMapping("/getAllTheatre")
	public @ResponseBody List<TheatreDetailsModel> getAllTheatreDetails(@RequestBody City city) throws TheatreNotFoundException{
		logger.info("getAllTheatreDetails() starts");
		logger.info(" CityName is "+city.getName());
		List<TheatreDetailsModel> theatreModelList = new ArrayList<TheatreDetailsModel>();
		List<Theatre> theatreList = theatreService.getAllTheatreDetails(city);
		logger.info("No Of Theatres Available :::"+theatreList.size());
		if(theatreList.size()==0){
			throw new TheatreNotFoundException("", "", city.getName());
		}else{
			 theatreList.stream().forEach(theatreL->theatreModelList.add(new TheatreDetailsModel(theatreL.getTheatreId(), theatreL.getName(), theatreL.getNoOfSeats(), theatreL.getCity().getCityId(), theatreL.getCity().getName())));
		}
		logger.info("getAllTheatreDetails() ends");
		return theatreModelList;
	}
	
	@PostMapping("/getAllTheatreByName")
	public @ResponseBody List<TheatreDetailsModel> getAllTheatreDetailsByName(@RequestBody Theatre theatre) throws TheatreNotFoundException{
		logger.info("getAllTheatreDetailsByName() starts");
		logger.info("Theatre Name Is :::"+theatre.getName());
		List<TheatreDetailsModel> theatreModelList = new ArrayList<TheatreDetailsModel>();
		List<Theatre> theatreList = theatreService.getAllTheatreDetailsByName(theatre);
		logger.info("No Of Theatres Available :::"+theatreList.size());
		if(theatreList.size()==0){
			throw new TheatreNotFoundException("", "", theatre.getName());
		}else{
			 theatreList.stream().forEach(theatreL->theatreModelList.add(new TheatreDetailsModel(theatreL.getTheatreId(), theatreL.getName(), theatreL.getNoOfSeats(), theatreL.getCity().getCityId(), theatreL.getCity().getName())));
		}
		logger.info("getAllTheatreDetailsByName() starts");
		return theatreModelList;
	}
	

}
