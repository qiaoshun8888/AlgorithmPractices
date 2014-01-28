package myUtils.sort;

/**
 *	MergeSort.java
 *
 *	Description: 
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Jan 28, 2014
 */

public class MergeSort extends SortBase {

	public static void sort(Object[] a) {
		calledTimes = 0;
		runTime = System.currentTimeMillis();
				
		if (a == null || a.length <= 1) return;
		
		sortHelper(a, 0, a.length - 1);
		
		runTime = System.currentTimeMillis() - runTime;
	}
	private static void sortHelper(Object[] a, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			sortHelper(a, left, mid);
			sortHelper(a, mid + 1, right);
			merge(a, left, mid, right);
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void merge(Object[] a, int left, int mid, int right) {
		Object[] aux = new Object[right - mid];
		
		//  1  4  5  #  2  8  9
		//  ^        #  ^
		//  |        #  |
		int offset = mid + 1;
		for (int i = offset; i <= right; i++) {
			calledTimes++;
			aux[i - offset] = a[i];
		}
		
		int auxRight = aux.length - 1, aRight = mid;
		
		while (auxRight >= 0 && aRight >= left) {
			calledTimes++;
			if (((Comparable)aux[auxRight]).compareTo(a[aRight]) >= 0) {
				a[right--] = aux[auxRight--];
			}
			else {
				a[right--] = a[aRight--];
			}
		}
		
		while (auxRight >= 0) {
			calledTimes++;
			a[right--] = aux[auxRight--];
		}
	}
}
