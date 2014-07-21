package other_practices2.array;

public class RemoveElement {

	/*
	 * Given an array and a value, remove all instances of that value in place
	 * and return the new length.
	 * 
	 * The order of elements can be changed. It doesn't matter what you leave
	 * beyond the new length.
	 */

	// overwrite the array
	public int removeElement(int[] A, int elem) {
		if (A == null || A.length == 0)
			return 0;
		int index = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem)
				A[index++] = A[i];
		}
		return index;
	}

	// this method won't overwrite the elements in the array
	public int removeElement2(int[] A, int elem) {
		if (A == null || A.length == 0)
			return 0;
		// 1 2 2 3 1 2 4 5 3 (2)
		int endIndex = A.length - 1;
		for (int i = 0; i <= endIndex; i++) {
			if (A[i] == elem) {
				while (A[endIndex] == elem) {
					if (endIndex == i || endIndex <= 0)
						return endIndex;
					endIndex--;
				}
				swap(A, i, endIndex--);
			}
		}
		return endIndex + 1;
	}

	private void swap(int[] vs, int a, int b) {
		if (a != b) {
			vs[a] ^= vs[b];
			vs[b] ^= vs[a];
			vs[a] ^= vs[b];
		}
	}

	public static void main(String[] args) {
		// int[] vs = { 1, 2, 2, 3, 1, 2, 4, 5, 3 };
		int[] vs = { 3, 2, 2, 3, 3, 3, 2, 2, 2, 3, 3, 3 };
		// int[] vs = { 3 };
		// int[] vs = { 22, 2, 2, };
		int elem = 3;
		RemoveElement o = new RemoveElement();
		System.out.println(o.removeElement(vs, elem));
	}
}
