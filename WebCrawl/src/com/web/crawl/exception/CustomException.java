package com.web.crawl.exception;

import java.io.Serializable;

import com.web.crawl.utils.CrawlLogger;

public class CustomException extends Exception implements Serializable
{
	private static final long serialVersionUID = -7769894292825884573L;
	  private String errorMessage = null;
	  private Exception exception;
	  
	  public CustomException(String message)
	  {
		  this.errorMessage=message;
		  CrawlLogger.customlogger(message);
	  }
	  public final String getMessage()
	  {
		  return this.errorMessage;
	  }
	  public void setException(Exception exception) 
	  {
		  this.exception = exception;
	  }
	  
	  public Exception geException()
	  {
		  return this.exception;
	  }
}

