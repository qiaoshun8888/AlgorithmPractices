package leetcode;

import java.util.*;

/**
 * RestoreIpAddress.java
 * 
 * Description: Given a string containing only digits, restore it by returning
 * all possible valid IP address combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Feb 1, 2014
 */

public class RestoreIpAddress {

	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> result = new ArrayList<String>();
		if (s == null || s.length() < 4) return result;
		
		char[] cc = s.toCharArray();
		
		Stack<String> stack = new Stack<String>();
		
		restoreIpAddressesHelper(cc, 0, 3, 1, 0, stack, result);
		
		return result;
	}
	
	private void restoreIpAddressesHelper(char[] cc, int index, int winSize, int block, int count, Stack<String> stack, ArrayList<String> result) {
		if (block > 4) {
			if (count == cc.length) {
				List<String> list = new ArrayList<String>(stack);
				StringBuilder sb = new StringBuilder();
				for (String s : list) {
					sb.append(s);
				}
				result.add(sb.toString());
			}
			return;
		}
		
		if (index >= cc.length) return;
		
		for (int i = cc[index] == '0' ? 1: winSize; i > 0; i--) {
			if (index + i > cc.length) continue;
			String ipBlock = generateIpBlock(cc, index, i);
			if (isValidIpBlock(ipBlock)) {
				if (block < 4)
					stack.push(ipBlock+".");
				else
					stack.push(ipBlock);
				restoreIpAddressesHelper(cc, index + i, 3, block + 1, count + ipBlock.length(), stack, result);
				stack.pop();
			}
		}
	}
	
	private String generateIpBlock(char[] cc, int index, int winSize) {
		StringBuilder sb = new StringBuilder();
		for (int i = index; i < index + winSize; i++) {
			sb.append(cc[i]);
		}
		return sb.toString();
	}
	
	private boolean isValidIpBlock(String ipBlock) {
		int ip = Integer.parseInt(ipBlock);
		return ip >= 0 && ip <= 255;
	}
	
	public static void main(String[] args) {
		RestoreIpAddress o = new RestoreIpAddress();
		String s = "010010"; //"25525511135";
		ArrayList<String> result = o.restoreIpAddresses(s); 
		for (String ip : result) {
			System.out.println(ip);
		}
	}
}
