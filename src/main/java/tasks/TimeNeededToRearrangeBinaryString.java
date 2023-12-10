package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 8/22/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
		id = 2380,
		name = "Time Needed to Rearrange a Binary String",
		url = "https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string/",
		difficulty = Difficulty.MEDIUM
)
public class TimeNeededToRearrangeBinaryString {
	public int secondsToRemoveOccurrences(String s) {
		return secondsToRemoveOccurrences(s.toCharArray());
	}

	public int secondsToRemoveOccurrences(char[] chars) {
		boolean seen = false;

		for (int i = chars.length - 1; i > 0; i--) {
			if (chars[i - 1] == '0' && chars[i] == '1') {
				seen = true;
				chars[i - 1] = '1';
				chars[i] = '0';
				i--;
			}
		}

		if (seen) {
			return 1 + secondsToRemoveOccurrences(chars);
		}

		return 0;
	}
}
