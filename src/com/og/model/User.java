package com.og.model;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class User implements Serializable 
{

	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}

	@PostConstruct
	private void initialize() 
	{
		System.out.println("Bean is initialized with the following user name: " + name);
	}
	
	@PreDestroy
	private void cleanUp() 
	{
		System.out.println("You can do the cleanup here");
	}
}