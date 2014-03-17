package myUtils.datastructure;

public class TreeNode {
	
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	public TreeNode next;

	public TreeNode() {
		this.val = 0;
	}
	
	public TreeNode(int val) {
		this.val = val;
	}
	
	public void print() {
		System.out.print(toString() + " ");
	}
	
	public void println() {
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return "Node(" + val + ")";
	}
}
