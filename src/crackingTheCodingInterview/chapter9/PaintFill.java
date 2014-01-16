package crackingTheCodingInterview.chapter9;

import java.util.LinkedList;

public class PaintFill {

	static class CPoint {
		int x, y, color;
		public CPoint(int x, int y, int color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}
		
		public String toString() {
			return "(" + x + "," + y +  ")";
		}
	}
	
	// Given a new Point p with the new color
	public static void paintFill(CPoint [][] matrix, int row, int column, int x, int y, int color) {
		LinkedList<CPoint> queue = new LinkedList<CPoint>();
		CPoint point = matrix[x][y];
		if (point.color == color) return;
		int area_color = point.color;
		queue.add(point);
		while (!queue.isEmpty()) {
			CPoint pp = queue.pop();
			pp.color = color; // fill the new color
			x = pp.x; y = pp.y;
			// check top
			if (x - 1 >= 0) {
				pp = matrix[x - 1][y];
				if (pp.color == area_color) {
					// System.out.println("== top: " + pp);
					queue.add(pp);
				}
			}
			
			// check right
			if (y + 1 < column) {
				pp = matrix[x][y + 1];
				if (pp.color == area_color) {
					// System.out.println("== right: " + pp);
					queue.add(pp);
				}
			}
			
			// check bottom
			if (x + 1 < row) {
				pp = matrix[x + 1][y];
				if (pp.color == area_color) {
					// System.out.println("== bottom: " + pp);
					queue.add(pp);
				}
			}
			
			// check left
			if (y - 1 >= 0) {
				pp = matrix[x][y - 1];
				if (pp.color == area_color) {
					// System.out.println("== left: " + pp);
					queue.add(pp);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int row = 5, column = 5, color = 1;
		CPoint[][] matrix = new CPoint[row][column];
		for (int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				// Fill default color
				if (i == 0 && j < column - 1) color = 1;
				else if (i == 1 && j < column - 1) color = 0;
				else if (i == 2 && j == 0) color = 1;
				else if (i == 2 && j < column - 1) color = 0;
				else if (i == 2 && j == column - 1) color = 1;
				else if (i == 3 && j == 0) color = 1;
				else if (i == 3 && j < column) color = 0;
				else if (i == 4 && j < column - 1) color = 1;
				else if (i == 4 && j == column - 1) color = 0;
				matrix[i][j] = new CPoint(i, j, color);
				System.out.printf("%3d", color);
			}
			System.out.println();
		}
		
		System.out.println();
		paintFill(matrix, row, column, 2, 0, 0);

		for (int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				System.out.printf("%3d", matrix[i][j].color);
			}
			System.out.println();
		}
	}
}
