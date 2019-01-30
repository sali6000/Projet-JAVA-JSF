package com.og.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bill database table.
 * 
 */
@Entity
@NamedQuery(name="Bill.findAll", query="SELECT b FROM Bill b")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int bill_Id;

	@Temporal(TemporalType.DATE)
	private Date date_Bill;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="FK_User")
	private User user;

	//bi-directional many-to-one association to Rent
	@OneToMany(mappedBy="bill")
	private List<Rent> rents;

	public Bill() {
	}

	public int getBill_Id() {
		return this.bill_Id;
	}

	public void setBill_Id(int bill_Id) {
		this.bill_Id = bill_Id;
	}

	public Date getDate_Bill() {
		return this.date_Bill;
	}

	public void setDate_Bill(Date date_Bill) {
		this.date_Bill = date_Bill;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Rent> getRents() {
		return this.rents;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}

	public Rent addRent(Rent rent) {
		getRents().add(rent);
		rent.setBill(this);

		return rent;
	}

	public Rent removeRent(Rent rent) {
		getRents().remove(rent);
		rent.setBill(null);

		return rent;
	}

}