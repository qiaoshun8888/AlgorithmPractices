package crackingProgrammingInterviewYouTuBe;

public class N20SearchIn2DSortedArray {
	
	private static int called_times = 0;

	/**
	 * Search value in a 2-D sorted array
	 * 
	 * */
	
	/**
	 * 1  2  3  4  5
	 * 6  7  8  9  10
	 * 11 12 13 14 15
	 * 16 17 18 19 20
	 * 21 22 23 24 25
	 * 
	 * search 15
	 * 
	 * */
	public static void search(int[][] matrix, int x) {
		int a = binarySearchRow(matrix, x, 0, matrix.length - 1);
		if (found) System.out.println("Found point (" + a + ", 0)");
		else {
			int b = binarySearchColumn(matrix, x, 0, matrix[0].length - 1, a);
			System.out.println("Found point (" + a + ", " + b + ")");
		}
	}

	private static boolean found = false;
	private static int binarySearchRow(int[][] matrix, int x, int low, int high) {
		called_times++;
		if (low > high) return -1;
		int mid = (low + high) / 2;
		if (x == matrix[mid][0]) {
			found = true;
			return mid;
		}

		if (mid - 1 >= 0 && x > matrix[mid - 1][0] && x < matrix[mid][0]) return mid - 1;
		else if (mid == matrix.length - 1 && x > matrix[mid][0]) return mid;

		if (x > matrix[mid][0]) return binarySearchRow(matrix, x, mid + 1, high);
		else return binarySearchRow(matrix, x, low, mid - 1);
	}
	private static int binarySearchColumn(int[][] matrix, int x, int low, int high, int row) {
		called_times++;
		if (low > high) return -1;
		int mid = (low + high) / 2;
		if (x == matrix[row][mid]) return mid;
		
		if (x > matrix[row][mid]) return binarySearchColumn(matrix, x, mid + 1, high, row);
		else return binarySearchColumn(matrix, x, low, mid - 1, row);
	}
	
	public static void main(String [] args) {
		int [][] matrix = new int[100][100];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = matrix[0].length*i + j + 1;
			}
		}
		
		search(matrix, 9421);
		System.out.println("called_times: " + called_times);
	}
}
