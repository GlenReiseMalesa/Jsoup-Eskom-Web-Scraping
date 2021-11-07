
public class Main {

	

	public static void main(String[] args) {
		
        //Start by initializing
        Schedule schedule = new Schedule("Aardoff");
        schedule.initialize();
 

	    
	    
	    
	   
	    
	   	  String display ="";
	      //Getting the schedule of each surburb using 
	     	for(int k = 0 ;k < Schedule.LoadSheddingFullSchedule.size();k++) {
	     		
	     		display += Schedule.LoadSheddingFullSchedule.get(k).province+" "+Schedule.LoadSheddingFullSchedule.get(k).municipality+" "+Schedule.LoadSheddingFullSchedule.get(k).suburb+" "+Schedule.LoadSheddingFullSchedule.get(k).Date+" "+Schedule.LoadSheddingFullSchedule.get(k).Time+"\n";
	     	  
	     	}
	         System.out.println(display);  


		
	}
	
	
	


}
