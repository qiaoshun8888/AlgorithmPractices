package other_practices2.hard;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

	/**
	 * Given n points on a 2D plane, 
	 * find the maximum number of points that lie on the same straight line.
	 */

	static class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}

	private int duplicates = 0;
	private int max = 0;

	public int maxPoints(Point[] points) {
		if (points == null) return 0;
		if (points.length <= 2) return points.length;
		Map<Double, Integer> map = new HashMap<Double, Integer>();
		for (int i = 0; i < points.length; i++) {
			Point o = points[i];
			duplicates = 1; // O point self.
			map.clear();
			for (int j = 0; j < points.length; j++) {
				if (i == j) continue; // same node, ignore
				Point p = points[j];
				if (isSameNode(o, p)) duplicates++; // same position
				else if (o.x == p.x) putMap(map, Integer.MAX_VALUE); // y-axis
				else {
					double slope = (double)(p.y - o.y) / (p.x - o.x);
					putMap(map, slope);
				}
			}
			if (map.size() == 0) max = duplicates; // all in one point.
			else addDuplicats(map);
		}
		return max;
	}

	private void putMap(Map<Double, Integer> map, double key) {
		int count = 1;
		if (map.containsKey(key))
			count += map.get(key);
		map.put(key, count);
	}

	private void addDuplicats(Map<Double, Integer> map) {
		for (int v : map.values()) {
			max = Math.max(max, duplicates + v);
		}
	}

	private boolean isSameNode(Point a, Point b) {
		return a.x == b.x && a.y == b.y;
	}
}
