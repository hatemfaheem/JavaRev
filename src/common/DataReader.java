package common;

import java.util.Iterator;
import java.util.List;

public class DataReader {

	public static Iterable<List<String>> ReadWikiArticles() {
		return new Iterable<List<String>>() {
			@Override
			public Iterator<List<String>> iterator() {
				return new FileContentIterator(Constants.WIKI_PATH);
			}
		};
	}
}
