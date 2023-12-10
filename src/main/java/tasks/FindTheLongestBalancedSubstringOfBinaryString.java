package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 4/2/2023
 */
@LeetCode(
		id = 2609,
		name = "Find the Longest Balanced Substring of a Binary String",
		url = "https://leetcode.com/problems/find-the-longest-balanced-substring-of-a-binary-string/description/",
		difficulty = Difficulty.EASY
)
public class FindTheLongestBalancedSubstringOfBinaryString {
	public int findTheLongestBalancedSubstring(String s) {
		int max = 0;
		int pos = 0;
		while (pos < s.length()) {
			int z = 0;
			int o = 0;
			while (pos < s.length() && s.charAt(pos) == '0') {
				z++;
				pos++;
			}

			while (pos < s.length() && s.charAt(pos) == '1') {
				o++;
				if (z >= o) {
					max = Math.max(max, o * 2);
				}
				pos++;
			}
		}

		return max;
	}
}
