package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 03-Aug-20
 */
@LeetCode(id = 424, name = "Longest Repeating Character Replacement", url = "https://leetcode.com/problems/longest-repeating-character-replacement/")
public class LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
		int[] memo = new int[26];
		int left = 0;
		int max = 0;
		int currMax = 0;
		for (int right = 0; right < s.length(); right++) {
			memo[s.charAt(right) - 'A']++;
			currMax = Math.max(currMax, memo[s.charAt(right) - 'A']);
			while (1 + right - left - currMax > k) {
				memo[s.charAt(left++) - 'A']--;
			}
			max = Math.max(max, 1 + right - left);
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1));
		System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AAAA", 0));
		System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AAAA", 2));
		System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("ABAB", 2));
	}
}
