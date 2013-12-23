package crackingProgrammingInterviewYouTuBe;

import java.util.Stack;

public class N22ComputeArithmeticTree {

	/**
	 * Computer arithmetic tree (non-leaves being operators and leaves are numbers)
	 * 
	 *     +
	 *    / \     =   1 + 2 = 3
	 *   1   2 
	 *   
	 *     +
	 *   /   \
	 *  1     *   =   1 + 2 * 3 = 7
	 *       / \
	 *      2   3
	 * */
	
	static class Node {
		Node left, right;
		char op;
		double value;
		public Node(char op) {
			this.op = op;
		}
		public Node(double value) {
			this.op = '0';
			this.value = value;
		}
		public boolean isOperator() {
			return op != '0';
		}
	}
	
	private static Stack<Double> stack = new Stack<Double>();
	public static void calculate (Node root) {
		if (root == null) return;
		
		calculate(root.left);
		calculate(root.right);
		
		if (root.isOperator()) {
			double a = stack.pop();
			double b = stack.pop();
			stack.push(cal(a, b, root.op));
		}
		else {
			stack.push(root.value);
		}
	}
	private static double cal(double a, double b, char op) {
		if (op == '+') {
			return a + b;
		}
		else if (op == '-') {
			return a - b;
		}
		else if (op == '*') {
			return a * b;
		}
		else {
			return a / b;
		}
	}
	
	public static void main(String [] args) {
	/**
	 *     +
	 *   /   \
	 *  1     *   =   1 + 2 * 3 = 7
	 *       / \
	 *      2   3
	 */
		Node root = new Node('+');
		root.left = new Node(1);
		root.right = new Node('*');
		root.right.left = new Node(2);
		root.right.right = new Node(3);
		calculate(root);
		System.out.println(stack.pop());
	}
}
