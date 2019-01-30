package com.og.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the author database table.
 * 
 */
@Entity
@NamedQuery(name="Author.findAll", query="SELECT a FROM Author a")
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int author_Id;

	private String firstname;

	private byte isActive;

	private String lastname;

	//bi-directional many-to-one association to MovieAuthor
	@OneToMany(mappedBy="author")
	private List<MovieAuthor> movieAuthors;

	public Author() {
	}

	public int getAuthor_Id() {
		return this.author_Id;
	}

	public void setAuthor_Id(int author_Id) {
		this.author_Id = author_Id;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<MovieAuthor> getMovieAuthors() {
		return this.movieAuthors;
	}

	public void setMovieAuthors(List<MovieAuthor> movieAuthors) {
		this.movieAuthors = movieAuthors;
	}

	public MovieAuthor addMovieAuthor(MovieAuthor movieAuthor) {
		getMovieAuthors().add(movieAuthor);
		movieAuthor.setAuthor(this);

		return movieAuthor;
	}

	public MovieAuthor removeMovieAuthor(MovieAuthor movieAuthor) {
		getMovieAuthors().remove(movieAuthor);
		movieAuthor.setAuthor(null);

		return movieAuthor;
	}

}