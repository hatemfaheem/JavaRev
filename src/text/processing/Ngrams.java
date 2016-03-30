package text.processing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import common.Utility;

public class Ngrams {
	public List<Entry<String, Integer>> CountNgrams(Iterable<List<String>> data, int maxGrams) {
		HashMap<String, Integer> counts = new HashMap<String, Integer>();
		System.out.println("Counting ...");
		this.CountNgrams(data, counts, maxGrams);
		System.out.println("Sorting ...");
		List<Entry<String, Integer>> sortedEntries = Utility.SortHashMapByValuesDescending(counts);
		return sortedEntries;
	}

	public List<Entry<String, Integer>> CountNgrams(List<String> sentences, int maxGrams) {
		HashMap<String, Integer> counts = new HashMap<String, Integer>();
		this.CountNgrams(sentences, counts, maxGrams);
		List<Entry<String, Integer>> sortedEntries = Utility.SortHashMapByValuesDescending(counts);
		return sortedEntries;
	}

	public List<Entry<String, Integer>> CountNgrams(String sentence, int maxGrams) {
		HashMap<String, Integer> counts = new HashMap<String, Integer>();
		this.CountNgrams(sentence, counts, maxGrams);
		List<Entry<String, Integer>> sortedEntries = Utility.SortHashMapByValuesDescending(counts);
		return sortedEntries;
	}

	// ============================================================================

	private void CountNgrams(Iterable<List<String>> data, HashMap<String, Integer> counts, int maxGrams) {
		for (List<String> content : data) {
			this.CountNgrams(content, counts, maxGrams);
		}
	}

	private void CountNgrams(List<String> sentences, HashMap<String, Integer> counts, int maxGrams) {
		for (String sentence : sentences) {
			this.CountNgrams(sentence, counts, maxGrams);
		}
	}

	private void CountNgrams(String sentence, HashMap<String, Integer> counts, int maxGrams) {
		List<String> grams = this.GenerateNGrams(sentence, maxGrams);
		for (String gram : grams) {
			if (!counts.containsKey(gram)) {
				counts.put(gram, 1);
			} else {
				counts.put(gram, counts.get(gram) + 1);
			}
		}
	}

	// ============================================================================

	private List<String> GenerateNGrams(String sentence, int maxGrams) {
		sentence = Preprocessor.Preprocess(sentence);
		ArrayList<String> ngrams = new ArrayList<String>();
		String[] tokensArr = sentence.split(" ");
		List<String> tokens = Arrays.asList(tokensArr);
		for (int gramLen = 1; gramLen <= maxGrams; gramLen++) {
			for (int i = 0; i < tokensArr.length - gramLen + 1; i++) {
				String gram = String.join(" ", (tokens.subList(i, i + gramLen)));
				ngrams.add(gram);
			}
		}

		return ngrams;
	}
}
