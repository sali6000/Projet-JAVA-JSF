package com.og.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the movie database table.
 * 
 */
@Entity
@NamedQuery(name="Movie.findAll", query="SELECT m FROM Movie m")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int movie_Id;

	private int duration_Minute;

	private String image;

	private byte isActive;

	private float price;

	private int rate;

	private String summarize;

	private String title;

	//bi-directional many-to-one association to CountryMovie
	@OneToMany(mappedBy="movie")
	private List<CountryMovie> countryMovies;

	//bi-directional many-to-one association to Peggi
	@ManyToOne
	@JoinColumn(name="FK_Peggi")
	private Peggi peggi;

	//bi-directional many-to-one association to Year
	@ManyToOne
	@JoinColumn(name="FK_Year")
	private Year year;

	//bi-directional many-to-one association to MovieAuthor
	@OneToMany(mappedBy="movie")
	private List<MovieAuthor> movieAuthors;

	//bi-directional many-to-one association to MovieCategory
	@OneToMany(mappedBy="movie")
	private List<MovieCategory> movieCategories;

	//bi-directional many-to-one association to RentMovie
	@OneToMany(mappedBy="movie")
	private List<RentMovie> rentMovies;

	//bi-directional many-to-one association to BatchMovie
	@OneToMany(mappedBy="movie")
	private List<BatchMovie> batchMovies;

	public Movie() {
	}

	public int getMovie_Id() {
		return this.movie_Id;
	}

	public void setMovie_Id(int movie_Id) {
		this.movie_Id = movie_Id;
	}

	public int getDuration_Minute() {
		return this.duration_Minute;
	}

	public void setDuration_Minute(int duration_Minute) {
		this.duration_Minute = duration_Minute;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getSummarize() {
		return this.summarize;
	}

	public void setSummarize(String summarize) {
		this.summarize = summarize;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<CountryMovie> getCountryMovies() {
		return this.countryMovies;
	}

	public void setCountryMovies(List<CountryMovie> countryMovies) {
		this.countryMovies = countryMovies;
	}

	public CountryMovie addCountryMovy(CountryMovie countryMovy) {
		getCountryMovies().add(countryMovy);
		countryMovy.setMovie(this);

		return countryMovy;
	}

	public CountryMovie removeCountryMovy(CountryMovie countryMovy) {
		getCountryMovies().remove(countryMovy);
		countryMovy.setMovie(null);

		return countryMovy;
	}

	public Peggi getPeggi() {
		return this.peggi;
	}

	public void setPeggi(Peggi peggi) {
		this.peggi = peggi;
	}

	public Year getYear() {
		return this.year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public List<MovieAuthor> getMovieAuthors() {
		return this.movieAuthors;
	}

	public void setMovieAuthors(List<MovieAuthor> movieAuthors) {
		this.movieAuthors = movieAuthors;
	}

	public MovieAuthor addMovieAuthor(MovieAuthor movieAuthor) {
		getMovieAuthors().add(movieAuthor);
		movieAuthor.setMovie(this);

		return movieAuthor;
	}

	public MovieAuthor removeMovieAuthor(MovieAuthor movieAuthor) {
		getMovieAuthors().remove(movieAuthor);
		movieAuthor.setMovie(null);

		return movieAuthor;
	}

	public List<MovieCategory> getMovieCategories() {
		return this.movieCategories;
	}

	public void setMovieCategories(List<MovieCategory> movieCategories) {
		this.movieCategories = movieCategories;
	}

	public MovieCategory addMovieCategory(MovieCategory movieCategory) {
		getMovieCategories().add(movieCategory);
		movieCategory.setMovie(this);

		return movieCategory;
	}

	public MovieCategory removeMovieCategory(MovieCategory movieCategory) {
		getMovieCategories().remove(movieCategory);
		movieCategory.setMovie(null);

		return movieCategory;
	}

	public List<RentMovie> getRentMovies() {
		return this.rentMovies;
	}

	public void setRentMovies(List<RentMovie> rentMovies) {
		this.rentMovies = rentMovies;
	}

	public RentMovie addRentMovy(RentMovie rentMovy) {
		getRentMovies().add(rentMovy);
		rentMovy.setMovie(this);

		return rentMovy;
	}

	public RentMovie removeRentMovy(RentMovie rentMovy) {
		getRentMovies().remove(rentMovy);
		rentMovy.setMovie(null);

		return rentMovy;
	}

	public List<BatchMovie> getBatchMovies() {
		return this.batchMovies;
	}

	public void setBatchMovies(List<BatchMovie> batchMovies) {
		this.batchMovies = batchMovies;
	}

	public BatchMovie addBatchMovy(BatchMovie batchMovy) {
		getBatchMovies().add(batchMovy);
		batchMovy.setMovie(this);

		return batchMovy;
	}

	public BatchMovie removeBatchMovy(BatchMovie batchMovy) {
		getBatchMovies().remove(batchMovy);
		batchMovy.setMovie(null);

		return batchMovy;
	}

}