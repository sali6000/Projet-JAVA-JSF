package com.og.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int city_Id;

	private String name;

	private String postal_Code;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="FK_Country")
	private Country country;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="city")
	private List<User> users;

	public City() {
	}

	public int getCity_Id() {
		return this.city_Id;
	}

	public void setCity_Id(int city_Id) {
		this.city_Id = city_Id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostal_Code() {
		return this.postal_Code;
	}

	public void setPostal_Code(String postal_Code) {
		this.postal_Code = postal_Code;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setCity(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setCity(null);

		return user;
	}

}