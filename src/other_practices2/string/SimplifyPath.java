package other_practices2.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class SimplifyPath {

	/*
	 * Given an absolute path for a file (Unix-style), simplify it.
	 * 
	 * For example, path = "/home/", => "/home" path = "/a/./b/../../c/", =>
	 * "/c" click to show corner cases.
	 * 
	 * Corner Cases: Did you consider the case where path = "/../"? In this
	 * case, you should return "/". Another corner case is the path might
	 * contain multiple slashes '/' together, such as "/home//foo/". In this
	 * case, you should ignore redundant slashes and return "/home/foo".
	 */

	public String simplifyPath(String path) {
		if (path == null || path.length() == 0)
			return path;
		String[] segs = path.substring(1).split("/");
		Stack<String> stack = new Stack<String>();
		for (String seg : segs) {
			if (seg.equals(".") || seg.length() == 0)
				continue;
			if (seg.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(seg);
			}
		}
		List<String> list = new ArrayList<String>(stack);
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s + "/");
		}

		String result = "/" + sb.toString();
		return result.length() == 1 ? result : result.substring(0,
				result.length() - 1);
	}

	public static void main(String[] args) {
		String[] test_paths = { "/home/", "/a/./b/../../c/", "/../", "/",
				"/home//foo/", "/home/foo", };
		String[] expected_paths = { "/home", "/c", "/", "/", "/home/foo",
				"/home/foo", };
		SimplifyPath o = new SimplifyPath();
		for (int i = 0; i < test_paths.length; i++) {
			System.out.println("TEST CASE [" + i + "]:  "
					+ o.simplifyPath(test_paths[i]).equals(expected_paths[i]));
		}
	}

}
