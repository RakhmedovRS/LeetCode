package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-04-27
 */
@LeetCode(
		id = 3132,
		name = "Find the Integer Added to Array II",
		url = "https://leetcode.com/problems/find-the-integer-added-to-array-ii/description/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheIntegerAddedToArrayII {
	public int minimumAddedInteger(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int min = Integer.MAX_VALUE;
		for (int diff = 1000; diff >= -1000; diff--) {
			if (checkAdded(nums1, nums2, diff)) {
				min = diff;
			}
		}
		return min;
	}

	private boolean checkAdded(int[] nums1, int[] nums2, int diff) {
		int skipped = 0;
		int nums1Pos = 0;
		int nums2Pos = 0;
		while (nums1Pos < nums1.length && nums2Pos < nums2.length && skipped <= 2) {
			if (nums2[nums2Pos] - nums1[nums1Pos] == diff) {
				nums1Pos++;
				nums2Pos++;
			} else {
				skipped++;
				nums1Pos++;
			}
		}

		return skipped <= 2;
	}
}