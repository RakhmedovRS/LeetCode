package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 7/2/2023
 */
@LeetCode(
		id = 2761,
		name = "Prime Pairs With Target Sum",
		url = "https://leetcode.com/problems/prime-pairs-with-target-sum/",
		difficulty = Difficulty.MEDIUM
)
public class PrimePairsWithTargetSum {
	public List<List<Integer>> findPrimePairs(int n) {
		List<Integer> primes = getPrimes(n);
		Set<Integer> set = new HashSet<>(primes);
		List<List<Integer>> answer = new ArrayList<>();
		for (int a : primes) {
			if (set.contains(n - a) && a <= n - a) {
				answer.add(Arrays.asList(a, n - a));
			}
		}

		return answer;
	}

	private List<Integer> getPrimes(int maxValue) {
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
}
