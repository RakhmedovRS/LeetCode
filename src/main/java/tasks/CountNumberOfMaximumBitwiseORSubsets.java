package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 10/17/2021
 */
@LeetCode(
		id = 2044,
		name = "Count Number of Maximum Bitwise-OR Subsets",
		url = "https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/",
		difficulty = Difficulty.MEDIUM
)
public class CountNumberOfMaximumBitwiseORSubsets {
	public int countMaxOrSubsets(int[] nums) {
		Arrays.sort(nums);
		int max = 0;
		for (int i = 30; i >= 0; i--) {
			for (int num : nums) {
				if (((num & (1 << i)) != 0) && (max & (1 << i)) == 0) {
					max |= num;
				}
			}
		}

		int[] count = new int[]{0};

		dfs(0, 0, nums, max, count);

		return count[0];
	}

	private void dfs(int pos, int curr, int[] nums, int max, int[] count) {
		if (curr == max) {
			count[0]++;
		}

		if (pos == nums.length) {
			return;
		}

		for (int i = pos; i < nums.length; i++) {
			dfs(i + 1, curr | nums[i], nums, max, count);
		}
	}
}
