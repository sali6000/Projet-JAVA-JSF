package com.og.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

import com.og.dao.EntityFinder;
import com.og.model.Movie;

@Named
@SessionScoped
public class MovieSearchBean implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private List<Movie> moviesFromDB;
	private List<Movie> moviesMatch;
	private String searchString;
	private String result;
	
	public List<Movie> getMoviesMatch()
	{
		return this.moviesMatch;
	}
	
	public String getResult()
	{
		return result;
	}
	
	public String getSearchString()
	{
		return searchString;
	}
	
	public void setSearchString(String s)
	{
		this.searchString = s;
	}
	
	public void searchStringValueChanged(ValueChangeEvent vce)
	{
	    searchByTitle(vce.getNewValue().toString().toUpperCase());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void searchByTitle(String searchTitle)
	{
		if(this.moviesFromDB == null)
		{
			EntityFinder ef = new EntityFinder();
			this.moviesFromDB = ((List<Movie>) ef.findAll(Movie.class, Movie.class.getName().substring(13)));
		}
		this.moviesMatch = new ArrayList<Movie>();
		int i = 0;
		// V�rifier parmis la list de films si un film correspond � l'entr�e ajax
		for(Movie m : this.moviesFromDB)
		{
			// Si un film correspond � la recherche
			if(m.getTitle().toUpperCase().contains(searchTitle.toUpperCase()))
			{
				this.moviesMatch.add(m);
				i++;				
			}
		}
		this.result = ""+i+" film(s) trouv�(s). Appuyez sur ENTER pour afficher le r�sultat.";
		
		// Si le r�sultat ne contient pas le film recherch�
		if(!(i>0))
		{
			this.result = "Aucun film n'a �t� trouv�.";
			this.moviesMatch = null;
		}
		else if(searchTitle.isEmpty())
		{
			this.result = "";
			this.moviesMatch = null;
		}
	}
}
