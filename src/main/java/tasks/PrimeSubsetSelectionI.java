package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-10-18
 */
@LeetCode(
        id = 4079,
        name = "Prime Subset Selection I",
        url = "https://leetcode.com/problems/prime-subset-selection-i/description/",
        difficulty = Difficulty.MEDIUM
)
public class PrimeSubsetSelectionI {
    public List<Integer> maxPrimes(int n, int s) {
        List<Integer> primes = getPrimes(n);
        List<Integer> ans = new ArrayList<>();
        for (int p : primes) {
            if (s - p < 0) {
                break;
            }
            ans.addLast(p);
            s -= p;
        }
        return ans;
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