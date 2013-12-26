package other_practices1;

public class FindKthLargestNumberFromTwoArrays {

	/**
	 * Given two sorted lists (stored in arrays) of size n, find an O(log n)
	 * algorithm that computes the nth largest element in the union of the two
	 * lists.
	 * 
	 * */
	
	public static int find(int [] vs1, int [] vs2, int k) {
		if (k < 1 || k > vs1.length + vs2.length) {
			System.out.println("K is not valid.");
			return -1;
		}
		else {
			return binarySearch(vs1, vs2, 0, vs1.length - 1, 0, vs2.length - 1, k);
		}
	}
	private static int binarySearch(int [] vs1, int [] vs2, int low1, int high1, int low2, int high2, int k) {
		int mid1 = -1, mid2 = -1;
		
		if (low1 <= high1) {
			mid1 = (low1 + high1) / 2;
		}
		
		if (low2 <= high2) {
			mid2 = (low2 + high2) / 2;
		}
		
		// System.out.println("[" + low1 + "," + high1 + "] - " + mid1 + "(" + vs1[mid1] + ")" + "    [" + low2 + "," + high2 + "] - " + mid2 + "(" + vs2[mid2] + ")");
		
		if (mid1!= -1 && mid2 != -1) {
			int t = vs1.length - mid1 + vs2.length - mid2; 
			if (t == k) {
				boolean flag = vs1[mid1] < vs2[mid2];
				return correct(flag ? vs1 : vs2, flag ? vs2 : vs1, flag ? mid1 : mid2, flag ? mid2 : mid1);
			}
			else if (t > k) { // search the array that has smaller value of vs[mid]
				if (vs1[mid1] > vs2[mid2]) {
					return binarySearch(vs1, vs2, low1, high1, mid2 + 1, high2, k);
				}
				else {
					return binarySearch(vs1, vs2, mid1 + 1, high1, low2, high2, k);
				}
			}
			else { // search the array that has larger value of vs[mid]
				if (vs1[mid1] > vs2[mid2]) {
					return binarySearch(vs1, vs2, low1, mid1 - 1, low2, high2, k);
				}
				else {
					return binarySearch(vs1, vs2, low1, high1, low2, mid2 - 1, k);
				}
			}
		}
		else if (mid1 != -1) {
			return vs1[vs1.length - k];
		}
		else {
			return vs2[vs2.length - k];
		}
	}

	private static int correct(int[] vs1, int[] vs2, int mid1, int mid2) {
		while (vs1[mid1] < vs2[mid2]) {
			if (verify(vs1, vs2, mid1 + 1, mid2 - 1) && vs1[mid1] < vs2[mid2 - 1]) {
				mid1++;
				mid2--;
			} 
			else {
				break;
			}
		}
		return Math.min(vs1[mid1], vs2[mid2]);
	}
	private static boolean verify(int [] vs1, int [] vs2, int mid1, int mid2) {
		return mid1 + 1 < vs1.length - 1 && mid1 - 1 >= 0 && mid2 < vs2.length - 1 && mid2 - 1 >= 0;
	}
	
	public static void main(String [] args) {
		int [] vs2 = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
		int [] vs1 = {1, 3, 5, 7, 9, 11, 13, 21, 27, 31, 33, 35, 68, 99, 111, 112};
		int k = 4;
		
		System.out.println(find(vs1, vs2, k));
		
		int [] vs = new int[vs1.length + vs2.length];
		int i = 0, j = 0;
		while (i + j < vs.length) {
			if (i < vs1.length && j < vs2.length) {
				vs[i + j] = vs1[i] < vs2[j] ? vs1[i++] : vs2[j++];
			}
			else {
				if (i == vs1.length) {
					vs[i + j] = vs2[j++];
				}
				else {
					vs[i + j] = vs1[i++];
				}
			}
		}
		
		System.out.print("[" + vs[vs.length - k] + "]: ");
		for (int v : vs) {
			System.out.print(v + " ");
		}
		System.out.println();
		
		
		boolean isTest = true;
		if (isTest) {
			System.out.println("========= test =========");
			for (k = 1; k <= vs.length; k++) {
				int a = find(vs1, vs2, k), b = vs[vs.length - k]; 
				System.out.println("k: " + k + " --- " + a + " [" + b + "]" + (a != b ? " X " : ""));
			}
		}
	}
}
