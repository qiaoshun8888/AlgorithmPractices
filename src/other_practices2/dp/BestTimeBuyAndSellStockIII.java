package other_practices2.dp;

public class BestTimeBuyAndSellStockIII {

	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.

		Design an algorithm to find the maximum profit. You may complete at most two transactions.

		Note:
		You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
	 */

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) return 0;

		// Maximum profit from left
		int[] left = new int[prices.length];
		// Maximum profit from right
		int[] right = new int[prices.length];

		helper(prices, left, right);

		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			System.out.println(left[i] + "  " + right[i]);
			max = Math.max(max, left[i] + right[i]);
		}

		return max;
	}

	private void helper(int[] prices, int[] left, int[] right) {
		left[0] = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			left[i] = Math.max(left[i - 1], prices[i] - min);
			min = Math.min(min, prices[i]);
		}

		right[prices.length - 1] = 0;
		int max = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], max - prices[i]);
			max = Math.max(max, prices[i]);
		}
	}

	public static void main(String[] args) {
		int[] vs = {2,1,2,0,1};
		BestTimeBuyAndSellStockIII o = new BestTimeBuyAndSellStockIII();
		System.out.println(o.maxProfit(vs));
	}
}
