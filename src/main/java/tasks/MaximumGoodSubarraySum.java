package tasks;
import common.Difficulty;
import common.LeetCode;
import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-02-03
 */
@LeetCode(
id = 3026,
 name = "Maximum Good Subarray Sum",
 url = "https://leetcode.com/problems/maximum-good-subarray-sum/",
 difficulty = Difficulty.MEDIUM
)
public class MaximumGoodSubarraySum {
	public long maximumSubarraySum(int[] nums, int k) {
		long[] sums = new long[nums.length];
		Map<Integer, TreeSet<Integer>> positions = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				sums[i] = nums[i];
			} else {
				sums[i] = sums[i - 1] + nums[i];
			}

			positions.putIfAbsent(nums[i], new TreeSet<>((a, b) -> Long.compare(sums[a], sums[b])));
/*
			List<Integer> pos = positions.get(nums[i]);
			if (nums[i] > 0 && !pos.isEmpty() && sums[pos.get(pos.size() - 1)] < sums[i]) {
				pos.remove(pos.size() - 1);
				pos.add(i);
			} else {
				positions.get(nums[i]).add(i);
			}*/

			positions.get(nums[i]).add(i);
		}

		long max = Long.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			TreeSet<Integer> position1 = positions.getOrDefault(nums[i] - k, new TreeSet<>());
			TreeSet<Integer> position2 = positions.getOrDefault(nums[i] + k, new TreeSet<>());
			max = Math.max(max, calc(i, position1, sums));
			max = Math.max(max, calc(i, position2, sums));
		}

		return max == Long.MIN_VALUE ? 0 : max;
	}

	private long calc(int start, TreeSet<Integer> positions, long[] sums) {
		long max = Long.MIN_VALUE;
		if (positions.isEmpty()) {
			return max;
		}

		if (positions.size() <= 3000){
			for (int pos : positions) {
				if (start < pos) {
					long res = sums[pos] - (start == 0 ? 0 : sums[start - 1]);
					max = Math.max(max, res);
				} else {
					long res = sums[start] - (pos == 0 ? 0 : sums[pos - 1]);
					max = Math.max(max, res);
				}
			}
		}
		else {
			int left = positions.first();
			int right = positions.last();
			if (start < right) {
				long res = sums[right] - (start == 0 ? 0 : sums[start - 1]);
				max = Math.max(max, res);
			} else {
				long res = sums[start] - (right == 0 ? 0 : sums[right - 1]);
				max = Math.max(max, res);
			}

			if (start > left) {
				long res = sums[start] - (left == 0 ? 0 : sums[left - 1]);
				max = Math.max(max, res);
			} else {
				long res = sums[left] - (start == 0 ? 0 : sums[start - 1]);
				max = Math.max(max, res);
			}
		}

		return max;
	}
}