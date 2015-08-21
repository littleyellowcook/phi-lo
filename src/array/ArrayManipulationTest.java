package array;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class ArrayManipulationTest {
	
	public ArrayManipulation am;

	@Before
	public void setUp() throws Exception {
		am = new ArrayManipulation();
	}

	@Test
	public void testCreateSimpleArray() {
		ArrayList<Object> actual = am.createArray("a");
		ArrayList<Object> expected = new ArrayList<Object>(Arrays.asList("a"));
		assertArrayEquals("create simple array failed", expected.toArray(), actual.toArray());
	}
	
	@Test
	public void testCreateMixArray(){
		ArrayList<Object> actual = am.createArray("a", 1.2, 500L, false);
		ArrayList<Object> expected = new ArrayList<Object>(Arrays.asList("a", 1.2, 500L, false));
		assertArrayEquals("create mix array failed", expected.toArray(), actual.toArray());
	}
	
	@Test
	public void testNestedArray(){
		ArrayList<Object> subarray = am.createArray("a", "b", 1, 10L, true);
		ArrayList<Object> actual = am.createArray("a", 1.2, 500L, false, subarray);
		ArrayList<Object> expected = new ArrayList<Object>(Arrays.asList("a", 1.2, 500L, false, subarray));
		assertArrayEquals("create nexted array failed", expected.toArray(), actual.toArray());
	}
	
	@Test
	public void testFlatten1dArray(){
		ArrayList<Object> testArray = am.createArray("a", "b", 1, 10L, true);
		ArrayList<Object> actual = am.flattenArray(testArray);
		ArrayList<Object> expected = new ArrayList<Object>(Arrays.asList("a", "b", 1, 10L, true));
		assertArrayEquals("flatten 1d array failed", expected.toArray(), actual.toArray());
	}
	
	@Test
	public void testFlatten2dArray(){
		ArrayList<Object> subArray = am.createArray("a", "b", 1, 10L, true);
		ArrayList<Object> testArray = am.createArray("a", subArray, 1.2, 500L, false, subArray);
		ArrayList<Object> actual = am.flattenArray(testArray);
		ArrayList<Object> expected = new ArrayList<Object>(Arrays.asList("a", "a", "b", 1, 10L, true, 1.2, 500L, false, "a", "b", 1, 10L, true));
		assertArrayEquals("flatten 2d array failed", expected.toArray(), actual.toArray());
	}
	
	@Test
	public void testFlatten3dArray(){
		ArrayList<Object> secondLevelArray = am.createArray("a", "b", 1, 10L, true);
		ArrayList<Object> firstLevelArray = am.createArray(4, false, 5L, "d", secondLevelArray);
		ArrayList<Object> testArray = am.createArray("a", firstLevelArray, 1.2, 500L, false);
		ArrayList<Object> actual = am.flattenArray(testArray);
		ArrayList<Object> expected = new ArrayList<Object>(Arrays.asList("a", 4, false, 5L, "d", "a", "b", 1, 10L, true, 1.2, 500L, false));
		assertArrayEquals("flatten 3d array failed", expected.toArray(), actual.toArray());
	}
	
	@Test
	public void testFlatten4dArray(){
		ArrayList<Object> thirdLevelArray = am.createArray("a", "b", "c");
		ArrayList<Object> secondLevelArray = am.createArray(thirdLevelArray, "a", "b", 1, 10L, true);
		ArrayList<Object> firstLevelArray = am.createArray(4, false, 5L, "d", secondLevelArray);
		ArrayList<Object> testArray = am.createArray("a", firstLevelArray, 1.2, 500L, false);
		ArrayList<Object> actual = am.flattenArray(testArray);
		ArrayList<Object> expected = new ArrayList<Object>(Arrays.asList("a", 4, false, 5L, "d", "a", "b", "c", "a", "b", 1, 10L, true, 1.2, 500L, false));
		assertArrayEquals("flatten 4d failed", expected.toArray(), actual.toArray());
	}
}
