package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 25-Jul-20
 */
@LeetCode(id = 1524, name = "Number of Sub-arrays With Odd Sum", url = "https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/")
public class NumberOfSubArraysWithOddSum {
	public int numOfSubarrays(int[] arr) {
		long sum = 0;
		long even = 1;
		long odd = 0;
		for (int value : arr) {
			sum += value;
			if (sum % 2 == 0) {
				even++;
			}
			else {
				odd++;
			}
		}

		return (int) ((even * odd) % ((int) (Math.pow(10, 9) + 7)));
	}
}
