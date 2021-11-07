import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Schedule s = new Schedule();

 

	    
	    
	    
	   
	    
	   	  String display ="";
	      //Getting the schedule of each surburb using 
	     	for(int k = 0 ;k < Schedule.LoadSheddingFullSchedule.size();k++) {
	     		
	     		display += Schedule.LoadSheddingFullSchedule.get(k).province+" "+Schedule.LoadSheddingFullSchedule.get(k).municipality+" "+Schedule.LoadSheddingFullSchedule.get(k).suburb+" "+Schedule.LoadSheddingFullSchedule.get(k).Date+" "+Schedule.LoadSheddingFullSchedule.get(k).Time+"\n";
	     	  
	     	}
	         System.out.println(display);  


		
	}
	
	
	


}
