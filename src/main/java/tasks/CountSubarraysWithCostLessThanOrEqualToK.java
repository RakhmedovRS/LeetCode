package tasks;
import common.Difficulty;
import common.LeetCode;
import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-02-07
 */
@LeetCode(
id = 3835,
 name = "Count Subarrays With Cost Less Than or Equal to K",
 url = "https://leetcode.com/problems/count-subarrays-with-cost-less-than-or-equal-to-k/description/",
 difficulty = Difficulty.MEDIUM
)
public class CountSubarraysWithCostLessThanOrEqualToK {
    public long countSubarrays(int[] nums, long k) {
        int left = 0;
        int right = 0;
        TreeMap<Integer, Integer> minMax = new TreeMap<>();
        long ans = 0;
        while (right < nums.length) {
            minMax.put(nums[right], minMax.getOrDefault(nums[right], 0) + 1);
            while ((long) (minMax.lastKey() - minMax.firstKey()) * (right - left + 1) > k) {
                int count = minMax.remove(nums[left]);
                if (--count > 0) {
                    minMax.put(nums[left], count);
                }
                left++;
            }

            ans += right - left + 1;
            right++;
        }

        return ans;
    }
}