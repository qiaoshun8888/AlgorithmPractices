package crackingTheCodingInterview2;

import java.util.*;

public class Ch1_BigNumber2 {

	/**
	 * You have two integer arrays. Treat these arrays as if they were big
	 * numbers, with one digit in each slot. Perform multiplication on these two
	 * arrays and store the results in a new array.
	 * 
	 * */

	/**
	 * a[]: {1, 2, 3, 4, 5, 6, 7} 
	 * b[]: {9, 8, 7, 6, 5, 4, 3};
	 * 
	 * */

	public static int[] multiply(int[] a, int[] b) {
		int[] bigger = null, smaller = null;
		if (a.length > b.length) {
			bigger = a;
			smaller = b;
		} else {
			bigger = b;
			smaller = a;
		}
		int biggerIndex = bigger.length - 1, smallerIndex = smaller.length - 1, carry = 0;
		int[] result = new int[bigger.length + smaller.length];

		while (smallerIndex >= 0) {
			while (biggerIndex >= 0) {
				int resultIndex = result.length - 1
						- (smaller.length - 1 - smallerIndex)
						- (bigger.length - 1 - biggerIndex);
				int v = smaller[smallerIndex] * bigger[biggerIndex]
						+ result[resultIndex] + carry;
				
				/*
				System.out.printf("%d * %d = %d\n", smaller[smallerIndex], bigger[biggerIndex], v);
				for (int i = 0; i < result.length; i++) System.out.print(result[i]);
				System.out.println();
				*/
				
				carry = v / 10;
				v %= 10;
				// System.out.printf("carry: %d update %d in to result[%d]\n", carry, v, resultIndex);
				result[resultIndex] = v;
				biggerIndex--;
				
				if (biggerIndex < 0 && smallerIndex != 0) {
					result[resultIndex - 1] = carry;
					carry = 0;
				}
			}
			biggerIndex = bigger.length - 1;
			smallerIndex--;
		}

		result[0] = carry;
		if (result[1] > 10) {
			result[0] += result[1] / 10;
			result[1] %= 10;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] a = { 1, 3 }, b = { 9, 0 };
		int[] result = multiply(a, b);

		for (int i = 0; i < result.length; i++) {
			if (i == 0 && result[i] == 0)
				continue;
			System.out.print(result[i]);
		}
		System.out.println();
	}
}
