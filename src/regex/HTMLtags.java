package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLtags {

	public static void main(String[] args) {
		int T;
		TreeSet<String> divset = new TreeSet<String>();
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		in.nextLine();

		Pattern hiPattern = Pattern.compile("</\\s*(.*?)\\s*>");
		int n = 0;
		while (T-- > 0) {
			String str = in.nextLine();

			Matcher tagMatcher = hiPattern.matcher(str);
			int i = 1;
			while (tagMatcher.find()) {
				divset.add(tagMatcher.group(1));
			}
		}

		List<String> divs = new ArrayList<String>();

		for (String s : divset)
			divs.add(s);
		int size = divs.size();
		for (int i = 0; i < size; i++) {
			System.out.print(divs.get(i));
			if (i < size - 1)
				System.out.print(";");
		}

	}
}
