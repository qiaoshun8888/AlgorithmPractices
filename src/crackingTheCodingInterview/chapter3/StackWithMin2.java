package crackingTheCodingInterview.chapter3;

import java.util.Random;
import java.util.Stack;

public class StackWithMin2 extends Stack<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9186798631271152489L;
	
	Stack<Integer> min_stack;
	
	public StackWithMin2() {
		min_stack = new Stack<Integer>();
	}
	
	public void push(int value) {
		try {
			if (value <= min()) min_stack.push(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.push(value);
	}
	
	public Integer pop() {
		int v = super.pop();
		try {
			if (v == min()) min_stack.pop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public int min() throws Exception{
		return this.isEmpty() ? Integer.MAX_VALUE : min_stack.peek();
	}
	
	public static void main(String [] args) {
		StackWithMin2 swm = new StackWithMin2();
		Random rand = new Random();
		for (int i = 0;i < 10; i++) {
			swm.push(rand.nextInt(i*10+10));
		}
		
		while (!swm.isEmpty()) {
			swm.pop();
			try {
				System.out.println(swm.min());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
