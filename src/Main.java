

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

	 public static ArrayList<ScheduleModel> LoadSheddingFullSchedule = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//accessing the location data
           Location l  = new Location();     
          
           System.out.println(Location.location.get(10000).province);
           
           
           
           
           
///Everything needed to get back the schedule of each surburb           
        //Getting the loadshedding schedule 
       	 System.out.println("Loadshedding Stage "+loadSheddingStatus());
       	 
       	//Getting the schedule of each surburb using surburb index
       	  LoadSheddingSchedule("https://loadshedding.eskom.co.za/LoadShedding/GetScheduleM/"+Location.location.get(10000).surburbIndex+"/"+loadSheddingStatus()+"/1/704",Location.location.get(10000).surburb);
       	 
       	  	 
       	
               	 
		
	}
	
	
	
	public static void LoadSheddingSchedule(String url,String surburb) {
		
        Document doc;
        
		try {
			doc = Jsoup.connect(url).get();
	           Elements statusText = doc.getElementsByClass("scheduleDay");
	           String schedule = statusText.text().toString(); 
	           
	           
	           //Getting daily loadshedding schedules for each suburb
	           String pattern = "(([A-Z])\\w+[,][\\s]\\d+[\\s]([A-Z])\\w+)([\\s]\\d+[:]\\d+[\\s][-][\\s]\\d+[:]\\d+)+";

	           Pattern r = Pattern.compile(pattern);

	           Matcher m = r.matcher(schedule);
	           while(m.find( )) {
	        	   //get all the schedules for each day
	        	    String dailyScheduleDATETIME = m.group();
	        	    
	        	    
	        	   //now we have to break up all the daily schedules times in the string
	        	    String loadSheddingDate = "";
	        	    Matcher dateMatcher = Pattern.compile("([A-Z])\\w+[,][\\s]\\d+[\\s]([A-Z])\\w+").matcher(dailyScheduleDATETIME);
	        	    while(dateMatcher.find()) {
	        	    	//getting the date
	        	    	loadSheddingDate = dateMatcher.group();
	        	    }
	        	    
	        	    Matcher timeMatcher = Pattern.compile("(\\d+[:]\\d+[\\s][-][\\s]\\d+[:]\\d+)+").matcher(dailyScheduleDATETIME); 
	        	    while(timeMatcher.find()) {
	        	    	//getting the times
	        	    	String loadSheddingTime = "";
	        	    	loadSheddingTime = timeMatcher.group();
	        	    	
	        	    	
	        	    	//This is where we get the proper schedule
	        	        LoadSheddingFullSchedule.add(new ScheduleModel(surburb, loadSheddingDate, loadSheddingTime));
	        	    }
	        	    
	           }
	         
	         
		} catch (IOException e) {
			
			e.printStackTrace();
		
		}
		
	}
	
	public static int loadSheddingStatus() {
        Document doc;
		try {
			doc = Jsoup.connect("https://www.eskom.co.za/").get();
	           Elements statusText = doc.getElementsByClass("eskom-ls-text").select("b");
	           String status = statusText.text().toString(); 
	           
	           //get the stage number
	           char stat = status.charAt(status.length() - 1);
	           
	           return Integer.parseInt(stat+"");
		} catch (IOException e) {
			e.printStackTrace();
			   return 1;	
		}
	}
	
	

}
