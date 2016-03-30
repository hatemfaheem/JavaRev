package common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class FileContentIterator implements Iterator<List<String>> {

	private Iterator<Path> paths;

	public FileContentIterator(String directory) {
		try {
			Stream<Path> pathsStream = Files.walk(Paths.get(directory))
					.filter(path -> path.toString().endsWith(".new"));
			this.paths = pathsStream.iterator();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean hasNext() {
		return this.paths.hasNext();
	}

	@Override
	public List<String> next() {
		String filepath = this.paths.next().toString();
		ArrayList<String> lines = new ArrayList<String>();

		BufferedReader bufferedReader = null;

		try {

			bufferedReader = new BufferedReader(new FileReader(filepath));

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return lines;
	}
}
