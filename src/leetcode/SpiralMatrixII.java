package leetcode;

public class SpiralMatrixII {

	/**
	 * Given an integer n, generate a square matrix filled with elements from 1
	 * to n2 in spiral order.
	 * 
	 * For example, Given n = 3,
	 * 
	 * You should return the following matrix:
	 * 
	 * 		[
			 [ 1, 2, 3 ],
			 [ 8, 9, 4 ],
			 [ 7, 6, 5 ]
			]
	 * 
	 * */
	
	public static int[][] generateMatrix(int n) {
        if (n == 0) return null;
        int [][] matrix = new int[n][n];
        if (n == 1) {
            matrix[0][0] = 1;
            return matrix;
        }
        
        int maxLayer = n / 2, v = 1;
        for (int layer = 0; layer <= maxLayer; layer++) {
            // top
            for (int i = layer; i < n - layer; i++) {
                matrix[layer][i] = v++;
            }
            
            // right
            for (int i = layer + 1; i < n - layer; i++) {
                matrix[i][n - 1 - layer] = v++;
            }
            
            // bottom
            for (int i = n - 1 - layer - 1; i >= layer; i--) {
                matrix[n - 1 - layer][i] = v++;
            }
            
            // left
            for (int i = n - 1 - layer - 1; i > layer; i--) {
                matrix[i][layer] = v++;
            }
        }
        
        return matrix;
    }
	
	public static void main(String [] args) {
		int n = 5;
		int [][] matrix = generateMatrix(n);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
		
	}
}
