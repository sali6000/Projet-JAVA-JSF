package com.og.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import com.og.dao.EntityFinder;
import com.og.model.Movie;

@Named
@SessionScoped
public class MovieListBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(this.getClass());
	private List<Character> prefixMovies;
	private List<Movie> movies;
	private char letterFilter = '*';
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String filter()
	{
		EntityFinder ef = new EntityFinder();
		this.movies = ((List<Movie>) ef.findAll(Movie.class, Movie.class.getName().substring(13)));
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		this.letterFilter = request.getParameter("letterFilter").charAt(0);
		for(int i = 0; i < this.movies.size(); i++)
		{
			if(this.movies.get(i).getTitle().toUpperCase().charAt(0) != this.letterFilter && (this.letterFilter != '*') && !(this.letterFilter == '#' && Character.isDigit(this.movies.get(i).getTitle().toUpperCase().charAt(0))))
			{
					this.movies.remove(i);
					i--;
			}
		}
		return "/views/movie/MovieList.xhtml";
	}
		
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Movie> getMovies()
	{
		if(this.letterFilter == '*')
		{
			EntityFinder ef = new EntityFinder();
			this.movies = ((List<Movie>) ef.findAll(Movie.class, Movie.class.getName().substring(13)));
		}
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
