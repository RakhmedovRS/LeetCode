package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 21-Apr-20
 */
@LeetCode(
		id = 977,
		name = "Squares of a Sorted Array",
		url = "https://leetcode.com/problems/squares-of-a-sorted-array/",
		difficulty = Difficulty.EASY
)
public class SquaresOfSortedArray {
	public int[] sortedSquares(int[] nums) {
		int pos = 0;
		int[] answer = new int[nums.length];
		int minPos = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 0) {
				if (nums[minPos] <= nums[i]) {
					minPos = i;
				}
			}
		}

		int maxPos = minPos + 1;

		while (pos < answer.length) {
			int left = minPos < 0 ? Integer.MAX_VALUE : nums[minPos] * nums[minPos];
			int right = maxPos == nums.length ? Integer.MAX_VALUE : nums[maxPos] * nums[maxPos];

			if (left <= right) {
				answer[pos++] = left;
				minPos--;
			}
			else {
				answer[pos++] = right;
				maxPos++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new SquaresOfSortedArray().sortedSquares(new int[]{-1, 2, 2})));
		System.out.println(Arrays.toString(new SquaresOfSortedArray().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
		System.out.println(Arrays.toString(new SquaresOfSortedArray().sortedSquares(new int[]{-10000, -9999, -7, -5, 0, 0, 10000})));
		System.out.println(Arrays.toString(new SquaresOfSortedArray().sortedSquares(new int[]{-5, -4, -3, -2, -1})));
	}
}
