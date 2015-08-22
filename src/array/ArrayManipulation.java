package array;

import java.util.ArrayList;

/**
 * Class use for ArrayList manipulations
 * @author philotaig
 *
 */
public class ArrayManipulation {

	/**
	 * Return an ArrayList of given list of objects
	 * @param objects
	 * @return
	 */
	public ArrayList<Object> createArray(Object...objects) {
		ArrayList<Object> result = new ArrayList<Object>();
		for (Object obj : objects){
			result.add(obj);
		}
		return result;
	}

	/**
	 * Flatten given (nested) ArrayList into a single dimension ArrayList  
	 * @param testArray
	 * @return
	 */
	public ArrayList<Object> flattenArray(ArrayList<Object> testArray) {
		ArrayList<Object> result = new ArrayList<Object>();
		processArray(testArray, result);
		return result;
	}

	@SuppressWarnings("unchecked")
	private void processArray(ArrayList<Object> testArray,
			ArrayList<Object> result) {
		for (Object obj : testArray){
			try {
				processArray((ArrayList<Object>)obj, result);
			} catch (Exception e) {
				result.add(obj);
			}
		}
	}
	
	public static void main(String[] args){
		ArrayManipulation am = new ArrayManipulation();
		ArrayList<Object> thirdLevelArray = am.createArray("a", "b", "c");
		ArrayList<Object> secondLevelArray = am.createArray(thirdLevelArray, "a", "b", 1, 10L, true);
		ArrayList<Object> firstLevelArray = am.createArray(4, false, 5L, "d", secondLevelArray);
		ArrayList<Object> testArray = am.createArray("a", firstLevelArray, 1.2, 500L, false);
		ArrayList<Object> results = am.flattenArray(testArray);
		if (results != null && !results.isEmpty()){
			for (Object obj : results){
				System.out.println(obj.toString());
			}
		}
	}
}
