package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 9/4/2021
 */
@LeetCode(
		id = 1991,
		name = "Find the Middle Index in Array",
		url = "https://leetcode.com/problems/find-the-middle-index-in-array/",
		difficulty = Difficulty.EASY
)
public class FindTheMiddleIndexInArray {
	public int findMiddleIndex(int[] nums) {
		int[] sumLeftToRight = new int[nums.length];
		int[] sumRightToLeft = new int[nums.length];
		for (int i = 0; i < sumLeftToRight.length; i++) {
			sumLeftToRight[i] += (i > 0 ? (sumLeftToRight[i - 1]) : 0) + nums[i];
		}

		for (int i = sumLeftToRight.length - 1; i >= 0; i--) {
			sumRightToLeft[i] = (i < sumLeftToRight.length - 1 ? sumRightToLeft[i + 1] : 0) + nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			if (sumLeftToRight[i] == sumRightToLeft[i]) {
				return i;
			}
		}

		return -1;
	}
}
