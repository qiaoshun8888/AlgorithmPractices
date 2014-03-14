package leetcode;

public class BestTimeToBuyAndSellStock2 {

	/**
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times). However, you may not engage in multiple transactions at
	 * the same time (ie, you must sell the stock before you buy again).
	 * 
	 * */
	
	private class Node {
		
	}

	public int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;

		int profit = 0, min = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if (i != prices.length - 1) {
				if (prices[i + 1] < prices[i]) {
					profit += prices[i] - min;
					min = prices[i + 1];
				}
			}
		}

		int v = prices[prices.length - 1] - min;
		if (v > 0) {
			profit += v;
		}

		return profit;
	}

	
	public static void main(String [] args) {
		int [] vs = {2, 5, 1, 7, 8, 4, 6};

		BestTimeToBuyAndSellStock2 o = new BestTimeToBuyAndSellStock2();
		System.out.println(o.maxProfit(vs));
	}

}
