package customer;

import java.util.ArrayList;
import java.util.Collections;

public class CustomerReports {
	public ArrayList<Customer> getCustomerByDistance(Double minDistantInKilometer){
		ArrayList<Customer> result = new ArrayList<Customer>();
		ArrayList<Customer> allCustomers = FileUtil.readCustomerJsonFile(Customer.CUSTOMER_JSON);
		if (allCustomers != null){
			for (Customer c : allCustomers){
				if (GreatCircleDistantCalculatior.calculateDistance(
						GreatCircleDistantCalculatior.OFFICE_LAT, 
						GreatCircleDistantCalculatior.OFFICE_LON, 
						c.getLatitude(), c.getLongitude()) < minDistantInKilometer){
					result.add(c);
				}
			}
		}
		Collections.sort(result, new Customer.CustomerComparator());
		return result;
	}
	
	public static void main(String[] args){
		CustomerReports cr = new CustomerReports();
		ArrayList<Customer> custs = FileUtil.readCustomerJsonFile(Customer.CUSTOMER_JSON);
		if (custs != null && !custs.isEmpty()){
			ArrayList<Customer> results = cr.getCustomerByDistance(100D);
			System.out.println(results.size()+" customer found within 100km from the office");
			for (Customer c : results){
				System.out.println(c.getUser_id()+" "+c.getName());
			}
		}
	}
}
