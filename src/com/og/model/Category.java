package com.og.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int category_Id;

	private byte isActive;

	private String name;

	//bi-directional many-to-one association to MovieCategory
	@OneToMany(mappedBy="category")
	private List<MovieCategory> movieCategories;

	public Category() {
	}

	public int getCategory_Id() {
		return this.category_Id;
	}

	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MovieCategory> getMovieCategories() {
		return this.movieCategories;
	}

	public void setMovieCategories(List<MovieCategory> movieCategories) {
		this.movieCategories = movieCategories;
	}

	public MovieCategory addMovieCategory(MovieCategory movieCategory) {
		getMovieCategories().add(movieCategory);
		movieCategory.setCategory(this);

		return movieCategory;
	}

	public MovieCategory removeMovieCategory(MovieCategory movieCategory) {
		getMovieCategories().remove(movieCategory);
		movieCategory.setCategory(null);

		return movieCategory;
	}

}