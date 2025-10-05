package tasks;
import common.Difficulty;
import common.LeetCode;
import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-10-04
 */
@LeetCode(
id = 3702,
 name = "Longest Subsequence With Non-Zero Bitwise XOR",
 url = "https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/description/",
 difficulty = Difficulty.MEDIUM
)
public class LongestSubsequenceWithNonZeroBitwiseXOR {
    public int longestSubsequence(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] == 0){
            return 0;
        }
        long curr = 0;
        int used = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((curr ^ nums[i]) == 0 && i == nums.length - 1) {
                continue;
            } else {
                curr ^= nums[i];
                used++;
            }
        }

        return used;
    }
}