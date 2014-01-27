package google.arrays;

/**
 * RepresentNCents.java
 * 
 * Description: Given an infinite number of quarters (25 cents), dimes (10
 * cents), nickels (5 cents) and pennies (1 cent), write code to calculate the
 * number of ways of representing n cents.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 27, 2014
 */

public class RepresentNCents {

	private static int calledTimes = 0;
	
	/**
	 * 25
	 * 10
	 * 5
	 * 1
	 * 
	 * e.g.  10
	 * 
	 * 10
	 * 5, 5
	 * 5, 1 x 5
	 * 1 x 10
	 * 
	 * */
	public static int count(int n) {
		if (n <= 0) return 0;
		return countHelper(n, 0);
	}
	private static int countHelper(int n, int d) {
		calledTimes++;
		
		n -= d;
		
		if (n < 0) return 0;
		if (n == 0) {
			return 1;
		}
		
		int sum = 0;
		
		if (n >= 25 && (d >= 25 || d == 0)) {
			sum += countHelper(n, 25);
		}
		if (n >= 10 && (d >= 10 || d == 0)) {
			sum += countHelper(n, 10);
		}
		if (n >= 5 && (d >= 5 || d == 0)) {
			sum += countHelper(n, 5);
		}
		if (n >= 1 && (d >= 1 || d == 0)) {
			sum += 1;
		}
		
		return sum;
	}
	
	
	public static int count2(int n) {
		if (n <= 0) return 0;
		return countHelper2(n, 25);
	}
	private static int countHelper2(int n, int d) {
		calledTimes++;
		int nextD = 0;
		switch(d) {
			case 25: 
				nextD = 10;
				break;
			case 10:
				nextD = 5;
				break;
			case 5:
				nextD = 1;
				break;
			case 1:
				return 1;
		}
		int ways = 0;
		for (int i = 0; i * d <= n; i++) {
			ways += countHelper2(n - i * d, nextD);
		}
		return ways;
	}
	
	public static void main(String[] args) {
		int cents = 1000;
		System.out.println(count(cents));
		System.out.println("CalledTimes: " + calledTimes);
		
		System.out.println();
		calledTimes = 0;
		System.out.println(count2(cents));
		System.out.println("CalledTimes: " + calledTimes);
	}
}
