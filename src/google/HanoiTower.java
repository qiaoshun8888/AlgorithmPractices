package google;

import java.util.Stack;

/**
 *	HanoiTower.java
 *
 *	Description: Hanoi Tower
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Jan 23, 2014
 */

public class HanoiTower {

	private static int steps = 0;
	
	static class Disk {
		int size;
		public Disk(int size) {
			this.size = size;
		}
		public String toString() {
			return "Disk(" + size + ")";
		}
	}
	
	@SuppressWarnings("serial")
	static class Tower<E> extends Stack<E>{
		
		private final int tid;
		public Tower(int id) {
			this.tid = id;
		}
		
		public E pop() {
			if (super.isEmpty()) return null;
			return super.pop();
		}
		
		/**
		 *    1
		 *    2
		 *    3
		 *    
		 *    A    B    C
		 * */
		public void moveTo(int n, Tower<E> destination, Tower<E> buffer) {
			steps++;
			if (n > 0) {
				moveTo(n - 1, buffer, destination);
				E e = pop();
				destination.push(e);
				System.out.println("Move " + e + " from " + this + " to " + destination);
				buffer.moveTo(n - 1, destination, this);
			}
		}
		
		public String toString() {
			return "Tower(" + tid + ")";
		}
	}
	
	public static void solution(Disk[] disks) {
		@SuppressWarnings("unchecked")
		Tower<Disk> [] towers = (Tower<Disk>[])new Tower[3];
		for (int i = 0; i < 3; i++) {
			towers[i] = new Tower<Disk>(i + 1);
		}
		
		// 1 2 3 4
		for (Disk disk : disks) {
			towers[0].push(disk);
		}
		for (int i = disks.length - 1; i >= 0; i--) {
			System.out.println(disks[i]);
		}
		System.out.println(" ==== Tower 1 ==== ");
		System.out.println();
		
		towers[0].moveTo(disks.length, towers[2], towers[1]);
		
		System.out.println();
		while (!towers[2].isEmpty()) {
			System.out.println("      " + towers[2].pop());
		}
		System.out.println(" ==== Tower 3 ==== (steps: " + steps + ")");
	}
	
	public static void main(String[] args) {
		Disk [] disks = new Disk[]{
				new Disk(3),
				new Disk(2),
				new Disk(1),
		};
		solution(disks);
	}
}
