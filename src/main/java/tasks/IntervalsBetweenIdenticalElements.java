package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@LeetCode(
		id = 2121,
		name = "Intervals Between Identical Elements",
		url = "https://leetcode.com/problems/intervals-between-identical-elements/",
		difficulty = Difficulty.MEDIUM
)
public class IntervalsBetweenIdenticalElements {
	public long[] getDistances(int[] nums) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.putIfAbsent(nums[i], new ArrayList<>());
			map.get(nums[i]).add(i);
		}


		long[] ans = new long[nums.length];
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> list = entry.getValue();
			if (list.size() > 1) {
				int count = 0;
				long sum = 0;
				for (int i = 1; i < list.size(); i++) {
					sum += (long) Math.abs(list.get(i - 1) - list.get(i)) + ((long) Math.abs(list.get(i - 1) - list.get(i)) * count);
					count++;
					ans[list.get(i)] = sum;
				}

				count = 0;
				sum = 0;
				for (int i = list.size() - 2; i >= 0; i--) {
					sum += (long) Math.abs(list.get(i + 1) - list.get(i)) + ((long) Math.abs(list.get(i + 1) - list.get(i)) * count);
					count++;
					ans[list.get(i)] += sum;
				}
			}
		}

		return ans;
	}
}
