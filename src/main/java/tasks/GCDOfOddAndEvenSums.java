package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-08-23
 */
@LeetCode(
        id = 3658,
        name = "GCD of Odd and Even Sums",
        url = "https://leetcode.com/problems/gcd-of-odd-and-even-sums/description/",
        difficulty = Difficulty.EASY
)
public class GCDOfOddAndEvenSums {
    public int gcdOfOddEvenSums(int n) {
        int evens = n;
        int odds = n;
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 1; evens > 0 || odds > 0; i++) {
            if (i % 2 == 0) {
                evenSum += i;
                evens--;
            } else {
                oddSum += i;
                odds--;
            }
        }
        return gcd(evenSum, oddSum);
    }

    public static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}