package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 6/14/2022
 */
@LeetCode(
		id = 2295,
		name = "Replace Elements in an Array",
		url = "https://leetcode.com/problems/replace-elements-in-an-array/",
		difficulty = Difficulty.MEDIUM
)
public class ReplaceElementsInArray {
	public int[] arrayChange(int[] nums, int[][] operations) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.putIfAbsent(nums[i], new ArrayList<>());
			map.get(nums[i]).add(i);
		}

		for (int[] op : operations) {
			List<Integer> list1 = java.util.Optional.ofNullable(map.remove(op[0])).orElse(new ArrayList<>());
			List<Integer> list2 = java.util.Optional.ofNullable(map.remove(op[1])).orElse(new ArrayList<>());

			list2.addAll(list1);
			map.put(op[1], list2);
		}

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			for (int i : entry.getValue()) {
				nums[i] = entry.getKey();
			}
		}

		return nums;
	}
}
