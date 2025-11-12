package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-04-07
 */
@LeetCode(
        id = 3396,
        name = "Minimum Number of Operations to Make Elements in Array Distinct",
        url = "https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/",
        difficulty = Difficulty.EASY
)
public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {
    public int minimumOperations(int[] nums) {
        boolean[] seen = new boolean[101];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (seen[nums[i]]) {
                int pos = ((i + 1) % 3) == 0 ? (i + 1) : ((i + 1) / 3 + 1) * 3;
                return (pos + 1) / 3;
            } else {
                seen[nums[i]] = true;
            }
        }
        return 0;
    }
}