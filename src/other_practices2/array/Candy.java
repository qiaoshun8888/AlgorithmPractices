package other_practices2.array;

public class Candy {

	/*
	 * There are N children standing in a line. Each child is assigned a rating
	 * value.
	 * 
	 * You are giving candies to these children subjected to the following
	 * requirements:
	 * 
	 * Each child must have at least one candy. Children with a higher rating
	 * get more candies than their neighbors. What is the minimum candies you
	 * must give?
	 */

	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;
		int n = ratings.length;
		if (n == 1)
			return 1;
		int[] increment = new int[n];
		// init
		for (int i = 0; i < n; i++) {
			increment[i] = 1;
		}

		// from left to right
		for (int i = 1; i < n; i++) {
			if (ratings[i] > ratings[i - 1]) {
				increment[i] = increment[i - 1] + 1;
			}
		}
		// from right to left
		for (int i = n - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				increment[i] = Math.max(increment[i + 1] + 1, increment[i]);
			}
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			result += increment[i];
		}

		return result;
	}

	public static void main(String[] args) {
		// int[] vs = { 1, 2, 3, 4, 1 };
		int[] vs = { 2, 1 };
		Candy o = new Candy();
		System.out.println(o.candy(vs));
	}
}
