package crackingTheCodingInterview.chapter3;

import java.util.Random;
import java.util.Stack;

public class AscendingOrderStack {

	/* Biggest on the top */
	
	Stack<Integer> stack1, stack2;
	
	public AscendingOrderStack() {
		stack1 = new Stack<Integer>(); // data
		stack2 = new Stack<Integer>(); // buffer
	}
	
	public void push(int value) {
		if (stack1.isEmpty()) {
			stack1.push(value);
		}
		else {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			boolean added = false;
			while (!stack2.isEmpty()) {
				int v = stack2.pop();
				if (value <= v && !added) {
					stack1.push(value);
					added = true;
				}
				stack1.push(v);
			}
			if (!added) {
				stack1.push(value);
			}
		}
	}
	
	public int pop() {
		return stack1.pop();
	}
	
	public boolean isEmpty() {
		return stack1.isEmpty();
	}
	
	public static void main(String [] args) {
		AscendingOrderStack aos = new AscendingOrderStack();
		Random rand = new Random();
		
		for (int i = 0; i < 10; i++) {
			int v = rand.nextInt(i*100+10);
			aos.push(v);
			System.out.printf("%4d ", v);
		}
		System.out.println();
		
		while (!aos.isEmpty()) {
			System.out.printf("%5d", aos.pop());
		}
		System.out.println();
	}
}
