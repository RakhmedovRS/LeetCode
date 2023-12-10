package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 12/9/2023
 */
@LeetCode(
		id = 2956,
		name = "Find Common Elements Between Two Arrays",
		url = "https://leetcode.com/problems/find-common-elements-between-two-arrays/",
		difficulty = Difficulty.EASY
)
public class FindCommonElementsBetweenTwoArrays {
	public int[] findIntersectionValues(int[] nums1, int[] nums2) {

		Set<Integer> A = new HashSet<>();
		Set<Integer> B = new HashSet<>();
		for (int num : nums1) {
			A.add(num);
		}

		for (int num : nums2) {
			B.add(num);
		}

		int[] ans = new int[2];

		for (int j : nums1) {
			if (B.contains(j)) {
				ans[0]++;
			}
		}

		for (int j : nums2) {
			if (A.contains(j)) {
				ans[1]++;
			}
		}

		return ans;
	}
}
