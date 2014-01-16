package crackingTheCodingInterview.chapter1;

public class CompressString {
	
	public static String [] compressArray(String sa[]) {
		String [] ss = new String[sa.length];
		for (int i = 0; i < sa.length; i++) {
			ss[i] = compress(sa[i]);
		}
		return ss;
	}

	public static String compress(String s) {
		char pre_c = 0;
		int compress_v = 0;
		StringBuilder sb = new StringBuilder();
		
		for (char c : s.toCharArray()) {
			if (c != pre_c) {
				if (compress_v != 0) {
					sb.append(compress_v);
				}
				sb.append(c);
				pre_c = c;
				compress_v = 1;
			}
			else {
				compress_v++;
			}
		}
		sb.append(compress_v);

		String return_s = sb.toString();
		
		return return_s.length() > s.length() ? s : return_s;
	}
	
	public static void main(String args[]) {
		String [] sa = {"sssbbbaccdd", "sdbc", ""};
		
		System.out.println(CompressString.compress(sa[0]));
		
		for (String v : CompressString.compressArray(sa)) {
			System.out.println(v);
		}
		
		int v = 12;
		System.out.println(String.valueOf(v).length());
	}
}
