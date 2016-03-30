package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Utility {

	public static <K, V extends Comparable<? super V>> List<Entry<K, V>> SortHashMapByValues(HashMap<K, V> hashMap) {
		List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K, V>>(hashMap.entrySet());
		Collections.sort(sortedEntries, Utility.GetComparator(true));
		return sortedEntries;
	}

	public static <K, V extends Comparable<? super V>> List<Entry<K, V>> SortHashMapByValuesDescending(
			HashMap<K, V> hashMap) {
		List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K, V>>(hashMap.entrySet());
		Collections.sort(sortedEntries, Utility.GetComparator(false));
		return sortedEntries;
	}

	private static <K, V extends Comparable<? super V>> Comparator<Entry<K, V>> GetComparator(boolean ascending) {
		if (ascending) {
			return (new Comparator<Entry<K, V>>() {
				@Override
				public int compare(Entry<K, V> e1, Entry<K, V> e2) {
					return e1.getValue().compareTo(e2.getValue());
				}
			});
		} else {
			return (new Comparator<Entry<K, V>>() {
				@Override
				public int compare(Entry<K, V> e1, Entry<K, V> e2) {
					return e2.getValue().compareTo(e1.getValue());
				}
			});
		}
	}
}
