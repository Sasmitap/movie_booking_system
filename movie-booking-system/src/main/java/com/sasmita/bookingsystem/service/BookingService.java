package com.sasmita.bookingsystem.service;

import java.util.List;

import com.sasmita.bookingsystem.entity.BookingInfo;
import com.sasmita.bookingsystem.entity.Seat;

public interface BookingService {

	public List<Seat> getAvailableNoOfSeatsForParticularTheatreAndMovie(BookingInfo bookingInfo);

	public void saveBookingDetails(BookingInfo addBookingDetails);

	public void updateSeatDetails(Seat seat);

	public List<Object> getAllBookingDetails(int userId);

}
