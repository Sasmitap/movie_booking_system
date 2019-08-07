package com.sasmita.bookingsystem.service;

import java.util.List;

import com.sasmita.bookingsystem.entity.City;
import com.sasmita.bookingsystem.entity.Theatre;

public interface TheatreService {

	List<Theatre> getAllTheatreDetails(City city);

	List<Theatre> getAllTheatreDetailsByName(Theatre theatre);

}
