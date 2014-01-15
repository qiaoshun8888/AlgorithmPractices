package leetcode;

import java.util.*;

public class Anagrams {

	
	public ArrayList<String> anagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<String> list = null;
        
        for (String str : strs) {
            String s = sort(str);
            if (map.containsKey(s)) {
                list = map.get(s);
            }
            else {
                list = new ArrayList<String>();
            }
            list.add(str);
            map.put(s, list);
        }
        
        // Traverse a HashMap
        // 1) keySet()    2) values()    3) entrySet()
        list = new ArrayList<String>();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            // String key = entry.getKey();
        	ArrayList<String> value = entry.getValue();
        	if (value.size() > 1) list.addAll(value);
        }
        return list;
    }
    
    private String sort(String str) {
        char [] cc = str.toCharArray();
        Arrays.sort(cc);
        return new String(cc);
    }
    
    public static void main(String [] args) {
    	String [] strs = {"tea","and","ate","eat","dan"};
    	
    	Anagrams o = new Anagrams();
    	ArrayList<String> result = o.anagrams(strs);
    	
    	for (String s : result) {
    		System.out.print(s + " ");
    	}
    }
}
