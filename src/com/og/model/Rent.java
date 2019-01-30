package com.og.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the rent database table.
 * 
 */
@Entity
@NamedQuery(name="Rent.findAll", query="SELECT r FROM Rent r")
public class Rent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int rent_Id;

	private int duration_Day;

	private float price;

	private int rate;

	@Temporal(TemporalType.DATE)
	private Date start_Date;

	private String statut;

	//bi-directional many-to-one association to Bill
	@ManyToOne
	@JoinColumn(name="FK_Bill")
	private Bill bill;

	//bi-directional many-to-one association to RentMovie
	@OneToMany(mappedBy="rent")
	private List<RentMovie> rentMovies;

	//bi-directional many-to-one association to RentPackage
	@OneToMany(mappedBy="rent")
	private List<RentPackage> rentPackages;

	public Rent() {
	}

	public int getRent_Id() {
		return this.rent_Id;
	}

	public void setRent_Id(int rent_Id) {
		this.rent_Id = rent_Id;
	}

	public int getDuration_Day() {
		return this.duration_Day;
	}

	public void setDuration_Day(int duration_Day) {
		this.duration_Day = duration_Day;
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

	public Date getStart_Date() {
		return this.start_Date;
	}

	public void setStart_Date(Date start_Date) {
		this.start_Date = start_Date;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Bill getBill() {
		return this.bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public List<RentMovie> getRentMovies() {
		return this.rentMovies;
	}

	public void setRentMovies(List<RentMovie> rentMovies) {
		this.rentMovies = rentMovies;
	}

	public RentMovie addRentMovy(RentMovie rentMovy) {
		getRentMovies().add(rentMovy);
		rentMovy.setRent(this);

		return rentMovy;
	}

	public RentMovie removeRentMovy(RentMovie rentMovy) {
		getRentMovies().remove(rentMovy);
		rentMovy.setRent(null);

		return rentMovy;
	}

	public List<RentPackage> getRentPackages() {
		return this.rentPackages;
	}

	public void setRentPackages(List<RentPackage> rentPackages) {
		this.rentPackages = rentPackages;
	}

	public RentPackage addRentPackage(RentPackage rentPackage) {
		getRentPackages().add(rentPackage);
		rentPackage.setRent(this);

		return rentPackage;
	}

	public RentPackage removeRentPackage(RentPackage rentPackage) {
		getRentPackages().remove(rentPackage);
		rentPackage.setRent(null);

		return rentPackage;
	}

}