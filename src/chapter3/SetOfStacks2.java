package chapter3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class SetOfStacks2 {
	
	int capacity;
	int size; // size of current stack
	Stack<Integer> current_stack;
	ArrayList<Stack<Integer>> stacks;
	
	public SetOfStacks2(int capacity) {
		this.capacity = capacity;
		stacks = new ArrayList<Stack<Integer>>();
	}
	
	public void push(int value) {
		if (++size > capacity || current_stack == null) {
			current_stack = new Stack<Integer>(); 
			stacks.add(current_stack);
			size = 0;
		}
		current_stack.push(value);
	}
	
	public boolean isEmpty() {
		// System.out.printf("isEmpty: %s %d %d\n", (current_stack.isEmpty() ? "YES" : "NO"), stacks.size(), size);
		return current_stack.isEmpty() && stacks.size() == 0;
	}
	
	public int pop() throws Exception{
		size--;
		if (current_stack.isEmpty() || size < 0) {
			if (stacks.size() == 0) {
				throw new Exception("SetOfStacks2 is Empty!");
			}
			current_stack = stacks.get(stacks.size()-1);
			stacks.remove(stacks.size()-1);
			size = capacity;
		}
		return current_stack.pop();
	}

	public static void main(String [] args) {
		SetOfStacks2 sos = new SetOfStacks2(3);
		Random rand = new Random();
		for (int i = 0;i < 10; i++) {
			int v = rand.nextInt(i*10+10);
			System.out.print(v + " ");
			sos.push(v);
		}
		
		System.out.println();
		
		try {
			while (!sos.isEmpty()) {
				System.out.print(sos.pop() + " ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
