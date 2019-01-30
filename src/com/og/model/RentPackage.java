package com.og.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rent_package database table.
 * 
 */
@Entity
@Table(name="rent_package")
@NamedQuery(name="RentPackage.findAll", query="SELECT r FROM RentPackage r")
public class RentPackage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int rent_Package_Id;

	//bi-directional many-to-one association to Package
	@ManyToOne
	@JoinColumn(name="FK_Package")
	private Package moviePackage;

	//bi-directional many-to-one association to Rent
	@ManyToOne
	@JoinColumn(name="FK_Rent")
	private Rent rent;

	public RentPackage() {
	}

	public int getRent_Package_Id() {
		return this.rent_Package_Id;
	}

	public void setRent_Package_Id(int rent_Package_Id) {
		this.rent_Package_Id = rent_Package_Id;
	}

	public Package getPackage() {
		return this.moviePackage;
	}

	public void setPackage(Package _package) {
		this.moviePackage = _package;
	}

	public Rent getRent() {
		return this.rent;
	}

	public void setRent(Rent rent) {
		this.rent = rent;
	}

}