package other_practices2.array;

public class GasStation {

	/*
	 * There are N gas stations along a circular route, where the amount of gas
	 * at station i is gas[i].
	 * 
	 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
	 * travel from station i to its next station (i+1). You begin the journey
	 * with an empty tank at one of the gas stations.
	 * 
	 * Return the starting gas station's index if you can travel around the
	 * circuit once, otherwise return -1.
	 * 
	 * Note: The solution is guaranteed to be unique.
	 */

	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length == 0 || cost.length == 0
				|| gas.length != cost.length)
			return -1;
		// Gas:	  5  1  2  3  10  4
		// Cost:  4  3  1  2  8   8
		// ====   1 -2  1  1  2  -4
		int total = 0, j = -1;
		for (int i = 0, sum = 0; i < gas.length; i++) {
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (sum < 0) {
				j = i;
				sum = 0;
			}
		}
		return total >= 0 ? j + 1 : -1;
	}

	public static void main(String[] args) {
		// int[] gas = { 5, 1, 2, 3, 10, 6 };
		// int[] cost = { 4, 3, 1, 2, 8, 8 };
		int[] gas = { 5 };
		int[] cost = { 4 };
		GasStation o = new GasStation();
		System.out.println(o.canCompleteCircuit(gas, cost));
	}
}
