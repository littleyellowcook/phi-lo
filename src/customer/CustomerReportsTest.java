package customer;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CustomerReportsTest {

	public Customer cm;
	public CustomerReports cr;
	
	@Before
	public void setUp() throws Exception {
		cm = new Customer();
		cr = new CustomerReports();
	}

	@Test
	public void testReadFile() {
		ArrayList<Customer> actual = FileUtil.readCustomerJsonFile(Customer.CUSTOMER_JSON);
		assertNotNull(actual);
	    assertFalse(actual.isEmpty());
	    assertEquals(32, actual.size());
	}
	
	@Test
	public void testZeroDistance(){
		Double actual = GreatCircleDistantCalculatior.calculateDistance(
				GreatCircleDistantCalculatior.OFFICE_LAT, GreatCircleDistantCalculatior.OFFICE_LON,
				GreatCircleDistantCalculatior.OFFICE_LAT, GreatCircleDistantCalculatior.OFFICE_LON);
		assertTrue(0D == actual);
	}
	
	@Test
	public void testSingleDistance(){
		Double autal = GreatCircleDistantCalculatior.calculateDistance(
				GreatCircleDistantCalculatior.OFFICE_LAT, GreatCircleDistantCalculatior.OFFICE_LON,
				53.2451022D, -6.238335D);
		assertTrue(0 < autal);
	}
	
	@Test
	public void testGetCustomersLessThan50Km(){
		ArrayList<Customer> actual = cr.getCustomerByDistance(50D);
		assertNotNull(actual);
	    assertFalse(actual.isEmpty());
		assertEquals(8, actual.size());
	}
	

}
