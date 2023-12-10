package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/4/2020
 */
@LeetCode(id = 1608, name = "Special Array With X Elements Greater Than or Equal X", url = "https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/")
public class SpecialArrayWithXElementsGreaterThanOrEqualX {
	public int specialArray(int[] nums) {
		int greater;
		int max = 0;
		for (int num : nums) {
			max = Math.max(max, num);
		}

		for (int i = 0; i <= max; i++) {
			greater = 0;
			for (int num : nums) {
				greater += num >= i ? 1 : 0;
			}

			if (i == greater) {
				return i;
			}
		}

		return -1;
	}
}
