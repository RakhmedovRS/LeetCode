package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 02-Aug-20
 */
@LeetCode(id = 1534, name = "Count Good Triplets", url = "https://leetcode.com/problems/count-good-triplets/")
public class CountGoodTriplets {
	public int countGoodTriplets(int[] arr, int a, int b, int c) {
		if (arr == null || arr.length < 3) {
			return 0;
		}

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
						count++;
					}
				}
			}
		}

		return count;
	}
}
