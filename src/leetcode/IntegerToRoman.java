package leetcode;

import java.util.*;

public class IntegerToRoman {

	/**
	 * Given an integer, convert it to a roman numeral.
	 * 
	 * Input is guaranteed to be within the range from 1 to 3999.
	 * 
	 * */

	private Map<Integer, String> map = new HashMap<Integer, String>();
	private int vs[] = new int[13];

	public String intToRoman(int num) {
		initMap();
		initArray();
		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			for (int i = 0; i < vs.length; i++) {
				if (num >= vs[i]) {
					sb.append(map.get(vs[i]));
					num -= vs[i];
					break;
				}
			}
		}
		return sb.toString();
	}

	private void initArray() {
		vs[0] = 1000;
		vs[1] = 900;
		vs[2] = 500;
		vs[3] = 400;
		vs[4] = 100;
		vs[5] = 90;
		vs[6] = 50;
		vs[7] = 40;
		vs[8] = 10;
		vs[9] = 9;
		vs[10] = 5;
		vs[11] = 4;
		vs[12] = 1;
	}

	private void initMap() {
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
	}

	public static void main(String[] args) {
		IntegerToRoman o = new IntegerToRoman();
		System.out.println(o.intToRoman(1234));
	}
}
