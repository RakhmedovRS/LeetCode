package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-05-29
 */
@LeetCode(
		id = 3158,
		name = "Find the XOR of Numbers Which Appear Twice",
		url = "https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice/description/",
		difficulty = Difficulty.EASY
)
public class FindTheXOROfNumbersWhichAppearTwice {
	public int duplicateNumbersXOR(int[] nums) {
		int[] memo = new int[51];
		for (int num : nums) {
			memo[num]++;
		}

		int res = 0;
		for (int i = 0; i < memo.length; i++) {
			if (memo[i] == 2) {
				res ^= i;
			}
		}
		return res;
	}
}