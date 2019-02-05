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
	
	// (METHODE) Etape 2/3 FindOne (Pr�parer et s�curiser les transactions de la BD)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T findOne(Class<T> type, int id) 
	{	
		// Cr�ation d'une variable g�n�rique
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
	
	// (METHODE) Etape 2/3 FindAll (Pr�parer et s�curiser les transactions de la BD)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findAll(Class<T> t, String nameOfEntity) 
	{
		// Cr�ation d'une liste d'objets g�n�rique
		List<T> entities = new ArrayList<T>();
		
		// Ouverture de la connection � la BD
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