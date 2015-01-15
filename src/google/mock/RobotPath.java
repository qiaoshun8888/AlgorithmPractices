package google.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RobotPath {

	Point[][] matrix;
	int m, n;

	class Point {
		private int x;
		private int y;
		private boolean isBlocked;

		public Point(int x, int y, boolean isBlocked) {
			this.x = x;
			this.y = y;
			this.isBlocked = isBlocked;
		}

		/**
		 * Go to the next right point. If out of the boundary or the point is blocked, return null. 
		 **/
		public Point goNextRight() {
			if (this.x < matrix.length && this.y + 1 < matrix[0].length) {
				Point nextRight = matrix[x][y + 1];
				return nextRight.isBlocked ? null : nextRight;
			}
			return null;
		}

		/**
		 * Go to the next bottom point. If out of the boundary or the point is blocked, return null. 
		 **/
		public Point goNextBottom() {
			if (this.x + 1 < matrix.length && this.y < matrix[0].length) {
				Point nextBottom = matrix[x + 1][y];
				return nextBottom.isBlocked ? null : nextBottom;
			}
			return null;
		}

		/**
		 * If current point is the end point, return true; 
		 **/
		public boolean isEnd() {
			return this.x == m - 1 && this.y == n - 1; 
		}

		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}

	public List<List<Point>> getAllPaths() {
		List<List<Point>> paths = new ArrayList<List<Point>>();
		if (matrix == null || matrix.length == 0) return paths;
		Stack<Point> path = new Stack<Point>();
		Point startPoint = matrix[0][0];
		// Add the start point into the path.
		path.add(startPoint);
		getAllPathsHelper(startPoint, path, paths);
		return paths;
	}

	public void initMatrix(boolean[][] blockMatrix) {
		m = blockMatrix.length;
		n = blockMatrix[0].length;
		matrix = new Point[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = new RobotPath.Point(i, j, blockMatrix[i][j]);
			}
		}
	}

	private void getAllPathsHelper(Point p, Stack<Point> path, List<List<Point>> paths) {
		if (p.isEnd()) {
			paths.add(new ArrayList<Point>(path));
			return;
		}

		Point nextRight = p.goNextRight();
		if (nextRight != null) {
			path.push(nextRight);
			getAllPathsHelper(nextRight, path, paths);
			path.pop();
		}

		Point nextBottom = p.goNextBottom();
		if (nextBottom != null) {
			path.push(nextBottom);
			getAllPathsHelper(nextBottom, path, paths);
			path.pop();
		}
	}

	public static void main(String[] args) {
		boolean[][] blockMatrix = {
				{false, false, false, true, false},
				{false, true, false, false, false},
				{false, false, false, false, false},
				{true, false, false, false, false}
		};
		RobotPath o = new RobotPath();
		o.initMatrix(blockMatrix);
		List<List<Point>> paths = o.getAllPaths();
		System.out.println("Total number of the paths: " + paths.size() + "\n");
		for (List<Point> path : paths) {
			System.out.println(path);
		}
	}
}
