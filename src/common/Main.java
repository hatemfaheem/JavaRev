package common;

import java.util.List;
import java.util.Map.Entry;

import text.processing.Ngrams;

public class Main {

	public static void main(String[] args) {
		Iterable<List<String>> fileContents = DataReader.ReadWikiArticles();
		Ngrams ngrams = new Ngrams();
		System.out.println("Getting Ngrams ...");
		List<Entry<String, Integer>> entries = ngrams.CountNgrams(fileContents, 3);
		System.out.println("Writing to file ...");
		DataWriter.WriteToFile(entries, "/home/hatemfaheem/workspace/JavaRev/output/ngrams.txt");
		System.out.println("Dic Size = " + entries.size());
		System.out.println("Done.");
	}
}
