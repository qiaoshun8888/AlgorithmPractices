package programcreek.top10InterviewQuestions.stringArray;

import java.util.*;

public class WordLadder {

	/**
	 * Given two words (start and end), and a dictionary, find the length of
	 * shortest transformation sequence from start to end, such that:
	 * 
	 * Only one letter can be changed at a time Each intermediate word must
	 * exist in the dictionary For example,
	 * 
	 * Given: 
	 * 
	 * 		start = "hit" 
	 * 
	 * 		end = "cog" 
	 * 
	 * 		dict = ["hot","dot","dog","lot","log"]
	 * 
	 * 
	 * As one shortest transformation is 
	 * 
	 * 		"hit" -> "hot" -> "dot" -> "dog" -> "cog", 
	 * 
	 * return its length 5.
	 * 
	 * Note: Return 0 if there is no such transformation sequence. All words
	 * have the same length. All words contain only lowercase alphabetic
	 * characters.
	 * 
	 * */

	public int ladderLength(String start, String end, HashSet<String> dict) {
		if (start == null || start.length() == 0 || dict == null
				|| dict.size() == 0)
			return 0;
		
		dict.add(end);
		
		LinkedList<String> stringQueue = new LinkedList<String>();
		LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
		
		stringQueue.add(start);
		distanceQueue.add(1);
		
		while(!stringQueue.isEmpty()) {
			String str = stringQueue.pop();
			int distance = distanceQueue.pop();
			
			if (str.equals(end)) return distance;
			
			for (int i = 0; i < str.length(); i++) {
				char [] cc = str.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					cc[i] = c;
					String temp = new String(cc);
					if (dict.contains(temp)) {
						// System.out.println(temp);
						stringQueue.add(temp);
						distanceQueue.add(distance + 1);
						// remove visited nodes
						dict.remove(temp);
					}
				}
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		WordLadder o = new WordLadder();
		
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
		String start = "hit", end = "cog";
		
		System.out.println(o.ladderLength(start, end, dict));
	}
}
