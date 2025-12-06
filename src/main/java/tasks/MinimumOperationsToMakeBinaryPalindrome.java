package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-12-06
 */
@LeetCode(
        id = 3766,
        name = "Minimum Operations to Make Binary Palindrome",
        url = "https://leetcode.com/problems/minimum-operations-to-make-binary-palindrome/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToMakeBinaryPalindrome {
    public int[] minOperations(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for (int i = 0; i < nums.length; i++) {
            char[] digits = Integer.toBinaryString(nums[i]).toCharArray();
            dfs(ans, i, 0, digits.length - 1, digits, nums[i]);
        }
        return ans;
    }

    private void dfs(int[] ans, int pos, int left, int right, char[] digits, int num) {
        if (left > right) {
            ans[pos] = Math.min(ans[pos], Math.abs(num - Integer.parseInt(String.valueOf(digits), 2)));
            return;
        }

        digits[left] = '0';
        digits[right] = '0';
        dfs(ans, pos, left + 1, right - 1, digits, num);

        digits[left] = '1';
        digits[right] = '1';
        dfs(ans, pos, left + 1, right - 1, digits, num);
    }
}