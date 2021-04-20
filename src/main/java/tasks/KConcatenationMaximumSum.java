package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 16-Jul-20
 */
@LeetCode(id = 1191, name = "K-Concatenation Maximum Sum", url = "https://leetcode.com/problems/k-concatenation-maximum-sum/")
public class KConcatenationMaximumSum
{
	public int kConcatenationMaxSum(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int mod = (int) (Math.pow(10, 9) + 7);
		int arrMaxSum = kadane(arr, mod);
		if (k == 1) {
			return arrMaxSum;
		}

		long prefixSum = prefixSum(arr, mod);
		long postfixSum = postfixSum(arr, mod);
		long sum = 0;
		for (int num : arr) {
			sum += num;
		}

		if (sum > 0) {
			return (int) Math.max(sum * (k - 2) % mod + prefixSum + postfixSum, arrMaxSum);
		}
		else {
			return (int) Math.max(prefixSum + postfixSum, arrMaxSum);
		}
	}

	private int kadane(int[] arr, int mod) {
		int max = Integer.MIN_VALUE;
		int current = 0;
		for (int num : arr) {
			current = current > 0 ? (current + num) % mod : num;
			max = Math.max(max, current);
		}

		return max < 0 ? 0 : max % mod;
	}

	private long prefixSum(int[] arr, int mod) {
		long current = 0;
		long max = Integer.MIN_VALUE;
		for (int num : arr) {
			current = (current + num) % mod;
			max = Math.max(max, current);
		}

		return max;
	}

	private long postfixSum(int[] arr, int mod) {
		long current = 0;
		long max = Integer.MIN_VALUE;
		for (int i = arr.length - 1; i >= 0; i--) {
			current = (current + arr[i]) % mod;
			max = Math.max(max, current);
		}

		return max;
	}
}
