package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/3/2020
 */
@LeetCode(
		id = 246,
		name = "Strobogrammatic Number",
		url = "https://leetcode.com/problems/strobogrammatic-number/",
		difficulty = Difficulty.EASY,
		premium = true
)
public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
		int left = 0;
		int right = num.length() - 1;
		char leftChar;
		char rightChar;
		boolean[] invalid = new boolean[10];
		invalid[2] = true;
		invalid[3] = true;
		invalid[4] = true;
		invalid[5] = true;
		invalid[7] = true;

		while (left <= right) {
			if (left == right) {
				leftChar = num.charAt(left++);
				if (leftChar == '6' || leftChar == '9' || invalid[leftChar - '0']) {
					return false;
				}
				continue;
			}

			leftChar = num.charAt(left++);
			rightChar = num.charAt(right--);

			if (invalid[leftChar - '0'] || invalid[rightChar - '0']) {
				return false;
			}

			if (leftChar == '6') {
				if (rightChar != '9') {
					return false;
				}
				continue;
			}

			if (leftChar == '9') {
				if (rightChar != '6') {
					return false;
				}
				continue;
			}

			if (leftChar != rightChar) {
				return false;
			}
		}

		return true;
	}
}
