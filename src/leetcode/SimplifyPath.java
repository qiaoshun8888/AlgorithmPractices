package leetcode;

import java.util.*;

/**
 * SimplifyPath.java
 * 
 * Description: Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example, path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c"
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Feb 1, 2014
 */

public class SimplifyPath {

	public String simplifyPath(String path) {
		if (path == null || path.length() == 0)
			return new String();
		String[] strs = path.substring(1).split("/");
		Stack<String> stack = new Stack<String>();
		for (String s : strs) {
			if (s.equals(".") || s.length() == 0)
				continue;
			if (s.equals("..")) {
				if (!stack.isEmpty())
					stack.pop();
			} else {
				stack.push(s);
			}
		}

		StringBuilder sb = new StringBuilder();
		ArrayList<String> list = new ArrayList<String>(stack);
		for (String s : list) {
			sb.append(s + "/");
		}

		String result = "/" + sb.toString();
		return result.length() == 1 ? result : result.substring(0,
				result.length() - 1);
	}

	public static void main(String[] args) {
		SimplifyPath o = new SimplifyPath();
		String str = "/abc/..."; // "/home//foo/"; //"/a/./b/../../c/";
		System.out.println(o.simplifyPath(str));
	}
}
