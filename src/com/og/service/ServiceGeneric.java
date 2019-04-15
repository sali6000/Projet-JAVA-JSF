package com.og.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.og.model.Movie;

public class ServiceGeneric<T>
{
	// PROPERTIE
	private EntityManager em;
	
	// CONSTRUCTOR
	public ServiceGeneric(EntityManager em)
	{
		this.em = em;
	}
	
	// (METHODE) Etape 3/3 Create (Transaction vers la DB)
	public void Create(T entity)
	{
		em.persist(entity);
	}
	
	// (METHODE) Etape 3/3 FindAll (Transaction vers la DB)
	@SuppressWarnings("unchecked")
	public <K, V> List<T> FindAll(T entity, String nameOfEntity)
	{
	    Query query = em.createNamedQuery(nameOfEntity+".findAll", entity.getClass());	
    	return (List<T>) query.getResultList();
	}
	
	// (METHODE) Etape 3/3 FindById (Transaction vers la DB)
	public T FindById(int id, Class<T> entity)
	{
		return em.find(entity, id);
	}
	
	// (METHODE) Etape 3/3 FindAllByCustomQuery (Transaction vers la DB)
	@SuppressWarnings("unchecked")
	public <K, V> List<T> FindAllByCustomQuery(T entity, Map<K, V> param)
	{		
	    Query query = em.createNamedQuery(entity.getClass().getName()+".findAll", entity.getClass());
	    
	    // Si il y a des paramètres, les inscrires dans la requête
    	if(param != null) 
    	{
    		setParameters(query, param);
    	}
    		
    	return query.getResultList();
	}
	
	// Cette méthode permet d'identifier si une date est comprise dans les parametres de la query pour la convertir
	// cette vérification est faite à partir d'une Liste de clés - valeurs
	private <K, V> void setParameters(Query query, Map<K, V> param) 
	{	
		Set<Map.Entry<K, V>> entries = param.entrySet();
		Iterator<Map.Entry<K, V>> itr = entries.iterator();
		
		while(itr.hasNext())
		{
			Map.Entry<K, V> entry = itr.next();
			
			if((boolean) entry.getKey().toString().toLowerCase().contains("date"))
				query.setParameter((String) entry.getKey(),(Date) entry.getValue(), TemporalType.DATE);
			else
				query.setParameter((String) entry.getKey(),entry.getValue());
			//log.debug("entry.getValue: " + entry.getValue());
		}
	}
	
	/*
	 * RAPPEL
	 * Pour comprendre l'utilité des Map<k,v> :
	 * 
	  	public int getQuantiteOption(int idVoiture, int idOptionVoiture, EntityManager em) throws Exception
		{
			// En queryNative (en dehors de JPQL), les parametres de requêtes se font à l'aide de positions et la syntaxe suivante
			String stringQuery = "SELECT quantite FROM option_comprise_voiture WHERE FK_voiture = ?1 AND FK_option_voiture = ?2";
			Query query = em.createNativeQuery(stringQuery);
			query.setParameter("1", idVoiture);
			query.setParameter("2", idOptionVoiture);
			return (Integer)query.getSingleResult();
		}
	 * 
	 * */
}