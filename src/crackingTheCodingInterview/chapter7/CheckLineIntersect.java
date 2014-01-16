package crackingTheCodingInterview.chapter7;

public class CheckLineIntersect {

}

class Line {
	static double epsilon = 0.000001;
	double slope;
	double y_intercept;
	
	public Line(double slope, double y_intercept) {
		this.slope = slope;
		this.y_intercept = y_intercept;
	}
	
	public boolean isIntersected(Line line) {
		return Math.abs(this.slope - line.slope) > epsilon || 
			   Math.abs(this.y_intercept - line.y_intercept) < epsilon; 
	}
}
