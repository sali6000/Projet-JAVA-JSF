package com.og.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the package database table.
 * 
 */
@Entity
@NamedQuery(name="Package.findAll", query="SELECT p FROM Package p")
public class Package implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int package_Id;

	private int duration_Day;

	private byte isActive;

	private String name;

	private float price;

	//bi-directional many-to-one association to PackageMovie
	@OneToMany(mappedBy="_package")
	private List<PackageMovie> packageMovies;

	//bi-directional many-to-one association to RentPackage
	@OneToMany(mappedBy="moviePackage")
	private List<RentPackage> rentPackages;

	public Package() {
	}

	public int getPackage_Id() {
		return this.package_Id;
	}

	public void setPackage_Id(int package_Id) {
		this.package_Id = package_Id;
	}

	public int getDuration_Day() {
		return this.duration_Day;
	}

	public void setDuration_Day(int duration_Day) {
		this.duration_Day = duration_Day;
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

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<PackageMovie> getPackageMovies() {
		return this.packageMovies;
	}

	public void setPackageMovies(List<PackageMovie> packageMovies) {
		this.packageMovies = packageMovies;
	}

	public PackageMovie addPackageMovy(PackageMovie packageMovy) {
		getPackageMovies().add(packageMovy);
		packageMovy.setPackage(this);

		return packageMovy;
	}

	public PackageMovie removePackageMovy(PackageMovie packageMovy) {
		getPackageMovies().remove(packageMovy);
		packageMovy.setPackage(null);

		return packageMovy;
	}

	public List<RentPackage> getRentPackages() {
		return this.rentPackages;
	}

	public void setRentPackages(List<RentPackage> rentPackages) {
		this.rentPackages = rentPackages;
	}

	public RentPackage addRentPackage(RentPackage rentPackage) {
		getRentPackages().add(rentPackage);
		rentPackage.setPackage(this);

		return rentPackage;
	}

	public RentPackage removeRentPackage(RentPackage rentPackage) {
		getRentPackages().remove(rentPackage);
		rentPackage.setPackage(null);

		return rentPackage;
	}

}