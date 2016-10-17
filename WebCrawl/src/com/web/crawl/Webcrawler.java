package com.web.crawl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.redfin.sitemapgenerator.WebSitemapGenerator;
import com.redfin.sitemapgenerator.WebSitemapUrl;
import com.web.crawl.exception.CustomException;
import com.web.crawl.utils.CrawlLogger;
import com.web.crawl.utils.ExtractURL;
import com.web.crawl.utils.SiteMapGenerator;

public class Webcrawler {
	
  	public static void main(String[] args) {
	  
		Set<String> domainurllist = new HashSet<String>();	// To hold all the URL 
		Set<String> domainpagelist = new HashSet<>();		// to hold The domain page URL to search only within domain
		PageSearch urlscan= new PageSearch();
		SiteMapGenerator sitemapgen= new SiteMapGenerator();		
		String urlstring = null;
		
		
		//String urlstring = "http://wiprodigital.com/";
		System.out.println("Enter the domain name URL to Crawl");		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			 urlstring = br.readLine();
			 System.out.println("Entered domain name URL ="+urlstring);
			 domainurllist.add(urlstring);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 ArrayList<String> templist= urlscan.pagescan(urlstring);
		 // looping to find out the links in the parent domain page
		 for (int i=0; i < templist.size(); i++)
		 {
			 String url = templist.get(i);
			 domainurllist.add(url);
			 if(url.contains(urlstring))    //Filter out the domain page URL
			 {
				 if(!url.contains(".php"))	// to ignore the links those links or not valid URL
				 domainpagelist.add(url);
			 }
		 }
		  
		// Temporary list to scan the child pages
		 Set<String> testtemp = new HashSet<>();
		  Set<String> testtemp1= new HashSet<>();
		  testtemp1.addAll(domainpagelist);
	/** loop Begin */	 
		 do{
			 testtemp.clear();
			 testtemp.addAll(domainpagelist);		 
					 
		  int count=1;
		 for (String childpageurl : testtemp1)
		 {
			 
			 try{  
			   ArrayList<String> templist1= urlscan.pagescan(childpageurl);
				 
				 for (int i=0; i < templist1.size(); i++)
				 {
					 String url = templist1.get(i);
					 domainurllist.add(url);
					 if(url.contains(urlstring))
					 {
						 if(!url.contains(".php"))	
						 { 
							if(!url.contains("wp-json"))		// Ignore all the json Embed URL  
						      domainpagelist.add(url);
						 }
					 }
				 }
				 CrawlLogger.customlogurllist("testloop="+childpageurl+" ---sxize="+testtemp1.size()+"\n");
			 System.out.println("testloop="+childpageurl+" ---sxize="+testtemp1.size());
			 }catch(Exception e){
				 CrawlLogger.customlogger("page not found");
				 continue;
			 }
			 count++;
		 }
		 if(count <= domainpagelist.size())
		 {
			 testtemp1.clear();
			 /**
			  *  finding Sub child page URl list to Scan 
			  */
			 for(String s : domainpagelist)
			 {
				 if(!testtemp.contains(s))		
				 {
					 testtemp1.add(s);			
				 }
			 }
		 }
	}while(testtemp.size() < domainpagelist.size() );
		 
/**** Loop  end ****/
		 
	 /** 
	  * Generating the Site map
	  */
		 sitemapgen.sitemapgenerator(domainpagelist);
	
		 CrawlLogger.customlogurllist(" Site map is Geneated successfully ");
		

	}

}
