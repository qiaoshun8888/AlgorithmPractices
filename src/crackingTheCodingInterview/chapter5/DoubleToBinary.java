package crackingTheCodingInterview.chapter5;

public class DoubleToBinary {
	
	/**
	 * Non-Integer to binary
	 * 
	 * 0.101 -> 
	 * 
	 * 		1 * (1/2^1) + 0 * (1/2^2) + 1 * (1/2^3)
	 * 
	 * */
	
	public static String printBinary(double num) {
		if (num >= 1 || num <= 0) return "ERROR";
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		
		while(num > 0) {
			if (sb.length() >= 32) return "ERROR";
			double r = num * 2;
			if (r >= 1) {
				sb.append(1);
				num = r - 1;
			}
			else {
				sb.append(0);
				num = r;
			}
		}
		return sb.toString();
	}
	
	public static String printBinary2(double num) {
		if (num >= 1 || num <= 0) return "ERROR";
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		double fac = 0.5;
		while (num > 0) {
			if (sb.length() >= 32) return "ERROR";
			if (num >= fac) {
				sb.append(1);
				num -= fac;
			}
			else {
				sb.append(0);
			}
			fac /= 2;
		}
		return sb.toString();
	}

	public static void main(String [] args) {
		System.out.println(DoubleToBinary.printBinary(0.25));
		System.out.println(DoubleToBinary.printBinary2(0.625));
	}
}
