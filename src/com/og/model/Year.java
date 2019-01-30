package com.og.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the year database table.
 * 
 */
@Entity
@NamedQuery(name="Year.findAll", query="SELECT y FROM Year y")
public class Year implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int year_Id;

	private int year;

	//bi-directional many-to-one association to Movie
	@OneToMany(mappedBy="year")
	private List<Movie> movies;

	public Year() {
	}

	public int getYear_Id() {
		return this.year_Id;
	}

	public void setYear_Id(int year_Id) {
		this.year_Id = year_Id;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Movie> getMovies() {
		return this.movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public Movie addMovy(Movie movy) {
		getMovies().add(movy);
		movy.setYear(this);

		return movy;
	}

	public Movie removeMovy(Movie movy) {
		getMovies().remove(movy);
		movy.setYear(null);

		return movy;
	}

}