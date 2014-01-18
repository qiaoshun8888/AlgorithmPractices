package programcreek;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		
		String str = "sjf123jwefhue766wecvd99";
		List<Integer> numbers = new LinkedList<Integer>();
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(str);
		while(m.find()) {
			numbers.add(Integer.parseInt(m.group()));
		}
		
		for (int v : numbers) {
			System.out.print(v + " ");
		}
		System.out.println();
	}
}
