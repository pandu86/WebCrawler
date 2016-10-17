package com.web.crawl.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import com.redfin.sitemapgenerator.ChangeFreq;
import com.redfin.sitemapgenerator.WebSitemapGenerator;
import com.redfin.sitemapgenerator.WebSitemapUrl;

public final class SiteMapGenerator {

	/**
	 *  Method to generated the SiteMap 
	 */
	public  void  sitemapgenerator(Set  Urllist)
	{
		try
		{
		  System.out.println(" Site map file generator started");
		  
		  /** mention the builder path to store the Sitemap.xml in
		   *  
		   */
		WebSitemapGenerator webmap = WebSitemapGenerator.builder("http://wiprodigital.com/", new File("C:\\Temp")).build();
		
		 Iterator iterator = Urllist.iterator();
		 while(iterator.hasNext())
		 {
		   String url = (String) iterator.next();
		   
		   if(url.startsWith("http://wiprodigital.com/"))
		   {
			   if(!url.contains("wp-json")) // exclued embideed JSon format URL
			   {
			   WebSitemapUrl url1 = new WebSitemapUrl.Options(url).lastMod(new Date()).priority(1.0).changeFreq(ChangeFreq.DAILY).build();
			   webmap.addUrl(url1);
			   }
		   }
		   
		 }
	    	System.out.println("file executed");
		webmap.write();
		}catch (MalformedURLException e) {
			// TODO: handle exception
		}
	}
}
