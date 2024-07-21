package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-07-21
 */
@LeetCode(
		id = 3228,
		name = "Maximum Number of Operations to Move Ones to the End",
		url = "https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/description/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumNumberOfOperationsToMoveOnesToTheEnd {
	public int maxOperations(String s) {
		int result = 0;
		int seenOnes = 0;
		for (int i = 0; i < s.length(); i++) {
			boolean seenZero = false;
			if (s.charAt(i) == '0') {
				while (i < s.length() && s.charAt(i) == '0' && seenOnes > 0) {
					i++;
					seenZero = true;
				}
				if (seenZero) {
					result += seenOnes;
					seenOnes++;
				}
			} else {
				seenOnes++;
			}
		}
		return result;
	}
}