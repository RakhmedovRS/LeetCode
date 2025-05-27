package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-05-26
 */
@LeetCode(
        id = 2894,
        name = "Divisible and Non-divisible Sums Difference",
        url = "https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/description/",
        difficulty = Difficulty.EASY
)
public class DivisibleAndNondivisibleSumsDifference {
    public int differenceOfSums(int n, int m) {
        int divisible = 0;
        int nonDivisible = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                divisible += i;
            } else {
                nonDivisible += i;
            }
        }
        return nonDivisible - divisible;
    }
}