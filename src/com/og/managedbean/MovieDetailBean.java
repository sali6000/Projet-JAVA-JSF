package com.og.managedbean;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.og.dao.EntityFinder;
import com.og.model.Country;
import com.og.model.Movie;

@Named
@SessionScoped
public class MovieDetailBean implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(this.getClass());
	private int id;
	private Movie movie;

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String movieDetail()
	{
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		this.id = Integer.parseInt(request.getParameter("id"));
		EntityFinder ef = new EntityFinder();
		this.movie = ((Movie)ef.findOne(Movie.class,this.id));
		return "/views/movie/MovieDetail.xhtml";
		
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public Movie getMovie()
	{
		return this.movie;
	}
}
