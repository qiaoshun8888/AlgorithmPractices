package leetcode;

public class ReverseInteger {

	public int reverse(int x) {
        char [] cc = (x + "").toCharArray();
        boolean negative = cc[0] == '-';
        int start = negative ? 1 : 0, end = cc.length - 1;
        while (start < end) {
            swap(cc, start, end);
            start++;
            end--;
        }
        return Integer.parseInt(String.valueOf(cc));
        // return Long.parseLong(String.valueOf(cc));
    }
    
    private void swap(char [] cc, int i, int j) {
        if (cc[i] == cc[j]) return;
        char temp = cc[i];
        cc[i] = cc[j];
        cc[j] = temp;
    }
    
    public static void main(String [] args) {
    	int n = -12300;
    	ReverseInteger ri = new ReverseInteger();
    	System.out.println(ri.reverse(n));
    }
}
