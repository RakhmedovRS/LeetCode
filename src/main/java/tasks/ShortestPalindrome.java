package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/25/2020
 */
@LeetCode(
		id = 214,
		name = "Shortest Palindrome",
		url = "https://leetcode.com/problems/shortest-palindrome/",
		difficulty = Difficulty.HARD
)
public class ShortestPalindrome {
	public String shortestPalindrome(String origin) {
		String reversed = new StringBuilder(origin).reverse().toString();
		for (int i = 0; i <= reversed.length(); i++) {
			if (origin.startsWith(reversed.substring(i))) {
				return reversed.substring(0, i) + origin;
			}
		}

		return reversed + origin;
	}
}
