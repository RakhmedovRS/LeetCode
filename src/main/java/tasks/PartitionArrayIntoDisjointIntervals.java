package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 1/21/2021
 */
@LeetCode(
		id = 915,
		name = "Partition Array into Disjoint Intervals",
		url = "https://leetcode.com/problems/partition-array-into-disjoint-intervals/",
		difficulty = Difficulty.MEDIUM
)
public class PartitionArrayIntoDisjointIntervals {
	public int partitionDisjoint(int[] nums) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		Integer max = null;
		for (int i = 0; i < nums.length; i++) {
			if (max != null && max <= map.firstKey()) {
				return i;
			}

			int count = map.remove(nums[i]);
			if (--count > 0) {
				map.put(nums[i], count);
			}

			max = Math.max(max == null ? 0 : max, nums[i]);
		}

		return -1;
	}
}
