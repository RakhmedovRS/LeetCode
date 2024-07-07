package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-07-06
 */
@LeetCode(
		id = 3210,
		name = "Find the Encrypted String",
		url = "https://leetcode.com/problems/find-the-encrypted-string/description/",
		difficulty = Difficulty.EASY
)
public class FindTheEncryptedString {
	public String getEncryptedString(String s, int k) {
		char[] original = s.toCharArray();
		char[] result = new char[s.length()];
		for (int i = 0; i < result.length; i++) {
			result[i] = original[(i + k) % s.length()];
		}
		return String.valueOf(result);
	}
}