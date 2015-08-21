package customer;

public class GreatCircleDistantCalculatior {

	public static final double OFFICE_LAT = 53.3381985D;
	public static final double OFFICE_LON = -6.2592576D;
	
	public GreatCircleDistantCalculatior() {}
	
	/**
	 * Return Great Circle distance between two points in kilometres
	 * @param lat1
	 * @param lon1
	 * @param lat2
	 * @param lon2
	 * @return
	 */
	public static double calculateDistance(double lat1, double lon1, double lat2, double lon2){
		double radLat1 = Math.toRadians(lat1);
		double radLon1 = Math.toRadians(lon1);
		double radLat2 = Math.toRadians(lat2);
		double radLon2 = Math.toRadians(lon2);
		// Compute using law of cosines
		double angle = Math.acos(Math.sin(radLat1) * Math.sin(radLat2)
				+ Math.cos(radLat1) * Math.cos(radLat2) * Math.cos(radLon1 - radLon2));
		// convert back to degrees
		angle = Math.toDegrees(angle);
		// each degree on a great circle of Earth is 60 nautical miles
		double distance = 60 * angle;
		// conver to km
		return distance/0.53996;
	}
}
