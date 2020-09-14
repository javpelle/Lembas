package util;

import java.util.List;

import model.Variable;

public class BuilderUtil {
	
	public static final String TAB = "\t";

	public static final String LINE_SEPARATOR = System.lineSeparator();
	
	public static String generateBuilder(String className, List<Variable> variableList) {
		String build = generateBuilderMethod(className) + LINE_SEPARATOR;
		build += TAB + "public class " + className + "Builder {" + LINE_SEPARATOR;
		for (Variable v : variableList) {
			build += TAB + TAB + "private " + v.getType() + " " + v.getName() + ";" + LINE_SEPARATOR + LINE_SEPARATOR;
		}
		for (Variable v : variableList) {
			build += generateSetterBuilder(className, v) + LINE_SEPARATOR;
		}
		build += generateBuildMethod(className, variableList) + LINE_SEPARATOR;
		build += TAB + "}" + LINE_SEPARATOR;
		return build;
	}

	private static String generateBuilderMethod(String className) {
		return TAB + "public " + className + "Builder builder() {" + LINE_SEPARATOR + TAB + TAB + "return new "
				+ className + "Builder();" + LINE_SEPARATOR + TAB + "}" + LINE_SEPARATOR;
	}

	private static String generateSetterBuilder(String className, Variable v) {
		return TAB + TAB + "public " + className + "Builder " + v.getName() + "(" + v.getType() + " " + v.getName() + ") {"
				+ LINE_SEPARATOR + TAB + TAB + TAB + "this." + v.getName() + " = " + v.getName() + ";" + LINE_SEPARATOR
				+ TAB + TAB + TAB + "return this;" + LINE_SEPARATOR + TAB + TAB + "}" + LINE_SEPARATOR;
	}

	private static String generateBuildMethod(String className, List<Variable> variableList) {
		String build = TAB + TAB + "public " + className + " build() {" + LINE_SEPARATOR + TAB + TAB + TAB
				+ "return new " + className + "(";
		for (Variable v : variableList) {
			build += v.getName() + ", ";
		}
		build = build.substring(0, build.length() - 2);
		build += ");" + LINE_SEPARATOR + TAB + TAB + "}" + LINE_SEPARATOR;
		return build;
	}

}
