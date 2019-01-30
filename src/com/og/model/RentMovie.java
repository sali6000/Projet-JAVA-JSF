package com.og.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rent_movie database table.
 * 
 */
@Entity
@Table(name="rent_movie")
@NamedQuery(name="RentMovie.findAll", query="SELECT r FROM RentMovie r")
public class RentMovie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int rent_Movie_Id;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	@JoinColumn(name="FK_Movie")
	private Movie movie;

	//bi-directional many-to-one association to Rent
	@ManyToOne
	@JoinColumn(name="FK_Rent")
	private Rent rent;

	public RentMovie() {
	}

	public int getRent_Movie_Id() {
		return this.rent_Movie_Id;
	}

	public void setRent_Movie_Id(int rent_Movie_Id) {
		this.rent_Movie_Id = rent_Movie_Id;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Rent getRent() {
		return this.rent;
	}

	public void setRent(Rent rent) {
		this.rent = rent;
	}

}