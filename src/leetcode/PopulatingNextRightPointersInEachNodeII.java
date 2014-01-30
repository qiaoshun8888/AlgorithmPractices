package leetcode;

/**
 *	PopulatingNextRightPointersInEachNodeII.java
 *
 *	Description: Follow up for problem "Populating Next Right Pointers in Each Node".

	What if the given tree could be any binary tree? Would your previous solution still work?

	Note:

	You may only use constant extra space.
	For example,
	Given the following binary tree,
	
	         1
	       /  \
	      2    3
	     / \    \
	    4   5    7
	    
	After calling your function, the tree should look like:
	
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \    \
	    4-> 5 -> 7 -> NULL
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Jan 29, 2014
 */

public class PopulatingNextRightPointersInEachNodeII {

	static class TreeLinkNode {
		int val;
		TreeLinkNode left, right ,next;
		TreeLinkNode(int val) {
			this.val = val;
		}
		public String toString() {
			return "Node(" + val + ")";
		}
	}
	
	public void connect(TreeLinkNode root) {
		TreeLinkNode runner = root;
        while (runner != null) {
        	TreeLinkNode next = null, pre = null;
        	while (runner != null) {
        		if (next == null) next = runner.left != null ? runner.left : runner.right;
        		if (runner.left != null) {
        			if (pre != null)  pre.next = runner.left;
        			pre = runner.left;
        		}
        		if (runner.right != null) {
        			if (pre != null) pre.next = runner.right;
        			pre = runner.right;
        		}
        		runner = runner.next;
        	}
        	runner = next;
        }
    }
    
    public static void main(String[] args) {
    	TreeLinkNode root = new TreeLinkNode(1);
    	root.right = new TreeLinkNode(2);
    	
    	PopulatingNextRightPointersInEachNodeII o = new PopulatingNextRightPointersInEachNodeII();
    	o.connect(root);
    	
	}
}
