package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 6/26/2021
 */
@LeetCode(
		id = 1911,
		name = "Maximum Alternating Subsequence Sum",
		url = "https://leetcode.com/problems/maximum-alternating-subsequence-sum/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumAlternatingSubsequenceSum {
	public long maxAlternatingSum(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		else if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			list.addLast(nums[i]);
		}

		boolean lookingForBig = true;
		long sum = 0;
		long max = 0;
		while (!list.isEmpty()) {
			int current = list.removeFirst();
			if (lookingForBig) {
				while (!list.isEmpty() && current <= list.getFirst()) {
					current = list.removeFirst();
				}

				sum += current;
				lookingForBig = false;
			}
			else {
				while (!list.isEmpty() && current >= list.getFirst()) {
					current = list.removeFirst();
				}

				sum -= current;
				lookingForBig = true;
			}

			max = Math.max(max, sum);
		}

		return max;
	}
}
