package crackingTheCodingInterview.chapter9;

import java.util.ArrayList;

public class RobotMove {

	static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Point moveRight() {
			x++;
			return new Point(x, y);
		}
		
		public Point moveDown() {
			y++;
			return new Point(x, y);
		}
		
		public boolean isExit(int n) {
			return x == n - 1 && y == n - 1;
		}
	}
	
	private static int ways_called = 0;
	public static int ways(int x, int y, int n) {
		ways_called++;
		if (x == n - 1 && y == n - 1) return 1;
		if (x == n - 1) return ways(x, y + 1, n);
		if (y == n - 1) return ways(x + 1, y, n);
		return ways(x + 1, y, n) + ways(x, y + 1, n);
	}
	
	private static int waysImprove_called = 0;
	public static int waysImprove(int x, int y, int n, int [][] matrix) {
		waysImprove_called++;
		if (x == n - 1 && y == n - 1) return 1;
		if (matrix[x][y] != 0) return matrix[x][y];
		if (x == n - 1) return setMatrix(x, y + 1, matrix, waysImprove(x, y + 1, n, matrix));
		if (y == n - 1) return setMatrix(x + 1, y, matrix, waysImprove(x + 1, y, n, matrix));
		return setMatrix(x + 1, y, matrix, waysImprove(x + 1, y, n, matrix)) + setMatrix(x, y + 1, matrix, waysImprove(x, y + 1, n, matrix));
	}
	private static int setMatrix(int x, int y, int [][] matrix, int v) {
		matrix[x][y] = v;
		return v;
	}
	
	public static boolean waysImproveFindPath(int x, int y, int n, ArrayList<Point> path) {
		addPointToPath(x, y, path);
		if (x == n - 1 && y == n - 1) {
			addPointToPath(0, 0, path);
			return true;
		}
		
		boolean success = false;
		if (y < n - 1) {
			success = waysImproveFindPath(x, y + 1, n, path);
		}
		if (x < n - 1) {
			success = waysImproveFindPath(x + 1, y, n, path);
		}
		
		if (success) {
			addPointToPath(x, y, path);
		}
		
		return success;
	}
	public static void addPointToPath(int x, int y, ArrayList<Point> path) {
		path.add(new Point(x, y));
	}
	
	public static void main(String [] args) {
		ArrayList<Point> path = new ArrayList<Point>();
		int N = 3;
		System.out.println(RobotMove.ways(0, 0, N));
		System.out.println("ways called: " + ways_called);
		System.out.println(RobotMove.waysImprove(0, 0, N, new int[N][N]));
		System.out.println("waysImprove called: " + waysImprove_called);
		
		System.out.println();
		
		waysImproveFindPath(0, 0, N, path);
		int i = 0;
		for (Point p : path) {
			System.out.printf("(%d,%d) ", p.x, p.y);
			if (++i == (N-1)*2) {
				i = 0;
				System.out.println();
			}
		}
		System.out.println(path.size());
	}
}


class Point {
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}