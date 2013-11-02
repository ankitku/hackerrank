package regex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

	public static void main(String[] args) {
		int T;
		TreeSet<String> emailsSet = new TreeSet<String>();
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		in.nextLine();

		Pattern emailPattern = Pattern.compile("(\\.?[A-Za-z0-9_-])*@[A-Za-z0-9_-]*\\.(\\.?[A-Za-z0-9_-]){2,}");
		int n = 0;
		while (T-- > 0) {
			String str = in.nextLine();

			Matcher emailMatcher = emailPattern.matcher(str);
			int i = 1;
			while (emailMatcher.find()) {
				emailsSet.add(emailMatcher.group());
			}
		}

		List<String> emails = new ArrayList<String>();

		for (String s : emailsSet)
			emails.add(s);
		
		Collections.sort(emails);
		int size = emails.size();
		for (int i = 0; i < size; i++) {
			System.out.print(emails.get(i));
			if (i < size - 1)
				System.out.print(";");
		}

	}
}
