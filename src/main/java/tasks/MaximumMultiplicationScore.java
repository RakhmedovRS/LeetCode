package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-09-14
 */
@LeetCode(
        id = 3290,
        name = "Maximum Multiplication Score",
        url = "https://leetcode.com/problems/maximum-multiplication-score/description/",
        difficulty = Difficulty.MEDIUM
)
public class MaximumMultiplicationScore {
    public long maxScore(int[] A, int[] B) {
        long max0 = Integer.MIN_VALUE;
        long max1 = Integer.MIN_VALUE;
        long max2 = Integer.MIN_VALUE;
        long max3 = Integer.MIN_VALUE;

        for (int b : B){
            max3 = Math.max(max3, (long) A[3] * b + max2);
            max2 = Math.max(max2, (long) A[2] * b + max1);
            max1 = Math.max(max1, (long) A[1] * b + max0);
            max0 = Math.max(max0, (long) A[0] * b);
        }

        return max3;
    }
}