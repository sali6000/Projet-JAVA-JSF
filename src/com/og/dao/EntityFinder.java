package com.og.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import com.og.connection.EMF;
import com.og.service.ServiceGeneric;

import org.apache.log4j.Logger;

public class EntityFinder<T> 
{
	private Logger log = Logger.getLogger(this.getClass());
	// Log4j	 
	//@Inject
	//private transient Logger log;
	
	// (METHODE) Etape 2/3 FindOne (Préparer et sécuriser les transactions de la BD)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T findOne(Class<T> type, int id) 
	{	
		// Création d'une variable générique
		T entity = null;
		
		// Ouvrir la connection
		EntityManager em = EMF.getEM();	
		
		try 
		{
			ServiceGeneric serviceGeneric = new ServiceGeneric(em);
	    	entity = (T) serviceGeneric.FindById(id, type);
	    	em.clear();
	    }
		catch(Exception ex)
		{
			System.out.println("Une erreur est survenue: "+ex.getMessage());
		}
		finally 
		{
	        em.close();
	    }
		return entity;
	}
	
	// (METHODE) Etape 2/3 FindAll (Préparer et sécuriser les transactions de la BD)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findAll(Class<T> t, String nameOfEntity) 
	{
		// Création d'une liste d'objets générique
		List<T> entities = new ArrayList<T>();
		
		// Ouverture de la connection à la BD
		EntityManager em = EMF.getEM();
		
		try 
		{
			ServiceGeneric service = new ServiceGeneric(em);
	    	entities = (List<T>) service.FindAll(t, nameOfEntity);
		}
		finally 
		{
			em.clear();
	        em.close();
	    }
		return entities;
	}
}