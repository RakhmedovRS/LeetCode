package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-02-03
 */
@LeetCode(
		id = 3024,
		name = "Type of Triangle II",
		url = "https://leetcode.com/problems/type-of-triangle-ii/",
		difficulty = Difficulty.EASY
)
public class TypeOfTriangleII {
	public String triangleType(int[] nums) {
		Arrays.sort(nums);
		if (nums[2] >= nums[0] + nums[1]) {
			return "none";
		}

		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}

		if (set.size() == 1) {
			return "equilateral";
		} else if (set.size() == 2) {
			return "isosceles";
		} else {
			return "scalene";
		}
	}
}