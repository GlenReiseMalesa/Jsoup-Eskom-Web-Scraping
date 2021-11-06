

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//accessing the location data
           Location l  = new Location();     
           System.out.println(Location.location.get(10000).province);
           
           
           
        //Getting the loadshedding schedule 
       	 System.out.println("Loadshedding Stage "+loadSheddingStatus());
       	 
       	 //Getting the schedule of each surburb
       	LoadSheddingSchedule("https://loadshedding.eskom.co.za/LoadShedding/GetScheduleM/"+Location.location.get(10000).surburbIndex+"/"+loadSheddingStatus()+"/1/704",Location.location.get(10000).surburb);
       	 
       	  	 
       	 
       	 
		
	}
	
	
	
	public static void LoadSheddingSchedule(String url,String surburb) {
		
        Document doc;
        
		try {
			doc = Jsoup.connect(url).get();
	           Elements statusText = doc.getElementsByClass("scheduleDay").select("div");
	           String schedule = statusText.text().toString(); 
	           
	           System.out.println(schedule);
	         
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
