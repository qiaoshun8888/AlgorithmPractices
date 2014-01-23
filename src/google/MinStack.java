package google;

/**
 * MinStack.java
 * 
 * Description: How would you design a stack which, in addition to push and pop,
 * also has a function min which returns the minimum element? Push, pop and min
 * should all operate in 0(1) time.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 23, 2014
 */

public class MinStack {

	private int [] values;
	private int vIndex;
	
	private int [] mins;
	private int mIndex;
	
	private int capacity;
	
	public MinStack(int capacity) {
		this.capacity = capacity;
		values = new int[capacity];
		mins = new int[capacity];
		vIndex = -1;
		mIndex = -1;
	}
	
	public void push(int n) throws Exception {
		if (vIndex + 1 == capacity) {
			throw new Exception("Stack is full ( " + capacity + " )");
		}
		if (!isEmpty() && n < peek()) {
			mins[++mIndex] = n;
		}
		else if (isEmpty()) {
			mins[++mIndex] = n;
		}
		values[++vIndex] = n;
	}
	
	public int pop() throws Exception {
		if (isEmpty()) throw new Exception("Pop failed. Stack is Empty.");
		int v = values[vIndex--];
		if (v == mins[mIndex]) mIndex--;
		return v;
	}
	
	public int min() throws Exception {
		if (isEmpty()) throw new Exception("Peek failed. Stack is Empty.");
		return mins[mIndex];
	}
	
	public int peek() throws Exception {
		if (isEmpty()) throw new Exception("Peek failed. Stack is Empty.");
		return values[vIndex];
	}
	
	public int size() {
		return vIndex + 1;
	}
	
	public boolean isEmpty() {
		return vIndex == -1;
	}
	
	public static void main(String[] args) throws Exception {
		MinStack mStack = new MinStack(10);
		
		mStack.push(2);
		mStack.push(3);
		mStack.push(4);
		
		System.out.println(mStack.peek());
		
		System.out.println(mStack.pop());
		
		System.out.println("size: " + mStack.size());
		
		System.out.println("min: " + mStack.min());
		
		mStack.push(1);
		
		System.out.println("min: " + mStack.min());
		
		while (!mStack.isEmpty()) {
			System.out.println(mStack.pop());
		}
	}
}
