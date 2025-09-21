package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-09-21
 */
@LeetCode(
        id = 2714,
        name = "Semi-Ordered Permutation",
        url = "https://leetcode.com/problems/semi-ordered-permutation/description/",
        difficulty = Difficulty.EASY
)
public class SemiOrderedPermutation {
    public int semiOrderedPermutation(int[] nums) {
        int minPos = 0;
        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[minPos] > nums[i]) {
                minPos = i;
            }

            if (nums[maxPos] < nums[i]) {
                maxPos = i;
            }
        }

        int ans = minPos + (nums.length - 1 - maxPos);
        if (minPos > maxPos) {
            ans--;
        }
        return ans;
    }
}