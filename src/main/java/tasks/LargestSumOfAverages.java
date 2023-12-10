package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/29/2020
 */
@LeetCode(id = 813, name = "Largest Sum of Averages", url = "https://leetcode.com/problems/largest-sum-of-averages/")
public class LargestSumOfAverages {
	public double largestSumOfAverages(int[] A, int K) {
		return dfs(0, A, K, new Double[A.length][K + 1]);
	}

	private double dfs(int pos, int[] A, int K, Double[][] memo) {
		if (pos == A.length || K == 0) {
			return 0;
		}

		if (memo[pos][K] != null) {
			return memo[pos][K];
		}

		memo[pos][K] = 0D;
		double sum = 0D;
		for (int i = pos, count = 1; i <= A.length - K; i++, count++) {
			sum += A[i];
			if (K == 1 && i < A.length - 1) {
				continue;
			}
			memo[pos][K] = Math.max(memo[pos][K], sum / count + dfs(i + 1, A, K - 1, memo));
		}

		return memo[pos][K];
	}
}
