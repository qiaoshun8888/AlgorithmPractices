package crackingTheCodingInterview.chapter9;

import java.util.HashSet;
import java.util.Set;

public class NCents {

	public static int getWays0(int cents) {
		if (cents < 0) return 0;
		if (cents == 0) return 1;
		return getWays0(cents - 25) + getWays0(cents - 10) + getWays0(cents - 5) + getWays0(cents - 1); 
	}
	
	public static int getWays(int cents, int denom) {
		// System.out.println(cents + "  " + denom);
		int next_denom = 0;
		switch(denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}
		
		int ways = 0;
		for (int i = 0; i * denom <= cents; i++) {
			ways += getWays(cents - i * denom, next_denom);
		}
		
		return ways;
	}
	
	public static void main(String[] args) {
		System.out.println("getWays0:\t" + getWays0(10)); // Consider the order (e.g {1 1 1 1 1 5} is different from {5 1 1 1 1 1} 
		System.out.println("getWays:\t" + getWays(10, 25)); // Ignore the oder (e.g {1 1 1 1 1 5} is the same as {5 1 1 1 1 1}
	}
}
