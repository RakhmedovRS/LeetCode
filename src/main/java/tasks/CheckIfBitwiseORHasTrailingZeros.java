package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 12/30/2023
 */
@LeetCode(
		id = 2980,
		name = "Check if Bitwise OR Has Trailing Zeros",
		url = "https://leetcode.com/problems/check-if-bitwise-or-has-trailing-zeros/description/",
		difficulty = Difficulty.EASY
)
public class CheckIfBitwiseORHasTrailingZeros {
	public boolean hasTrailingZeros(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				String res = Integer.toBinaryString(nums[i] | nums[j]);
				if (res.charAt(res.length() - 1) == '0') {
					return true;
				}
			}
		}
		return false;
	}
}
