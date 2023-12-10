package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 11/18/2023
 */
@LeetCode(
		id = 2938,
		name = "Separate Black and White Balls",
		url = "https://leetcode.com/problems/separate-black-and-white-balls/",
		difficulty = Difficulty.MEDIUM
)
public class SeparateBlackAndWhiteBalls {
	public long minimumSteps(String s) {
		long res = 0;
		char[] chars = s.toCharArray();
		int left = 0;
		int right = chars.length - 1;

		while (left < right) {
			while (left <= right && chars[left] == '0') {
				left++;
			}

			while (right >= left && chars[right] == '1') {
				right--;
			}

			if (left < right) {
				res += right - left;
				chars[left++] = '0';
				chars[right--] = '1';
			}
		}

		return res;
	}
}
