package other_practices2.string;

public class ValidNumber {

	/*
	 * Validate if a given string is numeric.
	 * 
	 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
	 * "2e10" => true Note: It is intended for the problem statement to be
	 * ambiguous. You should gather all requirements up front before
	 * implementing one.
	 */
	public enum InputType {
		INVALID, // 0 Include: Alphas, '(', '&' and so on
		SPACE, // 1
		SIGN, // 2 '+', '-'
		DIGIT, // 3 numbers
		DOT, // 4 '.'
		EXPONENT, // 5 'e', 'E'
	};

	public boolean isNumber(String s) {
		int transTable[][] = {
			   // 0IN, 1SP, 2SI, 3DI, 4DO, 5E
				{ -1, 0, 3, 1, 2, -1 }, // 0初始无输入或者只有space的状态
				{ -1, 8, -1, 1, 4, 5 }, // 1输入了数字之后的状态
				{ -1, -1, -1, 4, -1, -1 }, // 2前面无输入，只输入了dot的状态
				{ -1, -1, -1, 1, 2, -1 }, // 3输入了符号后的状态
				{ -1, 8, -1, 4, -1, 5 }, // 4前面有数字和dot的状态
				{ -1, -1, 6, 7, -1, -1 }, // 5'e'和'E'输入后的状态
				{ -1, -1, -1, 7, -1, -1 }, // 6输入'e'之后输入sign的状态
				{ -1, 8, -1, 7, -1, -1 }, // 7输入'e'之后输入数字的状态
				{ -1, 8, -1, -1, -1, -1 }, // 8前面有有效输入之后，输入space的状态
		};
		int state = 0;
		InputType input;
		for (int i = 0; i < s.length(); i++) {
			input = InputType.INVALID;
			if (s.charAt(i) == ' ') 
				input = InputType.SPACE;
			else if (s.charAt(i) == '+' || s.charAt(i) == '-')
				input = InputType.SIGN;
			else if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
				input = InputType.DIGIT;
			else if (s.charAt(i) == '.')
				input = InputType.DOT;
			else if (s.charAt(i) == 'e' || s.charAt(i) == 'E')
				input = InputType.EXPONENT;
			state = transTable[state][input.ordinal()];
			if (state == -1) 
				return false;
		}
		return state == 1 || state == 4 || state == 7 || state == 8;
	}

	public static void main(String[] args) {
		String s = "1221.2e12";
		ValidNumber o = new ValidNumber();
		System.out.println(o.isNumber(s));
	}
}
