package myUtils.datastructure;

public class LinkedNode {
	
	public LinkedNode next;
	public int val;
	
	public LinkedNode(int val) {
		this.val = val;
	}
	
	@Override
	public String toString() {
		return "Node(" + val + ")";
	}
}
