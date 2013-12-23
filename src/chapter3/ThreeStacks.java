package chapter3;

import java.util.Random;

public class ThreeStacks {

	int [] data;
	
	private int stack_size;
	private int [] top_index;
	
	public ThreeStacks(int stack_size) {
		data = new int[stack_size * 3];
		this.stack_size = stack_size;
		top_index = new int[3];
		for (int i=0; i<3; i++) {
			this.top_index[i] = -1;
		}
	}
	
	public void push(int stack_num, int value) throws Exception {
		if (top_index[stack_num] + 1 >= stack_size) {
			throw new Exception("Stack " + stack_num + " is full!");
		}
		top_index[stack_num]++;
		data[topIndexOfStack(stack_num)] = value;
	}
	
	public int pop(int stack_num) throws Exception{
		if (top_index[stack_num] == -1) {
			throw new Exception("Stack " + stack_num + " is empty!");
		}
		int v = data[topIndexOfStack(stack_num)];
		data[topIndexOfStack(stack_num)] = 0;
		top_index[stack_num]--;
		
		return v;
	}
	
	public int peek(int stack_num) {
		return data[topIndexOfStack(stack_num)];
	}
	
	public boolean isEmpty(int stack_num) {
		return top_index[stack_num] == -1;
	}
	
	public void printStackInfo() {
		System.out.println("===== Stack Info =====");
		System.out.printf("top_index {%d, %d, %d]\n", top_index[0], top_index[1], top_index[2]);
		for (int i = 0; i < 3; i++) {
			System.out.printf("Stack[%d]: ", i);
			for (int j = 0; j < stack_size; j++) {
				System.out.printf("%4d", data[i*stack_size+j]);
			}
			System.out.println();
		}
		System.out.println("===== ========== =====");
	}
	
	// stack_num 0, 1, 2
	private int topIndexOfStack(int stack_num) {
		return stack_size * stack_num + top_index[stack_num]; 
	}
	
	public static void main(String args []) {
		ThreeStacks ts = new ThreeStacks(100);
		
		System.out.println("Is stack 0 empty? " + (ts.isEmpty(0) ? "YES" : "NO"));
		System.out.println();
		
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			try {
				ts.push(rand.nextInt(3), rand.nextInt(i*10 + 100));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		ts.printStackInfo();
		System.out.println();
		
		System.out.println("Is stack 0 empty? " + (ts.isEmpty(0) ? "YES" : "NO"));
		
		for (int i = 0; i < 3; i++) {
			System.out.printf("Peek Stack[%d]: %d\n", i, ts.peek(i));
		}
		System.out.println();
		
		System.out.print("Pop value: ");
		for (int i = 0; i < 50; i++) {
			try {
				System.out.printf("%4d", ts.pop(rand.nextInt(3)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		
		ts.printStackInfo();
		System.out.println();
	}
}
