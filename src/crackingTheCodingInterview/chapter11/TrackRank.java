package crackingTheCodingInterview.chapter11;

public class TrackRank {

	static class RNode {
		RNode left, right;
		int value, left_size;
		public RNode(int value) {
			this.value = value;
			this.left_size = 0;
		}
		
		public void insert(int v) {
			if (v > value) {
				if (right != null) right.insert(v);
				else right = new RNode(v);
			}
			else {
				if (left != null) left.insert(v);
				else left = new RNode(v);
				left_size++;
			}
		}
		
		public int getRank(int v) {
			if (v == value) return left_size;
			else if (v < value) {
				if (left == null) return -1;
				else return left.getRank(v);
			}
			else {
				int right_rank = right == null ? -1 : right.getRank(v);
				if (right_rank == -1) return -1;
				else return left_size + 1 + right_rank;
			}
		}
	}
	
	public static RNode generateBST(int [] vs) {
		RNode root = new RNode(vs[0]);
		for (int i = 1; i < vs.length; i++) {
			root.insert(vs[i]);
		}
		return root;
	}
	
	public static void printBinaryTree(RNode root, int level){
	    if(root==null)
	         return;
	    printBinaryTree(root.right, level+1);
	    if(level!=0){
	        for(int i=0;i<level-1;i++)
	            System.out.print("|\t");
	            System.out.println("|-------"+root.value + "(" + root.left_size + ")");
	    }
	    else {
	        System.out.println(root.value + "(" + root.left_size + ")");
	    }
	    printBinaryTree(root.left, level+1);
	} 
	
	public static void main(String [] args) {
		int [] vs = {8, 6, 9, 3, 7, 12, 10, 15};
		RNode root = TrackRank.generateBST(vs);
		TrackRank.printBinaryTree(root, 0);
		System.out.println(root.getRank(15));
	}
}
