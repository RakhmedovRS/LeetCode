package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-16
 */
@LeetCode(
        id = 3678,
        name = "Smallest Absent Positive Greater Than Average",
        url = "https://leetcode.com/problems/smallest-absent-positive-greater-than-average/description/",
        difficulty = Difficulty.EASY
)
public class SmallestAbsentPositiveGreaterThanAverage {
    public int smallestAbsent(int[] nums) {
        long sum = 0;
        boolean[] seen = new boolean[202];
        for (int num : nums) {
            sum += num;
            seen[num + 100] = true;
        }

        int median = Math.max(1, 1 + (int) (sum / nums.length));
        while (seen[median + 100]) {
            median++;
        }
        return median;
    }
}