package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/29/2020
 */
@LeetCode(
		id = 1682,
		name = "Longest Palindromic Subsequence II",
		url = "https://leetcode.com/problems/longest-palindromic-subsequence-ii/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class LongestPalindromicSubsequenceII {
	public int longestPalindromeSubseq(String s) {
		return dfs(s.toCharArray(), 0, s.length() - 1, 26, new Integer[s.length()][s.length()][27]);
	}

	private int dfs(char[] chars, int left, int right, int prev, Integer[][][] memo) {
		if (left >= right) {
			return 0;
		}

		if (memo[left][right][prev] != null) {
			return memo[left][right][prev];
		}

		memo[left][right][prev] = Math.max(dfs(chars, left + 1, right, prev, memo), dfs(chars, left, right - 1, prev, memo));

		if (chars[left] == chars[right] && (chars[left] - 'a') != prev) {
			memo[left][right][prev] = Math.max(memo[left][right][prev], 2 + dfs(chars, left + 1, right - 1, chars[left] - 'a', memo));
		}

		return memo[left][right][prev];
	}
}
