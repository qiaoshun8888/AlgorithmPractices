package crackingTheCodingInterview.chapter11;

public class BinarySearch {

	public static int searchIteratively(int [] vs, int x) {
		int left = 0, right = vs.length - 1, mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			if (x == vs[mid]) {  // find x
				return mid;
			}
			else if (x < vs[mid]) {  // x in the left side
				right = mid - 1;
			}
			else {  // x in the right side
				left = mid + 1;
			}
		}
		return -1;
	}
	
	public static int searchRecursively(int [] vs, int x, int left, int right) {
		if (left > right) return -1;
		int mid = (left + right) / 2;
		if (x == vs[mid]) return mid;
		else if (x > vs[mid]) return searchRecursively(vs, x, mid + 1, right);
		else return searchRecursively(vs, x, left, mid - 1);
	}
	
	public static void main(String [] args) {
		int [] vs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(searchIteratively(vs, 5));
		System.out.println(searchRecursively(vs, 5, 0, vs.length - 1));
	}
}
