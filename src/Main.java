import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

	
	private static HttpURLConnection connection;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader reader;
		String line; 
		StringBuffer response = new StringBuffer();
		
		try {
		   URL url = new URL("https://loadshedding.eskom.co.za/LoadShedding/GetMunicipalities/?Id=1");	
			
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
           
           
           System.out.println(response.toString());
           
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
