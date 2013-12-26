package other_practices1;

public class PrintFibonacciNumber {
	
	private static int calledTimes = 0;

	public static int printKthFibonacci (int k) {
		if (k == 0) return 0;
		if (k < 2) return 1;
		int n1 = 1, n2 = 1, temp = 0;
		for (int i = 2; i < k; i++) {
			calledTimes++;
			temp = n2;
			n2 += n1;
			n1 = temp;
		}
		return n2;
	}
	
	public static int printKthFibonacciRecursively (int k) {
		calledTimes++;
		if (k == 0) return 0;
		else if (k < 2) return 1;
		return printKthFibonacciRecursively(k - 1) + printKthFibonacciRecursively(k - 2); 
	}
	
	private static int [] vs = null;
	public static int printKthFibonacciRecursivelyImproved (int k) {
		calledTimes++;
		if (vs == null) {
			vs = new int[k + 1];
		}
		
		if (k == 0) return 0;
		else if (k < 2) {
			vs[k] = 1;
			return 1;
		}

		/*
		if (vs[k] == 0) {
			vs[k] = printKthFibonacciRecursivelyImproved(k - 1) + printKthFibonacciRecursivelyImproved(k - 2);
		}
		return vs[k];
		*/
		
		if (vs[k - 1] == 0) {
			vs[k - 1] = printKthFibonacciRecursivelyImproved(k - 1);
		}
		if (vs[k - 2] == 0) {
			vs[k - 2] = printKthFibonacciRecursivelyImproved(k - 2);
		}
		
		return vs[k - 1] + vs[k - 2]; 
	}
	
	public static void main(String [] args) {
		int k = 30;
		System.out.println(printKthFibonacci(k) + " calledTimes: " + calledTimes);
		calledTimes = 0;
		System.out.println(printKthFibonacciRecursively(k) + " calledTimes: " + calledTimes);
		calledTimes = 0;
		System.out.println(printKthFibonacciRecursivelyImproved(k) + " calledTimes: " + calledTimes);
		
		/*
		System.out.println("=======");
		for (int i = 0; i < 10; i++) {
			System.out.print(printKthFibonacci(i) + " ");
		}
		*/
	}
}
