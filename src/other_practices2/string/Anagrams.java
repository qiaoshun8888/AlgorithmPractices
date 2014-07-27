package other_practices2.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	/*
	 * Given an array of strings, return all groups of strings that are
	 * anagrams.
	 * 
	 * Note: All inputs will be in lower-case.
	 */

	public List<String> anagrams(String[] strs) {
		List<String> list = new ArrayList<String>();
		if (strs == null || strs.length == 0)
			return list;
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			String key = sort(str);
			if (map.containsKey(key)) {
				map.get(key).add(str);
			} else {
				map.put(key, new ArrayList<String>(Arrays.asList(str)));
			}
		}

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			List<String> tmpList = entry.getValue(); 
			if (tmpList.size() > 1) {
				list.addAll(tmpList);
			}
		}

		return list;
	}

	private String sort(String str) {
		char[] cc = str.toCharArray();
		Arrays.sort(cc);
		return new String(cc);
	}

	public static void main(String[] args) {
		String[] strs = { "tea", "and", "ate", "eat", "dan" };

		Anagrams o = new Anagrams();
		List<String> result = o.anagrams(strs);

		for (String s : result) {
			System.out.print(s + " ");
		}
	}
}
