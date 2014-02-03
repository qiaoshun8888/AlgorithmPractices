package google.arrays;

/**
 * MergeTwoSortedArray.java
 * 
 * Description: Merge two sorted array
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Feb 3, 2014
 */

public class MergeTwoSortedArray {

	public static void merge(int[] vs1, int[] vs2, int length1) {
		int endIndex = length1 + vs2.length - 1, end1 = length1 - 1, end2 = vs2.length - 1;
		while (endIndex >= 0 && end2 >= 0)
			if (end2 >= 0 && vs2[end2] > vs1[end1])
				vs1[endIndex--] = vs2[end2--];
			else 
				vs1[endIndex--] = vs1[end1--];
	}

	public static void main(String[] args) {
		int[] a = new int[50];
		int[] b = new int[10];
		int a_elements = 15;
		System.out.print("A: ");
		for (int i = 0; i < a_elements; i++) {
			a[i] = i * 2 + 1; // 1 3 5 7 9
			System.out.print(a[i] + " ");
		}
		System.out.print("\nB: ");
		for (int i = 0; i < 10; i++) {
			b[i] = (i + 1) * 2; // 2 4 6 8 10 ...
			System.out.print(b[i] + " ");
		}
		System.out.println();
		
		merge(a, b, a_elements);

		for (int i : a) {
			if (i == 0)
				break;
			System.out.print(i + " ");
		}
	}
}
