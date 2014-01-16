package crackingTheCodingInterview.chapter11;

public class SearchRotatedArray {

	public int find(int[] vs, int x) {
		return find(vs, x, 0, vs.length - 1);
	}

	private int find(int[] vs, int x, int low, int high) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;
		System.out.printf(
				"low: %d, high: %d, mid: %d, mid_val: %d, vs[mid] == x:%s\n",
				low, high, mid, vs[mid], vs[mid] == x);
		if (vs[mid] == x) {
			return mid;
		}
		
		if (vs[mid] == vs[low]) { // 2 2 3
			if (vs[mid] != vs[high]) {  // If vs[mid] != vs[high], we search right side.
				System.out.println(111111);
				return find(vs, x, mid + 1, high);
			}
			else {
				System.out.println(2222222);
				return -1;
				// int v = find(vs, x, mid + 1, high);
				// return v != -1 ? v : find(vs, x, low, mid - 1);
			}
		}
		// In this situation, the rotate point in the left, then the left part
		// is not always increasing.
		// So if x is larger than the vs[mid], we should search both left and
		// right side, otherwise, we only need to search the left side.
		else if (vs[mid] < vs[low]) { // 4 5 1 (2) 2 2 3
			if (x > vs[mid]) {
				int v = find(vs, x, mid + 1, high);
				return v != -1 ? v : find(vs, x, low, mid - 1);
			} else {
				return find(vs, x, low, mid - 1);
			}
		}
		// In this situation, the rotate point in the right, then the right part
		// is not always increasing.
		// So if x is larger than the vs[mid], we only need to search right side
		// because the left side is in increasing oder and the vs[mid] is less
		// than x. Otherwise we need to search both left and right side.
		else { // 2 3 (4) 5 1
			if (x > vs[mid]) {
				return find(vs, x, mid + 1, high);
			} else {
				int v = find(vs, x, low, mid - 1);
				return v != -1 ? v : find(vs, x, mid + 1, high);
			}
		}
	}

	public static void main(String[] args) {
		int[] vs = { 2, 2, 3, 3, 4, 5, 5, 5, 0, 1, 1, 1};
		SearchRotatedArray sra = new SearchRotatedArray();
		System.out.println(sra.find(vs, 1));
		/*
		String word1 = "hello", word2 = "hfllo";
		System.out.println(word1.compareTo(word2));
		System.out.println(word2.compareTo(word1));
		*/
	}
}
