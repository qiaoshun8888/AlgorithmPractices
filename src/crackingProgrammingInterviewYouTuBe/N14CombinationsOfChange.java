package crackingProgrammingInterviewYouTuBe;

import java.util.HashSet;
import java.util.Set;

public class N14CombinationsOfChange {

	/**
	 * Given a change amount , print all possible combinations using different
	 * sets of coins.
	 * 
	 * */

	static class Coins {
		int c25, c10, c5, c1;

		public Coins() {
			c25 = 0;
			c10 = 0;
			c5 = 0;
			c1 = 0;
		}

		public Coins(Coins c) {
			this.c25 = c.c25;
			this.c10 = c.c10;
			this.c5 = c.c5;
			this.c1 = c.c1;
		}

		public Coins add(int v) {
			switch (v) {
			case 25:
				c25++;
				break;
			case 10:
				c10++;
				break;
			case 5:
				c5++;
				break;
			case 1:
				c1++;
				break;
			default:
				break;
			}
			return this;
		}

		public String toString() {
			return "25(" + c25 + ")  10(" + c10 + ")  5(" + c5 + ")  1(" + c1
					+ ").";
		}

		public Coins copy() {
			return new Coins(this);
		}

		public void clear() {
			c25 = 0;
			c10 = 0;
			c5 = 0;
			c1 = 0;
		}
	}

	private static final int[] coins_array = { 25, 10, 5, 1 };
	public static void combinations(int amount, int coins, Coins c, Set<Coins> sets) {
		c = c == null ? new Coins() : c.add(coins); 
		
		if (amount == 0) {
			sets.add(c);
			return;
		} else if (amount < 0) {
			return;
		}

		int v = 0;
		for (int i = 0; i < coins_array.length; i++) {
			v = coins_array[i];
			if (amount >= v && coins >= v) {
				// Create a new instance, so the future change won't affect current object.
				combinations(amount - v, v, new Coins(c), sets);
			}
		}
	}

	public static void main(String[] args) {
		int change = 15;
		Set<Coins> set = new HashSet<Coins>();
		combinations(change, 25, null, set);

		for (Coins c : set) {
			System.out.println(c);
		}
	}
}
