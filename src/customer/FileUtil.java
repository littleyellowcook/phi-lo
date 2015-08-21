package customer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtil {

	/**
	 * Read a file contains list of customer information in form of JSON object per line
	 * @param file
	 * @return
	 */
	public static ArrayList<Customer> readCustomerJsonFile(String file) {
		ArrayList<Customer> customerArray = new ArrayList<Customer>();
		JSONParser parser = new JSONParser();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				StringReader sr = new StringReader(line);
				Object obj = parser.parse(sr);
				JSONObject jsonObject = (JSONObject) obj;
				if (jsonObject != null){
					Customer cust = new Customer();
					cust.setUser_id((Long) jsonObject.get(Customer.ID));
					cust.setName((String)jsonObject.get(Customer.NAME));
					cust.setLatitude(Double.valueOf((String)jsonObject.get(Customer.LAT)));
					cust.setLongitude(Double.valueOf((String)jsonObject.get(Customer.LONG)));
					customerArray.add(cust);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found, " + e);
		} catch (IOException e) {
			System.err.println("IO Exception, " + e);
		} catch (ParseException e) {
			System.err.println("Parse error, " + e);
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				System.err.println("IO Exception when closing streams, " + e);
			}
		} 
		return customerArray;
	}
}
