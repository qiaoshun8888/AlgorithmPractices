package google;

import java.util.Stack;

/**
 *	QueueWithTwoStacks.java
 *
 *	Description: Implement a MyQueue class which implements a queue using two stacks.
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Jan 23, 2014
 */

public class QueueWithTwoStacks<E> {

	Stack<E> head, tail;
	
	public QueueWithTwoStacks() {
		head = new Stack<E>();
		tail = new Stack<E>();
	}
	
	public void add(E e) { // offer
		tail.push(e);
	}
	
	public E remove() throws Exception{ // poll
		if (isEmpty()) {
			throw new Exception("Stack is empty!");
		}
		if (head.isEmpty()) {
			shift();
		}
		return head.pop();
	}
	
	private void shift() {
		while (!tail.isEmpty()) {
			head.push(tail.pop());
		}
	}
	
	public E element() throws Exception { // peek
		if (isEmpty()) {
			throw new Exception("Stack is empty!");
		}
		if (head.isEmpty()) {
			shift();
		}
		return head.peek();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		return head.size() + tail.size();
	}
	
	public static void main(String[] args) throws Exception {
		QueueWithTwoStacks<Integer> q = new QueueWithTwoStacks<Integer>();
		q.add(2);
		q.add(3);
		q.add(4);
		
		System.out.println(q.element());
		
		q.add(5);
		
		while (!q.isEmpty()) {
			System.out.println(q.remove());
		}
		
		q.add(10);
		q.add(9);
		q.add(8);
		
		while (!q.isEmpty()) {
			System.out.println(q.remove());
		}
	}
}
