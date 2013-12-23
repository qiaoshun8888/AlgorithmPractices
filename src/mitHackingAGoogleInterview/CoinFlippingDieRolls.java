package mitHackingAGoogleInterview;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

public class CoinFlippingDieRolls {

	/**
	 * Describe an algorithm to output a die roll (a random number from 1 to 6),
	 * given a function that outputs a coin toss ( a random number from 1 to 2).
	 * Each possible outcome should be equally likely.
	 * 
	 * */
	
	public static final int roll() {
		Random rand = new Random();
		return rand.nextInt(2);
	}
	
	public static int coinFlip() {
		int v = 0;
		for (int i = 2; i >= 0; i--) {
			v |= roll() << i;
		}
		if (v > 6 || v < 1) return coinFlip();
		return v;
	}
	
	public static void main(String [] args) {
		// System.out.println(coinFlip());
		Map<String, MutableInteger> map = new HashMap<String, MutableInteger>();
		for (int i = 0; i < 5000; i++) {
			String str_v = Integer.toString(coinFlip());
			MutableInteger initVal = new MutableInteger(1);
			MutableInteger pre_v = map.put(str_v, initVal); 
			if (pre_v != null) {
				initVal.set(pre_v.get() + 1);
			}
		}
		
		// Traverse map
		SortedMap<String, MutableInteger> sortedMap = new TreeMap<String, MutableInteger>(new Comparator() {
			@Override
			public int compare(Object k1, Object k2) {
				return Integer.parseInt(k1.toString()) - Integer.parseInt(k2.toString());
			}
		});
		sortedMap.putAll(map);
		
		Iterator it = sortedMap.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, MutableInteger> entry = (Entry<String, MutableInteger>)it.next();
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}

class MutableInteger {
	private int val;
	
	public MutableInteger(int val) {
		this.val = val;
	}
	
	public int get() {
		return val;
	}
	
	public void set(int val) {
		this.val = val;
	}
	
	@Override
	public String toString() {
		return Integer.toString(val);
	}
}
