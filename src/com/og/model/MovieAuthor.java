package com.og.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the movie_author database table.
 * 
 */
@Entity
@Table(name="movie_author")
@NamedQuery(name="MovieAuthor.findAll", query="SELECT m FROM MovieAuthor m")
public class MovieAuthor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int movie_Author_Id;

	//bi-directional many-to-one association to Author
	@ManyToOne
	@JoinColumn(name="FK_Author")
	private Author author;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	@JoinColumn(name="FK_Movie")
	private Movie movie;

	public MovieAuthor() {
	}

	public int getMovie_Author_Id() {
		return this.movie_Author_Id;
	}

	public void setMovie_Author_Id(int movie_Author_Id) {
		this.movie_Author_Id = movie_Author_Id;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}