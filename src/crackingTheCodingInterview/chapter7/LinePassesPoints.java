package crackingTheCodingInterview.chapter7;

import java.util.ArrayList;
import java.util.HashMap;
import java.text.DecimalFormat;

public class LinePassesPoints {

	ArrayList<Point> points;
	
	static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Line {
		
		int count;
		
		double slope;
		double y_intercept;
		
		boolean infinite_slope;
		double line_x; // indicate a line when slope == +/-oo
		
		public Line(Point x, Point y) {
			// calculate slope and y_intercept
			// if slope == +/-oo, throw an exception 
		}
		
		public String getLineKey() {
			StringBuilder key = new StringBuilder();
			key.append(infinite_slope ? "1," : "0,");
			if (infinite_slope) key.append(getDouble(line_x));
			else key.append(getDouble(slope)+"-"+getDouble(y_intercept));
			return key.toString(); 
		}
		
		public boolean isEqualToLine(Line line) {
			if (infinite_slope) {
				return getDouble(this.line_x) == getDouble(line.line_x);
			}
			else {
				return getDouble(this.slope) == getDouble(line.slope) && 
					   getDouble(this.y_intercept) == getDouble(line.y_intercept); 
			}
		}
	}
	
	public LinePassesPoints() {
		// generate the points
	}
	
	// convert #.###### -> #.##
	public static double getDouble(double n) {
		DecimalFormat df = new DecimalFormat("#.##");
		return Double.valueOf(df.format(n));
	}
	
	public static void main(String [] args) {
		LinePassesPoints lpp = new LinePassesPoints();
		HashMap<String, Line> map = new HashMap<String, Line>();
		for (int i = 0; i < lpp.points.size(); i++) {
			Point x = lpp.points.get(i);
			for (int j = i + 1; j < lpp.points.size(); j++) {
				Point y = lpp.points.get(j);
				Line line = new Line(x, y);
				if (map.containsKey(line.getLineKey())) {
					line = map.get(line.getLineKey());
					line.count++;
				}
				else {
					map.put(line.getLineKey(), line);
				}
			}
		}
		
		Line result_line = null;
		int result_count = 0;
		for (String key : map.keySet()) {
			Line line = map.get(key);
			if (line.count > result_count) {
				result_line = line;
				result_count = line.count;
			}
		}
		
		System.out.println();
	}
}
