package com.sasmita.bookingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasmita.bookingsystem.entity.City;
import com.sasmita.bookingsystem.entity.Theatre;
import com.sasmita.bookingsystem.repository.bo.TheatreRepository;

@Service
public class TheatreServiceImpl implements TheatreService{
	
	@Autowired
	TheatreRepository theatreRepository;

	@Override
	public List<Theatre> getAllTheatreDetails(City city) {
		return theatreRepository.getAllTheatreDetails(city);
	}

	@Override
	public List<Theatre> getAllTheatreDetailsByName(Theatre theatre) {
		return theatreRepository.getAllTheatreDetailsByName(theatre);
	}

}
