package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-03-23
 */
@LeetCode(
		id = 3090,
		name = "Maximum Length Substring With Two Occurrences",
		url = "https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/description/",
		difficulty = Difficulty.EASY
)
public class MaximumLengthSubstringWithTwoOccurrences {
	public int maximumLengthSubstring(String s) {
		int max = 0;
		outer:
		for (int i = 0; i < s.length(); i++) {
			int[] memo = new int[26];
			for (int j = i; j < s.length(); j++) {
				memo[s.charAt(j) - 'a']++;
				if (memo[s.charAt(j) - 'a'] <= 2) {
					max = Math.max(max, 1 + j - i);
				} else {
					continue outer;
				}
			}
		}

		return max;
	}
}