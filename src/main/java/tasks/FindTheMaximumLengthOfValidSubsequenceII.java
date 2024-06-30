package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-06-29
 */
@LeetCode(
		id = 3202,
		name = "Find the Maximum Length of Valid Subsequence II",
		url = "https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-ii/description/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheMaximumLengthOfValidSubsequenceII {
	public int maximumLength(int[] nums, int k) {
		int[][] memo = new int[k + 1][k + 1];
		int max = 1;
		for (int num : nums) {
			int curr = num % k;
			for (int i = 0; i < k; i++) {
				int prev = (i - curr + k) % k;
				memo[curr][i] = Math.max(memo[curr][i], memo[prev][i] + 1);
				max = Math.max(max, memo[curr][i]);
			}
		}
		return max;
	}
}