package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-11-15
 */
@LeetCode(
        id = 3254,
        name = "Find the Power of K-Size Subarrays I",
        url = "https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/description/",
        difficulty = Difficulty.MEDIUM
)
public class FindThePowerOfKSizeSubarraysI {
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }

        int pos = 0;
        int[] ans = new int[1 + nums.length - k];
        int left = 0;
        int right = 1;
        while (right < nums.length && pos < ans.length) {
            if (nums[right - 1] + 1 != nums[right]) {
                for (int i = 0; i < right - left && pos < ans.length; i++) {
                    ans[pos++] = -1;
                }
                left = right;
                right++;
            } else {
                if (right - left + 1 >= k) {
                    ans[pos++] = nums[right];
                    left++;
                }
                right++;
            }
        }
        return ans;
    }
}