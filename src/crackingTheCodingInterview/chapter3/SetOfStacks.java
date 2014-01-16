package crackingTheCodingInterview.chapter3;

import java.util.Random;
import java.util.Stack;

public class SetOfStacks {

	int capacity; // capacity of each stack
	int size; // size of current stack
	Stack<Integer> current_stack;
	Stack<Stack<Integer>> stacks;
	
	public SetOfStacks(int capacity) {
		this.capacity = capacity;
		stacks = new Stack<Stack<Integer>>();
	}
	
	public void push(int value) {
		if (++size > capacity || current_stack == null) {
			current_stack = new Stack<Integer>();
			stacks.push(current_stack);
			size = 0;
		}
		current_stack.push(value);
	}
	
	public int pop() throws Exception{
		size--;
		if (current_stack.isEmpty() || size < 0) {
			if (stacks.isEmpty()) {
				throw new Exception("SetOfStacks is Empty!");
			}
			current_stack = stacks.pop();
			size = capacity;
		}
		// System.out.println("isEmpty? " + current_stack.isEmpty() + " size: " + size);
		return current_stack.pop();
	}
	
	public boolean isEmpty() {
		return stacks.isEmpty() && current_stack.isEmpty();
	}
	
	public static void main(String [] args) {
		SetOfStacks sos = new SetOfStacks(10);
		Random rand = new Random();
		for (int i = 0;i < 10; i++) {
			int v = rand.nextInt(i*10+10);
			System.out.print(v + " ");
			sos.push(v);
		}
		
		System.out.println();
		
		while (!sos.isEmpty()) {
			try {
				System.out.print(sos.pop() + " ");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
