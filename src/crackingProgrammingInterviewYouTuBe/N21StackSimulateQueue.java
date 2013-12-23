package crackingProgrammingInterviewYouTuBe;

import java.util.Stack;

public class N21StackSimulateQueue {

	/**
	 * Use stack (LIFO) to simulate queue (FIFO)
	 * 
	 * */
	
	public static void main(String [] args) {
		MQueue mq = new MQueue();
		mq.push(2);
		mq.push(5);
		System.out.println(mq.pop());
		System.out.println(mq.pop());
		mq.push(9);
		System.out.println(mq.pop());
		System.out.println(mq.pop());
	}
}

class MQueue {
	
	private Stack<Integer> in, out;
	
	public MQueue() {
		in = new Stack<Integer>();
		out = new Stack<Integer>();
	}
	
	public void push(int v) {
		in.push(v);
	}
	
	public int pop() {
		shiftEle();
		return out.pop();
	}
	
	public int peek() {
		shiftEle();
		return out.peek();
	}
	
	private void shiftEle() {
		if (out.isEmpty()) {
			while (!in.isEmpty()) {
				out.push(in.pop());
			}
		}
	}
}
