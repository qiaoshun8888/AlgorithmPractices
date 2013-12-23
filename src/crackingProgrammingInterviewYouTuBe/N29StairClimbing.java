package crackingProgrammingInterviewYouTuBe;

import java.util.HashMap;
import java.util.Map;

public class N29StairClimbing {

	private static long called_times = 0;

	/**
	 * You can climb 1, 2 or 3 steps at one time, how many different ways you
	 * can climb a N-step stair.
	 * 
	 * */

	public static long countWaysNaive(int n) {
		called_times++;
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		return countWaysNaive(n - 1) + countWaysNaive(n - 2)
				+ countWaysNaive(n - 3);
	}

	private static Map<Integer, Long> map = new HashMap<Integer, Long>();
	public static long countWaysImproved(int n) {
		called_times++;
		if (n < 0)
			return 0L;
		if (n == 0)
			return 1L;

		int ways = 0;

		if (!map.containsKey(n - 1)) {
			map.put(n - 1, countWaysImproved(n - 1));
		}
		if (!map.containsKey(n - 2)) {
			map.put(n - 2, countWaysImproved(n - 2));
		}
		if (!map.containsKey(n - 3)) {
			map.put(n - 3, countWaysImproved(n - 3));
		}

		ways += map.get(n - 1);
		ways += map.get(n - 2);
		ways += map.get(n - 3);

		return ways;
	}

	/**
	 * n = 1 -> 1 : 1 
	 * n = 2 -> 2 : 1+1, 2 
	 * n = 3 -> 4 : 1+1+1, 2+1, 1+2, 3
	 * 
	 * n = (n-1) + (n-2) + (n-3)
	 * 
	 * Consider F(N) is number of ways to get to the Nth step. there are only
	 * three steps you can get there from: N-1, N-2 and N-3. All the ways you
	 * can get to the step (N-1) + (N-2) + (N-3) will give you the total number
	 * of ways.
	 * 
	 * */
	public static long countWaysUltimateImproved(int n) {
		long[] ways = { 1, 2, 4 };
		int current_n = 3;
		while (current_n < n) {
			called_times++;
			ways[current_n % 3] = ways[0] + ways[1] + ways[2];
			current_n++;
		}
		
		return ways[(current_n - 1) % 3];
	}

	public static void main(String[] args) {
		int N = 36;
		long start_time = System.currentTimeMillis();
		//System.out.println("N = " + N + "\tways_naive: " + countWaysNaive(N) + "\tcalled_times: " + called_times + "\tcost_time: " + (System.currentTimeMillis() - start_time));
		
		called_times = 0;
		start_time = System.currentTimeMillis();
		System.out.println("N = " + N + "\tways_improved: " + countWaysImproved(N) + "\tcalled_times: " + called_times + "\tcost_time: " + (System.currentTimeMillis() - start_time));
		
		called_times = 0;
		start_time = System.currentTimeMillis();
		System.out.println("N = " + N + "\tways_ultimate_improved: " + countWaysUltimateImproved(N) + "\tcalled_times: " + called_times + "\tcost_time: " + (System.currentTimeMillis() - start_time));
		
	}
}
