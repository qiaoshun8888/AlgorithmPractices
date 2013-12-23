package chapter1;

public class RotateImagePixels {

	public static int [][] rotate90(int [][] matrix, int n) {
		for (int i = 0; i < n / 2; i++) {
			int first = i;
			int last = n - 1 - i;
			for (int j = first; j < last; j++) {
				// System.out.println(i + " " + j);
				
				int offset = j - first;
				int top = matrix[first][j];
				
				// left -> top
				matrix[first][j] = matrix[last - offset][first];
				
				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];
				
				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				
				// top -> right
				matrix[j][last] = top;
			}
		}
		return matrix;
	}
	
	public static void main(String args []) {
		int N = 5;
		
		int [][] matrix = {
			{1,  2,  3,  4,  5},
			{6,  7,  8,  9,  10},
			{11, 12, 13, 14, 15},
			{16, 17, 18, 19, 20},
			{21, 22, 23, 24, 25}
		};
		
		matrix = RotateImagePixels.rotate90(matrix, N);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
