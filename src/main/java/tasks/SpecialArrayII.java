package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-05-26
 */
@LeetCode(
		id = 3152,
		name = "Special Array II",
		url = "https://leetcode.com/problems/special-array-ii/description/",
		difficulty = Difficulty.MEDIUM
)
public class SpecialArrayII {
	public boolean[] isArraySpecial(int[] nums, int[][] queries) {
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 1; i < nums.length; i++) {
			if ((nums[i] % 2 == 0 && nums[i - 1] % 2 == 0)
					|| (nums[i] % 2 != 0 && nums[i - 1] % 2 != 0)) {
				set.add(i - 1);
			}
		}

		boolean[] ans = new boolean[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int[] q = queries[i];
			int left = q[0];
			int right = q[1];

			ans[i] = left == right || set.subSet(left, true, right, false).isEmpty();
		}

		return ans;
	}
}