package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 7/3/2022
 */
@LeetCode(
		id = 2325,
		name = "Decode the Message",
		url = "https://leetcode.com/problems/decode-the-message/",
		difficulty = Difficulty.EASY
)
public class DecodeTheMessage {
	public String decodeMessage(String key, String message) {
		Map<Character, Character> map = new HashMap<>();
		char ch = 'a';
		for (char c : key.toCharArray()) {
			if (map.containsKey(c) || c == ' ') {
				continue;
			}

			map.put(c, ch++);
		}

		map.put(' ', ' ');

		StringBuilder sb = new StringBuilder();

		for (char c : message.toCharArray()) {
			sb.append(map.get(c));
		}

		return sb.toString();
	}
}
