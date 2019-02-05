package com.og.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rent_batch database table.
 * 
 */
@Entity
@Table(name="rent_batch")
@NamedQuery(name="RentBatch.findAll", query="SELECT r FROM RentBatch r")
public class RentBatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int rent_Batch_Id;

	//bi-directional many-to-one association to Rent
	@ManyToOne
	@JoinColumn(name="FK_Rent")
	private Rent rent;

	//bi-directional many-to-one association to Batch
	@ManyToOne
	@JoinColumn(name="FK_Batch")
	private Batch batch;

	public RentBatch() {
	}

	public int getRent_Batch_Id() {
		return this.rent_Batch_Id;
	}

	public void setRent_Batch_Id(int rent_Batch_Id) {
		this.rent_Batch_Id = rent_Batch_Id;
	}

	public Rent getRent() {
		return this.rent;
	}

	public void setRent(Rent rent) {
		this.rent = rent;
	}

	public Batch getBatch() {
		return this.batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

}