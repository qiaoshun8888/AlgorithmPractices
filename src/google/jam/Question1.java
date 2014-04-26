package google.jam;

import java.io.*;
import java.util.Arrays;

public class Question1 {
	
	private static String[] s_require = null;
	private static boolean stop = false;
	private static int case_id = 1;
	private static boolean[] used;
	private static boolean[] used_stop;
	
	public static void read() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/Users/johnqiao/Desktop/CS Career/algorithm practise/algorithm_practices/src/google/jam/q1_data2.txt"));
	    try {	        
	        int case_num = Integer.parseInt(br.readLine());
	        String[] temp = null;
	        
	        for (int i = 0; i < case_num; i++) {
	        	// initial state
	        	s_require = null;
	        	stop = false;
	        	
	        	temp = br.readLine().split(" ");
	        	int col = Integer.parseInt(temp[0]);
	        	int length = Integer.parseInt(temp[1]);
	        	String[] initial = br.readLine().split(" ");
	        	String[] require = br.readLine().split(" ");
	        	
	        	process(initial, require, length);
	        	 
	        	if (stop) {
	        		System.out.println("Case_ID: #" + case_id + " (" + countBits() + ") \t Done!");
	        	}
	        	else {
	        		System.out.println("Case_ID: #" + case_id + " (-) \t Impossible!");
	        	}
	        	
	        	case_id++;
	        }
	    } finally {
	        br.close();
	    }
	}
	
	// 111 001
	// 101 011
	
	private static void process(String[] initial, String[] require, int length) {
		used = new boolean[length];
		subsetsHelper(initial, require, 0);
	}
	
	private static void subsetsHelper(String[] initial, String[] require, int start) {
		if (stop) return;
		
		if (start == used.length) {
			String[] flipped_initial = flip(initial, used);
			if (match(flipped_initial, require)) { 
				used_stop = new boolean[used.length];
				for (int i = 0; i < used.length; i++)
					used_stop[i] = used[i];
//				System.out.println("Match!");
//				for (String s : flipped_initial)
//					System.out.print(s + " ");
//				System.out.println('\n');
				stop = true;
			}
			
			return;
		}

		used[start] = true;
		subsetsHelper(initial, require, start + 1);
		
		used[start] = false;
		subsetsHelper(initial, require, start + 1);
	}
	
	private static String[] flip(String[] initial, boolean[] b) {
		String[] new_initial = new String[initial.length];
		for (int i = 0; i < initial.length; i++) {
			// copy a char array
			char[] char_initial = new char[b.length];
			char[] temp = initial[i].toCharArray();
			for (int k = 0; k < b.length; k++) {
				char_initial[k] = temp[k];
			}
			
			// flip the new char array
			for (int j = 0; j < b.length; j++) {
				if (b[j])
					char_initial[j] = char_initial[j] != '0' ? '0' : '1';
				else
					char_initial[j] = char_initial[j];
			}
			
			// generate new_initial 
			new_initial[i] = new String(char_initial);
		}
		
		return new_initial;
	}
	
	private static boolean match(String[] initial, String[] require) {
		String[] s_initial = new String[initial.length];
		
		if (s_require == null) {
			s_require = new String[require.length];
			for (int i = 0; i < require.length; i++) {
				s_require[i] = require[i];
			}
			Arrays.sort(s_require);
		}
		
		
		for (int i = 0; i < s_initial.length; i++) {
			s_initial[i] = initial[i];
		}
		
		Arrays.sort(s_initial);
	
		for (int i = 0; i < s_initial.length; i++) {
//			System.out.println(s_initial[i] + "  " + s_require[i]);
			if (!s_initial[i].equals(s_require[i])) return false;
		}
		
		return true;
	}
	
	private static int countBits() {		
		int count = 0;
		for (boolean b : used_stop) {
			if (b) count++;
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		read();
	}
}
