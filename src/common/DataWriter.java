package common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map.Entry;

public class DataWriter {
	public static <K, V> void WriteToFile(List<Entry<K, V>> entries, String filepath) {
		try {
			File file = new File(filepath);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
			Writer writer = new BufferedWriter(outputStreamWriter);
			for (Entry<K, V> entry : entries) {
				writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
