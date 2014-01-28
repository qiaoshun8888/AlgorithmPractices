package google.arrays;

import myUtils.datastructure.CircularArray;

/**
 * CircularArrayTest.java
 * 
 * Description: Implement a Circular Array class that supports an array-like
 * data structure which can be efficiently rotated. The class should use a
 * generic type, and should support iteration via the standard for 
 * (Obj o : circuLarArray) notation.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 28, 2014
 */

public class CircularArrayTest {

	public static void main(String[] args) {
		CircularArray<Integer> ca = new CircularArray<Integer>(5);
		ca.set(1, 2);
		ca.set(3, 4);
		ca.set(4, 5);
		System.out.println(ca);
		ca.set(5, 1);
		System.out.println(ca);
		ca.set(7, 3);
		System.out.println(ca);
		
		System.out.println("Iterate the circular array...");
		for (int v : ca) {
			System.out.println(v);
		}
		System.out.println("Done the iteration.");
	}
}
