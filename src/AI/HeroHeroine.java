package AI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HeroHeroine {
	private static HashSet<String> maleCorpus = new HashSet<String>();
	private static HashSet<String> femaleCorpus = new HashSet<String>();

	private static HashSet<String> maleWords = new HashSet<String>();
	private static HashSet<String> femaleWords = new HashSet<String>();

	public static void main(String[] args) {
		String iText;
		
		String[] M = { "he", "him", "his", "man", "gentleman", "men", "boy",
				"boys", "lad", "mr", "mister", "master" };
		String[] F = { "she", "her", "hers", "woman", "lady", "women", "girl",
				"girls", "lass", "mrs", "miss", "missus" };

		maleWords.addAll(Arrays.asList(M));
		femaleWords.addAll(Arrays.asList(F));

		Scanner in = null;
		try {
			in = new Scanner(new File("corpus.txt"), "UTF-8").useDelimiter(".");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (in.hasNext()) {
			iText = in.nextLine();
			
			iText = iText.replace("[^a-z]+", " ");
			iText = iText.replaceAll("[\\.)(,:;'\"]", "");
			iText = iText.toLowerCase();
			
			String[] words = iText.split("\\s");
			
			if (getGender(words) == 1)
				maleCorpus.addAll(Arrays.asList(iText.split(" ")));
			else if (getGender(words) == 2)
				femaleCorpus.addAll(Arrays.asList(iText.split(" ")));

		}

		Set<String> intersection = new HashSet<String>(maleCorpus);
		intersection.retainAll(femaleCorpus);

		for (String word : intersection) {
			maleCorpus.remove(word);
			femaleCorpus.remove(word);
		}

		in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();

		for (int i = 0; i < n; i++) {
			String line = in.nextLine();
			line = line.toLowerCase();
			System.out.println(femaleCorpus.contains(line) ? "Female" : "Male");
		}
	}

	private static int getGender(String[] words) {

		int score = 0;
		for (String word : words)
			if (maleWords.contains(word))
				score++;
			else if (femaleWords.contains(word))
				score--;

		return score > 0 ? 1 : (score < 0 ? 2 : 0);

	}
}