package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

import text.processing.Ngrams;

public class Main {

	public static void main(String[] args) {
		// Iterable<List<String>> fileContents = DataReader.ReadWikiArticles();

		Ngrams ngrams = new Ngrams();
		HashMap<String, Integer> counts = new HashMap<String, Integer>();
		ngrams.CountNgrams("hatem mustafa faheem mohamed elseidy hatem mustafa faheem", counts, 3);
		Iterator it = counts.entrySet().iterator();
		while (it.hasNext()) {
			HashMap.Entry pair = (HashMap.Entry) it.next();
			System.out.println(pair.getKey() + " : " + pair.getValue());
		}

	}
}
