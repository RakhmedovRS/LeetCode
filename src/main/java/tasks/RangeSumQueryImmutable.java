package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 15-May-20
 */
@LeetCode(
		id = 303,
		name = "Range Sum Query - Immutable",
		url = "https://leetcode.com/problems/range-sum-query-immutable/",
		difficulty = Difficulty.EASY
)
public class RangeSumQueryImmutable {
	class NumArray {
		int[] nums;

		public NumArray(int[] nums) {
			this.nums = nums;
			for (int i = 1; i < nums.length; i++) {
				this.nums[i] += this.nums[i - 1];
			}
		}

		public int sumRange(int left, int right) {
			return nums[right] - (left == 0 ? 0 : nums[left - 1]);
		}
	}
}
