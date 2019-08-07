package com.sasmita.bookingsystem.repository.bo;

import java.util.List;

import com.sasmita.bookingsystem.entity.City;
import com.sasmita.bookingsystem.entity.Theatre;

public interface TheatreRepository {

	List<Theatre> getAllTheatreDetails(City city);

	List<Theatre> getAllTheatreDetailsByName(Theatre theatre);

}
