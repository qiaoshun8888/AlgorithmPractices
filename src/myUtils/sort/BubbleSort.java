package myUtils.sort;

/**
 * BubbleSort.java
 * 
 * Description:
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 28, 2014
 */

public class BubbleSort extends SortBase {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void sort(Object[] a) {
		calledTimes = 0;
		runTime = System.currentTimeMillis();
				
		if (a == null || a.length <= 1) return;
		
		boolean stop = false;
		
		while (!stop) {
			stop = true;
			for (int i = 0; i < a.length - 1; i++) {
				calledTimes++;
				if (((Comparable)a[i]).compareTo(a[i + 1]) > 0) {
					swap(a, i, i + 1);
					stop = false;
				}
			}
		}
		
		runTime = System.currentTimeMillis() - runTime;
	}
	
	public static void main(String[] args) {
		Integer [] vs = {2, 5, 1, -7};
		sort(vs);
		for (int v : vs) {
			System.out.print(v + " ");
		}
		System.out.println();
		System.out.println("calledTimes: " + calledTimes + ", runTime: " + runTime + "ms");
	}
}
