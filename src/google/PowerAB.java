package google;

/**
 *	PowerAB.java
 *
 *	Description: Implements power a, b
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Feb 2, 2014
 */

public class PowerAB {

	/**
	 * a = 2.0   b = 5
	 * 
	 * a^2 * a^2 * a^(5%2)
	 * 
	 * */
	public static double pow(double a, int b) {
		if (b < 0) return 1 / powHelper(a, -b);
		else return powHelper(a, b);
	}
	private static double powHelper(double a, int b) {
		// base case
		if (b == 0) return 1.0;
		
		double v = powHelper(a, b / 2);
		
		if ((b & 1) > 0) 
			return v * v * a;
		else
			return v * v;
	}
	
	public static void main(String[] args) {
		System.out.println(pow(2, 4));
	}
}
