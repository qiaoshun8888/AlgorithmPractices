package crackingProgrammingInterviewYouTuBe;

public class N02SquareRootNumber {

	public static double sqrt(double n) {
		if (n < 0) return -1;
		if (n == 0 || n == 1) return 0;
		
		double precision = 0.00000001;
		double left = 0, right = n, mid = 0;
		
		if (n < 1) right = 1;
		
		while (right - left > precision) {
			mid = (right + left) /2;
			if (n == mid * mid) return mid;
			if (n > mid * mid) left = mid;
			else right = mid;
		}
		
		return mid;
	}
	
	public static void main(String [] args) {
		System.out.println(N02SquareRootNumber.sqrt(10));
		System.out.println(N02SquareRootNumber.sqrt(16));
		System.out.println(N02SquareRootNumber.sqrt(99));
		System.out.println(N02SquareRootNumber.sqrt(100));
		System.out.println(N02SquareRootNumber.sqrt(1/9.0));
		
		System.out.println((-5 -7) >> 1); // signed right shift "/2"
		System.out.println((5 + 7) >>> 1); // unsigned right shift "/2"
	}
}
