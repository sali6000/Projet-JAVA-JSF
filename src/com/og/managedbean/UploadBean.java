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
	
	// Pour utiliser le "Part", clique droit sur le projet=> build path => configure build path -> project facets et changer java 1.6 en 1.7
	private Part uploadedFile;
	
	// Pour uploader un fichier
	public Part getUploadedFile()
	{
		return uploadedFile;
	}
	
	public void setUploadedFile(Part uploadedFile)
	{
		this.uploadedFile = uploadedFile;
	}
	
	public void saveFile()
	{
		try(InputStream input = uploadedFile.getInputStream())
		{
			String filename = uploadedFile.getSubmittedFileName();
			if(filename.contains(".jpg")) // voir http://www.vogella.com/tutorials/JavaRegularExpressions/article.html
			Files.copy(input, new File("C:\\Users\\User\\Desktop\\Bureau1\\Textes - PDF - PowerPoint\\CV + lettre passe partouts",filename).toPath());
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
}
