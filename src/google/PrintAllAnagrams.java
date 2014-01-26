package google;

import java.util.*;

/**
 *	PrintAllAnagrams.java
 *
 *	Description: Imagine you had a dictionary. How would you print all anagrams of a word?
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Jan 26, 2014
 */

public class PrintAllAnagrams {

	public static Map<String, LinkedList<String>> anagrams(String [] strs) {
		Map<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		if (strs == null) return map;
		
		for (String s : strs) {
			char [] cc = s.toCharArray();
			Arrays.sort(cc);
			String key = new String(cc).toLowerCase();
			LinkedList<String> list = null;
			if (!map.containsKey(key)) {
				list = new LinkedList<String>();
				map.put(key, list);
			}
			else {
				list = map.get(key);
			}
			list.add(s);
		}
		
		return map;
	}
	
	public static void main(String[] args) {
		String [] strs = {"hello", "llohe", "tea", "eat", "aet", "dog", "god", "dgo"};
		Map<String, LinkedList<String>> map = anagrams(strs);
		
		for (Map.Entry<String, LinkedList<String>> entry: map.entrySet()) {
			System.out.println("[" + entry.getKey() + "]: " + entry.getValue());
		}
	}
}
