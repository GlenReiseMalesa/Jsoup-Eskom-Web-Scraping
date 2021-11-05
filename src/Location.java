
public class Location {
	
	String province;
	String municipality;
	String surburb;
	int surburbIndex;

	public Location(String province,String municipality,String surburb,int surburbIndex) {
		// TODO Auto-generated constructor stub
		
		 this.province = province;
		 this.municipality =  municipality;
		 this.surburb = surburb;
		 this.surburbIndex = surburbIndex;
		
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getSurburb() {
		return surburb;
	}

	public void setSurburb(String surburb) {
		this.surburb = surburb;
	}

	public int getSurburbIndex() {
		return surburbIndex;
	}

	public void setSurburbIndex(int surburbIndex) {
		this.surburbIndex = surburbIndex;
	}
	

}
