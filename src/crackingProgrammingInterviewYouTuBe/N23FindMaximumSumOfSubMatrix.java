package crackingProgrammingInterviewYouTuBe;

import java.util.Random;

public class N23FindMaximumSumOfSubMatrix {
	
	private static int called_times = 0;

	/**
	 * Find the maximum sum of a sub-matrix in a 2-D Array (matrix)
	 * 
	 * */
	
	/**
	 * 1  2  3  4  5
	 * 6  7  8  9  10
	 * 11 12 13 14 15
	 * 16 17 18 19 20
	 * 21 22 23 24 25
	 * 
	 * */
	public static int maxSum(int [][] matrix) {
		int maxSum = Integer.MIN_VALUE;
		int max_x_start = 0, max_y_start = 0, max_x_end = 0, max_y_end = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				for (int m = i; m < matrix.length; m++) {
					for (int n = j; n < matrix[0].length; n++) {
						int tempSum = 0;
						// sum from (i, j) to (m, n)
						for (int x = i; x <= m ; x++) {
							for (int y = j; y <= n; y++) {
								called_times++;
								tempSum += matrix[x][y];
							}
						}
						
						if (tempSum > maxSum) {
							maxSum = tempSum;
							max_x_start = i;
							max_y_start = j;
							max_x_end = m;
							max_y_end = n;
						}
					}
				}
			}
		}
		System.out.printf("from (%d, %d) to (%d, %d)\n", max_x_start, max_y_start, max_x_end, max_y_end);
		return maxSum;
	}
	
	public static void main(String [] args) {
		int [][] matrix = new int[5][5];
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = rand.nextBoolean() ? rand.nextInt(10) : -rand.nextInt(10);
				sb.append("\t" + matrix[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		System.out.println(maxSum(matrix));
		System.out.println("========  called_times: " + called_times);
	}
}
