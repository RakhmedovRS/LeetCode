package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/21/2020
 */
@LeetCode(
		id = 902,
		name = "Numbers At Most N Given Digit Set",
		url = "https://leetcode.com/problems/numbers-at-most-n-given-digit-set/",
		difficulty = Difficulty.HARD
)
public class NumbersAtMostNGivenDigitSet {
	public int atMostNGivenDigitSet(String[] digits, int n) {
		String N = String.valueOf(n);
		int len = N.length();
		int[] memo = new int[len + 1];
		memo[len] = 1;
		int num;
		for (int i = len - 1; i >= 0; i--) {
			int current = N.charAt(i) - '0';
			for (String digit : digits) {
				num = Integer.parseInt(digit);
				if (num < current) {
					memo[i] += Math.pow(digits.length, len - i - 1);
				}
				else if (num == current) {
					memo[i] += memo[i + 1];
				}
			}
		}

		for (int i = 1; i < len; i++) {
			memo[0] += Math.pow(digits.length, i);
		}

		return memo[0];
	}
}
