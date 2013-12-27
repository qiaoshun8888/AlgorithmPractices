package projectEuler;

public class Q004LargestPalindromeProduct {

	/**
	 * A palindromic number reads the same both ways. The largest palindrome
	 * made from the product of two 2-digit numbers is 9009 = 91 x 99.
	 * 
	 * Find the largest palindrome made from the product of two 3-digit numbers.
	 * 
	 * */
	
	
	public static boolean isPalindromeNumber (int i) {
		char [] cc = Integer.toString(i).toCharArray();
		int left = 0, right = cc.length - 1;
		while (left < right) {
			if (cc[left++] != cc[right--]) return false; 
		}
		return true;
	}
	
	/**
	 *  21  22  23  24  25 ...
	 *  20  13  12  11  10
	 *  19  14  7   8   9
	 *  18  15  6   3   2
	 *  17  16  5   4   1
	 *  
	 *  Incorrect = =
	 * */
	/*
	public static void main(String [] args) {
		int x = 99, y = 99, step = 1, totalStep = 1, cubeWidth = 2;
		final byte UP = 1, DOWN = 2, LEFT = 3, RIGHT = 4;
		byte DIRECTION = UP, UP_NEXT = LEFT, LEFT_NEXT = DOWN;
		
		while (x > 0 && y > 0) {
			System.out.println(x + "  " + y);
			if (isPalindromeNumber(x * y)) {
				System.out.printf("%d x %d = %d", x, y, x * y); 
				return;
				// System.out.println(x * y);
			}
			step++;
			totalStep++;
			
			switch(DIRECTION) {
				case UP:
					x--;
					if (step == cubeWidth) {
						step = 1;
						DIRECTION = UP_NEXT;
						UP_NEXT = UP_NEXT == LEFT ? RIGHT : LEFT;
					}
					break;
				case DOWN:
					x++;
					if (step == cubeWidth) {
						step = 1;
						DIRECTION = LEFT;
					}
					break;
				case LEFT:
					y--;
					if (step == cubeWidth) {
						step = 1;
						DIRECTION = LEFT_NEXT;
						LEFT_NEXT = LEFT_NEXT == DOWN ? UP : DOWN;
					}
					break;
				case RIGHT:
					y++;
					if (step == cubeWidth) {
						step = 1;
						DIRECTION = UP;
					}
					break;
			}
			
			if (totalStep == cubeWidth * cubeWidth) cubeWidth++;
		}
	}
	*/
	
	/**
	 *  15                 | 95
	 *  14  10             | 96
	 *  13   9  6          | 97
	 *  12   8  5   3      | 98
	 *  11   7  4   2   1  | 99
	 *  -------------------
	 *  95  96  97  98  99
	 * */
	public static void main(String [] args) {
		int max = 0, ma = 0, mb = 0, calledTimes = 0;
		// Naive method
		for (int a = 999; a > 99; a--) {
			for (int b = 999; b > 99; b--) {
				calledTimes++;
				if (isPalindromeNumber(a * b)) {
					if (a * b > max) {
						max = a * b;
						ma = a;
						mb = b;
					}
				}
			}
		}
		System.out.printf("%d x %d = %d\n", ma, mb, max);
		System.out.println("calledTimes: " + calledTimes);
		System.out.println(" =================== ");
		
		// Improved method
		calledTimes = 0;
		int x = 999, i = x;
		max = 0;
		while (x > 99) {
			for (int j = 0; i - j >= x; j++) {
				calledTimes++;
				// System.out.println(x + " * " + (i - j));
				if (isPalindromeNumber(x * (i - j))) {
					if (x * (i - j) > max) max = x * (i - j);
					else  break;
					System.out.printf("%d x %d = %d\n", x, i - j, x * (i - j)); 
				}
			}
			x--;
		}
		System.out.println("calledTimes: " + calledTimes);
		System.out.println(" =================== ");
		
		// Perfect Method
		calledTimes = 0;
		int largestPalindrome = 0, a = 999, b = 0, db = 0;
		while (a >= 100) {
			if (a % 11 == 0) {
				b = 999;
				db = 1;
			}
			else {
				b = 990;
				db = 11;
			}
			
			while (b >= a) {
				calledTimes++;
				if (a * b <= largestPalindrome) break;
				if (isPalindromeNumber(a * b)) {
					largestPalindrome = a * b;
					ma = a;
					mb = b;
				}
				b -= db;
			}
			a--;
		}
		System.out.printf("%d x %d = %d\n", ma, mb, largestPalindrome);
		System.out.println("calledTimes: " + calledTimes);
		System.out.println(" =================== ");
	}
}
