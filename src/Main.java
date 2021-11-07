
public class Main {

	

	public static void main(String[] args) {
		
		/*
		 * Examples on how to use the methods and variables
		 */
		
   System.out.println("*************************************************************************************************"); 		
		
        //Always Start By Initialising
	        Schedule schedule = new Schedule("Aardoff");
	        schedule.initialize();
	        
	        
	System.out.println("*************************************************************************************************");        
 
       //Get the load-shedding stage
	        int loadsheddingStage = Schedule.loadSheddingStatus();
	        System.out.println("The whole South African Country Is On Stage : "+loadsheddingStage);
	    
	 System.out.println("*************************************************************************************************");  
	 
	   //Getting And Displaying All The Locations Available
	       String locations = "";
	       for(int i =0; i < Location.location.size();i++) {
	    	   locations += Location.location.get(i).province+" "+Location.location.get(i).municipality+" "+Location.location.get(i).surburb+"\n";
	       }
	       System.out.println(locations);
	  
	       
	  System.out.println("*************************************************************************************************");     
	       
	   //Getting the schedule of each suburb using the suburb name as an identifier 
	        String display ="";
	     	for(int k = 0 ;k < Schedule.LoadSheddingFullSchedule.size();k++) {
	     		
	     		display += Schedule.LoadSheddingFullSchedule.get(k).province+" "+Schedule.LoadSheddingFullSchedule.get(k).municipality+" "+Schedule.LoadSheddingFullSchedule.get(k).suburb+" "+Schedule.LoadSheddingFullSchedule.get(k).Date+" "+Schedule.LoadSheddingFullSchedule.get(k).Time+"\n"; 
	     	}
	        System.out.println(display);  
      
	  System.out.println("*************************************************************************************************"); 

		
	}
	
	
	


}
