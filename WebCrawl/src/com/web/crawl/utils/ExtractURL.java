package com.web.crawl.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractURL {
	
	
	  /**
	   *  Method to fetch the URL from each line 
	   */
		
		public  ArrayList<String> extractLinks(String text) {
			ArrayList<String> links = new ArrayList<String>();

			String regex = "\\(?\\b((http|https)://|www[.])[-A-Za-z0-9+&amp;@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&amp;@#/%=~_()|]";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(text);
			while(m.find()) {
			String urlstr = m.group();
			if (urlstr.startsWith("(") && urlstr.endsWith(")"))
			{
			urlstr = urlstr.substring(1, urlstr.length() - 1);
			}
			links.add(urlstr);
			}
			return links;
			}
		

}
