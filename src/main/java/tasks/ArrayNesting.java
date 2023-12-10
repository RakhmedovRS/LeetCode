package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 07-Jul-20
 */
@LeetCode(
		id = 565,
		name = "Array Nesting",
		url = "https://leetcode.com/problems/array-nesting/",
		difficulty = Difficulty.MEDIUM
)
public class ArrayNesting {
	public int arrayNesting(int[] nums) {
		boolean[] visited = new boolean[nums.length];
		int max = 0;
		for (int num : nums) {
			max = Math.max(max, traverse(nums, num, visited));
		}

		return max;
	}

	private int traverse(int[] nums, int pos, boolean[] visited) {
		if (visited[pos]) {
			return 0;
		}

		visited[pos] = true;

		return 1 + traverse(nums, nums[pos], visited);
	}
}
