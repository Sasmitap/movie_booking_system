package com.sasmita.bookingsystem.repository.boImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sasmita.bookingsystem.entity.BookingInfo;
import com.sasmita.bookingsystem.entity.Seat;
import com.sasmita.bookingsystem.repository.bo.BookingRepository;

@SuppressWarnings("unchecked")
@Repository
public class BookingRepositoryImpl implements BookingRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Seat> getAvailableNoOfSeatsForParticularTheatreAndMovie(BookingInfo bookingInfo) {
		String sqlQuery = "Select s From Seat s JOIN s.theatre t WHERE t.theatreId="+bookingInfo.getTheatreId();
		Query query = this.em.createQuery(sqlQuery);
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveBookingDetails(BookingInfo addBookingDetails) {
		em.persist(addBookingDetails);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateSeatDetails(Seat seat) {
		this.em.merge(seat);
	}

	@Override
	public List<Object> getAllBookingDetails(int userId) {
		String sqlQuery = "Select u.userId, u.name, t.theatreId, t.name, m.movieId, m.movieName, m.movieTiming, m.language, c.cityId, c.name, "
				+ "b.bookedDate, b.eventDate, b.bookingStatus, b.bookingId From BookingInfo b JOIN b.userInfo u JOIN b.theatreInfo t JOIN b.movieInfo m "
				+ "JOIN t.city c WHERE u.userId="+userId+" AND b.bookingStatus='booked'";
		Query query = this.em.createQuery(sqlQuery);
		return query.getResultList();
	}

}
