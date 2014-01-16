package programcreek;

public class DoubleExample {

	public static void main(String [] args) {
		// convert integer to double
		double d = 2 / 3;
		System.out.println(d);
		d = (double) 2 / 3; // or  2 / (double)3;
		System.out.println(d); // 0.6666666666666666
		
		// Round double
		d = 11.937528;
		int i = 1000; // round the result to 3 digits
		d = Math.round(d * i);
		d = d / i;
		System.out.println(d);
	}
}
