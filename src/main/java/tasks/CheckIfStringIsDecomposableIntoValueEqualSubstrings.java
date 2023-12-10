package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 7/17/2021
 */
@LeetCode(
		id = 1933,
		name = "Check if String Is Decomposable Into Value-Equal Substrings",
		url = "https://leetcode.com/problems/check-if-string-is-decomposable-into-value-equal-substrings/",
		difficulty = Difficulty.EASY
)
public class CheckIfStringIsDecomposableIntoValueEqualSubstrings {
	public boolean isDecomposable(String s) {
		char[] chars = s.toCharArray();
		boolean seenTwo = false;
		int count = 0;
		char prev = chars[0];
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == prev) {
				count++;
			}

			if (i == chars.length - 1 || chars[i] != prev) {
				if (count == 2) {
					if (seenTwo) {
						return false;
					}
					seenTwo = true;
				}

				if (count % 3 != 0) {
					if ((count - 2) % 3 != 0) {
						return false;
					}
					else {
						seenTwo = true;
					}
				}

				prev = chars[i];
				count = 1;
			}
		}

		return seenTwo;
	}
}
