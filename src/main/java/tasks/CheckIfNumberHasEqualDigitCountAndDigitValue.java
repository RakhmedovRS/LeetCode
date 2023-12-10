package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/12/2022
 */
@LeetCode(
		id = 2283,
		name = "Check if Number Has Equal Digit Count and Digit Value",
		url = "https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/",
		difficulty = Difficulty.EASY
)
public class CheckIfNumberHasEqualDigitCountAndDigitValue {
	public boolean digitCount(String num) {
		int[] memo = new int[10];
		char[] chars = num.toCharArray();
		for (char ch : chars) {
			memo[ch - '0']++;
		}

		for (int i = 0; i < chars.length; i++) {
			if (memo[i] != chars[i] - '0') {
				return false;
			}
		}

		return true;
	}
}
