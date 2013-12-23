package crackingProgrammingInterviewYouTuBe;

public class N35ReconstructBinaryTree {

	/**
	 * Reconstruct a binary tree given its pre-order and in-order traversal.
	 * 
	 * 			1
	 *        /   \
	 *       2     3
	 *           /   \
	 *          4     5
	 *    
	 *    pre-order: 	1 2 3 4 5
	 *    in-order:		2 1 4 3 5
	 * 
	 * */
	
	static class Node {
		Node left, right;
		int v;
		public Node(int v) {
			this.v = v;
		}
		
		public void traverse_inorder() {
			if (this != null) {
				if (left != null) {
					left.traverse_inorder();					
				}
				System.out.print(v + " ");
				if (right != null) {
					right.traverse_inorder();
				}
			}
		}
		
		public void traverse_preorder() {
			if (this != null) {
				System.out.print(v + " ");
				if (left != null) {
					left.traverse_preorder();
				}
				if (right != null) {
					right.traverse_preorder();
				}
			}
		}
	}
	
	public static Node constructBinaryTree(int [] pre, int pre_start, int pre_end, int [] in, int in_start, int in_end) {
		if (pre_start > pre_end) {
			return null;
		}
		if (pre_start == pre_end) {
			return new Node(pre[pre_start]);
		}
		
		int root_index_inorder = 0;
		for (int i = in_start; i <= in_end; i++) {
			if (in[i] == pre[pre_start]) {
				root_index_inorder = i;
				break;
			}
		}
		
		int left_sub_count = root_index_inorder  - in_start;
		int right_sub_count = in_end - root_index_inorder;
		
		Node n = new Node(pre[pre_start]);
		
		n.left = constructBinaryTree(pre, pre_start + 1, pre_start + left_sub_count, in, in_start, in_start + left_sub_count - 1);
		n.right = constructBinaryTree(pre, pre_start + left_sub_count + 1, pre_end, in, in_start + left_sub_count + 1, in_end);
		
		return n;
	}
	
	
	public static void main(String [] args) {
		int [] in_order = {1, 2, 3, 4, 5};
		int [] pre_order = {2, 1, 3, 4, 5};
		
		Node root = constructBinaryTree(pre_order, 0, pre_order.length - 1, in_order, 0, in_order.length - 1);
		
		System.out.print("in-order: ");
		root.traverse_inorder();
		System.out.println("\n");
		System.out.print("pre-order: ");
		root.traverse_preorder();
		
	}
}
