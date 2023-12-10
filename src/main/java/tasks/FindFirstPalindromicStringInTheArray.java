package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/19/2021
 */
@LeetCode(
		id = 2108,
		name = "Find First Palindromic String in the Array",
		url = "https://leetcode.com/problems/find-first-palindromic-string-in-the-array/",
		difficulty = Difficulty.EASY
)
public class FindFirstPalindromicStringInTheArray {
	public String firstPalindrome(String[] words) {
		for (String s : words) {
			if (isPalindrome(s)) {
				return s;
			}
		}

		return "";
	}

	private boolean isPalindrome(String string) {
		int start = 0;
		int end = string.length() - 1;

		while (start < end) {
			if (string.charAt(start) != string.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}

		return true;
	}
}
