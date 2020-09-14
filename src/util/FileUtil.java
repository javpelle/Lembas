package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.FileContent;
import model.Variable;

public class FileUtil {

	public static final String TAB = "\t";

	public static final String LINE_SEPARATOR = System.lineSeparator();

	/**
	 * Reads the content from a file.
	 * 
	 * @param path Name of the file to be readed.
	 * @return The content of the file in the form of a String.
	 */
	public static String readFile(String path) {
		File originalFile = new File(path);
		String content = "";
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(originalFile));
			String line = reader.readLine();

			while (line != null) {
				content = content + line + System.lineSeparator();
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {

		}
		return content;
	}

	/**
	 * Writes in a file.
	 * 
	 * @param path    Name of the file where we need to write.
	 * @param content Text we want to write on the file.
	 */
	public static void writeFile(String path, String content) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(content);
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Return variable List from file content.
	 * 
	 * @param content file content.
	 * @return List of variables.
	 */
	public static List<Variable> getVariablesFromFileContent(FileContent fileContent) {
		return fileContent.getVariables();
	}

//	public static void main(String[] args) {
//		System.out.print(generateSetter(new Variable("Long", "number")));
//		System.out.print(generateBuilderMethod("Tarjeta"));
//		List<Variable> l = new ArrayList<Variable>();
//		l.add(new Variable("Long", "id"));
//		l.add(new Variable("List<String>", "list"));
//		System.out.print(generateBuilder("Tarjeta", l));
//		System.out.print(generateAllArgsConstructor("Tarjeta", l));
//	}

		
}
