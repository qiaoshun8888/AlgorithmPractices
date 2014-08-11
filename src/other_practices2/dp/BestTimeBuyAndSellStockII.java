package other_practices2.dp;

public class BestTimeBuyAndSellStockII {

	/**
	 * Say you have an array for which the ith 
	 * element is the price of a given stock on day i.

		Design an algorithm to find the maximum profit. 
		You may complete as many transactions as you like 
		(ie, buy one and sell one share of the stock multiple times). 
		However, you may not engage in multiple transactions at the same time 
		(ie, you must sell the stock before you buy again).
	 */

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) return 0;
		int profit = 0, minPrice = -1;
		for (int i = 0; i < prices.length; i++) {
			if (i != prices.length - 1) {
				if (prices[i + 1] > prices[i] && minPrice == -1) {
					minPrice = prices[i];
				}
				else if (prices[i + 1] < prices[i] && minPrice != -1) {
					profit += prices[i] - minPrice;
					minPrice = -1;
				}
			}
			else {
				if (minPrice != -1) {
					profit += prices[i] - minPrice;
				}
			}
		}
		return profit > 0 ? profit : 0;
	}

	public static void main(String[] args) {
		int[] vs = {1,3,7,5,1,3,6,2};
		BestTimeBuyAndSellStockII o = new BestTimeBuyAndSellStockII();
		System.out.println(o.maxProfit(vs));
	}
}
