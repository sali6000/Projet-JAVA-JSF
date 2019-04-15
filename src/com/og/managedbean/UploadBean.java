package com.og.managedbean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

@Named
@SessionScoped
public class UploadBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(this.getClass());
	private String filename;
	

	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) 
	{
		this.filename = filename;
	}

	public void saveFile(String repository, Part uploadedFile)
	{
		try(InputStream input = uploadedFile.getInputStream())
		{
			this.filename = uploadedFile.getSubmittedFileName();
			if(this.filename.contains(".jpg"))// voir http://www.vogella.com/tutorials/JavaRegularExpressions/article.html
			{
				Files.copy(input, new File(System.getProperty("catalina.base").toString()+repository,filename).toPath());
			}
			else
			{
				this.filename = "";
			}
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
}
