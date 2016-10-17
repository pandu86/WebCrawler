package com.web.crawl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.web.crawl.exception.CustomException;
import com.web.crawl.utils.ExtractURL;

public class PageSearch {
	
	/**
	 *  Method to scan the page line by line ,
	 *  and  make a call to extractlinks() method to fetch the URL and store url in a list
	 */
		
	  public  ArrayList<String> pagescan(String pageurl)
	  {
		  BufferedReader buffread = null;
			InputStreamReader inpstread= null;
			ExtractURL fetchurl = new ExtractURL();
			URL url = null;
			
			//String urlstring = "http://wiprodigital.com/";
			try {
				url = new URL(pageurl);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				inpstread = new InputStreamReader(url.openStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 buffread = new BufferedReader(inpstread);
			 
			 String line = null;
			 ArrayList<String> pageurllist = new ArrayList<String>();
			 try {
				while ((line = buffread.readLine()) != null )
				 {
					String keysearch= "http";
					 if(line.indexOf( keysearch) != -1)
					 {
						 ArrayList<String> tempurllist= fetchurl.extractLinks(line);
						 for (int i=0 ; i< tempurllist.size(); i++)
						 {
							 pageurllist.add(tempurllist.get(i));
						 }
						 
					 }
				 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			 
			return pageurllist ;
	  }
		

}
