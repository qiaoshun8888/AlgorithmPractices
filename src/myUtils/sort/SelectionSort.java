package myUtils.sort;

/**
 *	SelectSort.java
 *
 *	Description: 
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Jan 28, 2014
 */

public class SelectionSort extends SortBase {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void sort(Object[] a) {
		calledTimes = 0;
		runTime = System.currentTimeMillis();
				
		if (a == null || a.length <= 1) return;
		
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				calledTimes++;
				if (((Comparable)a[i]).compareTo(a[j]) > 0) {
					swap(a, i, j);
				}
			}
		}
		
		runTime = System.currentTimeMillis() - runTime;
	}
	
	
}
