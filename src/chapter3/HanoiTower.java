package chapter3;

import java.util.Stack;

public class HanoiTower {
	
	private Stack<Integer> disks;
	private int index;
	
	public HanoiTower(int n) {
		disks = new Stack<Integer>();
		index = n;
	}
	
	public int index() {
		return index;
	}
	
	public void add(int d){
		if (!disks.isEmpty() && disks.peek() <= d) {
			// throw new Exception("cannot add disk " + d + " over " + disks.peek());
			System.out.println("Error placing disk " + d);
		}
		else {
			disks.push(d);
		}
	}
	
	public void moveToTop(HanoiTower t) {
		int disk = disks.pop();
		t.add(disk);
		System.out.printf("Move disk %d from Tower[%d] to Tower[%d].\n", disk, index(), t.index());
	}
	
	public void moveDisks(int n, HanoiTower destination, HanoiTower buffer) {
		if (n > 0) {
			moveDisks(n - 1, buffer, destination);
			moveToTop(destination);
			buffer.moveDisks(n - 1, destination, this);
		}
	}
	
	public static void main(String [] args) {
		int n = 3;
		HanoiTower [] towers = new HanoiTower[n];
		for (int i = 0; i < 3; i++) {
			towers[i] = new HanoiTower(i);
		}
		
		for (int i = n - 1; i >= 0; i--) {
			towers[0].add(i);
		}
		towers[0].moveDisks(n, towers[2], towers[1]);
	}
}
