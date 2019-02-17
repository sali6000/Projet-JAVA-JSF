package com.og.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.apache.log4j.Logger;
import com.og.dao.EntityFinder;
import com.og.model.Movie;

@Named
@SessionScoped
public class MovieListBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(this.getClass());
	private List<Movie> movies;
	private List<Character> prefixMovies;
		
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Movie> getMovies()
	{
		EntityFinder ef = new EntityFinder();
		this.movies = ((List<Movie>) ef.findAll(Movie.class, Movie.class.getName().substring(13)));
		return this.movies;
	}
	
	public List<Character> getPrefixMovies()
	{
		prefixMovies = new ArrayList<Character>();
		
		for(Character c : "#ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray())
		{
			prefixMovies.add(c);
		}
		return this.prefixMovies;
	}
}
