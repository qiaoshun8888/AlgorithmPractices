package google;

import java.util.Random;

/**
 * Randomness.java
 * 
 * Description: Given a function which generates a random number in [1,5],we
 * need to use this function to generate a random number in the range [1,9].
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Feb 1, 2014
 */

public class Randomness {

	public static int rand9() {
		final int [][] matrix = {
			{1, 2, 3, 4, 5},
			{6, 7, 8, 9, 1},
			{2, 3, 4, 5, 6},
			{7, 8, 9, 0, 0},
			{0, 0, 0, 0, 0}
		};
		int r = 0;
		while (r == 0) {
			r = matrix[rand5() - 1][rand5() - 1];
		}
		return r;
	}
	
	private static final int rand5() {
		Random rand = new Random();
		return rand.nextInt(5) + 1;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println("[" + rand9() + "]");
		}
	}
}
