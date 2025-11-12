package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-10-25
 */
@LeetCode(
        id = 3727,
        name = "Maximum Alternating Sum of Squares",
        url = "https://leetcode.com/problems/maximum-alternating-sum-of-squares/description/",
        difficulty = Difficulty.MEDIUM
)
public class MaximumAlternatingSumOfSquares {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        Arrays.sort(nums);

        long ans = 0;
        int left = 0;
        int right = nums.length - 1;
        int[] newArr = new int[nums.length];
        int pos = 0;
        while (right >= 0) {
            if (pos >= nums.length) {
                pos = 1;
            }
            newArr[pos] = nums[right--];
            pos += 2;
        }

        boolean add = true;
        for (int j : newArr) {
            ans += (long) (add ? 1 : -1) * j * j;
            add = !add;
        }

        return ans;
    }
}