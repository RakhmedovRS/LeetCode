package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-10-13
 */
@LeetCode(
        id = 3712,
        name = "Sum of Elements With Frequency Divisible by K",
        url = "https://leetcode.com/problems/sum-of-elements-with-frequency-divisible-by-k/description/",
        difficulty = Difficulty.EASY
)
public class SumOfElementsWithFrequencyDivisibleByK {
    public int sumDivisibleByK(int[] nums, int k) {
        int[] memo = new int[101];
        for (int n : nums) {
            memo[n]++;
        }

        int sum = 0;
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] % k == 0) {
                sum += i * memo[i];
            }
        }
        return sum;
    }
}