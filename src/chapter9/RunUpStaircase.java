package chapter9;

public class RunUpStaircase {

	private static int[] ways_array = new int[100];

	public static int getWaysNumber(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		if (ways_array[n] == 0)
			ways_array[n] = getWaysNumber(n - 1) + getWaysNumber(n - 2)
					+ getWaysNumber(n - 3);
		return ways_array[n];
	}

	public static void main(String[] args) {
		System.out.println(RunUpStaircase.getWaysNumber(1));
	}
}
