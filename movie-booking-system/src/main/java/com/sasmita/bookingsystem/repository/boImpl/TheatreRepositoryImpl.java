package com.sasmita.bookingsystem.repository.boImpl;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sasmita.bookingsystem.entity.City;
import com.sasmita.bookingsystem.entity.Theatre;
import com.sasmita.bookingsystem.repository.bo.TheatreRepository;

@SuppressWarnings("unchecked")
@Repository
public class TheatreRepositoryImpl implements TheatreRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Theatre> getAllTheatreDetails(City city) {
		List<String> cityNameList = Arrays.asList(city.getName());
		String sqlQuery = "SELECT t FROM Theatre t JOIN t.city c WHERE c.name IN :cityNames";
		Query query = this.em.createQuery(sqlQuery).setParameter("cityNames", cityNameList);
		return query.getResultList();	
	}

	@Override
	public List<Theatre> getAllTheatreDetailsByName(Theatre theatre) {
		String sqlQuery = "SELECT t FROM Theatre t JOIN t.city c WHERE t.name LIKE '%"+theatre.getName().trim()+"%'"
				+" AND c.name='"+theatre.getCityName()+"'";
		Query query = this.em.createQuery(sqlQuery);
		return query.getResultList();
		
	}

}
