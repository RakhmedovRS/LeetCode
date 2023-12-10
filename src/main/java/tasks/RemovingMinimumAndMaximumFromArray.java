package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/28/2021
 */
@LeetCode(
		id = 2091,
		name = "Removing Minimum and Maximum From Array",
		url = "https://leetcode.com/problems/removing-minimum-and-maximum-from-array/",
		difficulty = Difficulty.MEDIUM
)
public class RemovingMinimumAndMaximumFromArray {
	public int minimumDeletions(int[] nums) {
		if (nums.length <= 2) {
			return nums.length;
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int minIndex = -1;
		int maxIndex = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
				minIndex = i;
			}

			if (nums[i] > max) {
				max = nums[i];
				maxIndex = i;
			}
		}

		int removeFromBothSides = Math.min(minIndex, maxIndex) + 1 + nums.length - Math.max(minIndex, maxIndex);
		int removeFromLeftSide = Math.max(minIndex, maxIndex) + 1;
		int removeFromRightSide = nums.length - Math.min(minIndex, maxIndex);

		return Math.min(removeFromBothSides, Math.min(removeFromLeftSide, removeFromRightSide));
	}
}
