package AI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AppleClassifier {
	private static HashSet<String> iCorpus = new HashSet<String>();
	private static HashSet<String> fCorpus = new HashSet<String>();

	public static void main(String[] args){
		String iText;
		try {
			iText = new Scanner(new File("apple-computers.txt"), "UTF-8")
					.useDelimiter("\\A").next();
			iText = iText.replace("[^a-z]+", " ");
			iCorpus.addAll(Arrays.asList(iText.split(" ")));

			String fText = new Scanner(new File("apple-fruit.txt")).useDelimiter(
					"\\A").next();
			fText = fText.replace("[^a-z]+", " ");
			fCorpus.addAll(Arrays.asList(fText.split(" ")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Set<String> intersection = new HashSet<String>(iCorpus);
		intersection.retainAll(fCorpus);

		for (String word : intersection) {
			iCorpus.remove(word);
			fCorpus.remove(word);
		}

		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());

		for (int i = 0; i < n; i++) {
			String line = in.nextLine();
			System.out.println(IsFruit(line) ? "fruit" : "computer-company");
		}
	}

	private static boolean IsFruit(String text) {
		String pureText = text.replaceAll("[^A-Za-z]+", " ");

		if (IsStartedWithLowLetter(pureText))
			return true;

		if (IsIContext(pureText))
			return false;

		return true;
	}

	private static boolean IsIContext(String text) {
		String[] words = text.toLowerCase().split(" ");
		int score = 0;
		for (String word : words)
			if (iCorpus.contains(word))
				score++;
			else if (fCorpus.contains(word))
				score--;
		
		return score>0?true:false;
	}

	private static boolean IsStartedWithLowLetter(String text) {
		String lowText = text.toLowerCase();
		return text.contains(" apple ") || text.endsWith(" apple")
				|| lowText.startsWith("apples ")
				|| lowText.contains(" apples ") || lowText.endsWith(" apples");
	}
}