package com.web.crawl.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.web.crawl.exception.CustomException;

public class CrawlLogger {
	
	
	public static void customlogger(String message)
	{
		  Logger logger = Logger.getLogger("Customlog");  
		  FileHandler filehand;  

		  try {  

		      // Configure the logger with handler and formatter  
			  filehand = new FileHandler("C:/Temp/CustomLogFile.log");  
		      logger.addHandler(filehand);
		      SimpleFormatter formatter = new SimpleFormatter();  
		      filehand.setFormatter(formatter);  

		      // the following statement is used to log any messages  
		      logger.info(message); 
		     

		  } catch (SecurityException e) {  
		      e.printStackTrace();  
		  } catch (IOException e) {  
		      e.printStackTrace();  
		  }  

		 
	}
	
	public static void  customlogurllist(String message)
	{
		try {
			 File file = new File("C:/Temp/ChildURLlist.log");
			    if (!file.exists())
			   {
				   file.createNewFile(); 
			   }
			Files.write(Paths.get("C:/Temp/ChildURLlist.log"), message.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
