package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/8/2022
 */
@LeetCode(
		id = 2266,
		name = "Count Number of Texts",
		url = "https://leetcode.com/problems/count-number-of-texts/",
		difficulty = Difficulty.MEDIUM
)
public class CountNumberOfTexts {
	int MOD = 1_000_000_007;

	public int countTexts(String pressedKeys) {
		int[] memo = new int[pressedKeys.length() + 1];
		memo[0] = 1;
		char[] chars = pressedKeys.toCharArray();
		for (int i = 1; i <= chars.length; i++) {
			memo[i] = (memo[i] + memo[i - 1]) % MOD;
			if (i - 2 >= 0 && chars[i - 2] == chars[i - 1]) {
				memo[i] = (memo[i] + memo[i - 2]) % MOD;
				if (i - 3 >= 0 && chars[i - 3] == chars[i - 1]) {
					memo[i] = (memo[i] + memo[i - 3]) % MOD;
					if (i - 4 >= 0 && chars[i - 4] == chars[i - 1] && (chars[i - 1] == '7' || chars[i - 1] == '9')) {
						memo[i] = (memo[i] + memo[i - 4]) % MOD;
					}
				}
			}
		}

		return memo[pressedKeys.length()];
	}
}
