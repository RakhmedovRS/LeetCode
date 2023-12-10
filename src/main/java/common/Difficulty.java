package common;

/**
 * @author RakhmedovRS
 * @created 11/14/2020
 */
public enum Difficulty {
	EASY("Easy"),
	MEDIUM("Medium"),
	HARD("Hard"),
	UNDEFINED("Undefined");

	String name;

	Difficulty(String name) {
		this.name = name;
	}
}
