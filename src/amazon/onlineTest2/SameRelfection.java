package amazon.onlineTest2;

import java.util.ArrayList;
import java.util.List;

public class SameRelfection {

	public static int isSameReflection(String word1, String word2) {
		// Check whether word1 and word2 have same reflection.
		// Return 1 or -1
		// INSERT YOUR CODE HERE
		if(word1 == null || word2 == null){
			return (word1 == null && word2 == null) ? 1: -1;
		}
		if(word1.length() != word2.length()){
			return -1;
		}
		return (word1 + word1).contains(word2) ? 1 : -1;
	}

	public static void main(String[] args) {
		List<String[]> test_cases = new ArrayList<String[]>();
		test_cases.add(new String[]{"goshef", "shefgo"});
		test_cases.add(new String[]{"", ""});
		test_cases.add(new String[]{null, "shefgo"});
		test_cases.add(new String[]{"abc", null});
		int[] expected_results = {1, 1, -1, -1};
		for (int i = 0; i < test_cases.size(); i++) {
			String[] test_case = test_cases.get(i);
			System.out.println(isSameReflection(test_case[0], test_case[1]) == expected_results[i] ? "True" : "False");
		}

	}
}
