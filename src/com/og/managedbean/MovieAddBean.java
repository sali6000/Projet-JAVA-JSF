package com.og.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

import com.og.dao.EntityFinder;
import com.og.model.Author;
import com.og.model.Category;
import com.og.model.Country;
import com.og.model.CountryMovie;
import com.og.model.Movie;
import com.og.model.MovieAuthor;
import com.og.model.MovieCategory;
import com.og.model.Peggi;
import com.og.model.Year;
import com.og.model.Batch;

@Named
@SessionScoped
public class MovieAddBean implements Serializable 
{
	// 1. PROPERTIES
	// 1.1 VARIABLES GENERALES
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private EntityFinder ef;
	private UploadBean upload;
	private Part uploadedFile;
	private Movie movie;
	
	// 1.2 VARIABLES POUR LES FORMULAIRES
	private Object[] countries;
	private String[] countriesSelected;
	private String[] authors;
	private String[] authorsSelected;
	private String[] cathegories;
	private String[] cathegoriesSelected;
	private String[] batches;
	private String[] batchesSelected;
	private String[] peggies;
	private String peggiSelected;
	private int[] years;
	private int yearSelected;
	private int formNumber;

	// 2. POSTCONSTRUCT/PRECONSTRUCT
	@SuppressWarnings("rawtypes")
	// Exemple: Lorsque je vais sur la page MovieAdd.xhtml, this.movie est initialisé directement
	@PostConstruct
	public void init()
	{
		this.upload = new UploadBean();
		this.movie = new Movie();
		this.movie.setMovie_Id(0);
		ef = new EntityFinder();
	}
	
	// 3. GETTEURS ET SETTEURS
	// Récupère sous forme de tableau de string le nom des pays venant de la DB (tableau nécessaire pour l'affichage dans un checkbox)
	@SuppressWarnings({ "unchecked" })
	public String[] getCountries() {
		this.countries = ef.findAll(Country.class, Country.class.getName().substring(13)).toArray();
		String[] countriesName = new String[this.countries.length];
		int i = 0;
		for(Object c : this.countries)
		{
			countriesName[i] = ((Country)c).getName();
			i++;
		}
		
		return countriesName;
	}

	// Récupère le tableau des Countries au format String
	public String getCountriesInString()
	{
		return Arrays.toString(this.countriesSelected);
	}
	
	// Récupère les pays enregistrés par l'utilisateur
	public String[] getCountriesSelected() 
	{
		return this.countriesSelected;
	}

