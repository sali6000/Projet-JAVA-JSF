package com.og.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the package_movie database table.
 * 
 */
@Entity
@Table(name="package_movie")
@NamedQuery(name="PackageMovie.findAll", query="SELECT p FROM PackageMovie p")
public class PackageMovie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int package_Movie_Id;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	@JoinColumn(name="FK_Movie")
	private Movie movie;

	//bi-directional many-to-one association to Package
	@ManyToOne
	@JoinColumn(name="FK_Package")
	private Package _package;

	public PackageMovie() {
	}

	public int getPackage_Movie_Id() {
		return this.package_Movie_Id;
	}

	public void setPackage_Movie_Id(int package_Movie_Id) {
		this.package_Movie_Id = package_Movie_Id;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Package getPackage() {
		return this._package;
	}

	public void setPackage(Package _package) {
		this._package = _package;
	}

}