package amazon;

public class BestTimeToBuyAndSellStockII {

	/**
	 * Best Time to Buy and Sell Stock II
	 * 
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times). However, you may not engage in multiple transactions at
	 * the same time (ie, you must sell the stock before you buy again).
	 * 
	 * */
	
	// 2, 5, 3, 7, 6, 8, 3
	public static int maxProfit(int [] prices) {
		if (prices == null || prices.length == 0) return 0;
		
		int profit = 0, min = prices[0];
		
		for (int i = 0; i < prices.length; i++) {
			if (i + 1 < prices.length && prices[i + 1] < prices[i]) {
				profit += prices[i] - min;
				min = prices[i + 1];
			}
		}
		
		if (prices[prices.length - 1] > min) {
			profit += prices[prices.length - 1] - min;
		}
		
		return profit;
	}
	
	public static void main(String[] args) {
		int [] vs = {2, 5, 3, 7, 6, 8, 3}; // 3 + 7
		System.out.println(maxProfit(vs));
	}
}
