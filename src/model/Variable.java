package model;

public class Variable {

	/**
	 * Variable type.
	 */
	private String type;

	/**
	 * Variable name.
	 */
	private String name;

	public Variable(String type, String name) {
		this.type = type;
		this.name = name;
	}

	/**
	 * Returns variable type String.
	 * @return type String
	 */
	public String getType() {
		return type;
	}

	/**
	 * Returns variable name String.
	 * @return name String
	 */
	public String getName() {
		return name;
	}

}
