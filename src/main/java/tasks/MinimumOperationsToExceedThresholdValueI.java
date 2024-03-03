package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-03-02
 */
@LeetCode(
		id = 3065,
		name = "Minimum Operations to Exceed Threshold Value I",
		url = "https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/description/",
		difficulty = Difficulty.EASY
)
public class MinimumOperationsToExceedThresholdValueI {
	public int minOperations(int[] nums, int k) {
		Arrays.sort(nums);
		int cnt = 0;
		for (int num : nums) {
			if (num >= k) {
				break;
			}
			cnt++;
		}
		return cnt;
	}
}