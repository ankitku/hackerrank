package AI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Abbreviations {

	public static void main(String[] args) {
		int t, t2;
		List<String> abbvList = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
		t = in.nextInt();
		t2 = 2 * t;
		in.nextLine();

		Map<String, String> abbvMap = new HashMap<String, String>();

		Pattern abbvPattern = Pattern.compile("([A-Z]\\S*(\\s(of|for|and|the))*)");

		while (t2-- > t) {
			String str = in.nextLine();
			abbvList = new ArrayList<String>();
			List<String> tempAbbvList = new ArrayList<String>();
			
			Matcher abbvMatcher = abbvPattern.matcher(str);

			while (abbvMatcher.find()) {
				String s = abbvMatcher.group(1);
				s = s.replaceAll("[.)(,]", "");
				if ("The".equals(s))
					continue;

				if (s.matches("[A-Z]*") && !tempAbbvList.contains(s))
					tempAbbvList.add(s);
				else
					abbvList.add(s);
			}
			
			String initials = "";
			for(String s: abbvList)
				initials+=s.charAt(0);

			for (String abbv : tempAbbvList) {				
				int begin = 0, end = 0;
				
				begin = initials.indexOf(abbv);
				end = begin + abbv.length() - 1;
				
				if(begin == -1)
					continue;
				
				String value = "";
				for(int i = begin; i<= end; i++)
				{
					value+=abbvList.get(i);
					if(i < end)
						value+=" ";
				}
				abbvMap.put(abbv, value);
				
				abbvList.removeAll(abbvList.subList(begin, end));
				begin = (begin == 0)?0:begin-1;
				end = (end == initials.length()-1)?initials.length()-1:end+1;
				initials = initials.subSequence(0, begin).toString() + initials.subSequence(end, initials.length()-1);
			}

		}
		
		while(t-- > 0)
		{
			String str = in.nextLine();
			System.out.println(abbvMap.get(str));
		}

		in.close();
	}
}
