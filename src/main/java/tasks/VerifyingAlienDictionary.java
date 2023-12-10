package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 21-Jul-20
 */
@LeetCode(
		id = 953,
		name = "Verifying an Alien Dictionary",
		url = "https://leetcode.com/problems/verifying-an-alien-dictionary/",
		difficulty = Difficulty.EASY
)
public class VerifyingAlienDictionary {
	public boolean isAlienSorted(String[] words, String order) {
		Map<Character, Character> dict = new HashMap<>();
		for (int i = 0; i < order.length(); i++) {
			dict.put(order.charAt(i), (char) ('a' + i));
		}

		String[] original = new String[words.length];
		String[] sorted = new String[words.length];
		for (int i = 0; i < words.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (char ch : words[i].toCharArray()) {

				sb.append(dict.get(ch));
			}

			original[i] = sb.toString();
			sorted[i] = sb.toString();
		}

		Arrays.sort(sorted);
		for (int i = 0; i < sorted.length; i++) {
			if (!original[i].equals(sorted[i])) {
				return false;
			}
		}

		return true;
	}
}
