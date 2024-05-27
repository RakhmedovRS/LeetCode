package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-05-26
 */
@LeetCode(
		id = 3151,
		name = "Special Array I",
		url = "https://leetcode.com/problems/special-array-i/description/",
		difficulty = Difficulty.EASY
)
public class SpecialArrayI {
	public boolean isArraySpecial(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if ((nums[i] % 2 == 0 && nums[i - 1] % 2 == 0)
					|| (nums[i] % 2 != 0 && nums[i - 1] % 2 != 0)) {
				return false;
			}
		}
		return true;
	}
}