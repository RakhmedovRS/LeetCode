package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 11/29/2022
 */
@LeetCode(
		id = 2484,
		name = "Count Palindromic Subsequences",
		url = "https://leetcode.com/problems/count-palindromic-subsequences/",
		difficulty = Difficulty.HARD
)
public class CountPalindromicSubsequences {
	int MOD = 1_000_000_007;

	public int countPalindromes(String s) {

		if (s.length() <= 1) {
			return 0;
		}


		long res = 0;
		char[] chars = s.toCharArray();

		long[] left = leftToRight(chars, 2);
		long[] right = rightToLeft(chars, 3);

		for (int i = 2; i < chars.length - 2; i++) {
			for (int num1 = 0; num1 <= 9; num1++) {
				for (int num2 = 0; num2 <= 9; num2++) {
					int lKey = num1 * 10 + num2;
					int rKey = num2 * 10 + num1;

					long l = left[lKey];
					long r = right[rKey];

					res = (res + l * r) % MOD;
				}
			}

			push(left, right, i, chars);
		}

		return (int) res;
	}

	private void push(long[] left, long[] right, int pos, char[] chars) {
		for (int i = 0; i < pos; i++) {
			int key = (chars[i] - '0') * 10 + (chars[pos] - '0');
			left[key]++;
		}

		for (int i = pos + 2; i < chars.length; i++) {
			int key = (chars[pos + 1] - '0') * 10 + (chars[i] - '0');
			right[key]--;
		}
	}

	private long[] leftToRight(char[] chars, int pos) {
		long[] res = new long[101];
		for (int i = 0; i < pos; i++) {
			for (int j = i + 1; j < pos; j++) {
				int key = (chars[i] - '0') * 10 + (chars[j] - '0');
				res[key]++;
			}
		}

		return res;
	}

	private long[] rightToLeft(char[] chars, int pos) {
		long[] res = new long[101];
		for (int i = pos; i < chars.length; i++) {
			for (int j = i + 1; j < chars.length; j++) {
				int key = (chars[i] - '0') * 10 + (chars[j] - '0');
				res[key]++;
			}
		}

		return res;
	}
}
