package amazon.onlineTest2;

public class EliminateVowel {

	public static String eliminateVowelString(String string){
		// Eliminate all the vowels from the input string 
		// Return the string without vowels 
		// INSERT YOUR CODE HERE 
		if(string == null) return null; 
		StringBuffer sb = new StringBuffer(); 
		for(char c : string.toCharArray()){ 
			if("aeiouAEIOU".indexOf(c) < 0){ 
				// char is not an vowel, append to StringBuffer
				sb.append(c); 
			}
		} 
		// convert to a string
		return sb.toString(); 
	}

	public static void main(String[] args) {
		String[] test_cases = {
				"",
				"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ",
				null,
		};
		int[] expected_results = {
				0,
				42,
				-1
		};
		EliminateVowel o = new EliminateVowel();

		for (int i = 0; i < test_cases.length; i++) {
			if (o.eliminateVowelString(test_cases[i]).length() == expected_results[i]) {
				System.out.println("True");
			} else {
				System.out.println("False");
			}
		}
	}
}