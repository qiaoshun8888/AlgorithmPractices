package chapter4;

public class PathOfSum extends BinaryTreeTraversal{

	public static void findSum(Node node, int sum, int [] path, int level) {
		if (node == null) return;
		
		// Insert current node into path
		path[level] = node.value;
		
		// Look for paths with a sum that ends at this node
		int t = 0;
		for (int i = level; i >= 0; i--) {
			t += path[i];
			if (t == sum) {
				print(path, i, level);
			}
		}
		
		// Search current node from path
		findSum(node.left, sum, path, level + 1);
		findSum(node.right, sum, path, level + 1);
		
		// Remove current node from path. Not strictly necessary, since we would ignore this value, but it's good practice.
		path[level] = Integer.MIN_VALUE;
	}
	
	public static void findSum(Node node, int sum) {
		int depth = depth(node);
		int [] path = new int[depth];
		findSum(node, sum, path, 0);
	}
	
	public static void print(int [] path, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}
	
	public static int depth(Node node) {
		if (node == null) return 0;
		return 1 + Math.max(depth(node.left), depth(node.right));
	}
	
	public static void main(String [] args) {
		int[] vs = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Node root = PathOfSum.generateMinHeightBST(vs, 0, vs.length - 1);
		PathOfSum.printBinaryTree(root, 0);
		System.out.println("\n");
		PathOfSum.findSum(root, 7);
		
		System.out.println(12>>2);
	}
}
