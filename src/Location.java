import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


import org.json.JSONArray;
import org.json.JSONObject;


public class Location {

	private static HttpURLConnection connection;
	static ArrayList<LocationModel> location = new ArrayList<LocationModel>();//all the location data
	
	
	public Location() {
		// TODO Auto-generated constructor stub
		
		//for every province get it's list of municipalities
		for(int i = 1;i <= 9;i++) {
			
			if(i == 1 ) {
				parseMunicipaliies("Eastern Cape",MunicipalityHttpReqAndRes("https://loadshedding.eskom.co.za/LoadShedding/GetMunicipalities/?Id="+i));
			}
			
			if(i == 2 ) {
				parseMunicipaliies("Free State",MunicipalityHttpReqAndRes("https://loadshedding.eskom.co.za/LoadShedding/GetMunicipalities/?Id="+i));				
			}
			
			
			if(i == 3 ) {
				parseMunicipaliies("Gauteng",MunicipalityHttpReqAndRes("https://loadshedding.eskom.co.za/LoadShedding/GetMunicipalities/?Id="+i));				
			}
			
			if(i == 4 ) {
				parseMunicipaliies("KwaZulu-Natal",MunicipalityHttpReqAndRes("https://loadshedding.eskom.co.za/LoadShedding/GetMunicipalities/?Id="+i));				
			}
			
			if(i == 5 ) {
				parseMunicipaliies("Limpopo",MunicipalityHttpReqAndRes("https://loadshedding.eskom.co.za/LoadShedding/GetMunicipalities/?Id="+i));				
			}
			
			if(i == 6 ) {
				parseMunicipaliies("Mpumalanga",MunicipalityHttpReqAndRes("https://loadshedding.eskom.co.za/LoadShedding/GetMunicipalities/?Id="+i));				
			}
			
			if(i == 7 ) {
				parseMunicipaliies("North West",MunicipalityHttpReqAndRes("https://loadshedding.eskom.co.za/LoadShedding/GetMunicipalities/?Id="+i));				
			}
			
			if(i == 8 ) {
				parseMunicipaliies("Northern Cape",MunicipalityHttpReqAndRes("https://loadshedding.eskom.co.za/LoadShedding/GetMunicipalities/?Id="+i));				
			}
			
			if(i == 9 ) {
				parseMunicipaliies("Western Cape",MunicipalityHttpReqAndRes("https://loadshedding.eskom.co.za/LoadShedding/GetMunicipalities/?Id="+i));				
			}
            
		}
	}
	
	
public static String MunicipalityHttpReqAndRes(String URL) {
		
		BufferedReader reader;
		String line; 
		StringBuffer response = new StringBuffer();
		
		try {
		   URL url = new URL(URL);	
			
           connection = (HttpURLConnection) url.openConnection();
           
           //request setups
           connection.setRequestMethod("GET");
           connection.setConnectTimeout(5000);
           connection.setReadTimeout(5000);
           
           int status = connection.getResponseCode();
           if(status > 300) {
        	   reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        	   
        	   while((line = reader.readLine()) != null) {
        		   response.append(line);
        	   }
        	   reader.close();
        	   
           }else {
        	   reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        	   
        	   while((line = reader.readLine()) != null) {
        		   response.append(line);
        	   }
        	   reader.close();
           }
           
           
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
		return response.toString();	
	}
	
	public static void parseMunicipaliies(String provinceName,String response) {
		
		JSONArray bodies = new JSONArray(response);
		
		for(int i = 0;i<bodies.length();i++) {
			
			JSONObject body = bodies.getJSONObject(i);
			
			String municipality = body.getString("Text");
			int municipalIndex = body.getInt("Value");
			
			
			//send http request to get back surburb data
			//System.out.println(provinceName);
			
		
			
			parseSurburb(MunicipalityHttpReqAndRes("https://loadshedding.eskom.co.za/LoadShedding/GetSurburbData/?callback=jQuery19102955907279405847_1636147019478&pageSize=100&pageNum=1&searchTerm=&id="+municipalIndex+"&_=1636147019479"),provinceName, municipality,municipalIndex);
		}
	}
	
	
	public static void parseSurburb(String response,String provinceName,String municipalityName,int municipalityIndex) {
		
		
		response = response.substring(response.indexOf("[") + 1);
		if(response.length() != 0) {
		 response = response.substring(0, response.indexOf("]"));	    
		}	    
  
		JSONArray bodies = new JSONArray("["+response+"]");
		
		for(int i = 0;i<bodies.length();i++) {
			
			JSONObject body = bodies.getJSONObject(i);
			
			String surburb = body.getString("text");
			int surburbIndex = body.getInt("id");
			//int tot = body.getInt("Tot");
			
			
			//this is where our location list will be filled
			//not everything is being added to the list..........fix this tomorrow
			
			location.add(new LocationModel(provinceName,municipalityName,surburb,surburbIndex));
			
		}
	}
	

}
