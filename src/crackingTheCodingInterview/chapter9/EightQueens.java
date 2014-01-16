package crackingTheCodingInterview.chapter9;

import java.util.ArrayList;

public class EightQueens {
	
	private static final int GRID_SIZE = 8;
	
	public static void placeQueens(int row, Integer [] columns, ArrayList<Integer[]> results) {
		if (row == GRID_SIZE) {
			results.add(columns.clone());
		}
		else {
			for (int col = 0; col < GRID_SIZE; col++) {
				if (checkValid(columns, row, col)) {
					columns[row] = col; // place queen
					placeQueens(row + 1, columns, results);
				}
			}
		}
	}
	
	private static boolean checkValid(Integer [] columns, int row1, int column1) {
		for (int row2 = 0; row2 < row1; row2++) {
			int column2 = columns[row2];
			if (column1 == column2) return false;
			int column_distance = Math.abs(column2 - column1);
			int row_distance = row1 - row2;
			if (column_distance == row_distance) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Integer[] columns = new Integer[GRID_SIZE];
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		placeQueens(0, columns, results);
		
		System.out.println(results.size());
		System.out.println(columns[7]);
	}
}
