package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 3/27/2023
 */
@LeetCode(
		id = 2601,
		name = "Prime Subtraction Operation",
		url = "https://leetcode.com/problems/prime-subtraction-operation/",
		difficulty = Difficulty.MEDIUM
)
public class PrimeSubtractionOperation {
	public static List<Integer> getPrimes(int maxValue) {
		boolean[] sieveOfEratosthenes = new boolean[maxValue + 1];
		Arrays.fill(sieveOfEratosthenes, true);

		for (int num1 = 2; num1 * num1 <= maxValue; num1++) {
			if (sieveOfEratosthenes[num1]) {
				for (int num2 = num1 * num1; num2 <= maxValue; num2 += num1) {
					sieveOfEratosthenes[num2] = false;
				}
			}
		}

		List<Integer> primes = new ArrayList<>();
		for (int i = 2; i < sieveOfEratosthenes.length; i++) {
			if (sieveOfEratosthenes[i]) {
				primes.add(i);
			}
		}

		return primes;
	}

	public boolean primeSubOperation(int[] nums) {
		List<Integer> primes = getPrimes(1000);
		return dfs(nums, 0, 0, primes, new Boolean[1001][1001]);
	}

	private boolean dfs(int[] nums, int pos, int max, List<Integer> primes, Boolean[][] memo) {
		if (max >= nums[pos]) {
			return false;
		}

		if (memo[pos][max] != null) {
			return memo[pos][max];
		}

		if (pos == nums.length - 1) {
			return true;
		}

		if (nums[pos] < nums[pos + 1]) {
			memo[pos][max] = dfs(nums, pos + 1, Math.max(max, nums[pos]), primes, memo);
		}

		if (memo[pos][max] != null && memo[pos][max]) {
			return true;
		}

		memo[pos][max] = false;
		for (int num : primes) {
			if (num > nums[pos] || nums[pos] - num <= max) {
				break;
			}

			nums[pos] -= num;
			memo[pos][max] = dfs(nums, pos + 1, Math.max(max, nums[pos]), primes, memo);
			if (memo[pos][max]) {
				return true;
			}
			nums[pos] += num;
		}

		return memo[pos][max];
	}
}
