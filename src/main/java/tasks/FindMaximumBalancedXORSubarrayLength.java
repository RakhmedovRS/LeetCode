package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-22
 */
@LeetCode(
        id = 3755,
        name = "Find Maximum Balanced XOR Subarray Length",
        url = "https://leetcode.com/problems/find-maximum-balanced-xor-subarray-length/description/",
        difficulty = Difficulty.MEDIUM
)
public class FindMaximumBalancedXORSubarrayLength {
    public int maxBalancedSubarray(int[] nums) {
        Map<String, Integer> memo = new HashMap<>();
        memo.put("0,0", -1);

        int prefixXor = 0;
        int balance = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixXor ^= nums[i];
            if (nums[i] % 2 == 1) {
                balance++;
            } else {
                balance--;
            }

            String key = "" + prefixXor + "," + balance;

            if (memo.containsKey(key)) {
                ans = Math.max(ans, i - memo.get(key));
            } else {
                memo.put(key, i);
            }
        }

        return ans;
    }
}