package model;

import java.util.ArrayList;
import java.util.List;

public class FileContent {

	private List<String> lines;

	public FileContent() {
		lines = new ArrayList<String>();
	}

	public FileContent(List<String> lines) {
		this.lines = lines;
	}

	public void addLine(String line) {
		lines.add(line);
	}

	public void addLine(String line, int indexLine) {
		lines.add(indexLine, line);
	}

	public void addLines(List<String> lines, int indexLine) {
		for (String s : lines) {
			this.lines.add(indexLine++, s);
		}
	}
	
	/**
	 * Returns line of last "}".
	 * @return line of last "}". -1 if not found.
	 */
	public int getLastLineClass() {
		for (int i = lines.size() - 1; i >= 0; i--) {
			if (lines.get(i).contains("}")) {
				return i;
			}
		}
		return -1;
	}
	
	public List<Variable> getVariables() {
		List<Variable> variableList = new ArrayList<Variable>();
		for (String s: lines) {
			Variable v = checkVariable(s);
			if (v != null) {
				variableList.add(v);
			}
		}
		return variableList;
	}

	private Variable checkVariable(String s) {
		return null;
	}

	public String getLine(int indexLine) {
		return lines != null && lines.size() > indexLine ? lines.get(indexLine) : null;
	}

	public String toString() {
		String str = "";
		for (String s : lines) {
			str += s + System.lineSeparator();
		}
		return str;
	}

}
