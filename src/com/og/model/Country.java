package com.og.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int country_Id;

	private byte isActive;

	private String iso;

	private String name;

	private String shortName;

	//bi-directional many-to-one association to City
	@OneToMany(mappedBy="country")
	private List<City> cities;

	//bi-directional many-to-one association to CountryMovie
	@OneToMany(mappedBy="country")
	private List<CountryMovie> countryMovies;

	public Country() {
	}

	public int getCountry_Id() {
		return this.country_Id;
	}

	public void setCountry_Id(int country_Id) {
		this.country_Id = country_Id;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getIso() {
		return this.iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public List<City> getCities() {
		return this.cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public City addCity(City city) {
		getCities().add(city);
		city.setCountry(this);

		return city;
	}

	public City removeCity(City city) {
		getCities().remove(city);
		city.setCountry(null);

		return city;
	}

	public List<CountryMovie> getCountryMovies() {
		return this.countryMovies;
	}

	public void setCountryMovies(List<CountryMovie> countryMovies) {
		this.countryMovies = countryMovies;
	}

	public CountryMovie addCountryMovy(CountryMovie countryMovy) {
		getCountryMovies().add(countryMovy);
		countryMovy.setCountry(this);

		return countryMovy;
	}

	public CountryMovie removeCountryMovy(CountryMovie countryMovy) {
		getCountryMovies().remove(countryMovy);
		countryMovy.setCountry(null);

		return countryMovy;
	}

}