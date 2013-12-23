package other_practices1;

import java.util.Random;

public class CalculatePI {

	/**
	 * Area of circular: = PI*R^2.
	 * 
	 * Assume there is a circular in a square. Width of square W = 2, radius of
	 * circular R = 1. The randomly generate huge number of points, x = (-1, 1),
	 * y = (-1, 1), if x^2 + y^2 < 1, then the points are in the circular.
	 * 
	 * Suppose we got M points in the circular, and we have totally N points.
	 * THen the area of the circular also equal to: M/N*W^2
	 * 
	 * M / N * W^2 = PI * R^2
	 * 
	 * We got PI.
	 * 
	 * */
	public static double PI() {
		int N = 1000000, M = 0;
		Random rand = new Random();
		for (int i = 0; i < N; i++) {
			double x = rand.nextDouble() * 2 - 1;
			double y = rand.nextDouble() * 2 - 1;
			if (Math.pow(x, 2) + Math.pow(y, 2) < 1) M++; 
		}
		return (double)M / N * 4;
	}
	
	public static void main(String [] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(PI());
		}
	}
}
