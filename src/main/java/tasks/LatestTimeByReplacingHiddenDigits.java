package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @version 1.0
 * @since 24.01.2021
 */
@LeetCode(
		id = 1736,
		name = "Latest Time by Replacing Hidden Digits",
		url = "https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/",
		difficulty = Difficulty.EASY
)
public class LatestTimeByReplacingHiddenDigits {
	public String maximumTime(String time) {
		char[] answer = time.toCharArray();
		if (answer[0] == '?' && answer[1] == '?') {
			answer[0] = '2';
			answer[1] = '3';
		}

		if (answer[0] == '?') {
			if (answer[1] <= '3') {
				answer[0] = '2';
			}
			else {
				answer[0] = '1';
			}
		}

		if (answer[1] == '?') {
			if (answer[0] == '2') {
				answer[1] = '3';
			}
			else {
				answer[1] = '9';
			}
		}

		if (answer[3] == '?') {
			answer[3] = '5';
		}

		if (answer[4] == '?') {
			answer[4] = '9';
		}

		return String.valueOf(answer);
	}
}
