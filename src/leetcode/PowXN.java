package leetcode;

/**
 *	PowXN.java
 *
 *	Description: Implement pow(x, n).
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Jan 31, 2014
 */

public class PowXN {

	public double pow(double x, int n) {
		if (n < 0) return 1 / powHelper(x, -n);
		return powHelper(x, n);
	}
	private double powHelper(double x, int n) {
		if (n == 0) return 1;
		
		double v = powHelper(x, n / 2);
		
		if ((n & 1) > 0) {
			return v * v * x;
		}
		return v * v;
	}
	
	public static void main(String[] args) {
		PowXN o = new PowXN();
		System.out.println(o.pow(2, 10));
	}
}
