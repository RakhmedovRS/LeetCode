package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 26-Mar-20
 */
@LeetCode(
		id = 88,
		name = "Merge Sorted Array",
		url = "https://leetcode.com/problems/merge-sorted-array/",
		difficulty = Difficulty.EASY
)
public class MergeSortedArray {
	public void merge(int[] numsA, int m, int[] numsB, int n) {
		int posA = 0;
		int posB = 0;
		while (posA < m && posB < n) {
			if (numsA[posA] >= numsB[posB]) {
				int temp = numsA[posA];
				numsA[posA] = numsB[posB];
				numsB[posB] = temp;
				push(numsB, posB);
				posA++;
			}
			else if (numsA[posA] < numsB[posB]) {
				posA++;
			}
			else {
				posB++;
			}
		}

		while (posB < n) {
			numsA[posA++] = numsB[posB++];
		}
	}

	private void push(int[] nums, int pos) {
		while (pos < nums.length - 1 && nums[pos] > nums[pos + 1]) {
			swap(nums, pos, pos + 1);
			pos++;
		}
	}

	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
