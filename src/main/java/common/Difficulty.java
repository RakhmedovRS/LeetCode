package common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 11/14/2020
 */
public enum Difficulty {
	EASY("Easy"),
	MEDIUM("Medium"),
	HARD("Hard"),
	UNDEFINED("Undefined");

	final String name;
	final static Map<String, Difficulty> stringMap = new HashMap<>();

	static {
		for (Difficulty difficulty : Difficulty.values()) {
			stringMap.put(difficulty.name, difficulty);
		}
	}

	Difficulty(String name) {
		this.name = name;
	}

	public static Difficulty getByName(String name) {
		return stringMap.getOrDefault(name, Difficulty.UNDEFINED);
	}
}
