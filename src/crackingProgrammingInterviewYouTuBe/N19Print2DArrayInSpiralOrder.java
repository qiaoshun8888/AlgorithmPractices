package crackingProgrammingInterviewYouTuBe;

public class N19Print2DArrayInSpiralOrder {

	
	/**
	 * Print out a 2-D array in spiral order.
	 * 
	 * */
	
	/**
	 * 1  2  3  4  5
	 * 6  7  8  9  10
	 * 11 12 13 14 15
	 * 16 17 18 19 20
	 * 21 22 23 24 25
	 * 
	 * 1 2 3 4 5 10 15 20 25 24 23 22 21 16 11 6 7 ...
	 * */
	public static void print(int [][] matrix) {
		int top = 1, right = matrix[0].length - 1, bottom = matrix.length - 1, left = 0;
		
		int x = 0, y = 0;
		int direction = 1; // 1-right 2-bottom 3-left 4-top
		int count = 0;
		StringBuilder sb = new StringBuilder();
		while (count != matrix.length * matrix[0].length - 1) {
			// print top
			if (direction == 1) {
				if (y + 1 <= right) {
					sb.append(matrix[x][y] + " ");
					count++;
					y++;
				}
				else {
					direction = 2;
					right--;
				}
			}
			else if (direction == 2) {
				if (x + 1 <= bottom) {
					sb.append(matrix[x][y] + " ");
					count++;
					x++;
				}
				else {
					direction = 3;
					bottom--;
				}
			}
			else if (direction == 3) {
				if (y - 1 >= left) {
					sb.append(matrix[x][y] + " ");
					count++;
					y--;
				}
				else {
					direction = 4;
					left++;
				}
			}
			else if (direction == 4) {
				if (x - 1 >= top) {
					sb.append(matrix[x][y] + " ");
					count++;
					x--;
				}
				else {
					direction = 1;
					top++;
				}
			}
		}
		
		// add the last one
		sb.append(matrix[x][y]);
		
		System.out.println(sb);
	}
	
	public static void main(String [] args) {
		/**
		 * 	1  2  3
		 *  4  5  6
		 *  7  8  9
		 * */
		int [][] matrix = new int[3][3];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = matrix[0].length*i + j + 1;
			}
		}
		
		print(matrix);
	}
}
