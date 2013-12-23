package crackingProgrammingInterviewYouTuBe;

public class N17DivisionOperation {

	private static int called_times = 0;
	
	/**
	 * Implement division without using divisor operator
	 * 
	 * */
	
	public static int divide(int x, int y) throws Exception {
		if (y == 0) throw new Exception("Divisor cannot be ZERO!!");
		if (x == 0) return 0;
		boolean negative = (x < 0 && y > 0) || (x > 0 && y < 0);
		x = Math.abs(x);
		y = Math.abs(y);
		int i = 0;
		while (x >= y) {
			called_times++;
			x -= y;
			i++;
		}
		return negative ? -i : i;
	}
	
	public static int divideOptimized(int x, int y) throws Exception {
		if (y == 0) throw new Exception("Divisor cannot be ZERO!!");
		if (x == 0) return 0;
		
		boolean negative = (x < 0 && y > 0) || (x > 0 && y < 0);
		x = Math.abs(x);
		y = Math.abs(y);
		
		int quotient = 0;
		int cur_divisor = y, cur_quotient_base = 1;
		
		while (x >= y) {
			called_times++;
			if (x >= cur_divisor) {
				x -= cur_divisor;
				quotient += cur_quotient_base;
				
				cur_divisor *= 2;
				cur_quotient_base *= 2;
			}
			else {
				cur_divisor /= 2;
				cur_quotient_base /= 2;
			}
		}
		
		return negative ? -quotient : quotient;
	}
	
	public static void main(String [] args) {
		try {
			System.out.println(divide(-100000000, 2));
			System.out.println("called_times: " + called_times);
			System.out.println();
			called_times = 0;
			System.out.println(divideOptimized(-100000000, 2));
			System.out.println("called_times: " + called_times);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
