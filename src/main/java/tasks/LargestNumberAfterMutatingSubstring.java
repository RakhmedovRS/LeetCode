package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 7/25/2021
 */
@LeetCode(
		id = 1946,
		name = "Largest Number After Mutating Substring",
		url = "https://leetcode.com/problems/largest-number-after-mutating-substring/",
		difficulty = Difficulty.MEDIUM
)
public class LargestNumberAfterMutatingSubstring {
	public String maximumNumber(String num, int[] change) {
		char[] chars = num.toCharArray();
		boolean seenGreater = false;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] - '0' <= change[chars[i] - '0']) {
				if (chars[i] - '0' < change[chars[i] - '0']) {
					seenGreater = true;
				}
				chars[i] = (char) (change[chars[i] - '0'] + '0');
			}
			else if (seenGreater) {
				break;
			}
		}

		return String.valueOf(chars);
	}
}
