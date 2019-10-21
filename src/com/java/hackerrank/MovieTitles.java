package com.java.hackerrank;

import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.net.HttpURLConnection; 
import java.net.URL; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.gson.*;

public class MovieTitles 
{
  
  //Complete the function below. Base url:
  //https://jsonmock.hackerrank.com/api/movies/search/?Title=
  
  static final String base_url = "https://jsonmock.hackerrank.com/api/movies/search/?Title="; 
  static String[] getMovieTitles(String substr) 
  { 
	  List<String> movieTitles = new ArrayList<String>();

	  try 
	  {
		  String response = getResponse(base_url + substr); 
		  JsonParser parser = new JsonParser(); 
		  JsonElement rootNode = parser.parse(response);
	 
		  JsonObject contents = rootNode.getAsJsonObject(); 
		  JsonElement totalRecords = contents.get("total");
				 
		  JsonElement totalPages = contents.get("total_pages");
			
		  int currentPage = 0; 
		  while(currentPage++ < Integer.parseInt(totalPages.toString())) 
			  nextPage(movieTitles, currentPage, substr);
				  
		 Collections.sort(movieTitles); 
	 } 
	 catch(Exception e) 
	 { 
		  e.printStackTrace(); 
	  }
				  
	  String[] movieList = new String[movieTitles.size()];
	  return movieTitles.toArray(movieList); 
  }
  
  static void nextPage(List<String> movies, int currentPage, String substr) throws Exception 
  { 
	  String response = getResponse(base_url + substr + "&page="+ currentPage); 
	  JsonParser parser = new JsonParser(); 
	  JsonElement rootNode = parser.parse(response);
  
	  JsonObject contents = rootNode.getAsJsonObject(); 
	  JsonElement data = contents.get("data");
  
	  JsonArray titlesArray = data.getAsJsonArray(); 
	  for(JsonElement movieTitle : titlesArray) 
	  { 
		  JsonObject titleObj = movieTitle.getAsJsonObject(); 
		  String title = titleObj.get("Title").getAsString(); 
		  movies.add(title); 
	  }
  }
  
  static String getResponse(String urlString) throws Exception 
  { 
	  StringBuilder result = new StringBuilder(); 
	  URL url = new URL(urlString); 
	  HttpURLConnection connection = (HttpURLConnection)url.openConnection();
	  connection.setRequestMethod("GET");
	  BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
	  String line;
  
	  while((line = br.readLine()) != null) 
		  result.append(line);
  
	  br.close(); 
	  return result.toString(); 
  }
}
 