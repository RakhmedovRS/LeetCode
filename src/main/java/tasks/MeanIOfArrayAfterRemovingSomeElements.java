package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 10/17/2020
 */
@LeetCode(
		id = 1619,
		name = "Mean of Array After Removing Some Elements",
		url = "https://leetcode.com/problems/mean-of-array-after-removing-some-elements/",
		difficulty = Difficulty.EASY
)
public class MeanIOfArrayAfterRemovingSomeElements {
	public double trimMean(int[] arr) {
		Arrays.sort(arr);
		int left = arr.length / 20;
		int right = arr.length - left - 1;

		double sum = 0D;
		int count = 0;
		while (left <= right) {
			sum += arr[left++];
			count++;
		}

		return sum / count;
	}
}
