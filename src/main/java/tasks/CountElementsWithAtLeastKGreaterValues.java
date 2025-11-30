package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-29
 */
@LeetCode(
        id = 3759,
        name = "Count Elements With at Least K Greater Values",
        url = "https://leetcode.com/problems/count-elements-with-at-least-k-greater-values/description/",
        difficulty = Difficulty.MEDIUM
)
public class CountElementsWithAtLeastKGreaterValues {
    public int countElements(int[] nums, int k) {
        Arrays.sort(nums);
        int bigger = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            while (bigger < nums.length && nums[i] >= nums[bigger]) {
                bigger++;
            }

            if (nums.length - bigger >= k) {
                ans++;
            }
        }
        return ans;
    }
}