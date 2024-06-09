package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-06-09
 */
@LeetCode(
		id = 3179,
		name = "Find the N-th Value After K Seconds",
		url = "https://leetcode.com/problems/find-the-n-th-value-after-k-seconds/description/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheNthValueAfterKSeconds {
	int MOD = 1_000_000_007;

	public int valueAfterKSeconds(int n, int k) {
		long[] arr = new long[n];
		Arrays.fill(arr, 1L);
		while (k-- > 0) {
			long prevSum = 0;
			for (int i = 0; i < n; i++) {
				long val = arr[i];
				arr[i] += prevSum;
				arr[i] %= MOD;
				prevSum += val;
			}
		}
		return (int) (arr[n - 1] % MOD);
	}
}