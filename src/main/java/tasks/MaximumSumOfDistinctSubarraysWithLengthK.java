package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 11/7/2022
 */
@LeetCode(
        id = 2461,
        name = "Maximum Sum of Distinct Subarrays With Length K",
        url = "https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/",
        difficulty = Difficulty.MEDIUM
)
public class MaximumSumOfDistinctSubarraysWithLengthK
{
    public long maximumSubarraySum(int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        long curr = 0L;
        long max = 0L;
        while (right < nums.length)
        {
            if (right - left < k)
            {
                curr += nums[right];
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
                right++;
            }
            else
            {
                if (map.size() == k)
                {
                    max = Math.max(max, curr);
                }

                int count = map.remove(nums[left]) - 1;
                curr -= nums[left];
                if (count > 0)
                {
                    map.put(nums[left], count);
                }
                left++;

                curr += nums[right];
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
                right++;
            }

        }

        if (map.size() == k)
        {
            max = Math.max(max, curr);
        }

        return max;
    }
}
