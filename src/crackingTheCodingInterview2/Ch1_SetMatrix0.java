package crackingTheCodingInterview2;

public class Ch1_SetMatrix0 {

	/**
	 * Write an algorithm such that if an element in an MxN matrix is 0, its
	 * entire row and column are set to 0.
	 * 
	 * */
	
	/**
	 * Input:
	 * 
	 *   1 2 1 0
	 *   0 2 3 2
	 *   1 2 3 2
	 * 
	 * Output:
	 * 
	 *   0 0 0 0
	 *   0 0 0 0
	 *   0 2 3 0
	 *   
	 * */
	public static void setMatrix0(int [][] matrix) {
		boolean [] rows = new boolean[matrix.length];
		boolean [] column = new boolean[matrix[0].length];
		
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < column.length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = true;
					column[j] = true;
				}
			}
		}
		
		for (int i = 0; i < rows.length; i++) {
			if (rows[i]) {
				for (int j = 0; j < column.length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < column.length; i++) {
			if (column[i]) {
				for (int j = 0; j < rows.length; j++) {
					matrix[j][i] = 0;
				}
			}
		}
	}
	
	public static void main(String [] args) {
		int [][] matrix = {
			{1, 2, 1, 0},
			{0, 2, 3, 2},
			{1, 2, 3 ,2}
		};
		
		setMatrix0(matrix);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.printf("%d\t", matrix[i][j]);
			}
			System.out.println();
		}
	}
}
