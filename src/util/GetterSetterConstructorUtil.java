package util;

import java.util.List;

import model.Variable;

public class GetterSetterConstructorUtil {

	public static final String TAB = "\t";

	public static final String LINE_SEPARATOR = System.lineSeparator();

	public static String generateGetter(Variable v) {
		return TAB + "public " + v.getType() + " get" + v.getName().substring(0, 1).toUpperCase()
				+ v.getName().substring(1) + "() {" + LINE_SEPARATOR + TAB + TAB + "return " + v.getName() + ";"
				+ LINE_SEPARATOR + TAB + "}" + LINE_SEPARATOR;
	}

	public static String generateSetter(Variable v) {
		return TAB + "public void set" + v.getName().substring(0, 1).toUpperCase() + v.getName().substring(1) + "("
				+ v.getType() + " " + v.getName() + ") {" + LINE_SEPARATOR + TAB + TAB + "this." + v.getName() + " = "
				+ v.getName() + ";" + LINE_SEPARATOR + TAB + "}" + LINE_SEPARATOR;
	}

	public static String generateAllArgsConstructor(String className, List<Variable> variableList) {
		String constructor = TAB + "public " + className + "(";
		for (Variable v : variableList) {
			constructor += v.getType() + " " + v.getName() + ", ";
		}
		constructor = constructor.substring(0, constructor.length() - 2);
		constructor += ") {" + LINE_SEPARATOR;
		for (Variable v : variableList) {
			constructor += TAB + TAB + "this." + v.getName() + " = " + v.getName() + ";" + LINE_SEPARATOR;
		}
		return constructor + TAB + "}" + LINE_SEPARATOR;
	}

	public static String generateEmptyArgsConstructor(String className) {
		return TAB + "public " + className + "() {" + LINE_SEPARATOR + TAB + TAB + LINE_SEPARATOR + TAB + "}"
				+ LINE_SEPARATOR;
	}

}
