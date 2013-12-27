package projectEuler;

public class Q001MultiplesOf3And5 {

	/**
	 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
	 * we get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of
	 * all the multiples of 3 or 5 below 1000.
	 * 
	 * */
	
	public static void main(String [] args) {
		int sum = 0, max = 1000;
		for (int i = 3; i < max; i += 3) {
			if (i % 3 == 0) sum += i;
		}
		for (int i = 5; i < max; i += 5) {
			if (i % 5 == 0 && i % 3 != 0) sum += i;
		}
		System.out.println(sum);
		
		sum = 0;
		for (int i = 3; i < max; i++) {
			if (i % 3 == 0 || i % 5 == 0) sum += i;
		}
		System.out.println(sum);
	}
}
