package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-05-03
 */
@LeetCode(
        id = 3918,
        name = "Sum of Primes Between Number and Its Reverse",
        url = "https://leetcode.com/problems/sum-of-primes-between-number-and-its-reverse/description/",
        difficulty = Difficulty.MEDIUM
)
public class SumOfPrimesBetweenNumberAndItsReverse {
    public int sumOfPrimesInRange(int n) {
        Set<Integer> primes = getPrimes(1001);
        int reverse = reverse(n);
        int ans = 0;
        for (int number = Math.min(n, reverse); number <= Math.max(n, reverse); number++) {
            if (primes.contains(number)) {
                ans += number;
            }
        }
        return ans;
    }

    private int reverse(int num) {
        int res = 0;
        while (num > 0) {
            res *= 10;
            res += num % 10;
            num /= 10;
        }
        return res;
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