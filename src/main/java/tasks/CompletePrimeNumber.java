package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-12-06
 */
@LeetCode(
        id = 3765,
        name = "Complete Prime Number",
        url = "https://leetcode.com/problems/complete-prime-number/description/",
        difficulty = Difficulty.MEDIUM
)
public class CompletePrimeNumber {
    public boolean completePrime(int num) {
        char[] digits = ("" + num).toCharArray();
        int current = 0;
        for (int i = 0; i < digits.length; i++) {
            current *= 10;
            current += (digits[i] - '0');
            if (!isPrime(current)) {
                return false;
            }
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            current = 0;
            for (int j = i; j < digits.length; j++) {
                current *= 10;
                current += (digits[j] - '0');
            }
            if (!isPrime(current)) {
                return false;
            }
        }

        return true;
    }

    private boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        int root = (int) Math.sqrt(number);
        for (int i = 2; i <= root; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}