package google.bits;

/**
 *	BitManipulation.java
 *
 *	Description: Bits manipulation
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Jan 26, 2014
 */

public class BitManipulation {

	public static int getKthDigit(int x, int k) {
		return (x >> (k - 1)) & 1;
	}
	
	public static boolean isOdd(int x) {
		return (x & 1) == 1;
	}
	
	public static void lastKDigits(int x, int k) {
		System.out.println(Integer.toBinaryString(x));
		x &= ((1 << k) - 1);
		System.out.println(Integer.toBinaryString(x));
	}
	
	public static void setKthDigitZero(int x, int k) {
		System.out.println(Integer.toBinaryString(x));
		x &= ~(1 << k - 1);
		System.out.println(Integer.toBinaryString(x));
	}
	
	public static boolean isPowerOfTwo(int x) {
		System.out.println(Integer.toBinaryString(x));
		return x != 0 && (x & (x - 1)) == 0;
	}
	
	public static void flipLastContinuous1s(int x) {
		System.out.println(Integer.toBinaryString(x));
		x &= x + 1;
		System.out.println(Integer.toBinaryString(x));
	}
	
	public static void flipKthDigit(int x, int k) {
		System.out.println(Integer.toBinaryString(x));
		x ^= 1 << (k - 1);
		System.out.println(Integer.toBinaryString(x));
	}
	
	public static void main(String[] args) {
//		System.out.println(getKthDigit(9, 4));
//		System.out.println("isOdd: " + isOdd(4));
//		lastKDigits(76, 3);
//		setKthDigitZero(17, 5);
//		System.out.println(isPowerOfTwo(1));
//		flipLastContinuous1s(2231);
		flipKthDigit(12321, 2);
	}
}
