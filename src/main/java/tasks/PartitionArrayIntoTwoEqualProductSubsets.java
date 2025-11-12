package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-06-01
 */
@LeetCode(
        id = 3566,
        name = "Partition Array into Two Equal Product Subsets",
        url = "https://leetcode.com/problems/partition-array-into-two-equal-product-subsets/description/",
        difficulty = Difficulty.MEDIUM
)
public class PartitionArrayIntoTwoEqualProductSubsets {
    public boolean checkEqualPartitions(int[] nums, long target) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        return dfs(0, nums, 1, target, used) && dfs(0, nums, 1, target, used) && check(nums, used);
    }

    private boolean dfs(int pos, int[] nums, long curr, long target, boolean[] used) {
        if (pos >= nums.length || curr >= target) {
            return curr == target;
        }

        if (used[pos]) {
            return dfs(pos + 1, nums, curr, target, used);
        }

        used[pos] = true;
        boolean res = dfs(pos + 1, nums, curr * nums[pos], target, used);
        if (res) {
            return true;
        } else {
            used[pos] = false;
            return dfs(pos + 1, nums, curr, target, used);
        }
    }

    private boolean check(int[] nums, boolean[] used) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1 && !used[i]) {
                return false;
            }
        }
        return true;
    }
}