package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 6/18/2023
 */
@LeetCode(
        id = 2740,
        name = "Find the Value of the Partition",
        url = "https://leetcode.com/problems/find-the-value-of-the-partition/",
        difficulty = Difficulty.MEDIUM
)
public class FindTheValueOfThePartition
{
    public int findValueOfPartition(int[] nums)
    {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++)
        {
            diff = Math.min(diff, nums[i] - nums[i - 1]);
        }

        return diff;
    }
}
