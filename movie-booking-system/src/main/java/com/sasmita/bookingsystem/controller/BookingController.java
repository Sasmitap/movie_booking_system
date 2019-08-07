
package com.sasmita.bookingsystem.controller;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sasmita.bookingsystem.config.BookingNotFoundException;
import com.sasmita.bookingsystem.entity.BookingInfo;
import com.sasmita.bookingsystem.entity.Movie;
import com.sasmita.bookingsystem.entity.Seat;
import com.sasmita.bookingsystem.entity.Theatre;
import com.sasmita.bookingsystem.entity.UserInfo;
import com.sasmita.bookingsystem.model.BookingDetailsModel;
import com.sasmita.bookingsystem.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
	@Autowired
	BookingService bookingService;


	@PostMapping("/ticketBooking")
	public @ResponseBody List<BookingDetailsModel> saveBookingDetails(@RequestBody BookingInfo bookingInfo) throws SeatNotAvailableException, BookingFailedException, BookingNotFoundException{
		List<BookingDetailsModel> bookingDetailInformation = new ArrayList<BookingDetailsModel>();
		logger.info("saveBookingDetails() starts");
		logger.info("UserId Is :::"+bookingInfo.getUserId()+" Theatre Name ::"+bookingInfo.getTheatreName()+"Movie Name :::"+bookingInfo.getMovieName());
		logger.info("Booking Request Time Is :::"+new Date());

		/**
		 * get the available no of seats
		 */
		List<Seat> seatInfo = bookingService.getAvailableNoOfSeatsForParticularTheatreAndMovie(bookingInfo);
		if(seatInfo.size()==0){
			throw new SeatNotAvailableException("", "", bookingInfo.getMovieName());
		}else{
			logger.info("No. Of Available Seat :::"+seatInfo.get(0).getAvailableNoOfSeat()+" No.Of Booked Seat :::"+seatInfo.get(0).getBookedNoOfSeat());
			if(seatInfo.get(0).getAvailableNoOfSeat() == seatInfo.get(0).getBookedNoOfSeat())
				throw new SeatNotAvailableException("", "", bookingInfo.getMovieName());
			else if(seatInfo.get(0).getAvailableNoOfSeat() < seatInfo.get(0).getBookedNoOfSeat())
				throw new SeatNotAvailableException("", "", bookingInfo.getMovieName());
			else{
				try{
					/**
					 * Book the seat and decrease the number of seat
					 */
					seatInfo.get(0).setAvailableNoOfSeat(seatInfo.get(0).getAvailableNoOfSeat()-1);
					seatInfo.get(0).setBookedNoOfSeat(seatInfo.get(0).getBookedNoOfSeat()+1);

					/**
					 * Persist Booked Details
					 */
					BookingInfo addBookingDetails = new BookingInfo();
					addBookingDetails.setBookedDate(new Date());
					addBookingDetails.setEventDate(bookingInfo.getEventDate());
					addBookingDetails.setBookingStatus("Booked");
					addBookingDetails.setMovieTiming(bookingInfo.getMovieTiming());
					UserInfo userDet = new UserInfo();
					userDet.setUserId(bookingInfo.getUserId());
					addBookingDetails.setUserInfo(userDet);
					Theatre theatreDet = new Theatre();
					theatreDet.setTheatreId(bookingInfo.getTheatreId());
					addBookingDetails.setTheatreInfo(theatreDet);
					Movie movieDet = new Movie();
					movieDet.setMovieId(bookingInfo.getMovieId());
					addBookingDetails.setMovieInfo(movieDet);
					bookingService.saveBookingDetails(addBookingDetails);

					bookingService.updateSeatDetails(seatInfo.get(0));
				}catch(Exception e){
					logger.info("Exception has been occured while booking");
					e.printStackTrace();
					throw new BookingFailedException("","",bookingInfo.getMovieName());
				}

			}

		}
		logger.info("saveBookingDetails() ends");

		/**
		 * get All the Booking Details for the user
		 */
		List<Object> bookingDetailsList = bookingService.getAllBookingDetails(bookingInfo.getUserId());
		if(bookingDetailsList.size() == 0){
			throw new BookingNotFoundException("", "", "");
		}else{
			Iterator<Object> iterator = bookingDetailsList.iterator();
			while(iterator.hasNext()){
				Object[] obj = (Object[]) iterator.next();
				BookingDetailsModel bookigDetails = new BookingDetailsModel();
				bookigDetails.setUserId((int) obj[0]);
				bookigDetails.setUserName((String) obj[1]);
				bookigDetails.setTheatreId((int) obj[2]);
				bookigDetails.setTheatreName((String) obj[3]);
				bookigDetails.setMovieId((int) obj[4]);
				bookigDetails.setMovieName((String) obj[5]);
				bookigDetails.setMovieTime((Time) obj[6]);
				bookigDetails.setLanguage((String) obj[7]);
				bookigDetails.setCityId((int) obj[8]);
				bookigDetails.setCityName((String) obj[9]);
				bookigDetails.setBookingDate(formatter.format((Date) obj[10]));
				bookigDetails.setEventDate(formatter.format((Date)obj[11]));
				bookigDetails.setBookingStatus((String) obj[12]);
				bookigDetails.setBookingId((int) obj[13]);
				bookingDetailInformation.add(bookigDetails);
			}
			
			return bookingDetailInformation;
		}
	}

}
