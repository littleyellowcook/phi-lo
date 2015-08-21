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
}
