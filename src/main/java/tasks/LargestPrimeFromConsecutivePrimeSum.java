package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-12-07
 */
@LeetCode(
        id = 3770,
        name = "Largest Prime from Consecutive Prime Sum",
        url = "https://leetcode.com/problems/largest-prime-from-consecutive-prime-sum/description/",
        difficulty = Difficulty.MEDIUM
)
public class LargestPrimeFromConsecutivePrimeSum {
    static TreeSet<Integer> primes = new TreeSet<>(getPrimes(5_000_000));

    public int largestPrime(int n) {
        int num = 0;

        LinkedList<Integer> used = new LinkedList<>();
        for (int prime : primes) {
            if (num + prime > n) {
                break;
            }
            num += prime;
            used.addLast(prime);
        }

        while (!primes.contains(num) && !used.isEmpty()) {
            num -= used.removeLast();
        }

        return num;
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