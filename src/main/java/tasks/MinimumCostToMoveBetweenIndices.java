package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-05-03
 */
@LeetCode(
        id = 3919,
        name = "Minimum Cost to Move Between Indices",
        url = "https://leetcode.com/problems/minimum-cost-to-move-between-indices/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumCostToMoveBetweenIndices {
    public int[] minCost(int[] nums, int[][] queries) {
        int[] leftToRight = new int[nums.length];
        leftToRight[1] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftToRight[i] += leftToRight[i - 1];
            if (i < nums.length - 1) {
                int leftDiff = Math.abs(nums[i - 1] - nums[i]);
                int rightDiff = Math.abs(nums[i] - nums[i + 1]);
                if (leftDiff > rightDiff) {
                    leftToRight[i + 1] = 1;
                } else {
                    leftToRight[i + 1] = rightDiff;
                }
            }
        }

        int[] rightToLeft = new int[nums.length];
        rightToLeft[rightToLeft.length - 2] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rightToLeft[i] += rightToLeft[i + 1];
            if (i > 0) {
                int leftDiff = Math.abs(nums[i - 1] - nums[i]);
                int rightDiff = Math.abs(nums[i] - nums[i + 1]);
                if (leftDiff <= rightDiff) {
                    rightToLeft[i - 1] = 1;
                } else {
                    rightToLeft[i - 1] = leftDiff;
                }
            }
        }


        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a <= b) {
                ans[i] = leftToRight[b] - leftToRight[a];
            } else {
                ans[i] = rightToLeft[b] - rightToLeft[a];
            }
        }

        return ans;
    }
}