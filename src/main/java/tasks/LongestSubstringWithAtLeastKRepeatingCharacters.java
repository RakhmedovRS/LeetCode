package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/26/2020
 */
@LeetCode(
		id = 395,
		name = "Longest Substring with At Least K Repeating Characters",
		url = "https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/",
		difficulty = Difficulty.MEDIUM
)
public class LongestSubstringWithAtLeastKRepeatingCharacters {
	public int longestSubstring(String s, int k) {
		int len = 0;

		int left = 0;
		while (left < s.length()) {
			int[] freq = new int[26];
			for (int right = left; right < s.length(); right++) {
				freq[s.charAt(right) - 'a']++;
				if (isValid(freq, k)) {
					len = Math.max(len, 1 + right - left);
				}
			}

			int i = left;
			while (i < s.length() && s.charAt(left) == s.charAt(i)) {
				i++;
			}

			left = i;
		}

		return len;
	}

	private boolean isValid(int[] freq, int k) {
		for (int f : freq) {
			if (f != 0 && f < k) {
				return false;
			}
		}

		return true;
	}
}
