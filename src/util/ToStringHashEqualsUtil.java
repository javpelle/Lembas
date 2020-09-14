package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Variable;

public class ToStringHashEqualsUtil {
	public static final String[] PRIMITIVE_TYPE_LIST = { "byte", "short", "int", "long", "float", "double", "boolean",
			"char" };

	public static final String TAB = "\t";

	public static final String LINE_SEPARATOR = System.lineSeparator();

	public static String generateToString(String className, List<Variable> variableList) {
		String str = TAB + "@Override" + LINE_SEPARATOR + TAB + "public String toString() {" + LINE_SEPARATOR + TAB
				+ TAB + "return \"" + className + " [";
		String strAux = "";
		for (Variable v : variableList) {
			strAux += " + \", " + v.getName() + "=\" + " + v.getName();
		}
		str += strAux.substring(6) + " + \"]\";" + LINE_SEPARATOR + TAB + "}" + LINE_SEPARATOR;
		return str;
	}

	public static String generateEquals(String className, List<Variable> variableList) {
		String str = TAB + "@Override" + LINE_SEPARATOR +
				TAB + "public boolean equals(Object obj) {" + LINE_SEPARATOR +
				TAB + TAB + "if (this == obj)" + LINE_SEPARATOR +
				TAB + TAB + TAB + "return true;" + LINE_SEPARATOR +
				TAB	+ TAB + "if (obj == null)" + LINE_SEPARATOR +
				TAB + TAB + TAB + "return false;" + LINE_SEPARATOR +
				TAB + TAB + "if (getClass() != obj.getClass())" + LINE_SEPARATOR +
				TAB + TAB + TAB + "return false;" + LINE_SEPARATOR + 
				TAB + TAB + className + " other = (" + className + ") obj;" + LINE_SEPARATOR;
		for (Variable v : variableList) {
			str += Arrays.asList(PRIMITIVE_TYPE_LIST).contains(v.getType()) ? conditionalEqualsPrimitive(v)
					: conditionalEqualsObject(v);
		}
		return str + TAB + TAB + "return true;" + LINE_SEPARATOR + TAB + "}" + LINE_SEPARATOR;
	}
	
	private static String conditionalEqualsPrimitive(Variable v) {
		return TAB + TAB + "if (" + v.getName() + " != other." + v.getName() + ")" + LINE_SEPARATOR +
				TAB + TAB + TAB + "return false;" + LINE_SEPARATOR;
	}
	
	private static String conditionalEqualsObject(Variable v) {
		return TAB + TAB + "if (" + v.getName() + " == null) {" + LINE_SEPARATOR +
				TAB + TAB + TAB + "if (other." + v.getName() + " != null)" + LINE_SEPARATOR +
				TAB + TAB + TAB + TAB + "return false;" + LINE_SEPARATOR +
				TAB + TAB + "} else if (!" + v.getName() + ".equals(other." + v.getName() + "))" + LINE_SEPARATOR + 
				TAB + TAB + TAB + "return false;" + LINE_SEPARATOR;
	}


	public static void main(String[] args) {
		Variable v1 = new Variable("String", "type");
		Variable v2 = new Variable("String", "name");
		Variable v3 = new Variable("int", "pedo");
		List<Variable> variableList = new ArrayList<Variable>();
		variableList.add(v1);
		variableList.add(v2);
		variableList.add(v3);
		System.out.print(generateEquals("Variable", variableList));
		System.out.print(generateToString("Variable", variableList));
		System.out.print(BuilderUtil.generateBuilder("Variable", variableList));
		System.out.print(GetterSetterConstructorUtil.generateAllArgsConstructor("Variable", variableList));
		System.out.print(GetterSetterConstructorUtil.generateEmptyArgsConstructor("Variable"));
		for (Variable v : variableList) {
			System.out.print(GetterSetterConstructorUtil.generateGetter(v));
			System.out.print(GetterSetterConstructorUtil.generateSetter(v));
		}
	}
}
