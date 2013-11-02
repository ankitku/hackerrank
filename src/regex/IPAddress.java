package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddress {

	public static void main(String[] args) {
		int T;
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		in.nextLine();

		Pattern ipv4 = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
		Pattern ipv6 = Pattern.compile("([0-9|a-f]{1,4}:){7}([0-9|a-f]{1,4})");

		while (T-- > 0) {
			String str = in.nextLine();
			str = str.replaceAll("\\s", "");
			str = str.toLowerCase();
			
			Matcher ipv4matcher = ipv4.matcher(str);
			Matcher ipv6matcher = ipv6.matcher(str);

			if (ipv4matcher.matches())
				System.out.println("IPv4");
			else
			if (ipv6matcher.matches())
				System.out.println("IPv6");
			else
				System.out.println("Neither");
		}
	}
}
