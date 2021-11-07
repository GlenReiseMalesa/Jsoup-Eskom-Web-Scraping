
public class ScheduleModel {

	String  suburb;
	String Date;
	String Time;
	public ScheduleModel(String  suburb,String Date,String Time) {
		// TODO Auto-generated constructor stub
		this.suburb = suburb;
		this.Date = Date;
		this.Time=Time;
	}
	
	
	public String getSuburb() {
		return suburb;
	}
	
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}

	
	
}
