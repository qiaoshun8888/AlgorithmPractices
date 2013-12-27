package projectEuler;

public class Q005SmallestMultiple {

	/**
	 * 2520 is the smallest number that can be divided by each of the numbers
	 * from 1 to 10 without any remainder.
	 * 
	 * What is the smallest positive number that is evenly divisible by all of
	 * the numbers from 1 to 20?
	 * 
	 * */
	
	public static int LCM(int x, int y) {
		return x * y / GCD(x, y);
	}
	private static int GCD(int x, int y) {
		if (x % y == 0) return y;
		return GCD(y, x % y);
	}
	
	public static void main(String [] args) {
		int n = 20;
		int [] vs = new int[n];
		for (int i = 0; i < n; i++) {
			vs[i] = i + 1;
		}
		
		int number = vs[0] * vs[1];
		for (int i = 2; i < n; i++) {
			if (number % vs[i] == 0) continue;
			number = LCM(number, vs[i]);
		}
		System.out.println(number);
	}
}
