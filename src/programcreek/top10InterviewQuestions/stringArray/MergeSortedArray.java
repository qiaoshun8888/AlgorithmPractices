package programcreek.top10InterviewQuestions.stringArray;

public class MergeSortedArray {

	/**
	 * Given two sorted integer arrays A and B, merge B into A as one sorted
	 * array.
	 * 
	 * Note: You may assume that A has enough space to hold additional elements
	 * from B. The number of elements initialized in A and B are m and n
	 * respectively.
	 * 
	 * Thoughts for This Problem
	 * 
	 * The key to solve this problem is moving element of A and B backwards. If
	 * B has some elements left after A is done, also need to handle that case.
	 * 
	 * The take away message from this problem is that the loop condition. This
	 * kind of condition is also used for merging two sorted linked list.
	 * 
	 * */

	public void merge(int A[], int m, int B[], int n) {
		int endIndex = m + n - 1;
		n--;
		m--;
		
		while (m >= 0 && n >= 0) {
			if (B[n] > A[m]) {
				A[endIndex--] = B[n--];
			}
			else {
				A[endIndex--] = A[m--];
			}
		}

		while (n >= 0) {
			A[endIndex--] = B[n--];
		}
	}

	public static void main(String[] args) {
		int [] A = new int[50];
		for (int i = 0; i < 10; i++) {
			A[i] = 2 * i;
		}
		int [] B = {1, 3, 5, 7, 9, 13, 17, 29, 71};
		
		MergeSortedArray o = new MergeSortedArray();
		o.merge(A, 10, B, B.length);
		
		for (int i = 0; i < 10 + B.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
