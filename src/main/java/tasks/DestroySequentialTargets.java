package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 10/31/2022
 */
@LeetCode(
		id = 2453,
		name = "Destroy Sequential Targets",
		url = "https://leetcode.com/problems/destroy-sequential-targets/",
		difficulty = Difficulty.MEDIUM
)
public class DestroySequentialTargets {
	public int destroyTargets(int[] nums, int space) {
		Arrays.sort(nums);
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num % space, map.getOrDefault(num % space, 0) + 1);
		}

		int min = nums[0];
		int count = 0;
		for (int num : nums) {
			if (map.getOrDefault(num % space, 0) > count) {
				min = num;
				count = map.get(num % space);
			}
		}

		return min;
	}
}
