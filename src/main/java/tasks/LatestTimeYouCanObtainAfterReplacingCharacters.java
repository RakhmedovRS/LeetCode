package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-04-14
 */
@LeetCode(
		id = 3114,
		name = "Latest Time You Can Obtain After Replacing Characters",
		url = "https://leetcode.com/problems/latest-time-you-can-obtain-after-replacing-characters/description/",
		difficulty = Difficulty.EASY
)
public class LatestTimeYouCanObtainAfterReplacingCharacters {
	public String findLatestTime(String s) {
		char[] chars = s.toCharArray();
		if (chars[0] == '?' && chars[1] == '?') {
			chars[0] = '1';
			chars[1] = '1';
		} else if (chars[0] == '1') {
			if (chars[1] == '?') {
				chars[1] = '1';
			}
		} else if (chars[0] == '0') {
			if (chars[1] == '?') {
				chars[1] = '9';
			}
		} else if (chars[0] == '?') {
			if (chars[1] > '1') {
				chars[0] = '0';
			} else {
				chars[0] = '1';
			}
		}
		if (chars[3] == '?') {
			chars[3] = '5';
		}

		if (chars[4] == '?') {
			chars[4] = '9';
		}

		return String.valueOf(chars);
	}
}