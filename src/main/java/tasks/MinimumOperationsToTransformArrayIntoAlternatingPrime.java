package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-04-11
 */
@LeetCode(
        id = 3896,
        name = "Minimum Operations to Transform Array into Alternating Prime",
        url = "https://leetcode.com/problems/minimum-operations-to-transform-array-into-alternating-prime/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToTransformArrayIntoAlternatingPrime {
    public static TreeSet<Integer> getPrimes(int maxValue) {
        boolean[] sieveOfEratosthenes = new boolean[maxValue + 1];
        Arrays.fill(sieveOfEratosthenes, true);

        for (int num1 = 2; num1 * num1 <= maxValue; num1++) {
            if (sieveOfEratosthenes[num1]) {
                for (int num2 = num1 * num1; num2 <= maxValue; num2 += num1) {
                    sieveOfEratosthenes[num2] = false;
                }
            }
        }

        TreeSet<Integer> primes = new TreeSet<>();
        for (int i = 2; i < sieveOfEratosthenes.length; i++) {
            if (sieveOfEratosthenes[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    public int minOperations(int[] nums) {
        int ans = 0;
        TreeSet<Integer> primes = getPrimes(100_004);
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                Integer bigger = primes.ceiling(nums[i]);
                ans += Math.abs(bigger - nums[i]);
            } else {
                while (primes.contains(nums[i]++)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}