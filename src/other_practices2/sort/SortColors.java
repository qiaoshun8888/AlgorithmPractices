package other_practices2.sort;

public class SortColors {

	/**
	 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

		Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

		Note:
		You are not suppose to use the library's sort function for this problem.
	 */

	public void sortColors(int[] A) {
		if (A == null) return;
		int red = 0, blue = A.length - 1;
		for (int i = 0; i <= blue && red < blue; i++) {
			if (A[i] == 0 && i != red) swap(A, i--, red++);
			else if (A[i] == 2 && i != blue) swap(A, i--, blue--);
		}
	}
	private void swap(int[] vs, int a, int b) {
		if (a != b) {
			vs[a] ^= vs[b];
			vs[b] ^= vs[a];
			vs[a] ^= vs[b];
		}
	}

	public static void main(String[] args) {
		// int[] vs = {1,0,0,1,2,0,2,2,0,1,2};
		int[] vs = {0,1,2};
		SortColors o = new SortColors();
		o.sortColors(vs);
		for (int v : vs) {
			System.out.print(v + " ");
		}
	}
}
