package crackingProgrammingInterviewYouTuBe;

public class N05ConvertDoubleToRational {

	public static void main(String [] args) {
		System.out.println(convert(20.125));
	}
	
	/**
	 * Convert a double number to rational
	 * 
	 * e.g.  0.125 -> 1/8
	 * 
	 * double:  12312.12837102731
	 * */
	public static String convert(double d) {
		long l = (long)d;
		String d_str = String.valueOf(d).split("\\.")[1];
		long denominator = 1;
		for (int i = 0; i < d_str.length(); i++) {
			denominator *= 10;
		}
		
		long l_d_str = (long)(d * denominator);
		long lcd = GCD(Math.min(l_d_str, denominator), Math.max(l_d_str, denominator));
		return l_d_str / lcd + "/" + denominator / lcd;
	}
	
	/**
	 * denominator > numerator
	 * 
	 * e.g.   0.125 -> 1/8  LCD(125, 1000)
	 * 
	 * numerator = 125  denominator = 1000
	 *  
	 * Get LCD (18, 48):
	 * 
	 * 48 = 18 * 2 + 12
	 * 18 = 12 * 1 + 6
	 * 12 = 6 * 2 + 0
	 *      ^
	 *      |
	 *     GCD
	 * */
	private static long GCD (long numerator, long denominator) {
		if (denominator % numerator == 0) return numerator;
		return GCD(denominator % numerator, numerator);
	}
}
