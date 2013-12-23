package other_practices1;

public class ArmstrongNumbers {

	
	public static void printArmstrongNumbers(int digits) {
		for (int i = (int) Math.pow(10, digits - 1); i < Math.pow(10, digits); i++) {
			int [] x = new int[digits + 1];
			x[0] = i;
			char [] cc = String.valueOf(i).toCharArray();
			for (int j = 1; j < x.length; j++) {
				x[j] = cc[j-1] - 48;
			}
			if (armstrong(x, digits, 1, 0)) System.out.println(i);
		}
	}
	private static boolean armstrong(int [] x, int digits, int i, int sum) {
		if (i == x.length) {
			return sum == x[0];
		}
		sum += Math.pow(x[i], digits);
		return armstrong(x, digits, i + 1, sum);
	}
	
	public static void main(String [] args) {
		printArmstrongNumbers(3);
		/*
		System.out.println((int)'0'); // 48
		System.out.println((int)'A'); // 65
		System.out.println((int)'a'); // 97
		*/
	}
}
