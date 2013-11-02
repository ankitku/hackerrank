package AI;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcess {

	public static void main(String[] args) {
		int T;
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		in.nextLine();

		Pattern articleA = Pattern.compile("[\\s\"]a[\\s\"]");
		Pattern articleAN = Pattern.compile("[\\s\"]an[\\s\"]");
		Pattern articleTHE = Pattern.compile("[\\s\"]the[\\s\"]");

		Pattern date1 = Pattern
				.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((\\d\\d)?\\d\\d)");
		Pattern date2 = Pattern
				.compile("((0?[1-9]|1[012])/0?[1-9]|[12][0-9]|3[01])/((\\d\\d)?\\d\\d)");
		Pattern date3 = Pattern
				.compile("(0?[1-9]|[12][0-9]|3[01])(th)?,?\\s?(of)?\\s(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)[a-z]*\\s((\\d\\d)?\\d\\d)");
		Pattern date4 = Pattern
				.compile("(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)[a-z]*\\s(0?[1-9]|[12][0-9]|3[01])(th)?,?\\s((\\d\\d)?\\d\\d)");

		while (T-- > 0) {
			String str = in.nextLine();

			if (T > 0)
				in.nextLine();

			str = str.toLowerCase();

			int[] counts = new int[4];

			if (str.startsWith("a "))
				counts[0]++;
			else if (str.startsWith("an "))
				counts[1]++;
			else if (str.startsWith("the "))
				counts[2]++;

			Matcher Amatcher = articleA.matcher(str);
			Matcher ANmatcher = articleAN.matcher(str);
			Matcher THEmatcher = articleTHE.matcher(str);

			Matcher dat1Matcher = date1.matcher(str);
			Matcher dat2Matcher = date2.matcher(str);
			Matcher dat3Matcher = date3.matcher(str);
			Matcher dat4Matcher = date4.matcher(str);

			while (Amatcher.find())
				counts[0]++;

			while (ANmatcher.find())
				counts[1]++;

			while (THEmatcher.find())
				counts[2]++;

			while (dat1Matcher.find() || dat2Matcher.find()
					|| dat3Matcher.find() || dat4Matcher.find())
				counts[3]++;

			for (int l : counts)
				System.out.println(l);
		}
	}
}
