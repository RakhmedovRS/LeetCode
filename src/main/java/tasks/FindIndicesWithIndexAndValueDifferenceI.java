package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-09-21
 */
@LeetCode(
        id = 2903,
        name = "Find Indices With Index and Value Difference I",
        url = "https://leetcode.com/problems/find-indices-with-index-and-value-difference-i/description/",
        difficulty = Difficulty.EASY
)
public class FindIndicesWithIndexAndValueDifferenceI {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + indexDifference; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}