package myUtils.sort;

/**
 *	InsertionSort.java
 *
 *	Description: 
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Jan 28, 2014
 */

public class InsertionSort extends SortBase {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void sort(Object[] a) {
		calledTimes = 0;
		runTime = System.currentTimeMillis();
				
		if (a == null || a.length <= 1) return;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = i - 1; j >= 0 && ((Comparable)a[j]).compareTo(a[j + 1]) > 0; j--) {
				calledTimes++;
				swap(a, j, j + 1);
			}
		}
		
		runTime = System.currentTimeMillis() - runTime;
	}
}
