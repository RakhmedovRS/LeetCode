package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 1/25/2023
 */
@LeetCode(
        id = 2547,
        name = "Minimum Cost to Split an Array",
        url = "https://leetcode.com/problems/minimum-cost-to-split-an-array/",
        difficulty = Difficulty.HARD
)
public class MinimumCostToSplitArray
{
    public int minCost(int[] nums, int k)
    {
        Integer[] memo = new Integer[nums.length];
        int res = dfs(0, nums, k, memo);
        return res;
    }

    private int dfs(int pos, int[] nums, int k, Integer[] memo)
    {
        if (pos >= nums.length)
        {
            return 0;
        }

        if (memo[pos] != null)
        {
            return memo[pos];
        }

        int minSum = Integer.MAX_VALUE;
        int currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = pos; i < nums.length; i++)
        {
            if (map.containsKey(nums[i]))
            {
                if (map.get(nums[i]).equals(1))
                {
                    currSum += 2;
                }
                else
                {
                    currSum++;
                }
            }

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            minSum = Math.min(minSum, k + currSum + dfs(i + 1, nums, k, memo));
        }

        memo[pos] = minSum;
        return minSum;
    }
}
