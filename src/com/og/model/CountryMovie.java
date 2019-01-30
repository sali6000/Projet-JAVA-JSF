package com.og.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the country_movie database table.
 * 
 */
@Entity
@Table(name="country_movie")
@NamedQuery(name="CountryMovie.findAll", query="SELECT c FROM CountryMovie c")
public class CountryMovie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int country_Movie_Id;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="FK_Country")
	private Country country;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	@JoinColumn(name="FK_Movie")
	private Movie movie;

	public CountryMovie() {
	}

	public int getCountry_Movie_Id() {
		return this.country_Movie_Id;
	}

	public void setCountry_Movie_Id(int country_Movie_Id) {
		this.country_Movie_Id = country_Movie_Id;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}