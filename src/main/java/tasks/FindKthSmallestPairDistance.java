package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-08-13
 */
@LeetCode(
		id = 719,
		name = "Find K-th Smallest Pair Distance",
		url = "https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/",
		difficulty = Difficulty.HARD
)
public class FindKthSmallestPairDistance {
	public int smallestDistancePair(int[] nums, int k) {
		int[] memo = new int[1_000_001];
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				memo[Math.abs(nums[j] - nums[i])]++;
			}
		}

		for (int i = 0; i < memo.length; i++) {
			if (memo[i] >= k) {
				return i;
			}
			k -= memo[i];
		}

		return -1;
	}
}