package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 19-Sep-20
 */
@LeetCode(id = 1588, name = "Sum of All Odd Length Subarrays", url = "https://leetcode.com/problems/sum-of-all-odd-length-subarrays/")
public class SumOfAllOddLengthSubarrays {
	public int sumOddLengthSubarrays(int[] arr) {
		int result = 0;
		int len = 1;
		while (len <= arr.length) {
			for (int i = 0; i <= arr.length - len; i++) {
				for (int j = 0; j < len; j++) {
					result += arr[i + j];
				}
			}
			len += 2;
		}

		return result;
	}
}
