package com.sasmita.bookingsystem.repository.bo;

import java.util.List;

import com.sasmita.bookingsystem.entity.BookingInfo;
import com.sasmita.bookingsystem.entity.Seat;

public interface BookingRepository {

	List<Seat> getAvailableNoOfSeatsForParticularTheatreAndMovie(BookingInfo bookingInfo);

	void saveBookingDetails(BookingInfo addBookingDetails);

	void updateSeatDetails(Seat seat);

	List<Object> getAllBookingDetails(int userId);

}
