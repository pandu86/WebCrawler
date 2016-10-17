			WEB-CRAWLER

1. The WebCrawler is developed using JAVA.
2. Java version 1.8
3. Use Eclipse latest version to import the project
4. To Generate SimeMap used external Jar "sitemapgen4j-1.0.1.jar" and this jar file in java build path 

	Steps to add the jar file
	i) Right click on the project -> select properties
	ii) Select the "Java Build path" on the left pane --> right pane select the libraries.
	iii) Select the "Add External Jars" and select the "sitemapgen4j-1.0.1.jar" click on Open.
	iv) Click on apply and close the pop up.
5. To run the WebCrawler you can execute the "Webcrawler.java” provide the input as domain name URL. please wait until the Execution is completed.
6. The crawler executed and visit all the pages and find to find out the URL.
7. The Site map is generated on the folder path " C:\Temp" filename "sitemap.xml"
8. The URL list under the child pages I traversed and logged into a file “ChildURLlist.log “under folder path “C:\Temp” Note: this log is generated based on file handling , it can be generated using other method as well eg :log4j ,etc..
9. While traversing there are some of invalid URL which is not able to load page. These are caught in custom exception “page not fond” 

 



