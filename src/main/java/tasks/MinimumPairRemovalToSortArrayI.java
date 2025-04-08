package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-04-07
 */
@LeetCode(
        id = 3507,
        name = "Minimum Pair Removal to Sort Array I",
        url = "https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i/description/",
        difficulty = Difficulty.EASY
)
public class MinimumPairRemovalToSortArrayI {
    public int minimumPairRemoval(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        } else {
            int start = nums.length;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < min) {
                    min = sum;
                    start = i;
                }
            }

            int pos = 0;
            int[] copy = new int[nums.length - 1];
            for (int i = 0; i < nums.length; i++) {
                if (i == start) {
                    copy[pos++] = min;
                    i++;
                } else {
                    copy[pos++] = nums[i];
                }
            }

            return 1 + minimumPairRemoval(copy);
        }
    }

    boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }

        return true;
    }
}