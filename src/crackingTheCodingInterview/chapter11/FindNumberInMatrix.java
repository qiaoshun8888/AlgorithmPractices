package crackingTheCodingInterview.chapter11;

public class FindNumberInMatrix {

	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public String toString() {
			return "Point (" + x + ", " + y + ")";
		}
	}
	
	private static int called_times = 0;
	
	public Point find(int [][] matrix, int [][] aux, int x) {
		if (x < matrix[0][0]) return null;
		return find(matrix, aux, new Point(0, 0), x);
	}
	
	private Point find(int [][] matrix, int [][] aux, Point p, int x) {
		called_times++;
		if (p.x < matrix.length && p.x >= 0 && p.y < matrix[0].length && p.y >= 0) {
			if (matrix[p.x][p.y] == x) return p;
			if (matrix[p.x][p.y] < x) {
				int xx = p.x + 1 < matrix.length ? p.x + 1 : p.x;
				int yy = p.y + 1 < matrix[0].length ? p.y + 1 : p.y;
				if (xx == p.x && yy == p.y) {  // reach the end of the matrix
					return null;
				}
				p = new Point(xx, yy);
				System.out.println("go next:  " + p.x + "  " + p.y);
				if (!isExplored(aux, p)) return find(matrix, aux, p, x);
			}
			else {
				Point p_temp = null;
				if (p.x - 1 >= 0) {
					p_temp = new Point(p.x - 1, p.y);
					System.out.println("go up:  " + p_temp.x + "  " + p_temp.y);
					if (!isExplored(aux, p_temp))  p_temp = find(matrix, aux, p_temp, x); // go up and search
					else p_temp = null; // if the point is already explored, we ignore it
					if (p_temp != null) return p_temp;
				}
				
				if (p.y - 1 >= 0) {
					p_temp = new Point(p.x, p.y - 1);
					System.out.println("go left:  " + p_temp.x + "  " + p_temp.y);
					if (!isExplored(aux, p_temp))  p_temp = find(matrix, aux, p_temp, x); // go left and search
					else return null;
					if (p_temp != null) return p_temp;
				}
			}
		}
		return null;
	}
	
	private boolean isExplored(int [][] aux, Point p) {
		if (aux[p.x][p.y] == 0) {
			aux[p.x][p.y] = 1;
			return false;
		}
		return true;
	}
	
	/* Best approach */
	// Time: O(M + N)
	public Point findBestApproach(int [][] matrix, int goal) {
		int x = 0, y = matrix[0].length - 1;
		while (x < matrix.length && y >= 0) {
			called_times++;
			if (matrix[x][y] == goal) return new Point(x, y);
			else if (matrix[x][y] > goal) y--;
			else x++;
		}
		return null;
	}
	
	public static void main(String [] args) {
		/*
		int [][] matrix = {
				{1,   2,   3,   4,   5},
				{6,   7,   8,   9,   10},
				{11,  12,  13,  14,  15}
		};
		*/
		int [][] matrix = {
				{15,   20,   40,   85},
				{20,   35,   80,   95},
				{30,   55,   95,   105},
				{40,   80,   100,  120},
				{56,   81,   101,  121}
		};
		int [][] aux = new int[matrix.length][matrix[0].length];
		int GOAL = 56;
		FindNumberInMatrix fnim = new FindNumberInMatrix();
		System.out.println("find: " + fnim.find(matrix, aux, GOAL) + "\t called_times: " + called_times);
		called_times = 0;
		System.out.println("findBestApproach: " + fnim.findBestApproach(matrix, GOAL) + "\t called_times: " + called_times);
	}
}
