package regex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLlinks {

	public static void main(String[] args) {
		int T;
		TreeSet<String> divset = new TreeSet<String>();
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		in.nextLine();

		Pattern linksPattern = Pattern
				.compile("<a href=\"((((http:)?(\\/)+[A-Za-z0-9_-]*)*:?.*?))\".*?\">(.*?)<\\/");
		//<a href=\"((http:)?((\/)*?[A-Za-z0-9_-]*\.?)+\") 
		int n = 0;
		while (T-- > 0) {
			String str = in.nextLine();

			Matcher tagMatcher = linksPattern.matcher(str);
			int i = 1;
			while (tagMatcher.find()) {
				String a = tagMatcher.group(1) != null ? tagMatcher.group(1)
						: "";
				String b = tagMatcher.group(6) != null ? tagMatcher.group(5)
						: "";

				divset.add(a + "," + b);
			}
		}

		List<String> divs = new ArrayList<String>();

		for (String s : divset)
			divs.add(s);

		Collections.sort(divs);
		int size = divs.size();
		for (int i = 0; i < size; i++) {
			System.out.println(divs.get(i));
		}

	}
}
