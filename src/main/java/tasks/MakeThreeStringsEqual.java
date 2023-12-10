package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 11/18/2023
 */
@LeetCode(
		id = 2937,
		name = "Make Three Strings Equal",
		url = "https://leetcode.com/problems/make-three-strings-equal/",
		difficulty = Difficulty.EASY
)
public class MakeThreeStringsEqual {
	public int findMinimumOperations(String s1, String s2, String s3) {
		if (s1.length() <= 2 && s2.length() <= 2 && s3.length() <= 2) {
			if (s1.equals(s2) && s2.equals(s3)) {
				return 0;
			}
			return -1;
		}

		int ops = 0;
		int seen = 0;
		int i = 0;
		for (; i < Math.min(s1.length(), Math.min(s2.length(), s3.length())); i++) {
			if (s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) {
				seen++;
			}
			else {
				break;
			}
		}


		if (seen > 0) {
			ops += s1.length() - i;
			ops += s2.length() - i;
			ops += s3.length() - i;
			return ops;
		}

		return -1;
	}
}
