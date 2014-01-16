package crackingTheCodingInterview.chapter5;

import java.util.ArrayList;

public class FindMissing {
	
	public int findMissing(ArrayList<BitInteger> array) {
		// start from the least significant bit, and work our way up
		return findMissing(array, 0);
	}
	
	public int findMissing(ArrayList<BitInteger> array, int column) {
		if (column >= BitInteger.INTEGER_SIZE) {
			return 0; // Done!
		}
		ArrayList<BitInteger> oneBits = new ArrayList<BitInteger>(array.size()/2);
		ArrayList<BitInteger> zeroBits = new ArrayList<BitInteger>(array.size()/2);
		
		for (BitInteger t : array) {
			if (t.fetch(column) == 0) {
				zeroBits.add(t);
			}
			else {
				oneBits.add(t);
			}
		}
		
		if (zeroBits.size() <= oneBits.size()) {
			int v = findMissing(zeroBits, column + 1);
			return (v << 1) | 0;
		}
		else {
			int v = findMissing(oneBits, column + 1);
			return (v << 1) | 1;
		}
	}
	

	public static void main(String [] args) {
		
		
	}
}

class BitInteger {
	
	final static int INTEGER_SIZE = 100;
	
	int v;
	
	public BitInteger() {
		
	}
	
	public int fetch(int column) {
		return 0;
	}
	
}