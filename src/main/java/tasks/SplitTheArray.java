package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-02-24
 */
@LeetCode(
		id = 3046,
		name = "Split the Array",
		url = "https://leetcode.com/problems/split-the-array/description/",
		difficulty = Difficulty.EASY
)
public class SplitTheArray {
	public boolean isPossibleToSplit(int[] nums) {
		int[] memo = new int[101];
		for (int num : nums) {
			memo[num]++;
		}

		for (int j : memo) {
			if (j > 2) {
				return false;
			}
		}

		return true;
	}
}