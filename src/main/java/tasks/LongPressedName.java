package tasks;

import common.LeetCode;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 05-Jun-20
 */
@LeetCode(id = 925, name = "Long Pressed Name", url = "https://leetcode.com/problems/long-pressed-name/")
public class LongPressedName {
	public boolean isLongPressedName(String name, String typed) {
		List<Map.Entry<Character, Integer>> namePairs = shortString(name);
		List<Map.Entry<Character, Integer>> typedPairs = shortString(typed);
		if (namePairs.size() != typedPairs.size()) {
			return false;
		}

		for (int i = 0; i < namePairs.size(); i++) {
			Map.Entry<Character, Integer> namePair = namePairs.get(i);
			Map.Entry<Character, Integer> typedPair = typedPairs.get(i);

			if (namePair.getKey() != typedPair.getKey() || namePair.getValue() > typedPair.getValue()) {
				return false;
			}
		}

		return true;
	}

	private List<Map.Entry<Character, Integer>> shortString(String string) {
		List<Map.Entry<Character, Integer>> pairs = new ArrayList<>();
		char prev = string.charAt(0);
		int count = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == prev) {
				count++;
			}
			else {
				pairs.add(new AbstractMap.SimpleEntry<>(prev, count));
				prev = string.charAt(i);
				count = 0;
			}
		}
		pairs.add(new AbstractMap.SimpleEntry<>(prev, count));

		return pairs;
	}
}
