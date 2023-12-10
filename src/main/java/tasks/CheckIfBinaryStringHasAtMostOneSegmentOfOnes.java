package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/7/2021
 */
@LeetCode(
		id = 1784,
		name = "Check if Binary String Has at Most One Segment of Ones",
		url = "https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/",
		difficulty = Difficulty.EASY
)
public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
	public boolean checkOnesSegment(String s) {
		if (!s.contains("1")) {
			return false;
		}

		char[] chars = s.toCharArray();
		int index = s.indexOf('1');
		int left = index;
		while (left >= 0) {
			if (chars[left] == '1') {
				chars[left--] = '0';
			}
			else {
				break;
			}
		}

		int right = index + 1;
		while (right < chars.length) {
			if (chars[right] == '1') {
				chars[right++] = '0';
			}
			else {
				break;
			}
		}

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '1') {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		CheckIfBinaryStringHasAtMostOneSegmentOfOnes clazz = new CheckIfBinaryStringHasAtMostOneSegmentOfOnes();
		System.out.println(clazz.checkOnesSegment("110"));
		System.out.println(clazz.checkOnesSegment("10"));
		System.out.println(clazz.checkOnesSegment("1001"));
	}
}
