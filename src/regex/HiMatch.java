package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HiMatch {

	public static void main(String[] args) {
		int T;
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		in.nextLine();

		Pattern hiPattern = Pattern.compile("^[Hh][Ii]\\s(?![dD]).*");

		while (T-- > 0) {
			String str = in.nextLine();
			
			Matcher himatcher = hiPattern.matcher(str);

			if (himatcher.matches())
				System.out.println(str);
		}
	}
}
