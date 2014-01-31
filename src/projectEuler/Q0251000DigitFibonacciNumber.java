package projectEuler;

/**
 *	Q0251000DigitFibonacciNumber.java
 *
 *	Description: 
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Jan 30, 2014
 */

public class Q0251000DigitFibonacciNumber {

	
	public void findFib(int num) {
		double n1 = 1, n2 = 1, temp = 0;
		int count = 1, n = 2;
		
		while(true) {
			temp = n2;
			n2 = n1 + n2;
			n1 = temp;
			if (count == num) break;
			if (n2 >= 10) {
				count++;
				n2 /= 10;
				n1 /= 10;
			}
			n++;
		}
		
		System.out.println(n);
	}
	
	public static void main(String[] args) {
		Q0251000DigitFibonacciNumber o = new Q0251000DigitFibonacciNumber();
		o.findFib(1000);
	}
}
