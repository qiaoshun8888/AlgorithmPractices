package other_practices2.dp;

public class BestTimeBuyAndSellStockI {

	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.

		If you were only permitted to complete at most one transaction 
		(ie, buy one and sell one share of the stock), 
		design an algorithm to find the maximum profit.

	 */

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) return 0;
		int minPrices = prices[0], maxProfit = prices[1] - prices[0];
		for (int i = 2; i < prices.length; i++) {
			minPrices = Math.min(prices[i - 1], minPrices);
			maxProfit = Math.max(maxProfit, prices[i] - minPrices);
		}
		return maxProfit < 0 ? 0 : maxProfit;
	}

	public static void main(String[] args) {
		int[] vs = {1,3,7,5,1,3,6,2};
		BestTimeBuyAndSellStockI o = new BestTimeBuyAndSellStockI();
		System.out.println(o.maxProfit(vs));
	}
}
