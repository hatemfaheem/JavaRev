package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// Iterable<List<String>> fileContents = DataReader.ReadWikiArticles();
		
		List<String> grams = GenerateNGrams("hatem mustafa", 3);
		for (String gram : grams)
		{
			System.out.println(gram);
		}
	}

	private static List<String> GenerateNGrams(String sentence, int maxGrams)
	{
		ArrayList<String> ngrams = new ArrayList<String>();
		String [] tokensArr = sentence.split(" ");
		List<String> tokens = Arrays.asList(tokensArr);
		for (int gramLen=1; gramLen<=maxGrams; gramLen++)
		{
			for (int i=0; i<tokensArr.length - gramLen + 1; i++)
			{
				String gram = String.join(" ", (tokens.subList(i, i + gramLen)));
				ngrams.add(gram);
			}
		}
		
		return ngrams;
	}
	
}
