package amazon.onlineTest;

/**
 *	Question5.java
 *
 *	Description: 
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Mar 14, 2014
 */

public class Question5 {
	
	public static class Point {
		public double x;
		public double y;
	}
	
	public static class PointDistance {
		public Point point;
		public double distance;
		
		public PointDistance(Point p) {
			
		}
	}
	
	public static Point[] closestK(Point myList[], int k) {
		Point[] points = new Point[k];
		if (k <= 0) return points;
		
		// calculate the distance from each point to the original
		for (Point p : myList) {
			
		}
		
		return points;
	}
}
