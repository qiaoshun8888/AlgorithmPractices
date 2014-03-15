package amazon.onlineTest;

import java.util.PriorityQueue;

/**
 * Question5.java
 * 
 * Description:
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Mar 14, 2014
 */

public class Question5 {

	public static class Point implements Comparable<Point> {
		public double x;
		public double y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public double distance(){
			return Math.pow(this.x, 2) + Math.pow(this.y, 2); 
		}

		@Override
		public int compareTo(Point p) {
			double dist1 = this.distance();
			double dist2 = p.distance();
			return dist1 < dist2 ? -1 : (dist1 > dist2) ? 1 : 0; 
		}
		
		@Override
		public String toString() {
			return "Point(" + x + ", " + y + ")";
		}
	}

	public static Point[] closestK(Point myList[], int k) {
		// if k is an invalid input
		if (k <= 0) return new Point[0];
		
		// calculate the distance from each point to the original
		PriorityQueue<Point> closestPoints = new PriorityQueue<Point>(k);
		
		for (int i = 0; i < myList.length; i++) {
			// if current point's distance less than minPoint's
			// or PriorityQueue is not full
			if (closestPoints.size() < k || myList[i].compareTo(closestPoints.peek()) < 0) {
				closestPoints.add(myList[i]);
			}
		}
		
		Point[] points = new Point[k];
		for (int i = 0; i < k; i++) {
			points[i] = closestPoints.remove();
		}
		return points;
	}
	
	public static void main(String[] args) {
		Point[] points = {new Point(1, -2), new Point(1, 2), new Point(2, 3), new Point(3, 5), new Point(5, 7), new Point(8, 9), new Point(0, 2), new Point(3, 5)};
		Point[] result = closestK(points, 3);
		
		for (Point p : result) {
			System.out.println(p);
		}
	}
}
