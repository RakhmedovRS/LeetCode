package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 02-Jul-20
 */
@LeetCode(id = 1422, name = "Maximum Score After Splitting a String", url = "https://leetcode.com/problems/maximum-score-after-splitting-a-string/")
public class MaximumScoreAfterSplittingString {
	public int maxScore(String s) {
		int zeros = 0;
		int ones = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '1') {
				ones++;
			}
		}

		if (ones == s.length() || ones == 0) {
			return s.length() - 1;
		}

		int max = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '1') {
				ones--;
			}
			else {
				zeros++;
			}

			max = Math.max(max, zeros + ones);
		}

		return max;
	}
}
