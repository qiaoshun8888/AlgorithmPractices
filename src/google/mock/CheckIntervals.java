package google.mock;

import java.util.ArrayList;
import java.util.List;

public class CheckIntervals {

	static class Interval {
		int x;
		int y;
		public Interval(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static boolean checkInterval(Interval i1, Interval i2) {
		if (i1 == null || i2 == null) return false;
		return i1.x > i2.x ? checkInterval(i2, i1) : i1.y >= i2.x; 
	}

	public static void main(String[] args) {
		List<Interval[]> testCases = new ArrayList<Interval[]>();
		testCases.add(new Interval[]{new Interval(1, 5), new Interval(2, 6)});
		testCases.add(new Interval[]{new Interval(0, 2), new Interval(2, 6)});
		testCases.add(new Interval[]{new Interval(0, 1), new Interval(2, 6)});
		testCases.add(new Interval[]{new Interval(7, 9), new Interval(2, 6)});
		testCases.add(new Interval[]{new Interval(4, 9), new Interval(2, 6)});
		testCases.add(new Interval[]{new Interval(4, 9), null});

		boolean[] expectedResults = {true, true, false, false, true, false};
		for (int i = 0; i < testCases.size(); i++) {
			if (checkInterval(testCases.get(i)[0], testCases.get(i)[1]) == expectedResults[i]) {
				System.out.println("True");
			} else {
				System.out.println("False");
			}
		}
	}
}
