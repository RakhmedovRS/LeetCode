package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 28-Jun-20
 */
@LeetCode(id = 1460, name = "Make Two Arrays Equal by Reversing Sub-arrays", url = "https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/")
public class MakeTwoArrayEqualByReversingSubArrays {
	public boolean canBeEqual(int[] target, int[] arr) {
		Arrays.sort(target);
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if (target[i] != arr[i]) {
				return false;
			}
		}

		return true;
	}
}
