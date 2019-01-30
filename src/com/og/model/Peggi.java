package com.og.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the peggi database table.
 * 
 */
@Entity
@NamedQuery(name="Peggi.findAll", query="SELECT p FROM Peggi p")
public class Peggi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int peggi_Id;

	private String name;

	//bi-directional many-to-one association to Movie
	@OneToMany(mappedBy="peggi")
	private List<Movie> movies;

	public Peggi() {
	}

	public int getPeggi_Id() {
		return this.peggi_Id;
	}

	public void setPeggi_Id(int peggi_Id) {
		this.peggi_Id = peggi_Id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getMovies() {
		return this.movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public Movie addMovy(Movie movy) {
		getMovies().add(movy);
		movy.setPeggi(this);

		return movy;
	}

	public Movie removeMovy(Movie movy) {
		getMovies().remove(movy);
		movy.setPeggi(null);

		return movy;
	}

}