package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/8/2021
 */
@LeetCode(
		id = 9,
		name = "Palindrome Number",
		url = "https://leetcode.com/problems/palindrome-number/",
		difficulty = Difficulty.EASY
)
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}

		long reversed = 0L;
		int temp = x;
		while (temp > 0) {
			reversed *= 10;
			reversed += temp % 10;
			temp /= 10;
		}

		return reversed == x;
	}
}
