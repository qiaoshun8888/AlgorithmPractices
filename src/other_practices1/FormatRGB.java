package other_practices1;

public class FormatRGB {

	/**
	 * Format an RGB value (three 1-byte numbers) as a 6 digit hexadecimal string
	 * 
	 * */
	
	public static String formatRGB(int r, int g, int b) {
		return toHex(r) + toHex(g) + toHex(b);
	}
	private static String toHex(int v) {
		String s = Integer.toHexString(v); 
		return (s.length() == 1 ? "0" : "") + s;
	}
	
	public static void main(String [] args) {
		System.out.println(formatRGB(101, 225, 2));
	}
}
