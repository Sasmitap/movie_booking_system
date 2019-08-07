package com.sasmita.bookingsystem.repository.boImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sasmita.bookingsystem.entity.Movie;
import com.sasmita.bookingsystem.repository.bo.MovieRepository;

@SuppressWarnings("unchecked")
@Repository
public class MovieRepositoryImpl implements MovieRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<Movie> getAllMovieDetailsByName(Movie movie) {
		String sqlQuery = "SELECT m FROM Movie m JOIN m.theatre t JOIN t.city c WHERE m.movieName LIKE '%"+movie.getMovieName().trim()+"%'"
				+" AND c.name='"+movie.getCityName()+"'";
		Query query = this.em.createQuery(sqlQuery);
		return query.getResultList();
	}


	@Override
	public List<Movie> getAllMovieByLanguageAndTimeRange(Movie movie) {
		String sqlQuery = "SELECT m FROM Movie m JOIN m.theatre t JOIN t.city c WHERE m.language LIKE '%"+movie.getLanguage().trim()+"%'"
				+" AND c.name='"+movie.getCityName()+"' AND (m.movieTiming >='"+movie.getStratTime()+"' AND m.movieTiming <='"+movie.getEndTime()+"')";
		Query query = this.em.createQuery(sqlQuery);
		return query.getResultList();
	}

}
