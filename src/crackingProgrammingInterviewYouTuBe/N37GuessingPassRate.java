package crackingProgrammingInterviewYouTuBe;

public class N37GuessingPassRate {

	/**
	 * Probability of passing exam by guessing
	 * 
	 * */
	public static double passingRate (int n, int k) {
		double singleCorrect = 1.0 / 4.0, singleWrong = 3.0 / 4.0;
		double [][] ratios = new double[n + 1][k + 1];
		ratios[1][0] = singleWrong;
		ratios[1][1] = singleCorrect;
		
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				if (j == 0) {
					ratios[i][j] = ratios[i - 1][j] * singleWrong;
				}
				else {
					ratios[i][j] = ratios[i - 1][j - 1] * singleCorrect + ratios[i - 1][j] * singleWrong;
				}
			}
		}
		
		return ratios[n][k];
	}
	
	public static void main(String [] args) {
		System.out.println("Ratio of guessing 5 out of 10 is " + passingRate(10, 5));
	}
}
