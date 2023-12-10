package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/29/2020
 */
@LeetCode(
		id = 159,
		name = "Longest Substring with At Most Two Distinct Characters",
		url = "https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int[] table = new int[1 + 'z' - 'A'];
		int max = 0;
		for (int left = 0, right = 0; right < s.length(); right++) {
			table[s.charAt(right) - 'A']++;

			while (!isValid(table)) {
				table[s.charAt(left++) - 'A']--;
			}

			max = Math.max(max, 1 + right - left);
		}

		return max;
	}

	private boolean isValid(int[] table) {
		int count = 0;
		for (int i = 0; i < table.length && count <= 2; i++) {
			if (table[i] > 0) {
				count++;
			}
		}

		return count <= 2;
	}

	public static void main(String[] args) {
		System.out.println(new LongestSubstringWithAtMostTwoDistinctCharacters().lengthOfLongestSubstringTwoDistinct("abZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZYX"));
		System.out.println(new LongestSubstringWithAtMostTwoDistinctCharacters().lengthOfLongestSubstringTwoDistinct("ababffzzeee"));
		System.out.println(new LongestSubstringWithAtMostTwoDistinctCharacters().lengthOfLongestSubstringTwoDistinct("ccaabbb"));
		System.out.println(new LongestSubstringWithAtMostTwoDistinctCharacters().lengthOfLongestSubstringTwoDistinct("eceba"));
	}
}
