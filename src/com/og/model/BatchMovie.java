package com.og.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the batch_movie database table.
 * 
 */
@Entity
@Table(name="batch_movie")
@NamedQuery(name="BatchMovie.findAll", query="SELECT b FROM BatchMovie b")
public class BatchMovie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int batch_Movie_Id;

	//bi-directional many-to-one association to Batch
	@ManyToOne
	@JoinColumn(name="FK_Batch")
	private Batch batch;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	@JoinColumn(name="FK_Movie")
	private Movie movie;

	public BatchMovie() {
	}

	public int getBatch_Movie_Id() {
		return this.batch_Movie_Id;
	}

	public void setBatch_Movie_Id(int batch_Movie_Id) {
		this.batch_Movie_Id = batch_Movie_Id;
	}

	public Batch getBatch() {
		return this.batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}