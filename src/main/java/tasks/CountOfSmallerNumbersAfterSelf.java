package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 11-Aug-20
 */
@LeetCode(id = 315, name = "Count of Smaller Numbers After Self", url = "https://leetcode.com/problems/count-of-smaller-numbers-after-self/")
public class CountOfSmallerNumbersAfterSelf {
	public List<Integer> countSmaller(int[] nums) {
		int[][] numsAndIndices = new int[nums.length][3];
		for (int i = 0; i < nums.length; i++) {
			numsAndIndices[i] = new int[]{nums[i], i, 0};
		}

		mergeSort(numsAndIndices, 0, numsAndIndices.length - 1);

		List<Integer> answer = new ArrayList<>();
		for (int num : nums) {
			answer.add(num);
		}

		for (int[] numAndIndex : numsAndIndices) {
			answer.set(numAndIndex[1], numAndIndex[2]);
		}

		return answer;
	}

	private void mergeSort(int[][] numsAndIndices, int left, int right) {
		if (left >= right) {
			return;
		}

		int middle = (left + right) / 2;
		mergeSort(numsAndIndices, left, middle);
		mergeSort(numsAndIndices, middle + 1, right);

		int j = middle + 1;
		for (int i = left; i <= middle; i++) {
			while (j <= right && numsAndIndices[i][0] > numsAndIndices[j][0]) {
				j++;
			}

			numsAndIndices[i][2] += j - middle - 1;
		}

		merge(numsAndIndices, left, middle, right);
	}

	private void merge(int[][] numsAndIndices, int left, int middle, int right) {
		int[][] leftPart = new int[middle - left + 1][];
		int[][] rightPart = new int[right - middle][];
		for (int i = 0; i < leftPart.length; i++) {
			leftPart[i] = numsAndIndices[left + i];
		}

		for (int i = 0; i < rightPart.length; i++) {
			rightPart[i] = numsAndIndices[middle + i + 1];
		}

		int mainIdx = left;
		int leftPartIdx = 0;
		int rightPartIdx = 0;
		while (leftPartIdx < leftPart.length && rightPartIdx < rightPart.length) {
			if (leftPart[leftPartIdx][0] < rightPart[rightPartIdx][0]) {
				numsAndIndices[mainIdx++] = leftPart[leftPartIdx++];
			}
			else {
				numsAndIndices[mainIdx++] = rightPart[rightPartIdx++];
			}
		}

		while (leftPartIdx < leftPart.length) {
			numsAndIndices[mainIdx++] = leftPart[leftPartIdx++];
		}

		while (rightPartIdx < rightPart.length) {
			numsAndIndices[mainIdx++] = rightPart[rightPartIdx++];
		}
	}
}
