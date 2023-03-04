package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 9/6/2022
 */
@LeetCode(
        id = 2395,
        name = "Find Subarrays With Equal Sum",
        url = "https://leetcode.com/problems/find-subarrays-with-equal-sum/",
        difficulty = Difficulty.EASY
)
public class FindSubarraysWithEqualSum
{
    public boolean findSubarrays(int[] nums)
    {
        Map<Integer, Integer> sums = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++)
        {
            int sum = nums[i] + nums[i + 1];
            sums.put(sum, sums.getOrDefault(sum, 0) + 1);
            if (sums.get(sum) > 1)
            {
                return true;
            }
        }

        return false;
    }
}
