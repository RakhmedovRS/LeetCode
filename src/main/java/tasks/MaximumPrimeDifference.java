package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-04-14
 */
@LeetCode(
		id = 3115,
		name = "Maximum Prime Difference",
		url = "https://leetcode.com/problems/maximum-prime-difference/description/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumPrimeDifference {
	public int maximumPrimeDifference(int[] nums) {
		Set<Integer> primes = getPrimes(100);
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (primes.contains(nums[i])) {
				min = Math.min(min, i);
				max = Math.max(max, i);
			}
		}

		return max - min;
	}

	public static Set<Integer> getPrimes(int maxValue) {
		boolean[] sieveOfEratosthenes = new boolean[maxValue + 1];
		Arrays.fill(sieveOfEratosthenes, true);

		for (int num1 = 2; num1 * num1 <= maxValue; num1++) {
			if (sieveOfEratosthenes[num1]) {
				for (int num2 = num1 * num1; num2 <= maxValue; num2 += num1) {
					sieveOfEratosthenes[num2] = false;
				}
			}
		}

		Set<Integer> primes = new HashSet<>();
		for (int i = 2; i < sieveOfEratosthenes.length; i++) {
			if (sieveOfEratosthenes[i]) {
				primes.add(i);
			}
		}

		return primes;
	}
}