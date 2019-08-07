package com.sasmita.bookingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasmita.bookingsystem.entity.BookingInfo;
import com.sasmita.bookingsystem.entity.Seat;
import com.sasmita.bookingsystem.repository.bo.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	BookingRepository bookingRepository;

	@Override
	public List<Seat> getAvailableNoOfSeatsForParticularTheatreAndMovie(BookingInfo bookingInfo) {
		return bookingRepository.getAvailableNoOfSeatsForParticularTheatreAndMovie(bookingInfo);
	}

	@Override
	public void saveBookingDetails(BookingInfo addBookingDetails) {
		bookingRepository.saveBookingDetails(addBookingDetails);
	}

	@Override
	public void updateSeatDetails(Seat seat) {
		bookingRepository.updateSeatDetails(seat);
	}

	@Override
	public List<Object> getAllBookingDetails(int userId) {
		return bookingRepository.getAllBookingDetails(userId);
	}

}
