package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 21-Sep-20
 */
@LeetCode(id = 1144, name = "Decrease Elements To Make Array Zigzag", url = "https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/")
public class DecreaseElementsToMakeArrayZigzag {
	public int movesToMakeZigzag(int[] nums) {
		int[][] arrays = new int[][]{Arrays.copyOf(nums, nums.length), Arrays.copyOf(nums, nums.length)};
		int[] steps = new int[]{0, 0};
		int left;
		int right;
		int diff;
		int[] array;
		for (int pos = 0; pos < 2; pos++) {
			array = arrays[pos];
			for (int i = pos; i < array.length; i += 2) {
				left = i - 1 < 0 ? Integer.MIN_VALUE : array[i - 1];
				right = i + 1 == array.length ? Integer.MIN_VALUE : array[i + 1];
				if (array[i] <= left) {
					diff = 1 + left - array[i];
					steps[pos] += diff;
					array[i - 1] -= diff;
				}

				if (array[i] <= right) {
					diff = 1 + right - array[i];
					steps[pos] += diff;
					array[i + 1] -= diff;
				}
			}
		}

		return Math.min(steps[0], steps[1]);
	}
}
