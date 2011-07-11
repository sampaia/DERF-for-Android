package com.derf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import android.content.Context;

import com.derf.beans.News;

public class NewsAPI {
	
	private static String TOP_NEWS_JSON = "topnews.json";

	public static ArrayList<News> getTopNewsItems(FileOutputStream fos, FileInputStream fis, String category) throws JsonParseException, JsonMappingException, IOException{
		ArrayList<News> results = new ArrayList<News>();
		
		int categoryInt = Integer.valueOf(category);
		String url = "";
		
		if(categoryInt == 0)
			url = "http://www.derfmagazine.com/api/topnews?format=json";
		else
			url = "http://www.derfmagazine.com/api/category/" + category + "?format=json";
				
		ObjectMapper obj = new ObjectMapper();
		
		JsonNode json = null;
		if(fos != null){
			json = RestJsonClient.connect(url);
			fos.write(json.toString().getBytes());
			fos.close();
		}
		if(fis != null){
			json = obj.readValue(fis, JsonNode.class);
		}

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for(int i = 0; i < json.size(); i++){
			JsonNode o = json.get(i);
			String idVal = o.get("id").getValueAsText();
			int id = Integer.valueOf(idVal);
			
			News n = null;
			try {
				n = new News(id, 
						(Date)format.parse(o.get("date").getValueAsText()), 
						o.get("categoryId").getValueAsText(),
						o.get("categoryName").getValueAsText(),
						o.get("headline").getValueAsText(),
						o.get("text").getValueAsText(),
						o.get("imageURL").getValueAsText(),
						o.get("thumbnailURL").getValueAsText(),
						o.get("url").getValueAsText(),
						(Date)format.parse(o.get("lastAccessDate").getValueAsText())				
						);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			results.add(n);
		}
		
		return results;
	}
	
}
