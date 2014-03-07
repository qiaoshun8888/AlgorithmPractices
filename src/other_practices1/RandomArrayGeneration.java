package other_practices1;

import java.util.Random;

/**
 * RandomArrayGeneration.java
 * 
 * Description: Given an integer n, write a function to return an array of size
 * n, containing each of the numbers from 0 to n - 1 in a random order. The
 * number may not repeat and each number must show up exactly once.
 * 
 * Example:
 * n = 4	output: 2, 0, 1, 3
 * 2, 0, 0, 1 is not a valid array since 0 is duplicated and the 3 does not appear
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Mar 4, 2014
 */

public class RandomArrayGeneration {

	public static int[] generate(int n) {
		if (n <= 0) return null;
		int[] vs = new int[n];
		for(int i = 0; i < n; i++) vs[i] = i;
		shuffle(vs);
		return vs;
	}
	
	private static void shuffle(int[] vs) {
		Random rand = new Random();
		for (int i = vs.length - 1; i >= 1; i--) {
			int j = rand.nextInt(i + 1);
			swap(vs, i, j);
		}
	}
	
	private static void swap(int[] vs, int i, int j) {
		if (i != j) {
			vs[i] ^= vs[j];
			vs[j] ^= vs[i];
			vs[i] ^= vs[j];
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			int[] vs = generate(3);
			for (int v : vs) System.out.print(v + " ");
			System.out.println();
		}
	}
}
