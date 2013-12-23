package javaUtilsPractices;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

public class UP_HashMap {
	
	public static void printAndRemoveMap(Map<String, Integer> map) {
		if (map.size() == 0) {
			System.out.println("Map is empty!");
			return;
		}
		
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)it.next();
			System.out.println("KEY: " + entry.getKey() + " VALUE: " + entry.getValue());
			it.remove(); // avoid concurrentModificationException
		}
	}
	
	public static void main(String [] args) {
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		countMap.put("a", 10);
		countMap.put("b", 20);
		
		ValueComparator vc = new ValueComparator(countMap);
		
		Map<String, Integer> sortedMap = new TreeMap<String, Integer>(vc);
		sortedMap.putAll(countMap);
		System.out.println("size of sortedMap is " + sortedMap.size());
		
		printAndRemoveMap(sortedMap);
	}
}

class ValueComparator implements Comparator<String> {
	
	Map<String, Integer> base;
	
	public ValueComparator() {
		
	}
	
	public ValueComparator(Map<String, Integer> base) {
		this.base = base;
	}
	
	@Override
	public int compare(String a, String b) {
		return base.get(a) >= base.get(b) ? -1 : 1;
		// return 0 will merge keys
	}
}