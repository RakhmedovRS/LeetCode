package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-02-01
 */
@LeetCode(
        id = 3828,
        name = "Final Element After Subarray Deletions",
        url = "https://leetcode.com/problems/final-element-after-subarray-deletions/description/",
        difficulty = Difficulty.MEDIUM
)
public class FinalElementAfterSubarrayDeletions {
    public int finalElement(int[] nums) {
        return Math.max(nums[0], nums[nums.length - 1]);
    }
}