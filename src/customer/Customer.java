package customer;

import java.util.Comparator;

public class Customer {

	
	public static final String ID = "user_id";
	public static final String NAME = "name";
	public static final String LAT = "latitude";
	public static final String LONG = "longitude";
	public static final String CUSTOMER_JSON = "/Users/philotaig/Documents/WorkSpaces/myWorkSpace/laprat/src/gistfile.txt";
	
	public Customer(){}
	
	Double latitude;
	Double longitude;
	Long user_id;
	String name;
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sort Customer ID in asending order 
	 * @author philotaig
	 *
	 */
	public static class CustomerComparator implements Comparator<Customer>{
		public int compare(Customer c1, Customer c2){
			Long id1 = c1.getUser_id();
			Long id2 = c2.getUser_id();
			return id1.compareTo(id2);
		}
	}
}
