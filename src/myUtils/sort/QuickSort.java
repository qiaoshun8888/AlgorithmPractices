package myUtils.sort;

import java.util.Random;

/**
 *	QuickSort.java
 *
 *	Description: 
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Jan 28, 2014
 */

public class QuickSort extends SortBase {

	public static void sort(Object[] a) {
		calledTimes = 0;
		runTime = System.currentTimeMillis();
				
		if (a == null || a.length <= 1) return;
		
		sortHelper(a, 0, a.length - 1);
		
		runTime = System.currentTimeMillis() - runTime;
	}
	private static void sortHelper(Object[] a, int left, int right) {
		if (left < right) {
			int pivot = partition(a, left, right);
			sortHelper(a, left, pivot);
			sortHelper(a, pivot + 1, right);
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static int partition(Object[] a, int left, int right) {
		Random rand = new Random();
		Object vp = a[rand.nextInt(right - left + 1) + left];
		while (left < right) {
			while (((Comparable)a[left]).compareTo(vp) < 0) {
				calledTimes++;
				left++;
			}
			while (((Comparable)a[right]).compareTo(vp) > 0) {
				calledTimes++;
				right--;
			}
			swap(a, left, right);
		}
		return left;
	}
}
