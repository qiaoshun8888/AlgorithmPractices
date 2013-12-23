package chapter7;

public class Operations {

	public static int multiply(int a, int b) {
		boolean is_neg = (a < 0 && b > 0) || (a > 0 && b < 0);
		a = abs(a);
		b = abs(b);
		int r = 0;
		while (b > 0) {
			r += a;
			b += -1;
		}
		return is_neg ? neg(r) : r;
	}
	
	public static int subtract(int a, int b) {
		return a + neg(b);
	}
	
	public static int divide(int a, int b) {
		if (b == 0) return Integer.MAX_VALUE;
		boolean is_neg = (a < 0 && b > 0) || (a > 0 && b < 0);
		a = abs(a);
		b = abs(b);
		
		int r = 0;
		while (a > 0) {
			a += neg(b);
			if (a >= 0) r++;
		}
		return is_neg ? neg(r) : r;
	}
	
	private static int abs(int n) {
		return n < 0 ? neg(n) : n;
	}
	
	private static int neg(int n) {
		int r = 0;
		int temp = n < 0 ? 1 : -1;
		while (n != 0) {
			n += temp;
			r += temp;
		}
		return r;
	}
	
	public static void main(String [] args) {
		System.out.println(Operations.multiply(99, 9));
		System.out.println(Operations.subtract(9, 8));
		System.out.println(Operations.divide(-86, 20));
	}
	
}
