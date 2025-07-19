package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-07-19
 */
@LeetCode(
        id = 3618,
        name = "Split Array by Prime Indices",
        url = "https://leetcode.com/problems/split-array-by-prime-indices/description/",
        difficulty = Difficulty.MEDIUM
)
public class SplitArrayByPrimeIndices {
    public long splitArray(int[] nums) {
        long a = 0;
        long b = 0;
        Set<Integer> primes = new HashSet<>(getPrimes(100_001));
        for (int i = 0; i < nums.length; i++){
            if (primes.contains(i)) {
                a += nums[i];
            } else {
                b += nums[i];
            }
        }

        return Math.abs(a - b);
    }


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
}