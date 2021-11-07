
public class LocationModel {
	
	String province;
	String municipality;
	String surburb;
	int surburbIndex;
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocationModel(String province,String municipality,String surburb,int surburbIndex,int id) {
		// TODO Auto-generated constructor stub
		
		 this.province = province;
		 this.municipality =  municipality;
		 this.surburb = surburb;
		 this.surburbIndex = surburbIndex;
		 this.id = id;
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
