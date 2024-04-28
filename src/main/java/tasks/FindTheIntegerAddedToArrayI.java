package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-04-27
 */
@LeetCode(
		id = 3131,
		name = "Find the Integer Added to Array I",
		url = "https://leetcode.com/problems/find-the-integer-added-to-array-i/description/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheIntegerAddedToArrayI {
	public int addedInteger(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		return nums2[0] - nums1[0];
	}
}