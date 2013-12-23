package other_practices1;

public class GCD_LCM {

	
	public static long GCD(long x, long y) {
		if (Math.max(x, y) % Math.min(x, y) == 0) return x < y ? x : y;
		return GCD(Math.min(x, y), Math.max(x, y) % Math.min(x, y));
	}
	
	public static long LCM(long x, long y) {
		return x * y / GCD(x, y);
	}
	
	public static void main(String [] args) {
		System.out.println(GCD(25, 80));
		System.out.println(LCM(25, 80));
	}
}
