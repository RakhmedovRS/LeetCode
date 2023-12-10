package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 19-Apr-20
 */
@LeetCode(
		id = 27,
		name = "Remove Element",
		url = "https://leetcode.com/problems/remove-element/",
		difficulty = Difficulty.EASY
)
public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i++] = nums[j];
			}
		}

		return i;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{3, 2, 2, 3};
		int pos = new RemoveElement().removeElement(arr, 3);
		System.out.println(Arrays.toString(Arrays.copyOf(arr, pos)));
	}
}
