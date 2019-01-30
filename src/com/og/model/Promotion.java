package com.og.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the promotion database table.
 * 
 */
@Entity
@NamedQuery(name="Promotion.findAll", query="SELECT p FROM Promotion p")
public class Promotion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int promotion_Id;

	private int duration_Day;

	private byte isActive;

	private float price;

	public Promotion() {
	}

	public int getPromotion_Id() {
		return this.promotion_Id;
	}

	public void setPromotion_Id(int promotion_Id) {
		this.promotion_Id = promotion_Id;
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

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}