	// Enregistre les pays sélectionnés par l'utilisateur depuis le formulaire
	@SuppressWarnings({ "unchecked" })
	public void setCountriesSelected(String[] countriesSelected) 
	{
		this.countriesSelected = countriesSelected;
		List<Country> countriesList = ef.findAll(Country.class, Country.class.getName().substring(13));
		List<CountryMovie> countryMovieList = new ArrayList<CountryMovie>();
		for(String cs : this.countriesSelected)
		{
			for(Country c : countriesList)
			{
				if(cs.equals(c.getName()))
				{
					CountryMovie cm = new CountryMovie();
					cm.setCountry(c);
					cm.setMovie(this.movie);
					countryMovieList.add(cm);
				}
			}
		}
		
		this.movie.setCountryMovies(new ArrayList<CountryMovie>());
		
		for(CountryMovie cm : countryMovieList)
		{
			this.movie.addCountryMovy(cm);
		}
		
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public String getPeggiSelected() {
		return peggiSelected;
	}

	@SuppressWarnings({ "unchecked" })
	public void setPeggiSelected(String peggi) 
	{
		this.peggiSelected = peggi;
		List<Peggi> peggiesList = ef.findAll(Peggi.class, Peggi.class.getName().substring(13));

		for(Peggi c : peggiesList)
		{
			if(c.getName().equals(this.peggiSelected))
			{
				c.setMovies(new ArrayList<Movie>());
				c.addMovy(this.movie);
				this.movie.setPeggi(c);
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String[] getPeggies() 
	{		
		EntityFinder ef = new EntityFinder();
		List<Peggi> peggiList = ef.findAll(Peggi.class, Peggi.class.getName().substring(13));
		this.peggies = new String[peggiList.size()];
		int index = 0;
		for(Peggi value : peggiList)
		{
			this.peggies[index] = value.getName();
			index++;
		}
		return peggies;
	}

	public void setPeggies(String[] peggies) {
		
		
		this.peggies = peggies;
	}

	@SuppressWarnings({ "unchecked" })
	public int[] getYears() {
		List<Year> yearList = ef.findAll(Year.class, Year.class.getName().substring(13));
		this.years = new int[yearList.size()];		
		int index = 0;
		for(Year value : yearList)
		{
			this.years[index] = value.getYear();
			index++;
		}
		Arrays.sort(this.years);
		return years;
	}

	public void setYears(int[] years) {
		this.years = years;
	}

	public int getYearSelected() {
		return yearSelected;
	}

	@SuppressWarnings({ "unchecked" })
	public void setYearSelected(int yearSelected) {
		this.yearSelected = yearSelected;
		List<Year> yearsList = ef.findAll(Year.class, Year.class.getName().substring(13));
		
		for(Year c : yearsList)
		{
			if(c.getYear() == this.yearSelected)
			{
				this.movie.setYear(c);
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String[] getAuthors() {
		EntityFinder ef = new EntityFinder();
		List<Author> authorList = ef.findAll(Author.class, Author.class.getName().substring(13));
		this.authors = new String[authorList.size()];		
		int index = 0;
		for(Author value : authorList)
		{
			this.authors[index] = value.getFirstname() +" "+ value.getLastname();
			System.out.println(this.authors[index]);
			index++;
		}
		Arrays.sort(this.authors);
		return authors;
	}

	public void setAuthors(String[] authors) {
		
		this.authors = authors;
	}

	public String[] getAuthorsSelected() {
		return authorsSelected;
	}

	@SuppressWarnings("unchecked")
	public void setAuthorsSelected(String[] authorsSelected) {
		this.authorsSelected = authorsSelected;
		List<Author> authorsList = ef.findAll(Author.class, Author.class.getName().substring(13));
		List<MovieAuthor> movieAuthorList = new ArrayList<MovieAuthor>();
		
		for(String cs : this.authorsSelected)
		{
			for(Author c : authorsList)
			{
				if(cs.contains(c.getFirstname()) && cs.contains(c.getLastname()))
				{
					MovieAuthor ma = new MovieAuthor();
					ma.setAuthor(c);
					ma.setMovie(this.movie);
					movieAuthorList.add(ma);
				}
			}
		}
		
		this.movie.setMovieAuthors(new ArrayList<MovieAuthor>());
		
		for(MovieAuthor ma : movieAuthorList)
		{
			this.movie.addMovieAuthor(ma);			
		}
	}

	public String getAuthorsInString()
	{
		return Arrays.toString(this.authorsSelected);
	}
	
	@SuppressWarnings("unchecked")
	public String[] getCathegories() {
		List<Category> cathegoryList = ef.findAll(Category.class, Category.class.getName().substring(13));
		this.cathegories = new String[cathegoryList.size()];		
		int index = 0;
		for(Category value : cathegoryList)
		{
			this.cathegories[index] = value.getName();
			System.out.println(this.cathegories[index]);
			index++;
		}
		Arrays.sort(this.cathegories);
		return cathegories;
	}

	public void setCathegories(String[] cathegories) {
		this.cathegories = cathegories;
	}

	public String[] getCathegoriesSelected() {
		return cathegoriesSelected;
	}

	@SuppressWarnings({ "unchecked" })
	public void setCathegoriesSelected(String[] cathegoriesSelected) {
		this.cathegoriesSelected = cathegoriesSelected;
		List<Category> categoriesList = ef.findAll(Category.class, Category.class.getName().substring(13));
		List<MovieCategory> movieCategoryList = new ArrayList<MovieCategory>();
		
		for(String cs : this.cathegoriesSelected)
		{
			for(Category c : categoriesList)
			{
				if(cs.equals(c.getName()))
				{
					MovieCategory mc = new MovieCategory();
					mc.setCategory((Category)c);
					movieCategoryList.add(mc);
				}
			}
		}
		
		this.movie.setMovieCategories(new ArrayList<MovieCategory>());
		
		for(MovieCategory mc : movieCategoryList)
		{
			this.movie.addMovieCategory(mc);			
		}
	}
	
	public String getCathegoriesInString()
	{
		return Arrays.toString(this.cathegoriesSelected);
	}

	@SuppressWarnings({ "unchecked" })
	public String[] getBatches() {
		List<Batch> batchList = ef.findAll(Batch.class, Batch.class.getName().substring(13));
		this.batches = new String[batchList.size()];		
		int index = 0;
		for(Batch value : batchList)
		{
			this.batches[index] = value.getName();
			System.out.println(this.batches[index]);
			index++;
		}
		return batches;
	}

	public void setBatches(String[] batches) {
		this.batches = batches;
	}

	public String[] getBatchesSelected() {
		return batchesSelected;
	}

	public void setBatchesSelected(String[] batchesSelected) {
		this.batchesSelected = batchesSelected;
	}
	
	public String getBatchesInString()
	{
		return Arrays.toString(this.batchesSelected);
	}

	public Part getUploadedFile()
	{
		return uploadedFile;
	}
	
	public void setUploadedFile(Part uploadedFile)
	{
		this.uploadedFile = uploadedFile;
	}
	
	public int getFormNumber() {
		System.out.println(this.formNumber+" form number");
		return formNumber;
	}

	public void setFormNumber(int formNumber) {
		this.formNumber = formNumber;
	}

	// 4. METHODES
	// Sauvegarder une image
	// Reseter le formulaire
	// Passer au formulaire suivant
	// Revenir au formulaire précédent
	// Sauvegarder le film dans la base de donnée
	// Récupérer l'ID du dernié film se trouvant dans la DB
	public void saveImage()
	{
		this.upload.saveFile("\\webapps\\images", this.uploadedFile);
		this.movie.setImage(upload.getFilename());
		this.nextForm(2);
		this.movie.setMovie_Id(LastId());
	}
	
	// Reinitialise toutes les sélections
	public void reset()
	{
		this.movie = new Movie();
		this.countriesSelected = null;
		this.peggiSelected = null;
		this.authorsSelected = null;
		this.cathegoriesSelected = null;
		this.batchesSelected = null;
		this.yearSelected = 0;
		this.formNumber = 0;
	}
	
	// Passe au formulaire suivant et rafraichit la page
	public void nextForm(int number)
	{
		this.formNumber = number;
	}
	
	// Reviens au formulaire précédent et rafraichit la page
	public void backForm()
	{
		this.formNumber -= 1;
	}
	
	// Ajoute un film dans la FB
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void SaveMovie()
	{
		ef.addOne(this.movie);
		this.nextForm(4);
	}
	
	// Récupérer les films présents dans la DB, récupère l'ID du dernier film se trouvant en DB, retourne l'ID
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int LastId()
	{
		EntityFinder ef = new EntityFinder();
		Object[] IdMovies = ef.findAll(Movie.class, Movie.class.getName().substring(13)).toArray();
		int id = ((Movie)IdMovies[IdMovies.length-1]).getMovie_Id() + 1;
		return id;
	}
	
	public String backToIndex()
	{
		this.reset();
		return "/index.xhtml?faces-redirect=true";
	}
}
