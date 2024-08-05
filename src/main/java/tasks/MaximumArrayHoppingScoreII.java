package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-08-04
 */
@LeetCode(
		id = 3221,
		name = "Maximum Array Hopping Score II",
		url = "https://leetcode.com/problems/maximum-array-hopping-score-ii/description/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class MaximumArrayHoppingScoreII {
	public long maxScore(int[] nums) {
		int[] jumpTo = new int[nums.length];
		int curr = nums.length - 1;
		for (int i = curr; i >= 0; i--) {
			jumpTo[i] = curr;
			if (nums[i] > nums[curr]) {
				curr = i;
			}
		}

		long res = 0;
		for (int i = 0; jumpTo[i] != i; i = jumpTo[i]) {
			int from = i;
			int to = jumpTo[i];
			res += (long) (to - from) * nums[to];
		}
		return res;
	}
}