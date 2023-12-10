package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 8/8/2021
 */
@LeetCode(
		id = 1961,
		name = "Check If String Is a Prefix of Array",
		url = "https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/",
		difficulty = Difficulty.EASY
)
public class CheckIfStringIsPrefixOfArray {
	public boolean isPrefixString(String s, String[] words) {
		char[] chars = s.toCharArray();
		int pos = 0;
		for (String word : words) {
			for (char ch : word.toCharArray()) {
				if (pos == chars.length || chars[pos++] != ch) {
					return false;
				}
			}

			if (pos == chars.length) {
				return true;
			}
		}

		return pos == chars.length;
	}
}
