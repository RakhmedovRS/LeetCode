package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 16-Jun-20
 */
@LeetCode(id = 409, name = "Longest Palindrome", url = "https://leetcode.com/problems/longest-palindrome/")
public class LongestPalindrome {
	public int longestPalindrome(String s) {
		int[] memo = new int[256];
		int longest = 0;
		for (char ch : s.toCharArray()) {
			memo[ch]++;
			if (memo[ch] == 2) {
				longest += 2;
				memo[ch] = 0;
			}
		}

		return longest == s.length() ? longest : longest + 1;
	}
}
