package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 9/2/2023
 */
@LeetCode(
		id = 2841,
		name = "Maximum Sum of Almost Unique Subarray",
		url = "https://leetcode.com/problems/maximum-sum-of-almost-unique-subarray/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumSumOfAlmostUniqueSubarray {
	public long maxSum(List<Integer> nums, int m, int k) {
		long max = 0;
		if (k > nums.size()) {
			return max;
		}

		Map<Integer, Integer> map = new HashMap<>();
		int left = 0;
		int right = 0;
		long sum = 0;
		while (right < nums.size()) {
			int r = nums.get(right++);
			map.put(r, map.getOrDefault(r, 0) + 1);
			sum += r;
			if (right - left >= k) {
				if (right - left > k) {
					int l = nums.get(left++);
					int c = map.remove(l);
					if (c > 1) {
						map.put(l, c - 1);
					}
					sum -= l;
				}

				if (map.size() >= m) {
					max = Math.max(max, sum);
				}
			}
		}

		return max;
	}
}
