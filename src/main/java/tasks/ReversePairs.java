package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11-Aug-20
 */
@LeetCode(id = 493, name = "Reverse Pairs", url = "https://leetcode.com/problems/reverse-pairs/")
public class ReversePairs {
	public int reversePairs(int[] nums) {
		return mergeSortAndCount(nums, 0, nums.length - 1);
	}

	private int mergeSortAndCount(int[] nums, int left, int right) {
		if (left >= right) {
			return 0;
		}

		int middle = left + (right - left) / 2;
		int count = 0;
		count += mergeSortAndCount(nums, left, middle);
		count += mergeSortAndCount(nums, middle + 1, right);
		int j = middle + 1;
		for (int i = left; i <= middle; i++) {
			while (j <= right && nums[i] > nums[j] * 2L) {
				j++;
			}
			count += j - middle - 1;
		}

		merge(nums, left, middle, right);
		return count;
	}

	private void merge(int[] nums, int left, int middle, int right) {
		int[] leftSubArray = new int[middle - left + 1];
		int[] rightSubArray = new int[right - middle];
		for (int i = 0; i < leftSubArray.length; i++) {
			leftSubArray[i] = nums[left + i];
		}
		for (int i = 0; i < rightSubArray.length; i++) {
			rightSubArray[i] = nums[middle + 1 + i];
		}

		int mainIdx = left;
		int leftSubIdx = 0;
		int rightSubIdx = 0;
		while (leftSubIdx < leftSubArray.length && rightSubIdx < rightSubArray.length) {
			if (leftSubArray[leftSubIdx] < rightSubArray[rightSubIdx]) {
				nums[mainIdx++] = leftSubArray[leftSubIdx++];
			}
			else {
				nums[mainIdx++] = rightSubArray[rightSubIdx++];
			}
		}

		while (leftSubIdx < leftSubArray.length) {
			nums[mainIdx++] = leftSubArray[leftSubIdx++];
		}

		while (rightSubIdx < rightSubArray.length) {
			nums[mainIdx++] = rightSubArray[rightSubIdx++];
		}
	}
}
