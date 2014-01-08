package crackingTheCodingInterview2;

import java.util.*;

public class Ch1_BigNumber {

	/**
	 * You have two integer arrays. Treat these arrays as if they were big
	 * numbers, with one digit in each slot. Perform addition on these two
	 * arrays and store the results in a new array.
	 * 
	 * */
	
	/**
	 * a[]:   {1, 2, 3, 4, 5, 6, 7}
	 * b[]:	  {9, 8, 7, 6, 5, 4, 3};
	 * 
	 * */
	public static void add(int [] a, int [] b) {
		int [] c = null, bigger = null, smaller = null;
		if (a.length > b.length) {
			c = new int[a.length + 1];
			bigger = a;
			smaller = b;
		}
		else {
			c = new int[b.length + 1];
			bigger = b;
			smaller = a;
		}
		
		int preCarry = 0, curCarry = 0, biggerIndex = bigger.length - 1, smallerIndex = smaller.length - 1;
		
		while (smallerIndex >= 0) {
			int v = bigger[biggerIndex] + smaller[smallerIndex];
			if (v >= 10) curCarry = 1;
			c[biggerIndex + 1] = (curCarry == 1 ? (v - 10) : v) + preCarry;
			preCarry = curCarry;
			curCarry = 0;
			biggerIndex--;
			smallerIndex--;
		}
		
		while (biggerIndex >= 0) {
			int v = bigger[biggerIndex] + preCarry;
			if (v >= 10) {
				v -= 10;
				c[biggerIndex + 1] = v;
				preCarry = 1;
			}
			else {
				c[biggerIndex + 1] = v;
				preCarry = 0;
			}
			biggerIndex--;
		}
		
		if (biggerIndex < 0) {
			c[biggerIndex + 1] = preCarry;
		}
		
		for (int i = 0; i < c.length; i++) {
			if (i == 0 && c[0] == 0) continue;
			System.out.print(c[i]);
		}
		System.out.println();
	}
	
	/**
	 * Method - 2
	 * */
	public static void addStack(int [] a, int [] b) {
		Stack<Integer> stack = new Stack<Integer>();
		int [] bigger = null, smaller = null;
		if (a.length > b.length) {
			bigger = a;
			smaller = b;
		}
		else {
			bigger = b;
			smaller = a;
		}
		int biggerIndex = bigger.length - 1, smallerIndex = smaller.length - 1, carry = 0, v = 0;
		
		while (biggerIndex >= 0) {
			v = bigger[biggerIndex] + carry;
			if (smallerIndex >= 0) {
				v += smaller[smallerIndex];
				smallerIndex--;
			}
			if (v >= 10) {
				v -= 10;
				carry = 1;
			}
			else {
				carry = 0;
			}
			stack.push(v);
			
			biggerIndex--;
		}
		
		if (carry > 0) stack.push(carry);
		
		int [] result = new int[stack.size()];
		
		for (int i = 0; !stack.isEmpty(); i++) {
			result[i] = stack.pop();
		}
		
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
		System.out.println();
	}
	
	public static void main(String [] args) {
		int [] a = {7, 2, 2, 3, 4, 5, 6, 7};
		int [] b = {2, 9, 8, 7, 6, 9, 4, 3};
		add(a, b);
		addStack(a, b);
	}
}
