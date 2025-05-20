package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-05-19
 */
@LeetCode(
        id = 3355,
        name = "Zero Array Transformation I",
        url = "https://leetcode.com/problems/zero-array-transformation-i/description",
        difficulty = Difficulty.MEDIUM
)
public class ZeroArrayTransformationI {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] memo = new int[nums.length + 1];
        for (int[] query : queries) {
            memo[query[0]]--;
            memo[query[1] + 1]++;
        }

        for (int i = 1; i < memo.length; i++) {
            memo[i] += memo[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] += memo[i];
            if (nums[i] > 0) {
                return false;
            }
        }
        return true;
    }
}