package com.og.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the batch database table.
 * 
 */
@Entity
@NamedQuery(name="Batch.findAll", query="SELECT b FROM Batch b")
public class Batch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int batch_Id;

	private int duration_Day;

	private byte isActive;

	private String name;

	private float price;

	//bi-directional many-to-one association to BatchMovie
	@OneToMany(mappedBy="batch")
	private List<BatchMovie> batchMovies;

	//bi-directional many-to-one association to RentBatch
	@OneToMany(mappedBy="batch")
	private List<RentBatch> rentBatches;

	public Batch() {
	}

	public int getBatch_Id() {
		return this.batch_Id;
	}

	public void setBatch_Id(int batch_Id) {
		this.batch_Id = batch_Id;
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

	public List<BatchMovie> getBatchMovies() {
		return this.batchMovies;
	}

	public void setBatchMovies(List<BatchMovie> batchMovies) {
		this.batchMovies = batchMovies;
	}

	public BatchMovie addBatchMovy(BatchMovie batchMovy) {
		getBatchMovies().add(batchMovy);
		batchMovy.setBatch(this);

		return batchMovy;
	}

	public BatchMovie removeBatchMovy(BatchMovie batchMovy) {
		getBatchMovies().remove(batchMovy);
		batchMovy.setBatch(null);

		return batchMovy;
	}

	public List<RentBatch> getRentBatches() {
		return this.rentBatches;
	}

	public void setRentBatches(List<RentBatch> rentBatches) {
		this.rentBatches = rentBatches;
	}

	public RentBatch addRentBatch(RentBatch rentBatch) {
		getRentBatches().add(rentBatch);
		rentBatch.setBatch(this);

		return rentBatch;
	}

	public RentBatch removeRentBatch(RentBatch rentBatch) {
		getRentBatches().remove(rentBatch);
		rentBatch.setBatch(null);

		return rentBatch;
	}

}