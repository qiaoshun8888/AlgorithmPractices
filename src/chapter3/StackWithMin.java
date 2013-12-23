package chapter3;

import java.util.Stack;
import java.util.Random;

public class StackWithMin extends Stack<NodeWithMin> {
	
	public void push(int value) {
		super.push(new NodeWithMin(value, Math.min(value, min())));
	}
	
	public int min() {
		return this.isEmpty() ? Integer.MAX_VALUE : peek().min;
	}
	
	public static void main(String [] args) {
		
		StackWithMin swm = new StackWithMin();
		Random rand = new Random();
		for (int i = 0;i < 10; i++) {
			swm.push(rand.nextInt(i*10+10));
		}
		
		while (!swm.isEmpty()) {
			swm.pop();
			System.out.println(swm.min());
		}
	}
}

class NodeWithMin {
	int value;
	int min;
	
	public NodeWithMin(int value, int min) {
		this.value = value;
		this.min = min;
	}
}