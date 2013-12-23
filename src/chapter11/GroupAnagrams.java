package chapter11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedList;

public class GroupAnagrams {
	
	private String orderAnagram(String s) {
		char [] cc = s.toCharArray();
		java.util.Arrays.sort(cc);
		return new String(cc);
	}

	public void group(String [] vs) {
		int anagrams_id = 0;
		int [] ids = new int[vs.length];
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		for (int i = 0; i < vs.length; i++) {
			String n_s = orderAnagram(vs[i]);
			if (!table.containsKey(n_s)) {
				table.put(n_s, anagrams_id);
				ids[i] = anagrams_id++;
			}
			else {
				ids[i] = table.get(n_s);
			}
		}
		
		ArrayList<String> list = new ArrayList<String>();
		for (int ID = 0; ID <= anagrams_id; ID++) {
			for (int i = 0; i < ids.length; i++) {
				if (ids[i] == ID) {
					list.add(vs[i]);
				}
			}
		}
		
		for (String s : list) {
			System.out.print(s + " , ");
		}
	}
	
	public void groupByHashTable(String [] vs) {
		Hashtable<String, LinkedList<String>> table = new Hashtable<String, LinkedList<String>>();
		for (String s : vs) {
			String key = orderAnagram(s);
			if (!table.containsKey(key)) {
				table.put(key, new LinkedList<String>());
			}
			LinkedList<String> list = table.get(key);
			list.push(s); // insert the element at the front of the stack
		}
		
		int index = 0;
		for (String key : table.keySet()) {
			LinkedList<String> list = table.get(key);
			for (String s : list) {
				vs[index++] = s;
			}
		}
		
		for (String s : vs) {
			System.out.print(s + " , ");
		}
	}
	
	public static void main(String [] args) {
		String [] vs = {"hello", "dlrow", "hlloe", "world", "w", "he", "hello world", "olleh"};
		GroupAnagrams ga = new GroupAnagrams();
		ga.group(vs);
		System.out.println("\n");
		ga.groupByHashTable(vs);
	}
}

class AnagramComparator implements Comparator<String> {

	private String sortChars(String s) {
		char [] cc = s.toCharArray();
		java.util.Arrays.sort(cc);
		return new String(cc);
	}
	
	@Override
	public int compare(String o1, String o2) {
		return sortChars(o1).compareTo(sortChars(o2));
	}
	
	
}