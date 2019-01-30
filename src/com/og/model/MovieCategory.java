package com.og.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the movie_category database table.
 * 
 */
@Entity
@Table(name="movie_category")
@NamedQuery(name="MovieCategory.findAll", query="SELECT m FROM MovieCategory m")
public class MovieCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int movie_Category_Id;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="FK_Category")
	private Category category;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	@JoinColumn(name="FK_Movie")
	private Movie movie;

	public MovieCategory() {
	}

	public int getMovie_Category_Id() {
		return this.movie_Category_Id;
	}

	public void setMovie_Category_Id(int movie_Category_Id) {
		this.movie_Category_Id = movie_Category_Id;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}