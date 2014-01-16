package crackingTheCodingInterview.chapter11;

public class FindGivenString {

	public int find(String [] vs, String x) {
		return find(vs, x, 0, vs.length - 1);
	}
	
	private int find(String [] vs, String x, int left, int right) {
		if (left > right) return -1;
		int mid = (left + right) / 2;
		int mid_left = mid, mid_right = mid;
		// If vs[mid] is empty, then find the nearest non-empty element
		while (mid_left >= 0 || mid_right < vs.length) {
			if (vs[mid_left].length() == 0 && mid_left >= 0) {
				mid_left--;
			}
			if (vs[mid_left].length() != 0) {
				mid = mid_left;
				break;
			}
			if (vs[mid_right].length() == 0 && mid_right < vs.length) {
				mid_right++;
			}
			if (vs[mid_right].length() != 0) {
				mid = mid_right;
				break;
			}
		}
		if (vs[mid].equals(x)) {
			return mid;
		}
		else if (vs[mid].compareTo(x) < 0) {  // x on the right
			return find(vs, x, mid + 1, right);
		}
		else { // x on the left
			return find(vs, x, left, mid - 1);
		}
	}
	
	public static void main(String [] args) {
		String [] vs = {"", "abc", "", "", "abcd", "", "bcd", "daa", "feel", "", "good", "", "zoo", "zyx", "zzz"};
		FindGivenString fgs = new FindGivenString();
		System.out.println(fgs.find(vs, "good"));
	}
}
