package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 7/9/2023
 */
@LeetCode(
		id = 2771,
		name = "Longest Non-decreasing Subarray From Two Arrays",
		url = "https://leetcode.com/problems/longest-non-decreasing-subarray-from-two-arrays/",
		difficulty = Difficulty.MEDIUM
)
public class LongestNonDecreasingSubarrayFromTwoArrays {
	public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
		int res = 0;
		int[] memoMin = new int[nums1.length + 1];
		int[] memoMax = new int[nums1.length + 1];
		int[] min = new int[nums1.length + 1];
		int[] max = new int[nums1.length + 1];
		min[0] = max[0] = Integer.MIN_VALUE;
		for (int i = 0, j = 1; i < nums1.length; i++, j++) {
			int MIN = min[j - 1];
			int MAX = max[j - 1];

			int currMin = Math.min(nums1[i], nums2[i]);
			int currMax = Math.max(nums1[i], nums2[i]);
			min[j] = currMin;
			max[j] = currMax;


			if (currMin >= MIN) {
				memoMin[j] = memoMin[j - 1] + 1;
			}
			else {
				memoMin[j] = Math.max(memoMin[j], 1);
			}

			if (currMin >= MAX) {
				memoMin[j] = Math.max(memoMin[j], memoMax[j - 1] + 1);
			}
			else {
				memoMin[j] = Math.max(memoMin[j], 1);
			}

			if (currMax >= MAX) {
				memoMax[j] = memoMax[j - 1] + 1;
			}
			else {
				memoMax[j] = Math.max(memoMax[j], 1);
			}

			if (currMax >= MIN) {
				memoMax[j] = Math.max(memoMax[j], memoMin[j - 1] + 1);
			}
			else {
				memoMax[j] = Math.max(memoMax[j], 1);
			}

			res = Math.max(res, Math.max(memoMin[j], memoMax[j]));

		}

		return res;
	}
}
