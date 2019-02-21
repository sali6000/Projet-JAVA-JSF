package com.og.managedbean;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

@Named
@SessionScoped
public class UserDataBean implements Serializable 
{

	private static final long serialVersionUID = 1L;
	private String locale;
	private Locale lang;
	private static Map<String,Object> countries;
	
    @PostConstruct
    public void init() 
    {
    	lang = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
    }
	
	static 
	{
		countries = new LinkedHashMap<String,Object>();
		countries.put("French", Locale.FRENCH);
		countries.put("English", Locale.ENGLISH);
	}
	
	public Map<String, Object> getCountries() 
	{
		return countries;
	}
	
	public String getLocale() 
	{
		return locale;
	}
	public Locale getLang()
	{
		System.out.println(this.lang.getLanguage());
		return this.lang;
	}
	
	public void setLocale(String locale) 
	{
		this.locale = locale;
	}
	
	//value change event listener
	public void localeChanged(ValueChangeEvent e)
	{
		String newLocaleValue = e.getNewValue().toString();
		
		for (Map.Entry<String, Object> entry : countries.entrySet()) 
		{
			if(entry.getValue().toString().equals(newLocaleValue))
			{
				this.lang = new Locale(entry.getValue().toString());
				FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale)entry.getValue());         
	         }
	     }
	}
}
