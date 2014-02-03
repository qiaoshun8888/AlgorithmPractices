package google.arrays;

import java.util.*;

/**
 * FindAllIntersectionsInTwoSortedArray.java
 * 
 * Description: Find the intersection of two sorted arrays.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Feb 3, 2014
 */

public class FindAllIntersectionsInTwoSortedArray {

	public static ArrayList<Integer> find(int[] vs1, int[] vs2) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int index1 = 0, index2 = 0;
		
		while (index1 < vs1.length && index2 < vs2.length) {
			if (vs1[index1] == vs2[index2]) { 
				result.add(vs1[index1]);
				index1++;
				index2++;
			}
			else if (vs1[index1] > vs2[index2]) index2++;
			else index1++;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] vs1 = {1, 2, 3, 5, 7, 11, 13, 15};
		int[] vs2 = {2, 4, 6, 11, 12, 14, 15};
		for (int v : find(vs1, vs2)) {
			System.out.println(v);
		}
	}
}
