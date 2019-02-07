package com.og.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;

import com.og.dao.EntityFinder;
import com.og.model.Country;
import com.og.model.Movie;

@Named
@SessionScoped
public class IndexBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(this.getClass());
	private List<Country> countries;
	private List<Movie> movies;
	private String country;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Country> getCountries() 
	{
		EntityFinder ef = new EntityFinder();
		this.countries = (List<Country>) ef.findAll(Country.class, Country.class.getName().substring(13));
		return this.countries;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getCountry() 
	{
		EntityFinder ef = new EntityFinder();
		this.country = ((Country)ef.findOne(Country.class,1)).getName();
		return this.country;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Movie> getMovies()
	{
		EntityFinder ef = new EntityFinder();
		this.movies = ((List<Movie>) ef.findAll(Movie.class, Movie.class.getName().substring(13)));
		return this.movies;
	}
}
