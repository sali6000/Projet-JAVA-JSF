package com.og.managedbean;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.apache.log4j.Logger;
import com.og.dao.EntityFinder;
import com.og.model.Movie;

@Named
@SessionScoped
public class IndexBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(this.getClass());
	private List<Movie> movies;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Movie> getMovies()
	{
		System.out.println(System.getProperty("catalina.base"));
		EntityFinder ef = new EntityFinder();
		this.movies = ((List<Movie>) ef.findAll(Movie.class, Movie.class.getName().substring(13)));
		return this.movies;
	}
	
	public String returnMenu()
	{
		return "../index.xhtml";
	}
}