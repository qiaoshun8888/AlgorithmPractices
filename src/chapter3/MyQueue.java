package chapter3;

import java.util.Stack;
import java.util.Random;

public class MyQueue<E> {

	private Stack<E> stack_newest, stack_oldest;
	
	public MyQueue() {
		stack_newest = new Stack<E>();
		stack_oldest = new Stack<E>();
	}
	
	public void add(E e) {
		stack_newest.push(e);
	}
	
	public int size() {
		return stack_newest.size() + stack_oldest.size();
	}
	
	public E peek() {
		shiftStack();
		return stack_oldest.peek();
	}
	
	public E remove() {
		shiftStack();
		return stack_oldest.pop();
	}
	
	private void shiftStack() {
		if (stack_oldest.isEmpty()) {
			while (!stack_newest.isEmpty()) {
				stack_oldest.push(stack_newest.pop());
			}
		}
	}
	
	public static void main(String [] args) {
		MyQueue<Integer> mq = new MyQueue<Integer>();
		Random rand = new Random();
		for (int i = 0; i < 20; i++) {
			mq.add(rand.nextInt(i*10+10));
		}
		
		System.out.println(mq.peek());;
		System.out.println(mq.size());
		
		mq.remove();mq.remove();
		
		System.out.println(mq.peek());;
		System.out.println(mq.size());
	}
}
