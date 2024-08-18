package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-08-17
 */
@LeetCode(
		id = 3260,
		name = "Find the Largest Palindrome Divisible by K",
		url = "https://leetcode.com/problems/find-the-largest-palindrome-divisible-by-k/description/",
		difficulty = Difficulty.HARD
)
public class FindTheLargestPalindromeDivisibleByK {
	public String largestPalindrome(int n, int k) {
		char[] curr = new char[n];
		if (k == 1 || k == 3 || k == 9) {
			Arrays.fill(curr, '9');
			return String.valueOf(curr);
		} else if (k == 2) {
			Arrays.fill(curr, '8');
			for (int i = 1; i < curr.length - 1; i++) {
				curr[i] = '9';
			}
			return String.valueOf(curr);
		} else if (k == 4) {
			Arrays.fill(curr, '8');
			for (int i = 2; i < curr.length - 2; i++) {
				curr[i] = '9';
			}
			return String.valueOf(curr);
		} else if (k == 5) {
			Arrays.fill(curr, '5');
			for (int i = 1; i < curr.length - 1; i++) {
				curr[i] = '9';
			}
			return String.valueOf(curr);
		} else if (k == 6) {
			if (n == 1) {
				return "6";
			} else if (n == 2) {
				return "66";
			} else if (n == 3) {
				return "888";
			} else if (n == 4) {
				return "8778";
			}
			Arrays.fill(curr, '8');
			for (int i = 1; i < curr.length - 1; i++) {
				curr[i] = '9';
			}

			if (curr.length % 2 == 1) {
				curr[curr.length / 2] = '8';
			} else {
				curr[curr.length / 2 - 1] = '7';
				curr[curr.length / 2] = '7';
			}
			return String.valueOf(curr);
		} else if (k == 7) {
			if (n == 1) {
				return "7";
			} else if (n == 2) {
				return "77";
			} else if (n == 3) {
				return "959";
			} else if (n == 4) {
				return "9779";
			}
			Arrays.fill(curr, '9');
			if (n % 2 == 1) {
				return dfs(n / 2 - 2, n / 2 + 2, curr, java.math.BigInteger.valueOf(k));
			}
			return dfs(n / 2 - 2, n / 2 + 1, curr, java.math.BigInteger.valueOf(k));
		} else if (k == 8) {
			Arrays.fill(curr, '8');
			for (int i = 3; i < curr.length - 3; i++) {
				curr[i] = '9';
			}
			return String.valueOf(curr);
		}
		return "";
	}

	private String dfs(int left, int right, char[] chars, java.math.BigInteger k) {
		if (left > right) {
			if (new java.math.BigInteger(String.valueOf(chars)).remainder(k).equals(java.math.BigInteger.ZERO)) {
				return String.valueOf(chars);
			}
			return "";
		}
		for (int digit = 9; digit >= 0; digit--) {
			chars[left] = (char) (digit + '0');
			chars[right] = chars[left];
			String res = dfs(left + 1, right - 1, chars, k);
			if (!"".equals(res)) {
				return res;
			}
		}
		return "";
	}
}